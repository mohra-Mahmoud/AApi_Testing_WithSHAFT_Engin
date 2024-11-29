package ApiTest;

import ApiPages.Continents;
import com.shaft.driver.SHAFT;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContinentsTestCases {

    @Test
    public void VerifyStatusCode() {
        Continents request = new Continents();
        SHAFT.Validations.assertThat().number(request.IntialGetRequest().getStatusCode()).isEqualTo(200).perform();
    }

    @Test
    public void VerifyFirstContinentStructure() throws JSONException {
        Continents request = new Continents();
        String responseBody = request.IntialGetRequest().getBody().asString();

        // Check for null or empty response
        Assert.assertNotNull(responseBody, "Response body is null");
        Assert.assertFalse(responseBody.isEmpty(), "Response body is empty");

        JSONArray usersArray = new JSONArray(responseBody);
        Assert.assertTrue(usersArray.length() > 0, "Response array is empty");
        JSONObject continent = usersArray.getJSONObject(0);
        SHAFT.Validations.assertThat().object(continent.has("code")).isTrue().perform();
        SHAFT.Validations.assertThat().object(continent.has("name")).isTrue().perform();
        SHAFT.Validations.assertThat().object(continent.has("areaSqKm")).isTrue().perform();
        SHAFT.Validations.assertThat().object(continent.has("lines")).isTrue().perform();
        SHAFT.Validations.assertThat().object(continent.has("countries")).isTrue().perform();
        SHAFT.Validations.assertThat().object(continent.has("oceans")).isTrue().perform();
        SHAFT.Validations.assertThat().object(continent.has("developedCountries")).isTrue().perform();
    }

    @Test
    public void VerifyFirstContinentValues() throws JSONException {
        // Validate the values of the first continent in the response
        Continents request = new Continents();
        String responseBody = request.IntialGetRequest().getBody().asString();

        // Parse JSON response
        JSONArray continentsArray = new JSONArray(responseBody);
        JSONObject continent = continentsArray.getJSONObject(0);

        // Validate individual fields
        SHAFT.Validations.assertThat().object(continent.getString("code")).isEqualTo("AF").perform();
        SHAFT.Validations.assertThat().object(continent.getString("name")).isEqualTo("Africa").perform();
        SHAFT.Validations.assertThat().object(continent.getInt("areaSqKm")).isEqualTo(30370000).perform();

        // Validate "lines" array
        JSONArray linesArray = continent.getJSONArray("lines");
        Assert.assertEquals(linesArray.length(), 2, "Lines array length mismatch");
        SHAFT.Validations.assertThat().object(linesArray.getString(0)).isEqualTo("Equator").perform();
        SHAFT.Validations.assertThat().object(linesArray.getString(1)).isEqualTo("Prime Meridian").perform();

        // Validate "countries"
        SHAFT.Validations.assertThat().number(continent.getInt("countries")).isEqualTo(54).perform();

        // Validate "oceans" array
        JSONArray oceansArray = continent.getJSONArray("oceans");
        Assert.assertEquals(oceansArray.length(), 1, "Oceans array length mismatch");
        SHAFT.Validations.assertThat().object(oceansArray.getString(0)).isEqualTo("Atlantic Ocean, Indian Ocean").perform();

        // Validate "developedCountries" array
        JSONArray developedCountriesArray = continent.getJSONArray("developedCountries");
        Assert.assertEquals(developedCountriesArray.length(), 3, "Developed countries array length mismatch");
        SHAFT.Validations.assertThat().object(developedCountriesArray.getString(0)).isEqualTo("South Africa").perform();
        SHAFT.Validations.assertThat().object(developedCountriesArray.getString(1)).isEqualTo("Egypt").perform();
        SHAFT.Validations.assertThat().object(developedCountriesArray.getString(2)).isEqualTo("Nigeria").perform();
    }
}