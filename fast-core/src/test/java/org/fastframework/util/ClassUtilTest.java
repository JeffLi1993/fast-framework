package org.fastframework.util;

import org.fastframework.core.util.ClassUtil;
import org.fastframework.mvc.annotation.Controller;

import java.util.List;

/**
 * Created by bysocket on 16/7/21.
 */
public class ClassUtilTest {
    public static void main(String[] args) {
//        ClassUtil.getClassList("org.fastframework");
        List<Class<?>> controllerClassList = ClassUtil.getClassListByAnnotation("org.fastframework", Controller.class);
        return;
    }
}
