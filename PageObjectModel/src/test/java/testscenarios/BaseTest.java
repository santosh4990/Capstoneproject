package testscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuiteSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
    }

    @AfterSuite
    public void afterSuiteTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

