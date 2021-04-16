package webServiceTesting.unit;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import webServiceTesting.CreateUser;

public class CreateUserTest {

  CreateUser createUser = new CreateUser();
  String jsonWithUserAndJob = "{\"name\":\"testName\",\"job\":\"testJob\"}";

  String jsonWithUserNameSurnameAndJob = "{\"name\":\"testName autoSurname\",\"job\":\"testJob\"}";

  @Before
  public void setup() {
    createUser.setName("testName");
    createUser.setSurname("autoSurname");
    createUser.setJob("testJob");
//	  Response res = createUser.getRequestSpecification().given()
//	  	.contentType(ContentType.JSON)
//	  	.when()
//	  	.get("/users")
//	  	.then()
//	  	.extract().response();
//	  System.out.println(createUser.getRequestSpecification()
//			  .expect()
//			  .response()
//			  );
  }

  @Test
  public void buildBody_validUserAndJob_shouldReturnJsonWithUserAndJob() {
	  Assert.assertEquals(jsonWithUserAndJob, createUser.buildBody());
  }

  @Test
  public void buildBodyWithSurname_validUserAndJob_shouldReturnJsonWithUserNameSurnameAndJob() {
    Assert.assertEquals(jsonWithUserNameSurnameAndJob, createUser.buildBodyWithSurname());
  }

}