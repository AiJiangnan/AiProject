package com.ajn.mybatis.generator.model;

import java.util.Map;

/**
 * 生成文件输出路径
 *
 * @author 艾江南
 */
public class OutputPath {

    private Map<String, String> modelPath;
    private Map<String, String> mapperPath;
    private Map<String, String> interfacePath;

    public Map<String, String> getModelPath() {
        return modelPath;
    }

    public void setModelPath(Map<String, String> modelPath) {
        this.modelPath = modelPath;
    }

    public Map<String, String> getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(Map<String, String> mapperPath) {
        this.mapperPath = mapperPath;
    }

    public Map<String, String> getInterfacePath() {
        return interfacePath;
    }

    public void setInterfacePath(Map<String, String> interfacePath) {
        this.interfacePath = interfacePath;
    }

}
