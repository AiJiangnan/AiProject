package com.ajn.mybatis.generator.template.impl;

import java.util.List;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.constants.MapperConstants;
import com.ajn.mybatis.generator.model.TableProp;
import com.ajn.mybatis.generator.template.MapperTemplate;
import com.ajn.mybatis.generator.utils.NameUtil;

public class MapperTemplateImpl extends MapperTemplate {

    @Override
    protected String genDoctype() {
        return MapperConstants.MAPPER_XML_DOCTYPE;
    }

    @Override
    protected String genMapperBegin(String interfaceFullName, String className) {
        return String.format(MapperConstants.MAPPER_XML_BEGIN, interfaceFullName + "." + className);
    }

    @Override
    protected String genMapperEnd() {
        return MapperConstants.MAPPER_XML_END;
    }

    @Override
    protected String genSqlList(String className, List<TableProp> tableProp) {
        String list = "";
        for (int i = 0, n = tableProp.size(); i < n; i++) {
            list += "`" + tableProp.get(i).getColumnName() + "`";
            if (i < n - 1)
                list += ",";
        }
        return String.format(MapperConstants.MAPPER_XML_SQL_LIST, NameUtil.humpName(className), list);
    }

    @Override
    protected String genResultMap(String modelPakName, String className, List<TableProp> tableProp) {
        String result = String.format(MapperConstants.MAPPER_XML_RESULTMAP_BEGIN, NameUtil.humpName(className),
                modelPakName + "." + className);
        for (TableProp tp : tableProp) {
            if (tp.getColumnName().equals("id")) {
                result += String.format(MapperConstants.MAPPER_XML_RESULTMAP_ID, "id", "id");
            } else {
                result += String.format(MapperConstants.MAPPER_XML_RESULTMAP_RESULT, tp.getColumnName(),
                        NameUtil.humpName(tp.getColumnName()));
            }
        }
        result += MapperConstants.MAPPER_XML_RESULTMAP_END;
        return result;
    }

    @Override
    protected String genSqlMethod(String className, String tableName, List<TableProp> tableProp) {
        String result = "";
        String modelVar = "";
        for (int i = 0, n = tableProp.size(); i < n; i++) {
            modelVar += String.format(MapperConstants.MAPPER_XML_MODEL_VARIABLE,
                    NameUtil.humpName(tableProp.get(i).getColumnName()));
            if (i < n - 1)
                modelVar += ",";
        }
        result += String.format(MapperConstants.MAPPER_XML_INSERT_ENTITY, className, tableName,
                NameUtil.humpName(className), modelVar);
        result += Constants.NEXT_LINE;
        result += String.format(MapperConstants.MAPPER_XML_SELECT_ENTITY_LIST, className, NameUtil.humpName(className),
                NameUtil.humpName(className), tableName);
        return result;
    }

}
