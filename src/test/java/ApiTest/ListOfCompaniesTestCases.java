package ApiTest;

import ApiPages.ListOfCompanies;
import com.shaft.driver.SHAFT;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListOfCompaniesTestCases   {
    static  ListOfCompanies response = new ListOfCompanies();

    @Test
    public void VerifyStatusCode() {
        // Verify status code is 200
        Assert.assertEquals(response.getListOfCompanies().getStatusCode(), 200, "The status code is wrong");
    }

    @Test
    public void VerifyEachObjectStructure() throws JSONException {
        // Send GET request and get the response
        Response apiResponse = response.getListOfCompanies();

        // Extract the response body as a string
        String responseBody = apiResponse.getBody().asString();

        // Parse the response body as a JSON array
        JSONArray companiesArray = new JSONArray(responseBody);

        // Verify the length of the array
        Assert.assertEquals(companiesArray.length(), 11, "The list does not equal 10");

        // Verify the structure of each object in the array
        for (int i = 0; i < companiesArray.length(); i++) {
            JSONObject company = companiesArray.getJSONObject(i);
            SHAFT.Validations.assertThat().object(company.has("id")).isTrue().perform();
            SHAFT.Validations.assertThat().object(company.has("name")).isTrue().perform();
            SHAFT.Validations.assertThat().object(company.has("ceoName")).isTrue().perform();
            SHAFT.Validations.assertThat().object(company.has("address")).isTrue().perform();
            SHAFT.Validations.assertThat().object(company.has("domain")).isTrue().perform();
            SHAFT.Validations.assertThat().object(company.has("employeeCount")).isTrue().perform();






        }
    }
}







