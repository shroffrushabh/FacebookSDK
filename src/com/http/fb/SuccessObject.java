package com.http.fb;

public class SuccessObject {
	private Object access_token;
	private Object token_type;
	private Object expires_in;
	private Object data;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getAccess_token() {
		return access_token;
	}
	public void setAccess_token(Object access_token) {
		this.access_token = access_token;
	}
	public Object getToken_type() {
		return token_type;
	}
	public void setToken_type(Object token_type) {
		this.token_type = token_type;
	}
	public Object getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Object expires_in) {
		this.expires_in = expires_in;
	}
}
