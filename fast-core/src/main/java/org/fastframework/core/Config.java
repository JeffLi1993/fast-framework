package org.fastframework.core;

import org.fastframework.core.util.PropertiesUtil;

import java.util.Properties;

/**
 * 系统配置类
 * <p>
 * Created by bysocket on 16/7/19.
 */
public class Config {

    /**
     * .properties属性文件默认名
     */
    public static final String PROPERTY_FILE_DEFAULT_NAME = "fast";
    /**
     * 默认扫描包key ,不存在默认扫描全部
     */
    public static final String PROPERTY_PACKAGE_SCAN = "package.scan";
    public static final String PROPERTY_PACKAGE_SCAN_DEFAULT = "";

    private static final Properties configProperties = PropertiesUtil.getProperties(PROPERTY_FILE_DEFAULT_NAME);

    /**
     * 获取扫描包的目录
     *
     * @return
     */
    public static String getScanPackage() {
        return getStringOrDefault(PROPERTY_PACKAGE_SCAN, PROPERTY_PACKAGE_SCAN_DEFAULT);
    }

    /**
     * 根据key,获取属性值
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        return PropertiesUtil.getString(configProperties, key);
    }

    /**
     * 根据key,获取属性值
     *
     * @param key
     * @return
     */
    public static String getStringOrDefault(String key, String defaultValue) {
        return PropertiesUtil.getStringOrDefault(configProperties, key, defaultValue);
    }
}
