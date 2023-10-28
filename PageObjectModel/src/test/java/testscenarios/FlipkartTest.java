package testscenarios;



import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Objects.HomePage;
import Objects.ProductDetailsPage;
import Objects.SearchResultsPage;

public class FlipkartTest extends BaseTest {
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void setUp() {
        @SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }

  


    @Test(priority = 1)
    public void testFlipkartHomePage() {
        homePage.navigateToHomePage("https://www.flipkart.com/");
        Assert.assertTrue(homePage.isFlipkartLogoPresent());
    }

   
   
        @Test(priority = 2)
        public void testSearch() {
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
            
            searchResultsPage.searchForProduct("Macbook air m2");
            searchResultsPage.clickFirstItem();
            
            // Handle the new window or tab
            String originalWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandles = driver.getWindowHandles();
            
            for (String windowHandle : allWindowHandles) {
                if (!originalWindowHandle.equals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            
            // the WebDriver focus is on the new window
        
            wait.until(ExpectedConditions.urlContains("https://www.flipkart.com/apple-2022-macbook-air-m2-8-gb-256-gb-ssd-mac-os-monterey-mly13hn-a/p/itm2e7b5e998f058"));

            productDetailsPage.addToCart();
            
        }

        @AfterClass
        public void tearDown() {
    
 
}



}



