import java.io.IOException;

import com.http.fb.FBRequest;
import com.http.fb.FBResponse;
import com.http.fb.FQLRequestObject;
import com.http.fb.utils.Constants;
import com.http.fb.utils.UtilFunctions;


public class main {

	public static void main(String [] args) throws IOException{
		String token = "CAAE9tZAZBMijsBAHoLBVZA0EPzxHA794whvnxx3pZCBN1pUwIe2Jby8K4ViL9muCOoYWgHMRS9Av71Hl7qZB45NBrIYIqvrIwzHdPt4l7vJLlwooA3t10mo8wpZBlzZBvjsV48taYDZA1HNy8eFGsnAh9gThY2raIjAmRp5n9Ku6yHV82zji9Vvtw2jofzLZBL5WVs1oQA5OpegZDZD";
		FBResponse resp = FBRequest.checkIfValidFBSession(token);

		resp.getSuccess();
		resp.getError();
		
		resp = FQLRequestObject.getAppUsers(token, UtilFunctions.encodeURI(Constants.fqlGetAppUsers));
		resp.getSuccess();
		resp.getError();
		
	}
}