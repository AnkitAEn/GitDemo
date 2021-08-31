 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainMenu {
	
	public WebDriver driver;
	
//	By id = By.id("user_email");
//	By password = By.id("user_password");
	
	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[id='user_password']");
	By login = By.cssSelector("[value='Log In']");
	By forgotPassword = By.cssSelector("[href*='new/index']");
	
	public mainMenu(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
	public WebElement password() {
		
		return driver.findElement(password);
	}
	
	public WebElement loginButton() {
		
		return driver.findElement(login);
	}
	
	public forgotPassword getForgotPassword() {
		
		driver.findElement(forgotPassword).click();
		return new forgotPassword(driver);
	}
}
