package frontend.pages;

import frontend.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helper {

    @FindBy(xpath = "//button[@data-test-id='close-modal-button']")
    private WebElement closeModalButton;
    @FindBy(xpath = "//input[@placeholder='Buscar productos']")
    private WebElement searchBar;

    private String locationPoster = "//div[text()='Te ubicamos en ']";
    private String spanElementXpath = "//span[text()='%s']";
    private String aElementXpath = "//a[text()='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage closeModalButton() {
        click(closeModalButton);
        return this;
    }

    public HomePage searchForProduct(String productName) {
        isClickable(searchBar);
        searchBar.clear();
        searchBar.sendKeys(productName);
        searchBar.submit();
        return this;
    }

    public HomePage hoverCategories() {
        waitForVisibility(locationPoster);
        waitForInvisibility(locationPoster);
        String dynamicXpath = String.format(spanElementXpath, "Categorías");
        return hoverItem(dynamicXpath);
    }

    public HomePage hoverCategory(String category) {
        String dynamicXpath = String.format(aElementXpath, category);
        return hoverItem(dynamicXpath);
    }

    public HomePage clickBrand(String brand) {
        String dynamicXpath = String.format(spanElementXpath, brand);
        WebElement brandElement = waitForVisibility(dynamicXpath);
        click(brandElement);
        wait(3);
        return this;
    }

    private HomePage hoverItem(String dynamicXpath) {
        WebElement categoryElement = waitForVisibility(dynamicXpath);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(categoryElement).perform();
        return this;
    }

}
