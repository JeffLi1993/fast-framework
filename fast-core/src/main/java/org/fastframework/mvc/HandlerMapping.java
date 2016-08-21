package org.fastframework.mvc;

import org.fastframework.mvc.annotation.RequestMethod;
import org.fastframework.mvc.bean.HandlerBody;
import org.fastframework.mvc.bean.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 处理器映射
 *
 * Created by bysocket on 16/8/9.
 */
public class HandlerMapping {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HandlerMapping.class);

	/**
	 * 处理方法体
	 *
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static HandlerBody getHandler(String requestMethod,
			String requestPath) {
		HandlerBody handler = null;

		RequestBody reqTest = new RequestBody(
				RequestMethod.valueOf(requestMethod), requestPath);
		// Controller Map 请求 -> 方法体 的映射
		Map<RequestBody, HandlerBody> methodMap = ControllerCollection
				.getMethodMap();
		handler = methodMap.get(reqTest);
		LOGGER.debug("通过url映射到method");
		// handlerBody.getControllerMethod();
		// for (Map.Entry<RequestBody, HandlerBody> methodEntry : methodMap
		// .entrySet()) {
		// RequestBody req = methodEntry.getKey();
		// String reqPath = req.getRequestPath();
		// RequestMethod reqMethod = req.getRequestMethod();
		//
		// if (reqPath.equals(requestPath)
		// && reqMethod.name().equalsIgnoreCase(requestMethod)) {
		// handler = methodEntry.getValue().;
		// if (handler != null) {
		// return handler;
		// }
		// }
		// }
		return handler;
	}
}
