package com.ajn.mybatis.generator.api.generate.impl;

import java.io.File;
import java.util.List;

import com.ajn.mybatis.generator.api.generate.GenerateFile;
import com.ajn.mybatis.generator.config.JdbcConfiguration;
import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.config.impl.JdbcConfigurationImpl;
import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.MapperTemplate;
import com.ajn.mybatis.generator.template.impl.MapperTemplateImpl;
import com.ajn.mybatis.generator.utils.FileUtil;
import com.ajn.mybatis.generator.utils.NameUtil;

/**
 * 生成Mapper文件的实现类
 *
 * @author 艾江南
 */
public class GenerateMapper implements GenerateFile {

    private XmlConfiguration xmlConfig = new XmlConfigurationImpl();
    private JdbcConfiguration jdbcConfig = new JdbcConfigurationImpl();
    private MapperTemplate mapperTemplate = new MapperTemplateImpl();

    @Override
    public void generateFile() {
        List<Tables> tables = xmlConfig.getTables();

        for (Tables table : tables) {
            genOneFile(table);
        }

        System.out.println("Mapper finished!");
    }

    private void genOneFile(Tables table) {
        List<TableProp> tables = jdbcConfig.getTables(table.getTableName());
        String mapperPak = xmlConfig.getOutputPath().getMapperPath().get("targetPackage");
        String mapperPro = xmlConfig.getOutputPath().getMapperPath().get("targetProject");
        String modelPak = xmlConfig.getOutputPath().getModelPath().get("targetPackage");
        String interfacePak = xmlConfig.getOutputPath().getInterfacePath().get("targetPackage");
        String mapperDir = NameUtil.packageToDir(mapperPak);
        String className = table.getClassName();
        String tableName = table.getTableName();
        className = className == null || "".equals(className) ? NameUtil.bigHumpName(tableName) : className;
        String fileName = String.format(Constants.XML_MAPPER_NAME, className);
        String result = mapperTemplate.genMapper(interfacePak, modelPak, table, tables);
        File file = FileUtil.newFile(mapperPro + mapperDir, fileName);
        FileUtil.writeFile(file, result);
    }

}
