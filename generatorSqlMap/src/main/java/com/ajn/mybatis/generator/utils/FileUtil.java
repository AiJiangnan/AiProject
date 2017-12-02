package com.ajn.mybatis.generator.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 文件操作的工具类
 *
 * @author 艾江南
 */
public class FileUtil {

    /**
     * 创建目录中文件，目录可以不存在
     *
     * @param dirName
     * @param fileName
     * @return
     */
    public static File newFile(String dirName, String fileName) {
        File dir = new File(dirName);
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(dir, fileName);
        if (file.exists())
            file.delete();
        return file;
    }

    /**
     * 在文件中写入字符
     *
     * @param file
     * @param str
     */
    public static void writeFile(File file, String str) {
        OutputStreamWriter osw = null;
        BufferedWriter writer = null;
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            osw = new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8");
            writer = new BufferedWriter(osw);
            writer.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
