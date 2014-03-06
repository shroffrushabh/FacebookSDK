package com.http.fb;

import com.http.fb.utils.Constants;

public class FQLRequestObject {
	public static String generateURL(String token, String query){
		return Constants.fqlUrl+ "?"+Constants.accessToken+"="+token+
				"&"+Constants.query+"="+query;
	}

	public static FBResponse getAppUsers(String token, String query){
		return FBRequest.sendFBRequest(generateURL(token,query));
	}	
}
