package frontend.pages;

import frontend.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends Helper {

    @FindBy(xpath = "//ul[@data-test-id='results-list']/li[2]")
    private WebElement secondItem;
    @FindBy(xpath = "//button[@data-test-id='order-by-select']")
    private WebElement sortBy;
    @FindBy(xpath = "(//div[@data-test-id='product-price'])[1]/span")
    private WebElement firstPrice;
    @FindBy(xpath = "(//div[@data-test-id='product-price'])[2]/span")
    private WebElement secondPrice;

    private String aElementXpath = "//a[text()='%s']";

    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ResultsPage clickSecondItem() {
        click(secondItem);
        return this;
    }

    public ResultsPage clickSortBy() {
        click(sortBy);
        return this;
    }

    public ResultsPage clickOption(String option) {
        String dynamicXpath = String.format(aElementXpath, option);
        WebElement element = waitForVisibility(dynamicXpath);
        click(element);
        return this;
    }

    public double getFirstPrice() {
        return extractPrice(firstPrice);
    }

    public double getSecondPrice() {
        return extractPrice(secondPrice);
    }

    private double extractPrice(WebElement element) {
        String priceText = element.getText().replaceAll("[^0-9]", "");
        return Double.parseDouble(priceText);
    }
}
