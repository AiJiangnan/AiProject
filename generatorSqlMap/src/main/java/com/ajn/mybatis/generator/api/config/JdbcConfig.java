package com.ajn.mybatis.generator.api.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ajn.mybatis.generator.config.impl.XmlConfigurationImpl;
import com.ajn.mybatis.generator.model.DataSource;

/**
 * JDBC的单例
 *
 * @author 艾江南
 */
public class JdbcConfig {

    private static JdbcConfig instance;
    private static DataSource dataSource = new XmlConfigurationImpl().getDataSource();

    private JdbcConfig() {

    }

    static {
        try {
            Class.forName(dataSource.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库操作的所有资源
     *
     * @param conn
     * @param stat
     * @param rs
     */
    public void closeConnection(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (stat != null)
                stat.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取JDBC配置的实例
     *
     * @return
     */
    public static JdbcConfig getInstance() {
        if (instance == null)
            instance = new JdbcConfig();
        return instance;
    }

}
