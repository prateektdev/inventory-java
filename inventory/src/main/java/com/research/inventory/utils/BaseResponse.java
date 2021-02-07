package com.research.inventory.utils;

public class BaseResponse {

	private String message;
	private Boolean success;

	public String getMessage() {
		return message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "BaseResponse [message=" + message + ", success=" + success + "]";
	}

	public BaseResponse(Boolean success, String message) {
		super();
		this.message = message;
		this.success = success;
	}

	public BaseResponse() {
	}

}
