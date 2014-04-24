package com.http.fb;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FBResponse {
	private SuccessObject success;
	public SuccessObject getSuccess() {
		return success;
	}

	public void setSuccess(SuccessObject success) {
		this.success = success;
	}

	private ErrorObject error;

	public ErrorObject getError() {
		return error;
	}

	public void setError(ErrorObject error) {
		this.error = error;
	}

	public FBResponse(BufferedReader reader) {
		// TODO Auto-generated constructor stub
		String line = null;
		StringBuilder sb = new StringBuilder();
		JSONObject responseJson;
		try {
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response = sb.toString();
		
		responseJson = null;		
		responseJson = parseJSON(response);
				
		if(responseJson.containsKey("data")) {
			success = new SuccessObject();
			success.setData(responseJson.get("data"));
		} else if(!responseJson.containsKey("error")) {
			success = new SuccessObject();
			success.setAccess_token( responseJson.get("access_token"));
			success.setExpires_in( responseJson.get("expires_in"));
			success.setToken_type( responseJson.get("token_type"));
		} else {
			error = new ErrorObject();
			JSONObject errorJson = (JSONObject) responseJson.get("error");
			error.getError().put("message", errorJson.get("message"));
			error.getError().put("type", errorJson.get("type"));
			error.getError().put("code", errorJson.get("code"));
		}
	}

	public JSONObject parseJSON(String json){
		JSONObject obj = null;
		try {
			obj = (JSONObject)new JSONParser().parse(json);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

}
