package org.fastframework.mvc.annotation;

/**
 * 带 UTF-8 charset 定义的 MediaType
 * <p>
 * Created by bysocket on 16/8/4.
 */
public interface MediaTypes {
    String APPLICATION_XML = "application/xml";
    String APPLICATION_XML_UTF_8 = "application/xml; charset=UTF-8";

    String JSON = "application/json";
    String JSON_UTF_8 = "application/json; charset=UTF-8";

    String JAVASCRIPT = "application/javascript";
    String JAVASCRIPT_UTF_8 = "application/javascript; charset=UTF-8";

    String APPLICATION_XHTML_XML = "application/xhtml+xml";
    String APPLICATION_XHTML_XML_UTF_8 = "application/xhtml+xml; charset=UTF-8";

    String TEXT_PLAIN = "text/plain";
    String TEXT_PLAIN_UTF_8 = "text/plain; charset=UTF-8";

    String TEXT_XML = "text/xml";
    String TEXT_XML_UTF_8 = "text/xml; charset=UTF-8";

    String TEXT_HTML = "text/html";
    String TEXT_HTML_UTF_8 = "text/html; charset=UTF-8";
}
