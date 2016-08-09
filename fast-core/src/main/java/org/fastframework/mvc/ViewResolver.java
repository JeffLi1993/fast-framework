package org.fastframework.mvc;

import org.fastframework.mvc.annotation.MediaTypes;
import org.fastframework.mvc.bean.HandlerBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 视图解析器
 *
 * Created by bysocket on 16/8/9.
 */
public class ViewResolver {

	public static void resolveView(HttpServletRequest request, HttpServletResponse response, Object controllerMethodResult,HandlerBody handler) {
		// TODO 根据返回值返回
		try {
			String responseMediaType = handler.getResponseMediaType();
			if (MediaTypes.TEXT_PLAIN_UTF_8.equals(responseMediaType)) {
				response.getWriter().print(controllerMethodResult);
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
