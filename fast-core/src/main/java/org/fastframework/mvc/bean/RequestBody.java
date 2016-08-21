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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((requestMethod == null) ? 0 : requestMethod.hashCode());
		result = prime * result
				+ ((requestPath == null) ? 0 : requestPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestBody other = (RequestBody) obj;
		if (requestMethod != other.requestMethod)
			return false;
		if (requestPath == null) {
			if (other.requestPath != null)
				return false;
		} else if (!requestPath.equals(other.requestPath))
			return false;
		return true;
	}

}
