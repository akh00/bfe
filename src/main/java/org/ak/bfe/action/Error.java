package org.ak.bfe.action;

public class Error {
	private int code;
	private String message;
	private String description;
	public Error(int code, String message, String description) {
		super();
		this.code = code;
		this.message = message;
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getDescription() {
		return description;
	}
}
