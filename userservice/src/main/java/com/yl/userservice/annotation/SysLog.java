package com.yl.userservice.annotation;

import java.lang.annotation.*;

/**
 * @author yangjie
 * 2019/12/29 10:11
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 模块儿
     */
    String modular() default "";

    /**
     * 操作类型 1 增 2 删 3 改 4查 5 登录 6 退出
     */
    int type() default -1;

}
