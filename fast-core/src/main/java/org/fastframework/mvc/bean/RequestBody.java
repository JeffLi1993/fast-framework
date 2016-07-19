package org.fastframework.mvc.bean;

/**
 * 请求体
 * <p>
 * Created by bysocket on 16/7/19.
 */
public class RequestBody {

    /**
     * 请求方法 [POST] [GET]
     */
    private String requestMethod;

    /**
     * 请求路由
     */
    private String requestPath;

    public RequestBody(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }
}
