package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src/test/resources/uifeature"},
		glue =  {"steps","hooks"},
		plugin = {"pretty","html:target/cucumber-reports"},
		dryRun = false,
		monochrome=true
		)

public class campaignRunner extends AbstractTestNGCucumberTests {
	

}