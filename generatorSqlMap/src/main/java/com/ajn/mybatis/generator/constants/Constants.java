package com.ajn.mybatis.generator.constants;

/**
 * 公共的字符串模板
 *
 * @author 艾江南
 */
public interface Constants {

    String PACKAGE = "package %s;";
    String ONE_LINE = "\r\n";
    String NEXT_LINE = "\r\n\r\n";
    String JAVA_FILE_NAME = "%s.java";
    String JAVA_MAPPER_NAME = "%sMapper.java";
    String XML_MAPPER_NAME = "%sMapper.xml";

    /**
     * 导入包
     */
    String IMPORT_MODEL = "import %s.%s;\r\n";
    String IMPORT_LIST = "import java.util.List;\r\n";
    String IMPORT_UTIL_DATE = "import java.util.Date;\r\n";
    String IMPORT_SERIALLIZABLE = "import java.io.Serializable;\r\n";

}
