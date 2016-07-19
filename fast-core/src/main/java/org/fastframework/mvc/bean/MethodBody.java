package org.fastframework.mvc.bean;

import java.lang.reflect.Method;
import java.util.regex.Matcher;

/**
 * 方法体
 * <p>
 * Created by bysocket on 16/7/19.
 */
public class MethodBody {

    private Class<?> clazz;

    /**
     * 方法
     */
    private Method method;

    private Matcher requestPathMatcher;
    // TODO
}
