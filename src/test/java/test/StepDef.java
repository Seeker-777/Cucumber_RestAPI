package test;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class StepDef {

	Response response;
    
	
	RequestSpecification request;
	
	@Given("^The \"([^\"]*)\" for Get Operation$")
    public void the_something_for_get_operation(String baseuri) throws Throwable {
		
		request = RestAssured.given().baseUri(baseuri);
        
    }
	
	@Given("^The \"([^\"]*)\" for Post Operation and token is \"([^\"]*)\"$")
    public void the_something_for_post_operation_and_token_is_something(String Base_URI, String token) throws Throwable {
        
    	 request = (RequestSpecification) RestAssured.given().baseUri(Base_URI)
    			.contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .auth()
				   .oauth2(token)
				   .body("{\n" + 
				   		"    \"name\": \"Postman_Rest\",\n" + 
				   		"    \"desription\": \"Test Repo\",\n" + 
				   		"    \"homepage\": \"https://github.com/\",\n" + 
				   		"    \"private\": false,\n" + 
				   		"    \"has_issues\": true,\n" + 
				   		"    \"has_projects\": true,\n" + 
				   		"    \"has_wiki\": true\n" + 
				   		"}");
				   
    }

	@Given("^The \"([^\"]*)\" for Patch Operation and token is \"([^\"]*)\"$")
    public void the_something_for_patch_operation_and_token_is_something(String Base_URI, String token) throws Throwable {
        
		request = (RequestSpecification) RestAssured.given().baseUri(Base_URI)
    			.contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .auth()
				   .oauth2(token)
				   .body("{\n" + 
				   		"    \"name\": \"Postman_RestAPI\",\n" + 
				   		"    \"desription\": \"Test Repo\",\n" + 
				   		"    \"homepage\": \"https://github.com/\",\n" + 
				   		"    \"private\": false,\n" + 
				   		"    \"has_issues\": true,\n" + 
				   		"    \"has_projects\": true,\n" + 
				   		"    \"has_wiki\": true\n" + 
				   		"}");
		
    }

    @When("^User perform the Patch Operation$")
    public void user_perform_the_patch_operation() throws Throwable {
        
response = request.patch();
    	
    	String responsestring = response.then().extract().asString();
        System.out.println(responsestring);
    }

    @When("^User perform the Get Operation$")
    public void user_perform_the_get_operation() throws Throwable {
    	
    	response = request.get();
    	
    	String responsestring = response.then().extract().asString();
        System.out.println(responsestring);
        
    }
    
    @When("^User perform the Post Operation$")
    public void user_perform_the_post_operation() throws Throwable {
    	response = request.post(); 
    	String responsestring = response.then().extract().asString();
        System.out.println(responsestring);
    }


    @Then("^Response should not be null$")
    public void response_should_not_be_null() throws Throwable {
       
    	Assert.assertNotNull(response);
    }

    
    
    @And("^\"([^\"]*)\" should be as expected$")
    public void something_should_be_as_expected(int responsecode) throws Throwable {
        
    	Assert.assertEquals(responsecode, response.getStatusCode());
    }

  
    
}
