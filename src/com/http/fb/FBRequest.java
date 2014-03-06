package com.http.fb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.http.fb.utils.Constants;

public class FBRequest {

	public static String generateURL(String token){
		return Constants.fbUrl+Constants.accessTokenInfoApi
				+"?client_id="+Constants.appId
				+"&access_token="+token;
	}

	public static FBResponse checkIfValidFBSession(String token){
		return sendFBRequest(FBRequest.generateURL(token));
	}
	public static FBResponse sendFBRequest(String urlStr){
		FBResponse resp = null;
		InputStream is = null;
		HttpURLConnection connection = null;
		try {
			URL url;
			url = new URL(urlStr);

			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);

			connection.connect();

			int responseCode = connection.getResponseCode();

			//OutputStream os = connection.getOutputStream();
			//PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			//pw.close();
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(connection.getInputStream()));

			//is = connection.getInputStream();
			//BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			resp = new FBResponse(in);	

			in.close();	
			return resp;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			is = connection.getErrorStream();
			InputStreamReader i = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(i);
			resp = new FBResponse(reader);

		}
		return resp;
	}
}
