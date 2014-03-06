package com.http.fb.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UtilFunctions {
	public static String encodeURI(String url) throws UnsupportedEncodingException{
		return URLEncoder.encode(url, "UTF-8").replace("+", "%20");
	}
}
