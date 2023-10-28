package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartButton = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");



    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}

