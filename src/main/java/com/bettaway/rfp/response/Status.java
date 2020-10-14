package com.bettaway.rfp.response;

public enum Status {
	SUCCESS("SUCCESS"), FAILURE("FAILURE");

	String code;

	private Status(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
