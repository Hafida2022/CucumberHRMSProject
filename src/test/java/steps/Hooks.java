package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;
import utils.PageInitializer;

import java.time.Duration;

public class Hooks extends CommonMethods {

    @Before
    public void openBrowser() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(Constants.IMPLICIT_WAIT)
                );

        driver.get(
                ConfigReader.getProperty("url")
        );

        PageInitializer.initializePageObjects();
    }


    @After
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();
        }
    }
}
