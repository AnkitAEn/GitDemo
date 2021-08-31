package E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidatingNavBar extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException {
		
		driver = initializeDriver();
		log.info("Browser is initialized.");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page.");
	}

	@Test
	public void validateNavBar() throws IOException {
		
		LandingPage lg = new LandingPage(driver);
		Assert.assertTrue(lg.getNavBar().isDisplayed());
		log.info("Navigation test is done.");
	}
	
	@AfterTest
	public void tearoutBrowser() {
		
		driver.close();
		log.info("Driver is closed.");
	}
}
