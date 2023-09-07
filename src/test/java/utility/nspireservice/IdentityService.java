package utility.nspireservice;



import com.mashape.unirest.http.utils.Base64Coder;


import com.mashape.unirest.http.Unirest;


import core.http.HttpClient;
import utility.model.UserToken;

import java.util.Map;

public class IdentityService
{
    public static UserToken getUserToken(String identityBaseUrl, Map<String, String> headers, String username, String password) {
        /**
         * HashMap<String, String> headers = new HashMap<String, String>();
         * headers.put("X-Nspire-AppToken", "f07740dc-1252-48f3-9165-c5263bbf373c")
         */
        try {
            Unirest.setTimeouts(60000L, 60000L);
            String finalUrl = identityBaseUrl + "/token";
            System.out.println("identity service http url : "+finalUrl);
            headers.put("Authorization", "Basic " + Base64Coder.encodeString(username + ":" + password));
            HttpClient client = new HttpClient();
            return client.get(finalUrl, null, null, headers, UserToken.class).getParsedObject();
        }
        catch (Exception e){
            System.out.println("identity service error : "+e.getLocalizedMessage());
            return null;
        }
    }
}
