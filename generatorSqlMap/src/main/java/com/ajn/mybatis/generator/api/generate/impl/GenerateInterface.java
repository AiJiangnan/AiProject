package com.ajn.mybatis.generator.api.generate.impl;

import java.io.File;
import java.util.List;

import com.ajn.mybatis.generator.api.generate.GenerateFile;
import com.ajn.mybatis.generator.config.JdbcConfiguration;
import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.config.impl.JdbcConfigurationImpl;
import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.InterfaceTemplate;
import com.ajn.mybatis.generator.template.impl.InterfaceTemplateImpl;
import com.ajn.mybatis.generator.utils.FileUtil;
import com.ajn.mybatis.generator.utils.NameUtil;

/**
 * 生成接口文件的实现类
 *
 * @author 艾江南
 */
public class GenerateInterface implements GenerateFile {

    private XmlConfiguration xmlConfig = new XmlConfigurationImpl();
    private JdbcConfiguration jdbcConfig = new JdbcConfigurationImpl();
    private InterfaceTemplate interfaceTemplate = new InterfaceTemplateImpl();

    @Override
    public void generateFile() {
        List<Tables> tables = xmlConfig.getTables();

        for (Tables table : tables)
            genOneFile(table);

        System.out.println("Interface finished!");
    }

    private void genOneFile(Tables table) {
        // List<TableProp> list = jdbcConfig.getTables(table.getTableName());
        String infacePak = xmlConfig.getOutputPath().getInterfacePath().get("targetPackage");
        String infacePro = xmlConfig.getOutputPath().getInterfacePath().get("targetProject");
        String modelPak = xmlConfig.getOutputPath().getModelPath().get("targetPackage");
        String infaceDir = NameUtil.packageToDir(infacePak);
        String className = table.getClassName();
        String tableName = table.getTableName();
        className = className == null || "".equals(className) ? NameUtil.bigHumpName(tableName) : className;
        String fileName = String.format(Constants.JAVA_MAPPER_NAME, className);
        String result = interfaceTemplate.genInterface(infacePak, modelPak, table);
        File file = FileUtil.newFile(infacePro + infaceDir, fileName);
        FileUtil.writeFile(file, result);
    }
}
