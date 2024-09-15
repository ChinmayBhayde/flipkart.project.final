package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	static WebDriver driver;

    public WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void getUrl() {
    	getDriver().manage().window().maximize();
    	getDriver().get("https://www.flipkart.com");
        
    }
}