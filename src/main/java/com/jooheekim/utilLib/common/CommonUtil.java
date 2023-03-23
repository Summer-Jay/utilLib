package com.jooheekim.utilLib.common;

public class CommonUtil {
	/**
	 * string자료형으로 반환(null일 경우 문자열 "" return)
	 **/
	public static String getString(Object obj) {
		String returnStr= obj==null? "" : (String)obj;
		return returnStr;
	}
}
