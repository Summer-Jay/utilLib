package com.jooheekim.utilLib.common;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

public class ResponseManager {
	public HttpHeaders HTTP_HEADER=null;
	public static HttpStatus STATUS = null;
	public HttpServletRequest REQ_DATA = null;

	public String RESP_CODE="";
	public String RESP_MSG="";
	public long REQ_TIME=0;
	public static Map<String, Object> RESP_BODY = null;
	public static BodyBuilder HTTP_BODY = null;

	public ResponseManager(HttpStatus httpStatus){
		HTTP_HEADER = new HttpHeaders();
		HTTP_HEADER.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		STATUS=httpStatus;
	}

	public static ResponseManager getBuilderInstance(HttpServletRequest request) {
		ResponseManager resManager = new ResponseManager(HttpStatus.OK);
		resManager.setREQ_TIME(System.nanoTime());
		resManager.setREQ_DATA(request);
		resManager.setRESP_CODE("200");
		resManager.setRESP_MSG("정상처리되었습니다.");
		return resManager;
	}

	public static ResponseEntity<Map<String, Object>> getResult(ResponseManager resManager){
		if(resManager != null) {

		}else {
			resManager = new ResponseManager(HttpStatus.BAD_REQUEST);
			resManager.setRESP_CODE("400");
			resManager.setRESP_MSG("잘못된 요청입니다.");
		}

		HTTP_BODY = ResponseEntity.status(STATUS);
		return HTTP_BODY.body(RESP_BODY);
	}

	public void setREQ_DATA(HttpServletRequest request) {
		REQ_DATA=request;
	}

	public HttpServletRequest getREQ_DATA() {
		return REQ_DATA;
	}

	public void setRESP_CODE(String respCode) {
		RESP_CODE=respCode;
	}

	public String getRESP_CODE() {
		return RESP_CODE;
	}

	public void setRESP_MSG(String respMsg) {
		RESP_MSG=respMsg;
	}

	public String getRESP_MSG() {
		return RESP_MSG;
	}

	public void setREQ_TIME(long reqTime) {
		REQ_TIME=reqTime;
	}

	public long getREQ_TIME() {
		return REQ_TIME;
	}

	public void setRESP_STATUS(HttpStatus httpStatus) {
		STATUS=httpStatus;
	}

	public HttpStatus getRESP_STATUS() {
		return STATUS;
	}

	public void setRESULT_BODY(Object object) {
		RESP_BODY = new HashMap<String,Object>();
		RESP_BODY.put("RESP_RESULT", object);
	}

	public Map<String, Object> getRESULT_BODY(){
		return RESP_BODY;
	}

}
