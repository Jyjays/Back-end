package com.jyjays.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

//已改用NotBlank注解
@Aspect
@Component
public class ParamCheckAspect {

    @Around("execution(* com.jyjays.controller.*.*(..))")
    public Object checkParam(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg != null && arg.getClass().isAnnotationPresent(CheckParam.class)) {
                checkObject(arg);
            }
        }
        return joinPoint.proceed();
    }

    private void checkObject(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CheckParam.class)) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value == null) {
                    throw new IllegalArgumentException("参数不能为空：" + field.getName());
                } else if ("".equals(value.toString().trim())) {
                    throw new IllegalArgumentException("参数不能为空：" + field.getName());
                }
            }
        }
    }

}