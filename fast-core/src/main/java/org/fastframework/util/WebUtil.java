package org.fastframework.util;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
}
