package com.jyjays.filter;


import com.alibaba.druid.util.StringUtils;
import com.jyjays.controller.Code;
import com.jyjays.utils.JwtUtils;
import com.jyjays.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    private static final String[] WHITE={"/User/login","/User/2"} ;
//    private static final String WHITE="/User/login" ;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JwtUtils jwtUtils;



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            // 如果路径在白名单中则直接放行
            String path = request.getServletPath();
            boolean flag = false;
            for (String s : WHITE) {
                flag = path.equals(s);
                if (flag) {
                    filterChain.doFilter(request, response);
                    return;
                }
            }

            // 如果token为空，过滤
            String token = request.getHeader("Authorization");
            if(!jwtUtils.validateToken(token)){
                response.sendError(Code.SYSTEM_ERR, "token无效");
            }

            // 如果鉴权成功，则更新token
            // 生成新的token
            String username = jwtUtils.getUsernameFromToken(token);
            System.out.println(username);
            String newToken = jwtUtils.generateToken(username);
            // 删除旧的token
            if (!redisUtil.del(username)) {
                response.sendError(Code.SYSTEM_ERR, "token更新失败！");
                return;
            }
            // 加入新的token
            if (!redisUtil.set(username,newToken, 900)) {
                response.sendError(Code.SYSTEM_ERR, "token更新失败！");
                return;
            }
            response.addHeader("Authorization", newToken);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
