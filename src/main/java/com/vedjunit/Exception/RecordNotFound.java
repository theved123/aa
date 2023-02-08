package com.vedjunit.Exception;

import lombok.Data;
@Data
public class RecordNotFound extends RuntimeException {
	public RecordNotFound(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	private int code;
	private String msg;
	
}
