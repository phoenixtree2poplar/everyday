package com.yl.userservice.aop;

import com.alibaba.fastjson.JSONObject;
import com.yl.common.pojo.User;
import com.yl.userservice.annotation.SysLog;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yangjie
 * 2019/12/29 10:34
 */
@Aspect
@Component
public class SystemAopAspect {

    @Value("${sys.log}")
    private String isOpen;

    private static final Logger log = LoggerFactory.getLogger(SystemAopAspect.class);

    private static String[] types = { "java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long",
            "java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Char", "java.lang.String", "int",
            "double", "long", "short", "byte", "boolean", "char", "float" };

    // 配置织入点  注解类
    @Pointcut("@annotation(com.yl.userservice.annotation.SysLog)")
    public void logPointCut() {

    }

    /**
     * 前置通知 用于拦截操作，在方法返回后执行
     * @param joinPoint
     * 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    /**
     * 拦截异常操作，有异常时执行
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e);
    }

    private void handleLog(JoinPoint joinPoint, Exception e) {
        if ("true".equals(isOpen)) {
            try {
                // 获得注解
                SysLog controllerLog = getAnnotationLog(joinPoint);
                if (controllerLog == null) {
                    return;
                }
                String classType = joinPoint.getTarget().getClass().getName();
                Class<?> clazz = Class.forName(classType);
                // 类名地址 列:cn.yl.shopping.admin.service.impl.UserInfoServiceImpl
                String clazzName = clazz.getName();
                // 类名 : 列 :UserInfoServiceImpl
                String clazzSimpleName = clazz.getSimpleName();
                // 方法名
                String methodName = joinPoint.getSignature().getName();
                // 操作类型
                int type = controllerLog.type();
                // 模块
                String modular = controllerLog.modular();

                String[] paramNames = getFieldsName(this.getClass(), clazzName, methodName);
                String logContent = "";
                if (paramNames.length > 0) {
                    logContent = writeLogInfo(paramNames, joinPoint);
                }

//				SysLog sysLog = new SysLog();
//				sysLog.setLogId(Commons.getUUID());
//				sysLog.setLogClassName(clazzSimpleName);
//				sysLog.setLogMethodName(methodName);
//				sysLog.setLogModular(modular);
//				// 操作类型 1 增 2 删 3 改 4查 5 登录 6 退出
//				sysLog.setLogType(type);
//				sysLog.setLogMethodParam(logContent);
//				sysLog.setCreateName(SessionUtils.getUserName());
//				sysLog.setCreateTime(Commons.getTime());
//
//				// 插入数据库
//				int resultStatus = sysLogService.saveSysLog(sysLog);
//				if (resultStatus == 1) {
//					log.info("注解日志记录成功....");
//				}

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication instanceof OAuth2Authentication) {
                    OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
                    Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
                    String principal = (String) userAuthentication.getPrincipal();
                    User user = JSONObject.parseObject(principal, User.class);
                    log.info("======userName:" + user.getUsername());
                } else {
                    log.info("======userName: anonymous");
                }

                // 可以创建日志entity，插入数据库
                log.info("======clazzName:" + clazzName);
                log.info("======clazzSimpleName： " + clazzSimpleName);
                log.info("======methodName:" + methodName);
                log.info("======modular:" + modular);
                log.info("======type:" + type);
                log.info("======logContent:" + logContent);
            } catch (Exception exp) {
                // 记录本地异常日志
                log.error("==前置通知异常==");
                log.error("异常信息:{}", exp.getMessage());
                exp.printStackTrace();
            }
        }

    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private static SysLog getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(SysLog.class);
        }
        return null;
    }

    /**
     * 得到方法参数的名称
     * @param cls
     * @param clazzName
     * @param methodName
     * @return
     * @throws NotFoundException
     */
    private static String[] getFieldsName(@SuppressWarnings("rawtypes") Class cls, String clazzName, String methodName) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        // ClassClassPath classPath = new ClassClassPath(this.getClass());
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
        }
        String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++) {
            paramNames[i] = attr.variableName(i + pos); // paramNames即参数名
        }
        return paramNames;
    }

    /**
     * 得到参数的值
     *
     * @param obj
     */
    public static String getFieldsValue(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        String typeName = obj.getClass().getTypeName();
        for (String t : types) {
            if (t.equals(typeName))
                return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                for (String str : types) {
                    if (f.getType().getName().equals(str)) {
                        sb.append(f.getName() + " = " + f.get(obj) + ", ");
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 把方法里面的参数转换成一个json格式的字符串
     * @param paramNames
     * @param joinPoint
     * @author: fanyuke
     * @date 2019年4月16日下午4:27:42
     */
    private static String writeLogInfo(String[] paramNames, JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        StringBuilder lastSb = new StringBuilder();
        boolean clazzFlag = true;
        sb.append("{");
        for (int k = 0; k < args.length; k++) {
            Object arg = args[k];
            sb.append("\"" + paramNames[k] + "\"" + " ");
            // 获取对象类型
            String typeName = arg.getClass().getTypeName();

            for (String t : types) {
                if (t.equals(typeName)) {
                    sb.append(": " + "\"" + arg + "\"" + ", ");
                }
            }
            if (clazzFlag) {
                sb.append(getFieldsValue(arg));
            }
        }
        lastSb.append(sb.substring(0, sb.length() - 2));
        lastSb.append("}");
        return lastSb.toString();
    }
}
