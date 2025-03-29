package frontend.pages;

import frontend.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Helper {

    private String productXpath = "//div[contains(text(), '%s')]";

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductDisplayed(String product) {
        String dynamicXpath = String.format(productXpath, product);
        try {
            WebElement productTitle = waitForVisibility(dynamicXpath);
            return productTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
