package com.ajn.mybatis.generator.constants;

/**
 * 生成实体类中的字符串模板
 *
 * @author 艾江南
 */
public interface ModelConstants {

    String CLASS_BEGIN = "public class %s implements Serializable {";
    String CLASS_END = "}";
    String COMMENT = "\t/** %s */\r\n";
    String VARIABLE = "\tprivate %s %s;\r\n";
    String GETTER = "\tpublic %s get%s() {\r\n\t\treturn %s;\r\n\t}";
    String SETTER = "\tpublic void set%s(%s %s) {\r\n\t\tthis.%s = %s;\r\n\t}";

}
