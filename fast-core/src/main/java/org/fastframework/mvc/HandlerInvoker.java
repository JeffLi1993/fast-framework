package org.fastframework.mvc;

import org.fastframework.mvc.bean.HandlerBody;
import org.fastframework.util.ReflectUtil;
import org.fastframework.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Handler 调用器
 *
 * Created by bysocket on 16/8/9.
 */
public class HandlerInvoker {

	public static void invokeHandler(HttpServletRequest request, HttpServletResponse response, HandlerBody handler) {
		// 从 Request 获取参数 - Controller.Method 的 ParamList
		List<Object> controllerMethodParamList = WebUtil.getRequestParamMap(request);
//		List<Object> controllerMethodParamList = WebUtil.getRequestParamMap(request, handler.getControllerMethod());

		// ReflectUtil 获取 Controller.Method 的返回值
		Object controllerMethodResult = ReflectUtil.invokeControllerMethod(handler.getControllerClass(),
				handler.getControllerMethod(),controllerMethodParamList);

		// View 处理
		ViewResolver.resolveView(request,response,controllerMethodResult,handler);
	}

}
