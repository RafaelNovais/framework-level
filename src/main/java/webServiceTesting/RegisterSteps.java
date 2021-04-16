package webServiceTesting;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public  class RegisterSteps {

  Register register;
  String email;

  @Given("^I want to use the service to register a new user$")
  public void useUserCreationWebService() {
	  register = new Register();
  }

  @When("^I set email \"([^\"]*)\"$")
  public void setEmail(String email) {
	  register.setEmail(email);
    this.email = email;
  }


  @Then("^I validate if register was not included \"([^\"]*)\"$")
  public void validateMyResponseIsIncorrect(int code) throws Throwable {
	  int statusCode = register.getRequestSpecification()
	  	.header("Content-Type", "application/json")
	  	.body(register.buildBody())
	  	.post().getStatusCode();
			  	
	  if(statusCode != code) {
		  throw new PendingException();
	  }
  }
}
