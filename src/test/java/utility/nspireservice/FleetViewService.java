package utility.nspireservice;

import com.mashape.unirest.http.Unirest;
import core.http.HttpClient;
import core.http.Response;


import java.util.Map;

public class FleetViewService {

    private static String fleetViewServiceBaseUrl;

    public static void setFleetViewServiceBaseUrl(String baseUrl) {
        fleetViewServiceBaseUrl = baseUrl;
    }
    public static <T> T getAssetList(Map<String, String> headers, org.json.JSONObject jsonData) {
        /**
         * HashMap<String, String> headers = new HashMap<String, String>();
         *             headers.put("x-nspire-usertoken", userTokenResponse.getToken()); // received from Identity service
         *             headers.put("Content-Type", "application/json");
         */
        try{
            Unirest.setTimeouts(60000L, 60000L);
            HttpClient client = new HttpClient();
            String finalUrl =  fleetViewServiceBaseUrl + "/api/assets";
            System.out.println("fleetviewservice url: "+ finalUrl);
            Response<Object> response =  client.post(finalUrl,null,null,headers,jsonData);
            return (T) response.getParsedObject();
        }
        catch (Exception e){
            System.out.println("error while fetching asset list from fleetPeriscope: "+e.getLocalizedMessage());
            return null;
        }

    }


}
