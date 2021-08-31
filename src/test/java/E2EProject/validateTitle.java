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

public class validateTitle extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage lg;
	
	@BeforeTest
	public void initialization() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigating to Home Page");
	}


	@Test
	public void validateTitle() throws IOException {
		
		lg = new LandingPage(driver);
		String title = lg.getTitle().getText();
		Assert.assertEquals(title,"FEATURED COURSES23");
		log.info("Successfully validated the Text Message");
	}
	
	@Test
	public void validateHeader() throws IOException {
		
		lg = new LandingPage(driver);
		String header = lg.getHeader().getText();
		Assert.assertEquals(header,"An Academy to learn Everything about Testing");
		log.info("Successfully validated the Text Message");
	}
	
	@AfterTest
	public void tearoutBrowser() {
		
		driver.close();
		log.info("Driver is closed");
	}
	
}
