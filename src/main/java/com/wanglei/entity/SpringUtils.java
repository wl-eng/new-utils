 package com.wanglei.entity;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpringUtils {
	
	public static boolean isBlank(String str) {
		return (str == null || str.trim().equals(""));
	}
	
	public static boolean haveValue(String str) {
		return !(str == null || str.trim().equals(""));
	}
	
	public static boolean isMobile(String str) {
		//�ƶ��绰�ķ�Χ
		String regex = "^((13[0-9])|(14[5|7])|(15[0-3]|[5-9])|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	
	public static boolean isEmail(String str) {
		String regex = "\\w+([-+.\\w+])*@\\w+([-+.\\\\w+])*\\.\\w+([-+.\\\\w+])*$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	
	public static String getRandomStr(int n) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char)('A' + random.nextInt(26));
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String getRandomCn(int n ) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomCn());
		}
		return sb.toString();
	}
	
private static char getRandomCn() {
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出现异常");
        }

        return str.charAt(0);
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
