package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.ConfigReader;
import utils.DBUtils;
import utils.PageInitializer;

import java.sql.ResultSet;

import static utils.CommonMethods.click;
import static utils.CommonMethods.sendText;

public class AddEmployeeSteps extends PageInitializer {

    private String generatedEmployeeId;


    @Given("admin user is logged into HRMS")
    public void adminUserIsLoggedIntoHRMS() {

        sendText(loginPage.usernameField,
                ConfigReader.getProperty("username"));

        sendText(loginPage.passwordField,
                ConfigReader.getProperty("password"));

        click(loginPage.loginButton);
    }


    @Given("admin navigates to Add Employee page")
    public void adminNavigatesToAddEmployeePage() {
        click(addEmployeePage.pimMenu);
        click(addEmployeePage.addEmployeeMenu);

    }


    @When("admin enters first name {string}")
    public void adminEntersFirstName(String firstName) {

        addEmployeePage.firstNameField.sendKeys(firstName);
    }


    @When("admin enters middle name {string}")
    public void adminEntersMiddleName(String middleName) {

        addEmployeePage.middleNameField.sendKeys(middleName);
    }


    @When("admin enters last name {string}")
    public void adminEntersLastName(String lastName) {

        addEmployeePage.lastNameField.sendKeys(lastName);
    }


    @When("admin enters employee ID {string}")
    public void adminEntersEmployeeID(String employeeID) {

        addEmployeePage.employeeIdField.clear();

        addEmployeePage.employeeIdField.sendKeys(employeeID);
    }


    @When("admin saves the employee")
    public void adminSavesTheEmployee() {

        generatedEmployeeId =
                addEmployeePage.employeeIdField.getAttribute("value");

        addEmployeePage.saveButton.click();
    }


    @Then("employee ID should be generated automatically")
    public void employeeIDShouldBeGeneratedAutomatically() {

        Assert.assertNotNull(generatedEmployeeId);

        Assert.assertFalse(
                generatedEmployeeId.isEmpty()
        );
    }


    @Then("employee should be added successfully")
    public void employeeShouldBeAddedSuccessfully() {
        Assert.assertTrue(addEmployeePage.personalDetailsHeader.isDisplayed());


    }

    @Then("required error messages should be displayed")
    public void requiredErrorMessagesShouldBeDisplayed() {

        Assert.assertEquals(2, addEmployeePage.requiredErrorMessages.size());
    }

    @Then("employee record should exist in database")
    public void employeeRecordShouldExistInDatabase() throws Exception {

        DBUtils.createConnection();

        String query =
                "SELECT * FROM hs_hr_employee WHERE employee_id = '" +
                        generatedEmployeeId + "'";

        ResultSet resultSet = DBUtils.executeQuery(query);

        Assert.assertTrue(resultSet.next());

        DBUtils.closeConnection();
    }


}