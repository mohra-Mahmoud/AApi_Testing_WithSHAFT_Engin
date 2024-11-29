package ApiPages;

import Utility.BaseUrl;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;

public class ListOfToDo {
    static BaseUrl url = new BaseUrl();
    static SHAFT.API api = new SHAFT.API(url.GetUrlForToDOAndBlogsAndcontinents());

    public Response GetListToDo() {
        Response response = api.get("todos").performRequest();
        return response;

    }


}
