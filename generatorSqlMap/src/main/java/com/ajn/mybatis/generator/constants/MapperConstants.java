package com.ajn.mybatis.generator.constants;

/**
 * 生成Mapper文件中的字符串模板
 *
 * @author 艾江南
 */
public interface MapperConstants {

    String MAPPER_XML_DOCTYPE = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n";
    String MAPPER_XML_BEGIN = "<mapper namespace=\"%sMapper\">";
    String MAPPER_XML_END = "</mapper>";
    String MAPPER_XML_SQL_LIST = "\t<sql id=\"%sList\">\r\n\t\t%s\r\n\t</sql>";
    String MAPPER_XML_MODEL_VARIABLE = "#{%s}";
    String MAPPER_XML_RESULTMAP_BEGIN = "\t<resultMap id=\"%sMap\" type=\"%s\" >\r\n";
    String MAPPER_XML_RESULTMAP_END = "\t</resultMap>";
    String MAPPER_XML_RESULTMAP_ID = "\t\t<id column=\"%s\" property=\"%s\" />\r\n";
    String MAPPER_XML_RESULTMAP_RESULT = "\t\t<result column=\"%s\" property=\"%s\" />\r\n";

    /**
     * Mapper中的方法
     */
    String MAPPER_XML_INSERT_ENTITY = "\t<insert id=\"ins%s\">\r\n\t\tINSERT INTO %s (<include refid=\"%sList\"></include>) VALUES (%s)\r\n\t</insert>";
    String MAPPER_XML_SELECT_ENTITY_LIST = "\t<select id=\"sel%sList\" resultMap=\"%sMap\">\r\n\t\tSELECT <include refid=\"%sList\"></include> FROM %s\r\n\t</select>";

}
