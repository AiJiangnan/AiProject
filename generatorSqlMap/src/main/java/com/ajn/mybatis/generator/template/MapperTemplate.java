package com.ajn.mybatis.generator.template;

import java.util.List;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.utils.NameUtil;

/**
 * 生成Mapper的XML文件的模板
 *
 * @author 艾江南
 */
public abstract class MapperTemplate {

    protected abstract String genDoctype();

    protected abstract String genMapperBegin(String interfaceFullName, String className);

    protected abstract String genMapperEnd();

    protected abstract String genSqlList(String className, List<TableProp> tableProp);

    protected abstract String genSqlMethod(String className, String tableName, List<TableProp> tableProp);

    protected abstract String genResultMap(String modelPakName, String className, List<TableProp> tableProp);

    public final String genMapper(String interfacePak, String modelPakName, Tables table, List<TableProp> tableProp) {
        String className = table.getClassName();
        String tableName = table.getTableName();
        className = className == null || "".equals(className) ? NameUtil.bigHumpName(tableName) : className;
        String result = "";
        result += genDoctype();
        result += genMapperBegin(interfacePak, className);
        result += Constants.NEXT_LINE;
        result += genSqlList(className, tableProp);
        result += Constants.NEXT_LINE;
        result += genResultMap(modelPakName, className, tableProp);
        result += Constants.NEXT_LINE;
        result += genSqlMethod(className, tableName, tableProp);
        result += Constants.NEXT_LINE;
        result += genMapperEnd();
        return result;
    }

}
