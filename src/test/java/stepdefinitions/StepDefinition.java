package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import oussema.pojoclasses.LoginPOJO.LoginCredentials;
import oussema.pojoclasses.LoginPOJO.LoginResponse;
import oussema.pojoclasses.ProductPOJO.AllProductResponse;
import oussema.pojoclasses.UserPOJO.User;
import resources.Utils;
import java.io.FileNotFoundException;


import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    RequestSpecification theBaseRequest;
    Response response;
    RequestSpecification request;
    LoginCredentials loginCredentials;
    static String username;
    static String password;

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

    @When("User calls GetCartAPI with GET http request")
    public void user_calls_get_cart_api_with_get_http_request() {
        response = theBaseRequest.when()
                .get("/carts").then().extract().response();
    }

    @When("User calls GetSingleCartAPI with GET http request and id {string}")
    public void user_calls_get_single_cart_api_with_get_http_request_and_id(String id) {
        response = theBaseRequest.when()
                .get("/carts"+"/"+id).then().extract().response();
    }

    @When("User calls GetRecipeAPI with GET http request")
    public void user_calls_get_recipe_api_with_get_http_request() {
        response = theBaseRequest.when()
                .get("/recipes").then().extract().response();
    }

    @When("User calls GetSingleRecipeAPI with GET http request and id {string}")
    public void user_calls_get_single_recipe_api_with_get_http_request_and_id(String id) {
        response = theBaseRequest.when()
                .get("/recipes"+"/"+id).then().extract().response();
    }

    @When("User calls UserLoginAPI with POST http request")
    public void user_calls_user_login_api_with_post_http_request() {
        loginCredentials.setUsername(username);
        loginCredentials.setPassword(password);
        response = theBaseRequest.body(loginCredentials).when()
                .post("/auth/login").then().extract().response();
    }

    @Given("Access Token Expire Time in minutes {int}")
    public void access_token_expire_time_in_minutes(int expireTime) {
        loginCredentials = new LoginCredentials();
        loginCredentials.setExpiresInMins(expireTime);
    }

    @Then("Username and password are stored")
    public void username_and_password_are_stored(){
        User userToLogin = response.as(User.class);
        username = userToLogin.getUsername();
        password = userToLogin.getPassword();
    }

    @When("User calls UserLoginAPI with POST http request with invalid Username {string} and Password {string}")
    public void user_calls_user_login_api_with_post_http_request_with_invalid_username_and_password(String username,String password) {
        loginCredentials.setUsername(username);
        loginCredentials.setPassword(password);
        response = theBaseRequest.body(loginCredentials).when()
                .post("/auth/login").then().extract().response();
    }

    @Then("message in response is {string}")
    public void message_in_response_is_Product_with_id_not_found(String message){
        JsonPath js = new JsonPath(response.asString());
        String actualResult = js.get("message");
        String expectedResult = message;
        Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult));
    }
}
