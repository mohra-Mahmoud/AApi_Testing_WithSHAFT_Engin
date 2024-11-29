package ApiTest;

import ApiPages.contients;
import ApiPages.listofPost;
import com.shaft.driver.SHAFT;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

@Test

public class ListOfPostsTestCases {
    static listofPost respons;

    public void VerifyStatusCode() {
        respons = new listofPost();
        SHAFT.Validations.assertThat().number(respons.IntialGetRequest().getStatusCode()).isEqualTo(200).
                withCustomReportMessage("Verify status code is 200")
                .perform();

    }

    @Test
    public void validateJsonKeys() throws JSONException {
        respons = new listofPost();
        String responsebody = respons.IntialGetRequest().body().asString();

        // Convert the response body to JSON Object
        JSONArray usersArray = new JSONArray(responsebody);
        JSONObject FirstPost = new JSONObject().getJSONObject((String.valueOf(usersArray.get(0))));
        SHAFT.Validations.assertThat().object(FirstPost.has("userId")).isTrue().perform();
        SHAFT.Validations.assertThat().object(FirstPost.has("id")).isTrue().perform();
        SHAFT.Validations.assertThat().object(FirstPost.has("title")).isTrue().perform();
        SHAFT.Validations.assertThat().object(FirstPost.has("body")).isTrue().perform();
        SHAFT.Validations.assertThat().object(FirstPost.has("link")).isTrue().perform();
        SHAFT.Validations.assertThat().object(FirstPost.has("comment_count")).isTrue().perform();



    }
    /*
     "userId": 1,
    "id": 1,
    "title": "Introduction to Artificial Intelligence",
    "body": "Learn the basics of Artificial Intelligence and its applications in various industries.",
    "link": "https://example.com/article1",
    "comment_count": 8
     */


public void CheckValuesForFirstObject() throws JSONException {
    listofPost Request=new listofPost();
    String response=Request.IntialGetRequest().getBody().asString();
    JSONArray PostsArray = new JSONArray(response);
    JSONObject Post=new JSONObject(String.valueOf(PostsArray.get(0)));
    SHAFT.Validations.assertThat().object(Post.get("userId")).isEqualTo(1).perform();
    SHAFT.Validations.assertThat().object(Post.get("id")).isEqualTo(1).perform();
    SHAFT.Validations.assertThat().object(Post.get("title")).isEqualTo("Introduction to Artificial Intelligence").perform();
    SHAFT.Validations.assertThat().object(Post.get("body")).isEqualTo("\"Learn the basics of Artificial Intelligence and its applications in various industries.").perform();
    SHAFT.Validations.assertThat().object(Post.get("link")).isEqualTo("https://example.com/article1").perform();
    SHAFT.Validations.assertThat().object(Post.get("comment_count")).isEqualTo(8).perform();




}



}
