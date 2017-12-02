package com.ajn.mybatis.generator.api.generate.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.ajn.mybatis.generator.api.generate.GenerateFile;
import com.ajn.mybatis.generator.config.JdbcConfiguration;
import com.ajn.mybatis.generator.config.XmlConfiguration;
import com.ajn.mybatis.generator.config.impl.JdbcConfigurationImpl;
import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.ModelTemplate;
import com.ajn.mybatis.generator.template.impl.ModelTemplateImpl;
import com.ajn.mybatis.generator.utils.FileUtil;
import com.ajn.mybatis.generator.utils.NameUtil;

/**
 * 生成实体类文件的实现类
 *
 * @author 艾江南
 */
public class GenerateModel implements GenerateFile {

    private XmlConfiguration xmlConfig = new XmlConfigurationImpl();
    private JdbcConfiguration jdbcConfig = new JdbcConfigurationImpl();
    private ModelTemplate modelTemplate = new ModelTemplateImpl();

    @Override
    public void generateFile() {
        List<Tables> tables = xmlConfig.getTables();

        for (Tables table : tables)
            genOneFile(table);

        System.out.println("Model finished!");
    }

    private void genOneFile(Tables table) {
        List<TableProp> list = jdbcConfig.getTables(table.getTableName());
        Map<String, String> tableInfo = jdbcConfig.getTableInfo(table.getTableName());
        String modelPak = xmlConfig.getOutputPath().getModelPath().get("targetPackage");
        String modelPro = xmlConfig.getOutputPath().getModelPath().get("targetProject");
        String modelDir = NameUtil.packageToDir(modelPak);
        String className = table.getClassName();
        String tableName = table.getTableName();
        className = className == null || "".equals(className) ? NameUtil.bigHumpName(tableName) : className;
        String fileName = String.format(Constants.JAVA_FILE_NAME, className);
        String result = modelTemplate.genModel(modelPak, table, list, tableInfo);
        File file = FileUtil.newFile(modelPro + modelDir, fileName);
        FileUtil.writeFile(file, result);
    }

}
