package ApiPages;

import Utility.BaseUrl;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;

public class ListOfUsers extends Utility.BaseUrl  {
    BaseUrl Url=new BaseUrl();
    SHAFT.API api=new SHAFT.API(Url.GetUrlForCompaniesAndUser());
    public Response getListOfUsers(){
        Response response=api.get("users").performRequest();

        return response;
    }
    }












