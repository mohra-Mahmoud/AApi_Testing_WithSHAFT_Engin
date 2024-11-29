package Utility;

import com.shaft.driver.SHAFT;

public class BaseUrl {
    private String BaseUrl;
    public String GetUrlForCompaniesAndUser(){
       this.BaseUrl= "https://fake-json-api.mock.beeceptor.com/";
      return BaseUrl;
    }


    public String GetUrlForToDOAndBlogsAndcontinents(){
        this.BaseUrl= "https://dummy-json.mock.beeceptor.com/";
        return BaseUrl;
    }
}
