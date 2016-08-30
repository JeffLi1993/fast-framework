package org.fastframework.core.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * 类扫描工具类
 * <p>
 * Created by bysocket on 16/7/20.
 */
public class ClassUtil {

    /**
     * 包目录分隔符:点
     */
    public static final String PACKAGE_PATH_POINT = ".";
    /**
     * 包目录分隔符:点
     */
    public static final String PACKAGE_PATH_SEPARATOR = "/";
    /**
     * URL 协议名:file
     */
    public static final String URL_PROTOCOL_FILE = "file";
    /**
     * URL 协议名:jar
     */
    public static final String URL_PROTOCOL_JAR = "jar";
    /**
     * class 文件名后缀
     */
    public static final String CLASS_FILE_END = ".class";
    /**
     * class 文件分隔符:点
     */
    public static final String CLASS_FILE_POINT = PACKAGE_PATH_POINT;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);
    /**
     * 当前线程的类加载
     */
    private static final ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();

    public static ClassLoader getCurrentClassLoader() {
        return currentClassLoader;
    }

    /**
     * 根据包名和注解,获取包下的有该注解的类列表
     *
     * @param packageName
     * @param annotationClass
     * @return
     */
    public static List<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotationClass) {
        List<Class<?>> classList = getClassList(packageName);
        return classList.stream().filter(clazz ->
            clazz.isAnnotationPresent(annotationClass)).collect(Collectors.toList());
    }

    /**
     * 根据包名,获取包下的类列表
     *
     * @param packageName
     * @return
     */
    public final static List<Class<?>> getClassList(String packageName) {
        List<Class<?>> classList = new ArrayList<>();
        try {
            // 从包名获取 URL 类型的资源
            Enumeration<URL> urlList = getCurrentClassLoader()
                .getResources(packageName.replace(PACKAGE_PATH_POINT, PACKAGE_PATH_SEPARATOR));
            while (urlList.hasMoreElements()) {
                URL url = urlList.nextElement();
                if (url != null) {
                    // 获取 URL 协议名 [file] [jar]
                    String protocol = url.getProtocol();
                    if (URL_PROTOCOL_FILE.equals(protocol)) {
                        // 若在 class 目录,添加类
                        String packagePath = url.getPath().replaceAll("%20", " ");
                        addClass(classList, packagePath, packageName);
                    } else if (URL_PROTOCOL_JAR.equals(protocol)) {
                        // TODO 若在 jar 包中,则解析 jar 包中的 entry
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        JarFile jarFile = jarURLConnection.getJarFile();
                        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                        while (jarEntryEnumeration.hasMoreElements()) {
                            JarEntry jarEntry = jarEntryEnumeration.nextElement();
                            String jarEntryName = jarEntry.getName();
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("获取扫描类错误");
        }
        return classList;
    }

    /**
     * 根据 包路径 和 包名称,添加类到类列表(递归扫描)
     *
     * @param classList
     * @param packagePath
     * @param packageName
     */
    private static void addClass(List<Class<?>> classList, String packagePath, String packageName) {
        try {
            // 获取 包路径 下的所有 class文件列表或目录
            File[] fileList = new File(packagePath).listFiles(file ->
                file.isFile() && file.getName().endsWith(CLASS_FILE_END) || file.isDirectory()
            );
            // 遍历文件或目录
            for (File file : fileList) {
                String fileName = file.getName();
                // 是文件
                if (file.isFile()) {
                    // 是类名
                    String className = fileName.substring(0, fileName.lastIndexOf(CLASS_FILE_POINT));
                    if (StringUtils.isNoneEmpty(className)) {
                        className = packageName + PACKAGE_PATH_POINT + className;
                    }

                    Class<?> clazz = loadClass(className, false);
                    classList.add(clazz);
                }
                // 是目录
                else {
                    // 子包
                    String subPackagePath = fileName;
                    if (StringUtils.isNotEmpty(packagePath)) {
                        subPackagePath = packagePath + PACKAGE_PATH_SEPARATOR + subPackagePath;
                    }

                    // 子包名
                    String subPackageName = fileName;
                    if (StringUtils.isNotEmpty(packageName)) {
                        subPackageName = packageName + PACKAGE_PATH_POINT + subPackageName;
                    }

                    // 递归调用添加类
                    addClass(classList, subPackagePath, subPackageName);
                }
            }

        } catch (Exception e) {
            LOGGER.error("添加类错误");
        }
    }

    /**
     * 加载类
     *
     * @param className
     * @param initialize
     * @return
     */
    public static Class<?> loadClass(String className, Boolean initialize) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className, initialize, getCurrentClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("加载类错误");
            throw new RuntimeException(e);
        }
        return clazz;
    }
}
