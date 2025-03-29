package frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Config {
    private final WebDriver driver;
    private String driverPath = "driver\\chromedriver.exe";
    private String url = "https://www.fravega.com/";

    public Config() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        openBrowser();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void openBrowser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

}
