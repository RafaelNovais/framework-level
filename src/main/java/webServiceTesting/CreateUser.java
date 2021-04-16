package webServiceTesting;



import org.junit.runner.RunWith;

import cucumber.api.*;
import cucumber.api.junit.*;


import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
@CucumberOptions(features="features")

public class CreateUser {

  private String name;
  private String surname;
  private String job;
  private final RequestSpecification requestSpecification;

  public CreateUser() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api")
        .basePath("/users");
  }

  public RequestSpecification getRequestSpecification() {
    return requestSpecification;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
	  
    this.surname = surname;
  }
  
  public void setJob(String job) {
    this.job = job;
  }
  

  public String buildBody() {
	  
    JsonObject item = new JsonObject();
	item.addProperty("name", this.name);
	item.addProperty("job", this.job);
    
    return  item.toString();
  }

  public String buildBodyWithSurname() {
	  JsonObject item = new JsonObject();
	  item.addProperty("name", this.name + " " + this.surname);
	  item.addProperty("job", this.job);
	
	  return  item.toString();
  }
  
  public int executeRequest(CreateUser createUser) {
	  
	return createUser.getRequestSpecification()
		  	.header("Content-Type", "application/json")
		  	.body(createUser.buildBody())
		  	.post().getStatusCode(); 
  }
}
