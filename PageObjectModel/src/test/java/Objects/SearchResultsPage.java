package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.cssSelector("input[title='Search for Products, Brands and More'][name='q']");

    By firstItem = By.xpath("//div[contains(@class, '_4rR01T') and text()='APPLE 2022 MacBook AIR M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLY13HN/A']");



    public void searchForProduct(String product) {
        WebElement searchElement = driver.findElement(searchBox);
        searchElement.sendKeys(product);
        searchElement.sendKeys(Keys.ENTER);
    }

    public void clickFirstItem() {
        driver.findElement(firstItem).click();
    }
}


