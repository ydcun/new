package com.ydcun.common;

import javax.servlet.http.HttpServletRequest;

public class Util {

	/**
	 * 获取ip
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
	/**
	 * 判断str是否是数字 是true 否false
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	/**
	 * 	判断字符串是否为空
	 * @param str 字符串
	 * @param isDelSpace 是否去掉空格
	 * @return 是true,否false 
	 * 
	 */
	public static boolean isEmptyString(String str,boolean isDelSpace){
		if(null == str){
			return true;
		}
		if(isDelSpace){
			str = str.trim();
		}
		if(str.equals("")){
			return true;
		}
		return false;
	}
	/**
	 * 	判断字符串是否为空
	 * @param str 字符串
	 * @return 是true,否false 
	 * 
	 */
	public static boolean isEmptyString(String str){
		return isEmptyString(str,false);
	}
}
