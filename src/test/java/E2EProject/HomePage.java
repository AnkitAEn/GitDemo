package E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.forgotPassword;
import resources.Base;

public class HomePage extends Base {
	
	public WebDriver driver;
	//public static Logger log = LogManager.getLogger(Base.class.getName());
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException {
		
		driver = initializeDriver();
		log.info("Browser is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		
		
		driver.get(prop.getProperty("url"));
		LandingPage lg = new LandingPage(driver);
		if(lg.getPopUpSize()>0)
		{
			lg.getPop().click();
		}
	 	LoginPage lp = lg.getLogin();
	 	
//		lg.getLogin().click();
//		LoginPage lp = new LoginPage(driver);
		
		lp.getEmail().sendKeys(username);
		lp.password().sendKeys(password);
		lp.loginButton().click();
		
		forgotPassword fg = lp.getForgotPassword();
		fg.getEmail().sendKeys("abc");
		fg.sendMeInstruction().click();
		
		log.info("Validated user.");
		
	}
	@AfterTest
	public void tearoutBrowser() {
		
		driver.close();
		log.info("Driver is closed.");
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//Row stands how many different data type test should run
		//Columns stands for how many value for each test
		//eg. Object[1'test'][3'values']
		
		//0th row
		Object[][] data = new Object[2][2];
		data[0][0] = "unrestricteduser@gmail.com";
		data[0][1] = "123456";
		//1th row
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "123456";
		
		return data;
	}
	
}
