package POM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import launchBrowser.DriverFactory;

public class ProductPage {
	
	DriverFactory df = new DriverFactory();
	private WebDriver driver = df.getDriver();
	WebDriverWait wait;
	
	@FindBy(xpath = "//div[@class='SDsN9S']/div/div/div/label/div[text()='Apple']/parent::label/parent::div/parent::div")
	private WebElement filterSection;
	
	
	@FindBy(xpath = "//div[@class='SDsN9S']/div/div/div/label/div[text()='Apple']")
	private WebElement apple;
	
	@FindBy(xpath = "//div[@class='SDsN9S']/div/div/div/label/div[text()='Google']")
	private WebElement google;
	
	@FindBy(xpath = "//a[@class='CGtC98']/div/div[text()='Bestseller']/parent::div/following-sibling::div[@class='yKfJKb row']/div/div[contains(text(),'Apple')]")
	private WebElement bestseller;

	
	public ProductPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void scrollToFilter() {
		wait.until(ExpectedConditions.visibilityOf(apple));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	@SuppressWarnings("deprecation")
	public void selectAppleFilter() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(apple));
		apple.click();	
	}
	
	@SuppressWarnings("deprecation")
	public void selectGoogleFilter() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(google));
		google.click();
		
	}
	public void checkBestseller(String s1) {
		
		wait.until(ExpectedConditions.visibilityOf(bestseller));
		String s = bestseller.getText();
		Assert.assertEquals(s.contains(s1), true);
	}
}
