package org.fastframework.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 反射工具类
 * <p>
 * Created by bysocket on 16/8/9.
 */
public class ReflectUtil {

    public static Object invokeControllerMethod(Class<?> clazz, Method method, List<Object> paramList) {

        try {
            method.setAccessible(true);// 取消类型安全检测（可提高反射性能）
            Object instance = clazz.newInstance();
            return method.invoke(instance, paramList.toArray());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
