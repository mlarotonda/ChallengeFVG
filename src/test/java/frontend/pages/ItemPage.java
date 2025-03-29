package frontend.pages;

import frontend.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends Helper {

    @FindBy(xpath = "(//button[text()='Comprar'])[2]")
    private WebElement comprarButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickComprarButton() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(comprarButton).perform();
        click(comprarButton);
    }
}
