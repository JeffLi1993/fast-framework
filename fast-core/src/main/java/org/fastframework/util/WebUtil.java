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
    public static List<Object> getRequestParamMap(HttpServletRequest request, Class<?>[] controllerParamTypes) {

        // TODO 杜琪 - POST / Content-Type

        List<Object> requestParamList = new ArrayList<>();
        Enumeration<String> paramNames = request.getParameterNames();
        int i = 0;
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues != null) {
                if (1 == paramValues.length) {
                    // 获取请求参数
                    String paramValue = paramValues[0];
                    Class<?> paramType = controllerParamTypes[i];
                    // 支持四种类型：int/Integer、long/Long、double/Double、String
                    if (paramType.equals(int.class) || paramType.equals(Integer.class)) {
                        requestParamList.add(Integer.parseInt(paramValue));
                    } else if (paramType.equals(long.class) || paramType.equals(Long.class)) {
                        requestParamList.add(Long.parseLong(paramValue));
                    } else if (paramType.equals(double.class) || paramType.equals(Double.class)) {
                        requestParamList.add(Double.parseDouble(paramValue));
                    } else if (paramType.equals(String.class)) {
                        requestParamList.add(paramValue);
                    }
                }
                // TODO 数组
            }
            i++;
        }
        return requestParamList;
    }

}
