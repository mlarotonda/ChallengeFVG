package frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    private final WebDriverWait wait;
    private final WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void wait(int tiempo) {
        int timeInSecs = tiempo * 1000;
        try {
            Thread.sleep(timeInSecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void click(WebElement element) {
        isClickable(element).click();
    }

    protected WebElement isClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForVisibility(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void waitForInvisibility(String xpath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }
}
