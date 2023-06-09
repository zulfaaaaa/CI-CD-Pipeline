package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Login.Login;

public class UserSteps {
    @Steps
    Login login;
    @Given("user set valid PUT endpoint")
    public void userSetValidPUTEndpoint() {
        login.setValidPutEndpoint();
    }

    @When("user send PUT HTTP request")
    public void userSendPUTHTTPRequest() {
        login.sendPUTHTTPRequest();
    }

    @Then("user send update user data")
    public void userSendUpdateUserData() {
        login.validateValidPostDataUpdated();
    }

    @And("user received HTTP response code {int}")
    public void userReceivedHTTPResponseCode(int arg0) {
        login.validatePUTHTTPResponseCode200();
    }
}