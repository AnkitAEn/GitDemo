package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//div[@class='text-center'] //h2");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popUp = By.xpath("//button[text()='NO THANKS']");
	
//	@FindBy(css = "a[href*='sign_in']")
//	WebElement signIn;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage getLogin() {
		
		driver.findElement(signIn).click();
		return new LoginPage(driver);
		
//		LoginPage lp = new LoginPage(driver);
//		return lp;
		
//		return driver.findElement(signIn);
//		return signIn;
	}
	public WebElement getTitle() {
		
		return driver.findElement(title);

	}
	public WebElement getNavBar() {
		
		return driver.findElement(navBar);
		
	}
	public WebElement getHeader() {
		
		return driver.findElement(header);
		
	}
	public int getPopUpSize() {
		
		return driver.findElements(popUp).size();
		
	}
	public WebElement getPop() {
		
		return driver.findElement(popUp);
		
	}
}
