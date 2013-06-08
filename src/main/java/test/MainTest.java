package test;

import java.util.ArrayList;
import java.util.Iterator;

public class MainTest {

	/**
	 * 在整体字符串中找到不重复的字符串 （包含空格的）
	 * 
	 * @param sourceStr
	 * @return
	 */
	public ArrayList<String> findBiggestInManyStr(String sourceStr) {
		int currMax = 0;
		ArrayList<String> resaults = new ArrayList<String>();
		for (int i = 0; i < sourceStr.length(); i++) {
			for (int j = i + 1; j < sourceStr.length(); j++) {
				String currentString = sourceStr.substring(i, j);
				String realString = checkHasSameChar(currentString);
				if (realString.length() > currMax) {// 大于当前的最大字符
					currMax = realString.length();
					resaults.clear();// 置空
					resaults.add(realString);// 添加
				} else if (realString.length() == currMax) {// 等于当前的最大字符
					resaults.add(realString);// 添加
				}
			}
		}
		return resaults;
	}

	/**
	 * 查找出一个字符串中是否存在重复的字母
	 * 
	 * @param sourceStr
	 * @return 如果存在返回"",不存在返回该字符串
	 */
	private String checkHasSameChar(String sourceStr) {
		for (int i = 0; i < sourceStr.length(); i++) {
			String checkStr = String.valueOf(sourceStr.charAt(i));
			int index = sourceStr.substring(sourceStr.indexOf(checkStr) + 1)
					.indexOf(String.valueOf(checkStr));
			if (index != -1) {
				return "";
			}
		}
		return sourceStr;// 返回当前字符串
	}

	public static void main(String[] args) {
		MainTest mainTest = new MainTest();
		ArrayList<String> strs = mainTest
				.findBiggestInManyStr("Hello World! My code, my love, my precious!");
		for (Iterator iterator = strs.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

		ArrayList<String> strs2 = mainTest
				.findBiggestInManyStr("var imageData = document.getElementById(src).get_img_binary();");
		for (Iterator iterator = strs2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
