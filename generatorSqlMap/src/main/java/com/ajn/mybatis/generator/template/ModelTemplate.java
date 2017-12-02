package com.ajn.mybatis.generator.template;

import java.util.List;
import java.util.Map;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;

/**
 * 生成实体类Java文件的模板
 *
 * @author 艾江南
 */
public abstract class ModelTemplate {

    protected abstract String genPackage(String packageName);

    protected abstract String genImport(List<TableProp> tableProp);

    protected abstract String genClassBegin(Tables table);

    protected abstract String genClassEnd();

    protected abstract String genVariable(List<TableProp> tableProp, Map<String, String> tableInfo);

    protected abstract String genGetter(List<TableProp> tableProp);

    protected abstract String genSetter(List<TableProp> tableProp);

    public final String genModel(String packageName, Tables table, List<TableProp> tableProp, Map<String, String> tableInfo) {
        String result = "";
        result += genPackage(packageName);
        result += Constants.NEXT_LINE;
        result += genImport(tableProp);
        result += Constants.ONE_LINE;
        result += genClassBegin(table);
        result += Constants.NEXT_LINE;
        result += genVariable(tableProp, tableInfo);
        result += Constants.ONE_LINE;
        result += genGetter(tableProp);
        result += genSetter(tableProp);
        result += genClassEnd();
        return result;
    }

}
