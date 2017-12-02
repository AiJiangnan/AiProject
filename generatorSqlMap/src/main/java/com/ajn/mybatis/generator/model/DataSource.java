package com.ajn.mybatis.generator.model;

/**
 * 数据库连接资源
 *
 * @author 艾江南
 */
public class DataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

    public DataSource() {
        super();
    }

    public DataSource(String driver, String url, String username, String password) {
        super();
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
