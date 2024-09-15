package steps;

import org.testng.Assert;
import POM.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import launchBrowser.DriverFactory;

public class HomePageSteps {
	
	DriverFactory df = new DriverFactory();
	private HomePage hp;
	
	@Given("user is at the landing page")
	public void user_is_at_the_landing_page() {
		df.getUrl();
	}

	@When("user verifies Mobiles option")
	public void user_verifies_mobiles_option() {
		hp = new HomePage(df.getDriver());
		boolean mb= hp.verifyMobileOption();
		Assert.assertEquals(mb,true);
	}

	@Then("user verifies Fashion option")
	public void user_verifies_fashion_option() {
		hp = new HomePage(df.getDriver());
	    boolean isDisplayed= hp.verifyFashionOption();
	    Assert.assertEquals(isDisplayed, true);
	}

	@Then("user click on Mobiles option")
	public void user_click_on_mobiles_option() {
		hp = new HomePage(df.getDriver());
	    hp.clickOnMobileOption();
	}
}