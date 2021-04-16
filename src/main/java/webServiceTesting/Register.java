package webServiceTesting;



import org.junit.runner.RunWith;

import cucumber.api.*;
import cucumber.api.junit.*;


import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
@CucumberOptions(features="features")

public class Register {

  private String email;
  private final RequestSpecification requestSpecification;

  public Register() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api")
        .basePath("/register");
  }

  public RequestSpecification getRequestSpecification() {
    return requestSpecification;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String buildBody() {
	  
    JsonObject item = new JsonObject();
	item.addProperty("email", this.email);

    
    return  item.toString();
  }


}
