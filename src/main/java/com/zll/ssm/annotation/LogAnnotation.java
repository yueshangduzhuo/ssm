package com.zll.ssm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 自定义注解
 * @author: zhangll
 * @create: 2018-05-02 20:17
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    String operateModelNm() default "";
    String operateFuncNm() default "";
    String operateDescribe() default "";
}
