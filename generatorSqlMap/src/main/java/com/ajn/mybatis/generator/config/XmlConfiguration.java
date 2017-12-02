package com.ajn.mybatis.generator.config;

import java.util.List;

import com.ajn.mybatis.generator.model.DataSource;
import com.ajn.mybatis.generator.model.OutputPath;
import com.ajn.mybatis.generator.model.Tables;

/**
 * 获取XML配置文件中配置接口
 *
 * @author 艾江南
 */
public interface XmlConfiguration {

    /**
     * 获取XML配置文件中的数据库连接资源
     *
     * @return
     */
    DataSource getDataSource();

    /**
     * 获取XML配置文件中的文件输出路径
     *
     * @return
     */
    OutputPath getOutputPath();

    /**
     * 获取XML配置文件中的数据库表名和生成实体类名（为空时以数据库表名）
     *
     * @return
     */
    List<Tables> getTables();

}
