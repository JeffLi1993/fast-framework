package org.fastframework.mvc.bean;

import org.fastframework.mvc.annotation.RequestMethod;

/**
 * 请求体
 * <p>
 * Created by bysocket on 16/7/19.
 */
public class RequestBody {

    /**
     * 请求方法 [POST] [GET] {@link org.fastframework.mvc.annotation.RequestMethod}
     */
    private RequestMethod requestMethod;

    /**
     * 请求路由
     */
    private String requestPath;

    public RequestBody(RequestMethod requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }
}
