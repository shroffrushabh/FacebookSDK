import java.io.IOException;

import com.http.fb.FBRequest;
import com.http.fb.FBResponse;
import com.http.fb.FQLRequestObject;
import com.http.fb.utils.Constants;
import com.http.fb.utils.UtilFunctions;


public class main {

	public static void main(String [] args) throws IOException{
		String token = "CAACEdEose0cBAKVVwaf16iSma88vK5UL6tOFmrVQgnmg93qy0rfMsFnZAzM5Usjmt0zj7FgNKPiEXaMWz2FELQ9na0Q6Bk2UyMeXtv5s7lAFS9FGXfsZAAffZAAsDAq5ri6dLWwG0yXXFsZBuiLuZC1GoTx3vJgzyXvkH5Q4uhidoGPmZC70odIAtXLGgezrEcp1w7qiZBPhQZDZD";
		FBResponse resp = FBRequest.checkIfValidFBSession(token);

		resp.getSuccess();
		resp.getError();
		
		resp = FQLRequestObject.getAppUsers(token, UtilFunctions.encodeURI(Constants.fqlGetAppUsers));
		resp.getSuccess();
		resp.getError();
		
	}
}