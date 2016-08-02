package org.fastframework.core.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * .properties属性文件操作工具类
 *
 * Created by bysocket on 16/7/19.
 */
public class PropertyUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtil.class);

    /** .properties属性文件名后缀 */
    public static final String PROPERTY_FILE_SUFFIX	= ".properties";

    /**
     * 根据属性文件名,获取属性
     *
     * @param propsFileName
     * @return
     */
    public static Properties getProperties(String propsFileName) {
        if (StringUtils.isEmpty(propsFileName))
            throw new IllegalArgumentException();

        Properties  properties  = new Properties();
        InputStream inputStream = null;

        try {

            try {
                /** 加入文件名后缀 */
                if (propsFileName.lastIndexOf(PROPERTY_FILE_SUFFIX) == -1) {
                    propsFileName += PROPERTY_FILE_SUFFIX;
                }

                inputStream = Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(propsFileName);
                if (null != inputStream)
                    properties.load(inputStream);
            } finally {
                if ( null != inputStream) {
                    inputStream.close();
                }
            }

        } catch (IOException e) {
            LOGGER.error("加载属性文件出错!",e);
            throw new RuntimeException(e);
        }

        return properties;
    }

    /**
     * 根据key,获取属性值
     *
     * @param properties
     * @param key
     * @return
     */
    public static String getString(Properties properties, String key){
        return properties.getProperty(key);
    }

    /**
     * 根据key,获取属性值
     *
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties properties, String key, String defaultValue){
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 根据key,获取属性值
     *
     * @param properties
     * @param key
     * @param defaultValue
     * @param <V>
     * @return
     */
    public static <V> V getOrDefault(Properties properties, String key, V defaultValue){
        return (V) properties.getOrDefault(key,defaultValue);
    }
}
