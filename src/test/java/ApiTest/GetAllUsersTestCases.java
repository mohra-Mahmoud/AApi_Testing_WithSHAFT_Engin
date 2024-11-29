package ApiTest;

import ApiPages.ListOfUsers;
import com.google.gson.JsonParser;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class GetAllUsersTestCases {
   static ListOfUsers response =new ListOfUsers();
    @Test
    public void VerifyStatusCode(){

    Assert.assertEquals(response.getListOfUsers().getStatusCode(),200,"the statuse code is wrong");

    }

    @Test
    public void VerifyFirstContinentValues() throws JSONException {
      Response response_GetRequest=response.getListOfUsers();

      String responsebody= response_GetRequest.getBody().asString();

        // Step 2: Extract the response body as a JSON array
        JSONArray usersArray = new JSONArray(responsebody);

        // Step 3: Verify that the response contains 10 user objects
        Assert.assertEquals(usersArray.length(), 10, "Expected 10 users in the response.");

        // Step 4: Verify the structure of each user object
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject user = usersArray.getJSONObject(i);

            // Check if the required keys exist
            SHAFT.Validations.assertThat().object(user.has("id")).isTrue().perform();
            SHAFT.Validations.assertThat().object(user.has("name")).isTrue().perform();
            SHAFT.Validations.assertThat().object(user.has("email")).isTrue().perform();

            // Check the data types of the fields
            Assert.assertTrue(user.get("id") instanceof Integer, "'id' should be an integer.");
            Assert.assertTrue(user.get("name") instanceof String, "'name' should be a string.");
            Assert.assertTrue(user.get("email") instanceof String, "'email' should be a string.");


        }
  }



    }







