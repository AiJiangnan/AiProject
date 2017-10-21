package com.ajn.qingchun;

public class PhotoDownload {

    public static void main(String[] args) {

        String url0 = "http://www.55156.com/tag/3";

        for (int i = 1; i <= 10; i++) {
            new PhotoThread(url0 + (i == 1 ? "" : "_" + i) + ".html").start();
        }

    }

}