package main;

import java.io.File;

import com.ajn.mybatis.generator.api.config.XmlConfig;
import com.ajn.mybatis.generator.api.generate.GenerateFactory;
import com.ajn.mybatis.generator.api.generate.GenerateFile;

public class Main {

    public static void main(String[] args) {
        File file = new File("generatorConfig.xml");
        XmlConfig.setFile(file);
        GenerateFactory factory = new GenerateFactory();
        GenerateFile generateFile = factory.getGenerateFile("MODEL");
        generateFile.generateFile();
        generateFile = factory.getGenerateFile("INTERFACE");
        generateFile.generateFile();
        generateFile = factory.getGenerateFile("MAPPER");
        generateFile.generateFile();
    }

}
