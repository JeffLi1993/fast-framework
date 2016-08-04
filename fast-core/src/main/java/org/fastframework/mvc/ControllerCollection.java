package org.fastframework.mvc;

import org.fastframework.core.Config;
import org.fastframework.core.util.ClassUtil;
import org.fastframework.mvc.annotation.Controller;
import org.fastframework.mvc.bean.MethodBody;
import org.fastframework.mvc.bean.RequestBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller类收集器
 * <p>
 * Created by bysocket on 16/7/20.
 */
public class ControllerCollection {

    /**
     * Controller Map 请求 -> 方法体 的映射
     */
    public static final Map<RequestBody, MethodBody> methodMap = new LinkedHashMap<>();

    /**
     * Controller扫描包的目录
     */
    private static final String scanPackage = Config.getScanPackage();

    public static void init() {
        // 获取到@Controller注解的类列表
        List<Class<?>> controllerClassList =  ClassUtil.getClassListByAnnotation(scanPackage, Controller.class);

    }


}