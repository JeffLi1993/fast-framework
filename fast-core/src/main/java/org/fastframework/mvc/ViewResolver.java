package org.fastframework.mvc;

import org.fastframework.mvc.annotation.MediaTypes;
import org.fastframework.mvc.bean.HandlerBody;
import org.fastframework.mvc.util.MVCHelper;
import org.fastframework.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 视图解析器
 * <p>
 * Created by bysocket on 16/8/9.
 */
public class ViewResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewResolver.class);

    public static void resolveView(HttpServletRequest request, HttpServletResponse response,
                                   Object controllerMethodResult, HandlerBody handler) {
        // TODO 根据返回值返回
        try {
            // 请求路由
            String requestPath = MVCHelper.getRequestPath(request);
            String responseMediaType = handler.getResponseMediaType();

            if (MediaTypes.TEXT_PLAIN_UTF_8.equals(responseMediaType)) {
                LOGGER.debug("[fast framework] {} : 返回格式CharSet = {}, 返回结果 = {}", requestPath,
                    MediaTypes.TEXT_PLAIN_UTF_8, controllerMethodResult);
                response.getWriter().print(controllerMethodResult);
                return;
            } else if (MediaTypes.JSON_UTF_8.equals(responseMediaType)) {
                String resultJSON = JSONUtil.toJSONString(controllerMethodResult);
                LOGGER.debug("[fast framework] {} : 返回格式CharSet = {}, 返回结果 = {}", requestPath,
                    MediaTypes.JSON_UTF_8, resultJSON);
                response.getWriter().print(resultJSON);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
