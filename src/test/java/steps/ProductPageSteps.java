package steps;

import POM.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import launchBrowser.DriverFactory;

public class ProductPageSteps {
	
	DriverFactory df = new DriverFactory();
//	WebDriver driver = df.getDriver();
	private ProductPage product;
	
	@When("scroll to filter section")
	public void scroll_to_filter_section() {
		
		product = new ProductPage(df.getDriver());
	    product.scrollToFilter();
	}

	@When("select Apple from filter")
	public void select_apple_from_filter() {
		product = new ProductPage(df.getDriver());
	    product.selectAppleFilter();
	}

	@When("select Google from filter")
	public void select_google_from_filter() {
		product = new ProductPage(df.getDriver());
	    product.selectGoogleFilter();
	}
	
	@Then("user selects a bestseller {string} product")
	public void user_selects_a_bestseller_product(String string) {
		product = new ProductPage(df.getDriver());
	    product.checkBestseller(string);
	    System.out.print(string);
	}

}
