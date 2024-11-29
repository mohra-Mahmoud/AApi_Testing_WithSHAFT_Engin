package ApiTest;

import ApiPages.ListOfToDo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

public class ToDoTestCases {

    static ListOfToDo Intialrequest = new ListOfToDo();
    static Response response = Intialrequest.GetListToDo();
    static String responsebody;

    @Test
    public void VerifyStatusCode() {
        Assert.assertEquals(response.getStatusCode(), 200, " the status in not expected ");

    }

    @Test
    public void VerifyFirstObjectCompleteStatus() throws JSONException {
        responsebody = response.body().asString();
        JSONArray todoarray = new JSONArray(responsebody);
        for (int i = 0; i < todoarray.length(); i++) {
            JSONObject responsearray = todoarray.getJSONObject(i);
            Assert.assertFalse(responsearray.has("complete"), " the status return fales");

        }
    }

    @Test()
    public void VerifyFirstObjecttitle() throws JSONException {
        responsebody = response.body().asString();
      JSONArray  todoarray = new JSONArray(responsebody);
        JSONObject response = new JSONObject(String.valueOf(todoarray.get(0)));
        Assert.assertEquals(response.get("title"), "Buy groceries");
        Assert.assertTrue(response.get("id") instanceof Integer, "'id' should be an integer.");

    }
    // Asset that IDS is Unique

    @Test
    public void VerifyUniqueIds() throws JSONException {
        // Extract the response body as a string
        responsebody = response.body().asString();

        // Parse the response body into a JSON array
        JSONArray todoarray = new JSONArray(responsebody);

        // Create a HashSet to store IDs
        HashSet<Integer> idSet = new HashSet<>();

        // Iterate through the JSON array
        for (int i = 0; i < todoarray.length(); i++) {
            JSONObject responseObject = todoarray.getJSONObject(i);

            // Extract the "id" field from each object
            int id = responseObject.getInt("id");

            // Add the ID to the HashSet
            idSet.add(id);
        }

        // Assert that the size of the HashSet matches the array length
        Assert.assertEquals(idSet.size(), todoarray.length(), "Some IDs in the list are not unique.");
    }

}













