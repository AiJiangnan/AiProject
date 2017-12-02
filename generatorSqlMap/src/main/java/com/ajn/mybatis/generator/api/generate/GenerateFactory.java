package com.ajn.mybatis.generator.api.generate;

import com.ajn.mybatis.generator.api.generate.impl.GenerateInterface;
import com.ajn.mybatis.generator.api.generate.impl.GenerateMapper;
import com.ajn.mybatis.generator.api.generate.impl.GenerateModel;

/**
 * 创建生成文件的简单工厂
 *
 * @author 艾江南
 */
public class GenerateFactory {

    /**
     * 根据文件类型生成对应的文件
     *
     * @param fileType
     * @return
     */
    public GenerateFile getGenerateFile(String fileType) {
        if (fileType == null)
            return null;
        if (fileType.equalsIgnoreCase("MODEL"))
            return new GenerateModel();
        else if (fileType.equalsIgnoreCase("INTERFACE"))
            return new GenerateInterface();
        else if (fileType.equalsIgnoreCase("MAPPER"))
            return new GenerateMapper();
        return null;
    }

}
