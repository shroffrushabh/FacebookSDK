package com.http.fb;

import java.util.HashMap;

public class ErrorObject {
	private HashMap<Object, Object> error;
	public HashMap<Object, Object> getError() {
		return error;
	}
	public void setError(HashMap<Object, Object> error) {
		this.error = error;
	}
	ErrorObject(){
		error = new HashMap<Object, Object>();
	}
}
