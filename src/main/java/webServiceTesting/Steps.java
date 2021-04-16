package webServiceTesting;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public  class Steps {

  CreateUser createUser;
  String name, job;

  @Given("^I use user creation service$")
  public void useUserCreationWebService() {
    createUser = new CreateUser();
  }

  @When("^I set name \"([^\"]*)\"$")
  public void setName(String name) {
    createUser.setName(name);
    this.name = name;
  }

  @When("^I set job \"([^\"]*)\"$")
  public void setJob(String job) {
  }

  @Then("^I validate my 1 response is \"([^\"]*)\"$")
  public void validateMyResponseIsCorrect(int code) throws Throwable {
	  int statusCode = createUser.getRequestSpecification()
	  	.header("Content-Type", "application/json")
	  	.body(createUser.buildBody())
	  	.post().getStatusCode();
			  	
	  if(statusCode != code) {
		  throw new PendingException();
	  }
  }

  
}
