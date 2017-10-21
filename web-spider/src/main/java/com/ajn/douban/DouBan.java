package com.ajn.douban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 豆瓣影评Top250爬虫
 * 
 * @author 艾江南
 * @version 1.0.0
 *
 */
public class DouBan {

	public static void main(String[] args) {
		String url = "https://movie.douban.com/top250?start=";
		String nameRegs = "<span class=\"title\">.*</span>";
		int index = 1;
		for (int i = 0; i < 250; i += 25) {
			List<String> name = getInfo(url + i, nameRegs);
			for (String string : name) {
				if (string.indexOf("&nbsp;") < 0)
					System.out.println("Top" + (index++) + "\t" + string.replace("<span class=\"title\">", "").replace("</span>", ""));
			}
		}
	}

	/**
	 * 根据URL和正则表达式获取信息
	 * 
	 * @param url
	 * @param regs
	 * @return
	 */
	public static List<String> getInfo(String url, String regs) {
		BufferedReader in = null;
		List<String> result = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regs);
		try {
			URL u = new URL(url);
			in = new BufferedReader(new InputStreamReader(u.openConnection().getInputStream(), "UTF-8"));
			String line = null;
			while ((line = in.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				while (matcher.find())
					result.add(matcher.group());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
