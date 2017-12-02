package com.ajn.mybatis.generator.template.impl;

import com.ajn.mybatis.generator.constants.Constants;
import com.ajn.mybatis.generator.constants.InterfaceConstants;
import com.ajn.mybatis.generator.template.InterfaceTemplate;
import com.ajn.mybatis.generator.utils.NameUtil;

public class InterfaceTemplateImpl extends InterfaceTemplate {

    @Override
    protected String genPackage(String packageName) {
        return String.format(Constants.PACKAGE, packageName);
    }

    @Override
    protected String genInterfaceBegin(String className) {
        return String.format(InterfaceConstants.INTERFACE_BEGIN, className);
    }

    @Override
    protected String genInterfaceEnd() {
        return InterfaceConstants.INTERFACE_END;
    }

    @Override
    protected String genMethod(String className) {
        String result = "";
        result += String.format(InterfaceConstants.INSERT_ENTITY_METHOD, className,
                className + " " + NameUtil.humpName(className));
        result += Constants.NEXT_LINE;
        result += String.format(InterfaceConstants.SELECT_ENTITY_LIST_METHOD, className, className);
        return result;
    }

    @Override
    protected String genImport(String modelPakName, String className) {
        String result = "";
        result += Constants.IMPORT_LIST;
        result += String.format(Constants.IMPORT_MODEL, modelPakName, className);
        return result;
    }

}
