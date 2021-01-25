package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * created by huangyating
 *
 * @Date 2020/11/19
 */
@Aspect
@Component
public class WebLogAspect {

    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);


    @Pointcut("@annotation(com.example.demo.aop.WebLog)")
    public void webLog(){

    }

    @Before("webLog()")
    public void before(JoinPoint joinPoint) throws Exception {
        // 得到 HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("============ before ==========");
        // 获取WebLog注解信息
        String info = getWebLogInfo(joinPoint);
        logger.info("Point Info    : {}", info);
        // 请求地址URL
        logger.info("URL	: {}", request.getRequestURL().toString());
        // 请求方法
        logger.info("HTTP Method : {}", request.getMethod());
        // 具体切入执行方法
        logger.info("Class Method : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        // 请求IP
        logger.info("IP	: {}", request.getRemoteAddr());// 打印描述信息
        // 请求参数
        logger.info("Input Parameter : {}", Arrays.asList(joinPoint.getArgs()));


    }

    /**
     * 获取web日志注解信息
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public String getWebLogInfo(JoinPoint joinPoint) throws Exception {
        // 获取切入点的目标类
        String targetName = joinPoint.getTarget().getClass().getName();
        Class<?> targetClass = Class.forName(targetName);
        // 获取切入方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取切入方法参数
        Object[] arguments = joinPoint.getArgs();
        // 获取目标类的所有方法
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            // 方法名相同、包含目标注解、方法参数个数相同（避免有重载）
            if (method.getName().equals(methodName) && method.isAnnotationPresent(WebLog.class)
                    && method.getParameterTypes().length == arguments.length) {
                return method.getAnnotation(WebLog.class).value();
            }
        }
        return "";
    }
}
