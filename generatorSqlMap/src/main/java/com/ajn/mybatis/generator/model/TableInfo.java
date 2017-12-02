package com.ajn.mybatis.generator.model;

public class TableInfo {

    private String field;
    private String type;
    private String isNull;
    private String comment;

    public TableInfo() {
        super();
    }

    public TableInfo(String field, String type, String isNull, String comment) {
        super();
        this.field = field;
        this.type = type;
        this.isNull = isNull;
        this.comment = comment;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
