package org.fastframework.mvc;

import org.fastframework.mvc.bean.HandlerBody;
import org.fastframework.mvc.util.MVCHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MVC 前端控制器
 * 1. 初始化相关配置: 类扫描/路由匹配
 * 2. 转发请求到 HandlerMapping
 * 3. 反射调用Controller方法,并解耦
 * 4. 根据返回值,响应视图或数据
 * <p>
 * Created by bysocket on 16/7/19.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServlet.class);

    /**
     * 初始化相关配置
     * 扫描类 - 路由Map
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        ControllerCollection.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求默认编码
        request.setCharacterEncoding(MVCHelper.REQ_CHARACTER_UTF_8);
        // 请求相关信息
        // 请求方法 [POST] [GET]
        String requestMethod = request.getMethod();
        // 请求路由
        String requestPath = MVCHelper.getRequestPath(request);

        LOGGER.debug("[fast framework] {} : {}", requestMethod, requestPath);

        // "/" 请求重定向到默认首页
        if (MVCHelper.URL_PATH_SEPARATOR.equals(requestPath)) {
            MVCHelper.redirectRequest(MVCHelper.REQ_DEFAULT_HOME_PAGE, request, response);
            return;
        }

        // 处理器映射
        // 获取 handler
        HandlerBody handler = HandlerMapping.getHandler(requestMethod, requestPath);

        // null == handler
        if (null == handler) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 调用 Handler
        HandlerInvoker.invokeHandler(request, response, handler);
        return;
    }
}
