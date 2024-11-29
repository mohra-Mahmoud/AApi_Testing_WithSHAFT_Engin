package ApiPages;

import Utility.BaseUrl;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;

public class ListOfCompanies extends Utility.BaseUrl {
    BaseUrl Url=new BaseUrl();
    SHAFT.API api=new SHAFT.API(Url.GetUrlForCompaniesAndUser());
    public Response getListOfCompanies(){
        Response response=api.get("companies").performRequest();

     return response;
    }


}
