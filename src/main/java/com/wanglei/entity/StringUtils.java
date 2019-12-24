package com.wanglei.entity;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	static char charArray[] = new char[36];
	static {
		for (int i = 0; i < 10; i++) {
			charArray[i] = (char)('0' + i);
		}
		for (int i = 0; i < 26; i++) {
			charArray[i+10] = (char)('A' + i);
		}		
	}
	public static boolean isBlank(String str) {
		return null==str||"".equals(str.trim());
	}
	public static boolean haveValue(String str) {
		return null!=str && !"".equals(str.trim());
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		String regex = "^\\d{1,}$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(str);
		boolean find = matcher.find();
		return find;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		String regex = "^(135|136|138)\\d{8}$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(str);
		boolean find = matcher.find();
		return find;
		
		
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static String getRandomStr(int n) {
		Random random = new Random();
		//Math.random();
		//UUID.randomUUID();
		//a -z;
		StringBuilder sb = new StringBuilder();
		//StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			char randomChar = (char)('a' +  random.nextInt(26));// 0 ~  25;
			sb.append(randomChar);
		}
		return sb.toString();
	}
	
	public static String getRandomStrNum(int n) {
		//char charArray[] = {'0','1' ..}
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int index =  random.nextInt(36);// 0 ~  25;
			char randomChar = charArray[index];
			sb.append(randomChar);
		}
		
		return sb.toString();
		
	}
	
	public static String getGb2312(int n) throws UnsupportedEncodingException {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getGb2312());
		}
		return sb.toString();
	}
	
	private static String getGb2312() throws UnsupportedEncodingException {
		
		byte word[] = new byte[2];
		//  0x1A   0x1A+94
		Random random = new Random();
		word[0] = (byte)(0xA1 + 0x10 + random.nextInt(39));
		word[1] = (byte)(0xA1  + random.nextInt(94));
		return new String(word,"GBK");
		
	}

	public static boolean isUrl(String url) {
		 //转换为小写
       String str = url.toLowerCase();
       String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
               + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
              + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                + "|" // 允许IP和DOMAIN（域名） 
                + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
               + "[a-z]{2,6})" // first level domain- .com or .museum  
               + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
               + "((/?)|" // a slash isn't required if there is no file name  
               + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
       return  str.matches(regex);	
	}

}
