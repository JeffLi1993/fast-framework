package org.fastframework.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by bysocket on 16/8/9.
 */
public class WebUtil {
	/**
	 * 从请求中获取所有参数
	 *
	 * @param request
	 * @return
	 */
	public static List<Object> getRequestParamMap(HttpServletRequest request) {
		List<Object> requestParamList = new ArrayList<>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues != null) {
				if (1 == paramValues.length) {
					requestParamList.add(paramValues[0]);
				}
				// TODO 数组入参
			}
		}
		return requestParamList;
	}

//	/**
//	 * 从请求中获取所有参数
//	 *
//	 * @param request
//	 * @return
//	 */
//	public static List<Object> getRequestParamMap(HttpServletRequest request, Method controllerMethod) {
//		List<Object> requestParamList = new ArrayList<>();
//
//		Parameter[] controllerParamList = controllerMethod.getParameters();
//		for (int i = 0 ; 0 < controllerParamList.length ; i++) {
//			Parameter p = controllerParamList[0];
//			// TODO javax.servlet.http.HttpServletRequest
//			// TODO javax.servlet.http.HttpServletResponse
//			// TODO javax.servlet.http.HttpSession
//			String name = p.getName();
//
//			if ("".equals(name)) {
//
//			} else {
//				Enumeration<String> paramNames = request.getParameterNames();
//				while (paramNames.hasMoreElements()) {
//					String paramName = paramNames.nextElement();
//					if (controllerParam.getName().equals(paramName)) {
//						String[] paramValues = request.getParameterValues(paramName);
//						if (paramValues != null) {
//							if (1 == paramValues.length) {
////								if (controllerParam(Integer.class)) {
//								requestParamList.add(Integer.valueOf(paramValues[0]));
////								} else if (controllerParam.isInstance(Integer.class)) {
////									requestParamList.add(paramValues[0]);
////								}
//							}
//							// TODO 数组入参
//						}
//					}
//			}
//		}
//
//
//		return requestParamList;
//	}

	/**
	 * 根据方法的参数类型获取参数类型列表
	 *
	 * @param parameterTypes
	 * @return
	 */
	private static List<Object> getControllerParamList(Class<?>[] parameterTypes) {
		List<Object> list = new ArrayList<>();
		for (Class<?> clazz : parameterTypes) {
			list.add(clazz);
		}
		return list;
	}

}
