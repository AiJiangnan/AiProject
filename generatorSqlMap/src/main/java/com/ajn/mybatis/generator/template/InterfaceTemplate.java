package com.ajn.mybatis.generator.template;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.utils.NameUtil;

/**
 * 生成接口Java文件的模板
 *
 * @author 艾江南
 */
public abstract class InterfaceTemplate {

    protected abstract String genPackage(String packageName);

    protected abstract String genInterfaceBegin(String className);

    protected abstract String genInterfaceEnd();

    protected abstract String genMethod(String className);

    protected abstract String genImport(String modelPakName, String className);

    public final String genInterface(String packageName, String modelPakName, Tables table) {
        String className = table.getClassName();
        String tableName = table.getTableName();
        className = className == null || "".equals(className) ? NameUtil.bigHumpName(tableName) : className;
        String result = "";
        result += genPackage(packageName);
        result += Constants.NEXT_LINE;
        result += genImport(modelPakName, className);
        result += Constants.ONE_LINE;
        result += genInterfaceBegin(className);
        result += Constants.NEXT_LINE;
        result += genMethod(className);
        result += Constants.NEXT_LINE;
        result += genInterfaceEnd();
        return result;
    }

}
