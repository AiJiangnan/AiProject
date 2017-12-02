package com.ajn.mybatis.generator.config.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.ajn.mybatis.generator.api.config.XmlConfig;
import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.model.DataSource;
import com.ajn.mybatis.generator.model.OutputPath;
import com.ajn.mybatis.generator.model.Tables;

public class XmlConfigurationImpl implements XmlConfiguration {

    private final Element root = XmlConfig.getInstance().getRoot();

    @Override
    public DataSource getDataSource() {
        final Element jdbcConnection = root.element("jdbcConnection");
        String driver = jdbcConnection.attribute("driver").getStringValue();
        String url = jdbcConnection.attribute("url").getStringValue();
        String username = jdbcConnection.attribute("username").getStringValue();
        String password = jdbcConnection.attribute("password").getStringValue();
        return new DataSource(driver, url, username, password);
    }

    @Override
    public OutputPath getOutputPath() {
        OutputPath outputPath = new OutputPath();
        outputPath.setModelPath(getMapConfig(root, "javaModelGenerator"));
        outputPath.setMapperPath(getMapConfig(root, "mapperGenerator"));
        outputPath.setInterfacePath(getMapConfig(root, "javaInterfaceGenerator"));
        return outputPath;
    }

    private Map<String, String> getMapConfig(Element root, String nodeName) {
        final Element node = root.element(nodeName);
        Map<String, String> map = new HashMap<String, String>();
        map.put("targetPackage", node.attribute("targetPackage").getStringValue());
        map.put("targetProject", node.attribute("targetProject").getStringValue());
        return map;
    }

    @Override
    public List<Tables> getTables() {
        List<Tables> list = new ArrayList<Tables>();
        Iterator<?> tables = root.elementIterator("table");
        while (tables.hasNext()) {
            Tables table = new Tables();
            Element ele = (Element) tables.next();
            table.setClassName(ele.attribute("className").getStringValue());
            table.setTableName(ele.attribute("tableName").getStringValue());
            if (!table.getTableName().equals("") && table.getTableName() != null)
                list.add(table);
        }
        return list;
    }

}
