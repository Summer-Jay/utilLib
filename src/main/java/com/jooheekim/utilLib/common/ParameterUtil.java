package com.jooheekim.utilLib.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerMapping;

public class ParameterUtil {
	/**
	 * url parameter + query parameter를 한번에 가져온다.
	 **/
	public static Map<String, Object> getReqUrlParam(HttpServletRequest request){
		Map<String, Object> paramMap = new HashMap<String, Object>();

		//url parameter를 가져온다.
		paramMap = (Map<String, Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		//query parameter를 가져온다.
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()) {
			String key = params.nextElement();
			String value = request.getParameter(key);

			//url parameter가 담겨있는 paramMap에 query parameter를 추가한다.
			paramMap.put(key, value);

		}
		return paramMap;
	}

}
