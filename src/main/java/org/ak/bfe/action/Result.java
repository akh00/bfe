package org.ak.bfe.action;

import java.util.List;

public class Result {
	private int code;
	private List<Error> errors;
	
	public Result(int code, List<Error> errors) {
		super();
		this.code = code;
		this.errors = errors;
	}

	public int getCode(){
		return code;
	}

	public List<Error> getErrors()
	{
		return errors;
	}
}
