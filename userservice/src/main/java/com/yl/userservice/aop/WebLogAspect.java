package com.yl.userservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author yangjie
 * 2019/12/27 19:51
 *
 * @Aspect注释告诉Spring这是个切面类，然后@Compoment将转换成Spring容器中的bean或者是代理bean
 *
 * execution: 匹配连接点
 *
 * within: 某个类里面
 *
 * this: 指定AOP代理类的类型
 *
 * target:指定目标对象的类型
 *
 * args: 指定参数的类型
 *
 * bean:指定特定的bean名称，可以使用通配符（Spring自带的）
 *
 * @target： 带有指定注解的类型
 *
 * @args: 指定运行时传的参数带有指定的注解
 *
 * @within: 匹配使用指定注解的类
 *
 * @annotation:指定方法所应用的注解
 */
//@Order(5)  //order越小越先执行
@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.yl.userservice.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称

//    @Pointcut("execution(public * com.yl.userservice.controller..*.*(..))")//切入点描述，这个是uiController包的切入点
//    public void uiControllerLog(){}

//    @Before("controllerLog() || uiControllerLog()") //在切入点的方法run之前要干的
    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

    }


}
