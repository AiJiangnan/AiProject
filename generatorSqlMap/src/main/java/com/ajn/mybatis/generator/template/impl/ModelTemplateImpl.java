package com.ajn.mybatis.generator.template.impl;

import java.util.List;
import java.util.Map;

import com.ajn.mybatis.generator.constants.ModelConstants;
import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.model.Tables;
import com.ajn.mybatis.generator.template.ModelTemplate;
import com.ajn.mybatis.generator.utils.NameUtil;

public class ModelTemplateImpl extends ModelTemplate {

    @Override
    protected String genPackage(String packageName) {
        return String.format(Constants.PACKAGE, packageName);
    }

    @Override
    protected String genClassBegin(Tables table) {
        String className = table.getClassName();
        String tableName = NameUtil.bigHumpName(table.getTableName());
        return String.format(ModelConstants.CLASS_BEGIN,
                className == null || "".equals(className) ? tableName : className);
    }

    @Override
    protected String genClassEnd() {
        return ModelConstants.CLASS_END;
    }

    @Override
    protected String genVariable(List<TableProp> tableProp, Map<String, String> tableInfo) {
        String result = "";
        for (TableProp table : tableProp) {
            final String comment = tableInfo.get(table.getColumnName());
            if (comment != null && !"".equals(comment)) {
                result += String.format(ModelConstants.COMMENT, comment);
            }
            result += String.format(ModelConstants.VARIABLE, table.getColumnClassName(),
                    NameUtil.humpName(table.getColumnName()));
        }
        return result;
    }

    @Override
    protected String genGetter(List<TableProp> tableProp) {
        String result = "";
        for (TableProp table : tableProp) {
            String humpName = NameUtil.humpName(table.getColumnName());
            String bigHumpName = NameUtil.bigHumpName(table.getColumnName());
            result += String.format(ModelConstants.GETTER, table.getColumnClassName(), bigHumpName, humpName);
            result += Constants.NEXT_LINE;
        }
        return result;
    }

    @Override
    protected String genSetter(List<TableProp> tableProp) {
        String result = "";
        for (TableProp table : tableProp) {
            String humpName = NameUtil.humpName(table.getColumnName());
            String bigHumpName = NameUtil.bigHumpName(table.getColumnName());
            result += String.format(ModelConstants.SETTER, bigHumpName, table.getColumnClassName(), humpName, humpName,
                    humpName);
            result += Constants.NEXT_LINE;
        }
        return result;
    }

    @Override
    protected String genImport(List<TableProp> tableProp) {
        String result = Constants.IMPORT_SERIALLIZABLE;
        for (TableProp tp : tableProp) {
            if (tp.getColumnClassName().equals("Date")) {
                result += Constants.IMPORT_UTIL_DATE;
                break;
            }
        }
        return result;
    }

}
