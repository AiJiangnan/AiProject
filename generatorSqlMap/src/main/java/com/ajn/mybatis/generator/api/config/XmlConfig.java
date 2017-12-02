package com.ajn.mybatis.generator.api.config;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 获取XML配置文件的单例
 *
 * @author 艾江南
 */
public class XmlConfig {

    private static XmlConfig instance;
    private Element root;
    private static File file;

    private XmlConfig() {
        SAXReader saxReader = new SAXReader();
        try {
            Document doc = saxReader.read(file);
            root = doc.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void setFile(File file) {
        XmlConfig.file = file;
    }

    /**
     * 获取配置文件中信息，返回根节点
     *
     * @return
     */
    public Element getRoot() {
        return root;
    }

    /**
     * 获取XML配置文件的实例
     *
     * @return
     */
    public static XmlConfig getInstance() {
        if (instance == null)
            instance = new XmlConfig();
        return instance;
    }

}
