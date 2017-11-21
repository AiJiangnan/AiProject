package com.ajn.douban;

import com.ajn.utils.URLUtil;
import java.util.List;

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
			List<String> name = URLUtil.getInfoByUrlRegs(url + i, nameRegs);
			for (String string : name) {
				if (string.indexOf("&nbsp;") < 0)
					System.out.println("Top" + (index++) + "\t"
							+ string.replace("<span class=\"title\">", "").replace("</span>", ""));
			}
		}
	}

}
