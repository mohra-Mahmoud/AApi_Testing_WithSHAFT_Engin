package ApiPages;

import Utility.BaseUrl;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;

public class listofPost {
    //Instantiate from BaseUrl
    BaseUrl url=new BaseUrl();
    //take object from SHAFT ENGIN API
    SHAFT.API api=new SHAFT.API(url.GetUrlForToDOAndBlogsAndcontinents());
    // create method to call API
      public Response IntialGetRequest(){

      return api.get("posts").performRequest() ;


    }




}
