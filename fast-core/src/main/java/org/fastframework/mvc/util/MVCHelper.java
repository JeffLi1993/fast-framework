package org.fastframework.mvc.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MVC 相关的帮助类
 * <p>
 * Created by bysocket on 16/7/19.
 */
public class MVCHelper {

    /**
     * URL 目录分隔符
     */
    public static final String URL_PATH_SEPARATOR = "/";
    /**
     * 请求编码 UTF-8
     */
    public static final String REQ_CHARACTER_UTF_8 = "UTF-8";
    /**
     * 请求默认主页地址
     */
    public static final String REQ_DEFAULT_HOME_PAGE = "/index.html";
    private static final Logger LOGGER = LoggerFactory.getLogger(MVCHelper.class);

    /**
     * 获取请求路径
     * /servlet/MyServlet/a/b
     *
     * @param request
     * @return
     */
    public static String getRequestPath(HttpServletRequest request) {
        String servletPath = request.getServletPath(); // /servlet/MyServlet
        String pathInfo = request.getPathInfo();    // /a/b

        return (null != servletPath ? servletPath : "") + StringUtils.defaultIfEmpty(pathInfo, StringUtils.EMPTY);
    }

    /**
     * 重定向请求
     *
     * @param path
     * @param request
     * @param response
     */
    public static void redirectRequest(String path, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath() + path);
        } catch (Exception e) {
            LOGGER.error("重定向请求失败!", e);
            throw new RuntimeException(e);
        }
    }
}
