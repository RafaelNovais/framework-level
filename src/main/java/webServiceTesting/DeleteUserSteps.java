package webServiceTesting;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public  class DeleteUserSteps {

  DeleteUser deleteUser;
  int idUser;
 

  
  @Given("^I use delete creation service$")
  public void useUserCreationWebService() {
	  deleteUser = new DeleteUser();
  }
  
  @Given("^I Create a user before$")
  public void TestCreateUser() {
	  CreateUser createUser = new CreateUser();
	  
	  createUser.setName("Toy");
	  createUser.setJob("singer");
	  createUser.executeRequest(createUser);
	    
   
  }  
 
  @When("^I set user \"([^\"]*)\"$")
  public void setIdUser(int idUser) {
	  deleteUser.setIdUser(idUser);
    this.idUser = idUser;
  }


  @Then("^I validate if my response status is \"([^\"]*)\"$")
  public void validateMyResponseIsIncorrect(int deleted) throws Throwable {
	  int statusCode = deleteUser.getRequestSpecification()
	  	.header("Content-Type", "application/json")
	  	.delete("/"+this.idUser).getStatusCode();
			  	
	  if(statusCode != deleted) {
		  throw new PendingException();
	  }
  }
  
}
