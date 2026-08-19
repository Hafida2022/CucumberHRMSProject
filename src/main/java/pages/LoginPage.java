package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    // Username réel du site
    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameField;


    // Password réel du site
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;


    // Login button réel du site
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


    // Required sous Username
    @FindBy(xpath = "//input[@name='username']/parent::div/following-sibling::span")
    public WebElement usernameRequiredError;


    // Required sous Password
    @FindBy(xpath = "//input[@name='password']/parent::div/following-sibling::span")
    public WebElement passwordRequiredError;


    // Invalid credentials
    @FindBy(css = "div[role='alert']")
    public WebElement invalidCredentialsError;

    public LoginPage() {

        PageFactory.initElements(driver, this);
    }
}