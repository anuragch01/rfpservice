package com.bettaway.rfp.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean {
	private Status status;
	private String message;
	private Object payload;
	private List<ErrorBean> error;

	public ResponseBean() {
		super();
	}

	public ResponseBean(Status status, Object payload, List<ErrorBean> error, String message) {
		super();
		this.message = message;
		this.status = status;
		this.payload = payload;
		this.error = error;
	}

	public ResponseBean(Status status, Object payload, String message) {
		super();
		this.status = status;
		this.payload = payload;
		this.message = message;
	}

	public ResponseBean(Status status, List<ErrorBean> error, String message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public ResponseBean(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getPayload() {
		return payload;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public List<ErrorBean> getError() {
		return error;
	}

	public void setError(List<ErrorBean> error) {
		this.error = error;
	}

	public static ResponseBean of(Status status, Object payload, List<ErrorBean> error, String message) {
		return new ResponseBean(status, payload, error, message);
	}

	public static ResponseBean failure(List<ErrorBean> error, String message) {
		return new ResponseBean(Status.FAILURE, error, message);
	}

	public static ResponseBean success(Object payload, String message) {
		return new ResponseBean(Status.SUCCESS, payload, message);
	}

	public static ResponseBean success(String message) {
		return new ResponseBean(Status.SUCCESS, message);
	}

	public static ResponseBean failure(String message) {
		return new ResponseBean(Status.FAILURE, message);
	}
}
