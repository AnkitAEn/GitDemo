package stepDefination;

import java.io.IOException;

import org.junit.runner.RunWith;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


@RunWith(Cucumber.class)
public class StepDefination extends Base {

	LoginPage lp;
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws IOException {
		
		driver = initializeDriver();
		
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String url) {
		driver.get(url);

	}

	@Given("^Click on the Login link available on the top right corner to land on the signin page$")
	public void click_on_the_Login_link_available_on_the_top_right_corner_to_land_on_the_signin_page() {
	 
		LandingPage lg = new LandingPage(driver);
		if(lg.getPopUpSize()>0)
		{
			lg.getPop().click();
		}
		lp = lg.getLogin();
	 	
	}

	@When("^User enter (.+) and (.+) and click on login button$")
    public void user_enter_and_and_click_on_login_button(String username, String password) {
	   
		lp.getEmail().sendKeys(username);
		lp.password().sendKeys(password);
		lp.loginButton().click();
		
	}

	@Then("^Verify the user to successfully logged in$")
	public void verify_the_user_to_successfully_logged_in() {
	   System.out.println("done");
	}
	
	 @And("^Close browser$")
	    public void close_browser() {
	        driver.quit();
	    }
 
}