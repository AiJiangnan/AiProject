package com.ajn.mybatis.generator.model;

/**
 * 配置文件中的数据库表名和对应的实体类名
 *
 * @author 艾江南
 */
public class Tables {

    private String tableName;
    private String className;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
