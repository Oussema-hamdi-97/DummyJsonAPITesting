package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import oussema.pojoclasses.productPOJO.AllProductResponse;
import oussema.pojoclasses.userPOJO.AllUserResponse;
import oussema.pojoclasses.userPOJO.Users;
import resources.Utils;
import java.io.FileNotFoundException;


import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    RequestSpecification theBaseRequest;
    Response response;
    RequestSpecification request;

    @Given("The BaseURI for DummyJson")
    public void the_base_uri_for_dummy_json() throws FileNotFoundException {
        request = baseRequest();
        theBaseRequest = given().spec(request);
    }
    @When("User calls GetProductAPI with GET http request")
    public void user_calls_get_product_api_with_get_http_request() {
        response = theBaseRequest.when()
                .get("/products").then().extract().response();
    }
    @Then("The API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer expectedStatusCode) {
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,expectedStatusCode);
    }

    @When("User calls GetProductAPI with GET http request using {string}")
    public void user_calls_get_product_api_with_get_http_request_using(String id) {
        response = theBaseRequest.when()
                .get("/products"+"/"+id).then().extract().response();
    }

    @When("User calls SearchProductAPI with GET http request and search for {string}")
    public void user_calls_search_product_api_with_get_http_request(String product) {
        response = theBaseRequest.queryParam("q",product).when()
                .get("/products/search").then().extract().response();
    }

    @Then("The total number of products is not null")
    public void the_total_number_of_products_is_not_null(){
        AllProductResponse allProductResponse = response.as(AllProductResponse.class);
        Assert.assertTrue(allProductResponse.getTotal()>0);
    }

    @Then("The API call is failed with status code {int}")
    public void the_api_call_is_failed_with_status_code(Integer expectedStatusCode) {
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,expectedStatusCode);
    }

    @Then("message in response is {string} with id {string} not found")
    public void message_in_response_is_Product_with_id_not_found(String message,String id){
        JsonPath js = new JsonPath(response.asString());
        String actualResult = js.get("message");
        String expectedResult = message+" with id '"+id+"' not found";
        Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult));
    }

    @Then("The total number of products is null")
    public void the_total_number_of_products_is_null(){
        AllProductResponse allProductResponse = response.as(AllProductResponse.class);
        Assert.assertTrue(allProductResponse.getTotal()==0);
    }

    @When("User calls GetUserAPI with GET http request")
    public void user_calls_get_user_api_with_get_http_request() {
        response = theBaseRequest.when()
                .get("/users").then().extract().response();
    }

    @When("User calls GetUserAPI with GET http request using {string}")
    public void user_calls_get_user_api_with_get_http_request_using(String id) {
        response = theBaseRequest.when()
                .get("/users"+"/"+id).then().extract().response();
        //Users users = response.as(Users.class);
        //System.out.println(users.getFirstName());
    }
}
