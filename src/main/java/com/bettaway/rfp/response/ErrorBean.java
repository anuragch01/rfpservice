package com.bettaway.rfp.response;

import java.util.*;

public class ErrorBean {
	private String code;
	private String message;

	private ErrorBean() {
		super();
	}

	private ErrorBean(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static ErrorBean of(String code, String message) {
		return new ErrorBean(code, message);
	}

	public static List<ErrorBean> toList(String code, String message) {
		return Arrays.asList(new ErrorBean(code, message));
	}

	public static List<ErrorBean> toList(Map<String, String> errorBeanMap) {
		List<ErrorBean> errorBeanList = new ArrayList<>();
		if (!Objects.isNull(errorBeanMap))
			errorBeanMap.forEach((key, value) -> errorBeanList.add(ErrorBean.of(key, value)));
		return errorBeanList;
	}
}
