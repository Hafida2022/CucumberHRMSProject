package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//a[contains(@href,'/pim/viewPimModule')]")
    public WebElement pimMenu;

    @FindBy(xpath = "//a[text()='Add Employee']")
    public WebElement addEmployeeMenu;

    @FindBy(name = "firstName")
    public WebElement firstNameField;

    @FindBy(name = "middleName")
    public WebElement middleNameField;

    @FindBy(name = "lastName")
    public WebElement lastNameField;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div//input")
    public WebElement employeeIdField;

    @FindBy(css = "button[type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    public WebElement personalDetailsHeader;

    @FindBy(xpath = "//span[text()='Required']")
    public List<WebElement> requiredErrorMessages;

    public AddEmployeePage() {

        PageFactory.initElements(driver, this);


    }
}