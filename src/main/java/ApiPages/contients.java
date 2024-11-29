package ApiPages;

import Utility.BaseUrl;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;

public class contients {
    BaseUrl Url=new BaseUrl();
    SHAFT.API api=new SHAFT.API(Url.GetUrlForToDOAndBlogsAndcontinents());

    public Response IntialGetRequest(){
       Response response= api.get("contients").performRequest();


       return response;
    }



}
