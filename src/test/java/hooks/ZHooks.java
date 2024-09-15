package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import launchBrowser.DriverFactory;

public class ZHooks extends DriverFactory {

	WebDriver driver = getDriver();
	WebDriver wait;
	
	@After(order = 2)
	public void tearDown(Scenario  scenario) throws InterruptedException
	{
		boolean isScenarioFailed = scenario.isFailed();
		
		if(isScenarioFailed)
		{
			String scenarioName = scenario.getName();
			TakesScreenshot	ts = (TakesScreenshot)driver;		
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", scenarioName);
			Thread.sleep(2000);
			driver.quit();
		}
	}
	
	@After(value = "@end", order = 1)
	public void quitBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
