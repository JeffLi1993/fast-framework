package org.fastframework.mvc;

import org.fastframework.mvc.annotation.PostParam;
import org.fastframework.mvc.annotation.RequestMethod;
import org.fastframework.mvc.bean.HandlerBody;
import org.fastframework.util.ReflectUtil;
import org.fastframework.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.ArrayList;

/**
 * Handler 调用器
 * <p>
 * Created by bysocket on 16/8/9.
 */
public class HandlerInvoker {

    /**
     * 请求处理器
     * 根据请求,获取请求参数
     * 调用Method,获取返回值
     * 调用View,返回响应
     *
     * @param request
     * @param response
     * @param handler
     */
    public static void invokeHandler(HttpServletRequest request, HttpServletResponse response, HandlerBody handler) {
        List<Object> controllerMethodParamList = new ArrayList<>();
        Method controllerMethod = handler.getControllerMethod();

        // POST 请求
        if (request.getMethod().equals(RequestMethod.POST.toString())) {
            List<Class<?>> getParameterTypes = new ArrayList();
            Class<?> postParamType = null;

            for (Parameter p : controllerMethod.getParameters()) {
                if (p.isAnnotationPresent(PostParam.class)) {
                    postParamType = p.getType();
                } else {
                    getParameterTypes.add(p.getType());
                }
            }
            controllerMethodParamList = WebUtil.getRequestParamMap(request, getParameterTypes.toArray(new Class<?>[0]));
            Object postParamObject = WebUtil.getRequestBody(request, postParamType);
            controllerMethodParamList.add(0, postParamObject);

        }
        // GET 请求
        else if (request.getMethod().equals(RequestMethod.GET.toString())) {
            // 从 Request 获取参数 - Controller.Method 的 ParamList
            controllerMethodParamList = WebUtil.getRequestParamMap(request, controllerMethod.getParameterTypes());
        }

        // ReflectUtil 获取 Controller.Method 的返回值
        Object controllerMethodResult = ReflectUtil.invokeControllerMethod(handler.getControllerClass(),
            handler.getControllerMethod(), controllerMethodParamList);

        // View 处理
        ViewResolver.resolveView(request, response, controllerMethodResult, handler);
    }

}
