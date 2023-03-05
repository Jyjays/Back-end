package com.jyjays.filter;

import com.jyjays.controller.Code;
import com.jyjays.utils.JwtUtils;
import com.jyjays.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    private static final String[] WHITE = {"/User/login", "/User/2"};

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            // 如果路径在白名单中则直接放行
            String path = request.getServletPath().trim();
            for (String s : WHITE) {
                if (path.equals(s.trim())) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }

            // 如果token为空，过滤
            String token = request.getHeader("Authorization");
            if (token == null || token.trim().length() == 0 || !jwtUtils.validateToken(token)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无效的token");
                return;
            }

            if (!token.equals(redisUtil.get(jwtUtils.getUsernameFromToken(token)))) {
                response.sendError(Code.SYSTEM_ERR+1, "无有效登陆信息");
                return ;
            }


            // 如果鉴权成功，则更新token
            // 生成新的token
            String username = jwtUtils.getUsernameFromToken(token);
            String newToken = jwtUtils.generateToken(username);

            // 删除旧的token
            if (!redisUtil.del(username)) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "token更新失败！");
                return;
            }

            // 加入新的token
            if (!redisUtil.set(username, newToken, 900)) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "token更新失败！");
                return;
            }

            response.addHeader("Authorization", newToken);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("过滤器出现异常：", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "过滤器出现异常：" + e.getMessage());
        }
    }
}

