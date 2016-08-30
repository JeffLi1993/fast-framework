package org.fastframework.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RequestMapping 注解
 * <p>
 * Created by bysocket on 16/8/4.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    /**
     * URL
     */
    String value() default "";

    /**
     * application/json,text/html {@link MediaTypes}
     */
    String produces() default MediaTypes.TEXT_PLAIN_UTF_8;

    /**
     * GET, POST, PUT, PATCH, DELETE {@link RequestMethod}
     */
    RequestMethod method() default RequestMethod.GET;
}
