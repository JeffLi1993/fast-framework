package org.fastframework.util;

import org.fastframework.core.Config;
import org.fastframework.core.util.PropertiesUtil;
import org.junit.Test;

import java.util.Properties;

/**
 * {@link PropertiesUtil} 测试用例
 * <p/>
 * Created by bysocket on 16/7/19.
 */
public class PropertyUtilTest {

    @Test
    public void testGetProperties() {
        Properties properties = PropertiesUtil.getProperties("fast");
        String fastFrameworkName = properties.getProperty("fast.framework.name");
        String authorName = properties.getProperty("fast.framework.author");
        Object age = properties.getOrDefault("fast.framework.age", 10);
        Object defaultVal = properties.getOrDefault("fast.framework.null", 10);
        System.out.println(fastFrameworkName);
        System.out.println(authorName);
        System.out.println(age.toString());
        System.out.println(defaultVal.toString());
    }

    @Test
    public void testGetString() {
        Properties properties = PropertiesUtil.getProperties("fast");
        String fastFrameworkName = PropertiesUtil.getString(properties, "fast.framework.name");
        String authorName = PropertiesUtil.getString(properties, "fast.framework.author");
        System.out.println(fastFrameworkName);
        System.out.println(authorName);
    }

    @Test
    public void testGetOrDefault() {
        Properties properties = PropertiesUtil.getProperties("fast");
        Object age = PropertiesUtil.getOrDefault(properties, "fast.framework.age", 10);
        Object defaultVal = PropertiesUtil.getOrDefault(properties, "fast.framework.null", 10);
        System.out.println(age.toString());
        System.out.println(defaultVal.toString());
    }

    @Test
    public void testGetScanPackage() {
        System.out.println(Config.getScanPackage());
    }
}
