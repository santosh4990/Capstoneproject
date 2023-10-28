package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	
	    private WebDriver driver;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By flipkartLogo = By.xpath("//img[@title='Flipkart']");



	    public void navigateToHomePage(String url) {
	        driver.get(url);
	    }

	    public boolean isFlipkartLogoPresent() {
	        return driver.findElement(flipkartLogo).isDisplayed();
	    }
	}



