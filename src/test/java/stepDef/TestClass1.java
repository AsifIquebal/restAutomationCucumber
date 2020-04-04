package stepDef;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utility.utils;

import java.util.List;

import static io.restassured.RestAssured.given;

public class TestClass1 {

    Response response;
    List<String> list;

    @When("^user send a GET request to \"(.*?)\"$")
    public void userCallGetApiForAlbums(String string) {
        response = given()
                .when()
                .get(string)
                .then().log().status()
                .extract()
                .response();
    }

    @Then("^status code should be (\\d+)$")
    public void validateGetAlbumStatusCode(int statusCode) {
        Assert.assertEquals("Status Code mismatch", statusCode, response.getStatusCode());
    }

    @When("^user sends a GET request to \"(.*?)\"$")
    public void callAlbumAPItoGetItsSize(String string) {
        response = utils.GET_Response(string);
        list = JsonPath.read(response.asString(), "$.[*].id");
    }

    @Then("^album size should be (\\d+)$")
    public void validateAlbumSize(int albumSize) {
        Assert.assertEquals("Album Size mismatch", albumSize, list.size());
    }

    @When("^user calls the user api \"(.*?)\"$")
    public void callUsersAPI(String string) {
        response = utils.GET_Response(string);
    }

    @Then("^on response user \"(.*?)\" should belong to company \"(.*?)\"$")
    public void validateUsersCompany(String str1, String str2) {
        list = JsonPath.read(response.asString(), "$.[*].[?(@.name=='" + str1 + "')].company.name");
        Assert.assertEquals(list.get(0), str2);
    }

    @When("^user calls the photos api \"(.*?)\"$")
    public void callPhotosAPI(String string) {
        response = utils.GET_Response(string);
    }

    @Then("^on response following details should present$")
    public void dataVerification(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String s1 = response.then().extract().body().path(data.get(1).get(0)).toString();
        Assert.assertEquals(s1, data.get(1).get(1));
        String s2 = response.then().extract().body().path(data.get(2).get(0)).toString();
        Assert.assertEquals(s2, data.get(2).get(1));
    }

}
