package com.ajn.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.InputStream;

/**
 * 网络爬虫工具包
 * 
 * @author 艾江南
 * @version 1.0.0
 * 
 */
public class URLUtil {

    /**
     * 根据URL和正则表达式获取信息
     * 
     * @param url
     * @param regs
     * @return
     */
    public static List<String> getInfoByUrlRegs(String url, String regs) {
        BufferedReader in = null;
        List<String> result = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regs);
        try {
            URL u = new URL(url);
            in = new BufferedReader(new InputStreamReader(u.openStream(), "UTF-8"));
            String line = null;
            while ((line = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find())
                    result.add(matcher.group());
            }
        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 根据URL下载文件
     * 
     * @param url
     * @param savePath
     * 
     */
    public static void downloadFileByUrl(String url, String savePath) {
        String fileName = IDUtils.genImageName() + url.substring(url.lastIndexOf("."));
        InputStream is = null;
        FileOutputStream fos = null;
        ByteArrayOutputStream bos = null;
        File saveDir = new File(savePath);
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setConnectTimeout(3 * 1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0(compatible;MSIE 5.0;Window NT;DigExt)");
            is = conn.getInputStream();
            bos = new ByteArrayOutputStream();
            while ((len = is.read(buffer)) != -1)
                bos.write(buffer, 0, len);
            if (!saveDir.exists())
                saveDir.mkdir();
            File file = new File(saveDir, fileName);
            fos = new FileOutputStream(file);
            fos.write(bos.toByteArray());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                is.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}