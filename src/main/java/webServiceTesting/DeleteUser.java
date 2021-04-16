package webServiceTesting;



import org.junit.runner.RunWith;

import cucumber.api.*;
import cucumber.api.junit.*;


import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
@CucumberOptions(features="features")

public class DeleteUser {

  private int idUser;
  private final RequestSpecification requestSpecification;

  public DeleteUser() {
    this.requestSpecification = RestAssured.given()
        .baseUri("https://reqres.in/api")
        .basePath("/users");
  }

  public RequestSpecification getRequestSpecification() {
    return requestSpecification;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }


  public String buildBody() {
	  
    JsonObject item = new JsonObject();
	item.addProperty("idUser", this.idUser);

    return  item.toString();
  }


}
