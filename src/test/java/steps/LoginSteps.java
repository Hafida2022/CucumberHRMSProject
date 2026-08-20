package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ConfigReader;
import utils.PageInitializer;

public class LoginSteps extends PageInitializer {
    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {

    }


    @When("user leaves username empty")
    public void userLeavesUsernameEmpty() {

        loginPage.usernameField.clear();
    }


    @When("user enters valid password")
    public void userEntersValidPassword() {

        loginPage.passwordField.sendKeys(
                ConfigReader.getProperty("password")
        );
    }


    @When("user enters valid username")
    public void userEntersValidUsername() {

        loginPage.usernameField.sendKeys(
                ConfigReader.getProperty("username")
        );
    }


    @When("user leaves password empty")
    public void userLeavesPasswordEmpty() {

        loginPage.passwordField.clear();
    }


    @When("user enters username {string}")
    public void userEntersUsername(String username) {

        loginPage.usernameField.sendKeys(username);
    }


    @When("user enters password {string}")
    public void userEntersPassword(String password) {

        loginPage.passwordField.sendKeys(password);
    }


    @When("user clicks on login button")
    public void userClicksOnLoginButton() {

        loginPage.loginButton.click();
    }


    @Then("user should see {string} message for username")
    public void userShouldSeeMessageForUsername(String expectedMessage) {

        String actualMessage =
                loginPage.usernameRequiredError.getText();

        Assert.assertEquals(
                expectedMessage,
                actualMessage
        );
    }


    @Then("user should see {string} message for password")
    public void userShouldSeeMessageForPassword(String expectedMessage) {

        String actualMessage =
                loginPage.passwordRequiredError.getText();

        Assert.assertEquals(
                expectedMessage,
                actualMessage
        );
    }


    @Then("user should see {string} message")
    public void userShouldSeeMessage(String expectedMessage) {

        String actualMessage =
                loginPage.invalidCredentialsError.getText();

        Assert.assertTrue(
                actualMessage.contains(expectedMessage)
        );
    }
}