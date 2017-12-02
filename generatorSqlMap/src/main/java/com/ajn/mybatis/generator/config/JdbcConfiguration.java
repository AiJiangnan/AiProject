package com.ajn.mybatis.generator.config;

import java.util.List;
import java.util.Map;

import com.ajn.mybatis.generator.model.TableProp;

/**
 * 使用JDBC获取数据库表的信息
 *
 * @author 艾江南
 */
public interface JdbcConfiguration {

    /**
     * 使用JDBC获取数据库表中的字段信息和字段数据类型对应的Java封装类
     *
     * @param tableName
     * @return
     */
    List<TableProp> getTables(String tableName);

    /**
     * 使用JDBC获取数据库中表的详细信息
     *
     * @param tableName
     * @return
     */
    Map<String, String> getTableInfo(String tableName);

}
