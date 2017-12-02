package com.ajn.mybatis.generator.model;

/**
 * 数据库表的属性
 *
 * @author 艾江南
 */
public class TableProp {

    private String columnName;
    private String columnClassName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnClassName() {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
    }

}
