package org.fastframework.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * JSON 工具类
 * <p/>
 * Created by bysocket on 16/7/19.
 */
public class JSONUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class);

    /**
     * 默认JSON类
     **/
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 将 Java 对象转换为 JSON 字符串
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String toJSONString(T object) {
        String jsonStr;
        try {
            jsonStr = mapper.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.error("Java Object Can't covert to JSON String!");
            throw new RuntimeException(e);
        }
        return jsonStr;
    }


    /**
     * 将 JSON 字符串转化为 Java 对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        T object;
        try {
            object = mapper.readValue(json, clazz);
        } catch (Exception e) {
            LOGGER.error("JSON String Can't covert to Java Object!");
            throw new RuntimeException(e);
        }
        return object;
    }

}
