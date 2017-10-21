package com.ajn.qingchun;

import com.ajn.utils.URLUtil;
import java.util.List;

public class PhotoDownload {

    public static void main(String[] args) {
        String url = "http://www.55156.com/tag/3.html";
        String url1 = "http://www.55156.com/qingchun/";
        String urlDir = "http://t1.55156.com/uploads/tu/201607/qingchun/";
        String savePath = "G:/downloadPhoto";
        String regs = urlDir + ".*\"";
        List<String> list1 = URLUtil.getInfoByUrlRegs(url, url1 + "[0-9a-z].*?html");
        int count = 0;
        for (String str : list1) {
            String realPath1 = str.replace(".html", "");
            for (int i = 1; i <= 100; i++) {
                String u = i == 1 ? realPath1 + ".html" : realPath1 + "_" + i + ".html";
                try {
                    List<String> list = URLUtil.getInfoByUrlRegs(u, regs);
                    for (String string : list) {
                        String realUrl = string.replace("\"", "");
                        URLUtil.downloadFileByUrl(realUrl, savePath);
                        count++;
                        System.out.println("图片" + realUrl + "下载成功！");
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
        System.out.println("一共张" + count + "图片");
    }

}