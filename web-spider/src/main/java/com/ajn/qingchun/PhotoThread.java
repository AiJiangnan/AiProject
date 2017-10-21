package com.ajn.qingchun;

import com.ajn.utils.URLUtil;
import java.util.HashSet;
import java.util.List;
import org.apache.log4j.Logger;

public class PhotoThread extends Thread {

    private String url;
    private String temp = "";
    private String url1 = "http://www.55156.com/qingchun/";
    private String urlDir = "http://t1.55156.com/uploads/tu/201607/qingchun/";
    private String savePath = "G:/downloadPhoto";

    public PhotoThread(String url) {
        this.url = url;
    }

    public void downloadImg() {
        HashSet<String> pathList1 = new HashSet<String>();
        Logger logger = Logger.getLogger(PhotoThread.class);
        List<String> pathList = URLUtil.getInfoByUrlRegs(url, url1 + "[0-9a-z].*?html");
        pathList1.addAll(pathList);
        for (String str : pathList1) {
            str = str.replace(".html", "");
            for (int i = 1; i <= 100; i++) {
                temp = str + (i == 1 ? "" : "_" + i) + ".html";
                try {
                    List<String> pathList2 = URLUtil.getInfoByUrlRegs(temp, urlDir + ".*?\\.jpg");
                    for (String str1 : pathList2) {
                        URLUtil.downloadFileByUrl(str1, savePath);
                        System.out.println(str1);
                        logger.info(str1);
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        this.downloadImg();
    }

}