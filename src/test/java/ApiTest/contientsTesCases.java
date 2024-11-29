package ApiTest;

import ApiPages.contients;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class contientsTesCases {

@Test
    public void VerifyStatuscode(){
       contients Request=new contients();
        SHAFT.Validations.assertThat().number(Request.IntialGetRequest().getStatusCode()).isEqualTo(200).perform();

    }
    @Test
    public void GetTheFirstObject() throws JSONException {

        contients Request=new contients();
        String response=Request.IntialGetRequest().getBody().asString();
     JSONArray usersArray = new JSONArray(response).getJSONArray(0);
        JSONObject contianent=new JSONObject(String.valueOf(usersArray));
        SHAFT.Validations.assertThat().object(contianent.has("code")).isTrue().perform();
        SHAFT.Validations.assertThat().object(contianent.has("name")).isTrue().perform();
        SHAFT.Validations.assertThat().object(contianent.has("areaSqKm")).isTrue().perform();
        SHAFT.Validations.assertThat().object(contianent.has("lines")).isTrue().perform();
        SHAFT.Validations.assertThat().object(contianent.has("countries")).isTrue().perform();
        SHAFT.Validations.assertThat().object(contianent.has("oceans")).isTrue().perform();
        SHAFT.Validations.assertThat().object(contianent.has("developedCountries")).isTrue().perform();}

    @Test
    public void CheckValuesForFirstObject() throws JSONException {
        contients Request=new contients();
        String response=Request.IntialGetRequest().getBody().asString();
        JSONArray usersArray = new JSONArray(response).getJSONArray(0);
        JSONObject contianent=new JSONObject(String.valueOf(usersArray));
        SHAFT.Validations.assertThat().object(contianent.has("code")).isEqualTo("AF").perform();
        SHAFT.Validations.assertThat().object(contianent.has("name")).isEqualTo("Africa").perform();
        SHAFT.Validations.assertThat().object(contianent.has("areaSqKm")).isEqualTo("30370000").perform();
        SHAFT.Validations.assertThat().object(contianent.has("lines")).isEqualTo("[\"Equator\", \"Prime Meridian\"]").perform();
        SHAFT.Validations.assertThat().object(contianent.has("countries")).isEqualTo(54).perform();
        SHAFT.Validations.assertThat().object(contianent.has("oceans")).isEqualTo("[\"Atlantic Ocean, Indian Ocean\"]").perform();
        SHAFT.Validations.assertThat().object(contianent.has("developedCountries")).isEqualTo("[\"South Africa\", \"Egypt\", \"Nigeria\"]").perform();












    }





}
