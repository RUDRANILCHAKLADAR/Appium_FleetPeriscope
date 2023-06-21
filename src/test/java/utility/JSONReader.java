package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
    public static JSONObject getJSONData()  {
        JSONObject jsonObject = null;
        try (FileInputStream inputStream = new
                FileInputStream("//Users//MDehury//Desktop//Appium_PeriScope//src//test//java//data//users.json"))
        {
            JSONTokener jsonTokener = new JSONTokener(inputStream);
            jsonObject = new JSONObject(jsonTokener);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(jsonObject);
    }

//    public String[] readJsonData() throws IOException, ParseException {
//        JSONParser jsonparser=new JSONParser();
//        FileReader reader=new FileReader(".\\data\\users.json");
//        Object obj=jsonparser.parse(reader);
//        JSONObject userLoginsJsonObj=(JSONObject)obj;
//        JSONArray userLoginsArray=(JSONArray)userLoginsJsonObj.get("user-logins");
//        String arr[]=new String[userLoginsArray.size()];
//        for (int i=0; i<userLoginsArray.size();i++)
//        {
//            JSONObject users=(JSONObject) userLoginsArray.get(i);
//            String user=(String)users.get("username");
//            String pwd=(String)users.get("password");
//            arr[i]=user+"," +pwd ;
//        }
//        return arr;
//    }

//    public static JSONObject readJSOn() throws IOException, ParseException {
//        JSONParser jsonParser = new JSONParser();
//        FileReader reader = new FileReader(".\\data\\users.json");
//        Object obj = jsonParser.parse(reader);
//        JSONObject userData= (JSONObject) obj;
//
//        return null;
//    }


}
