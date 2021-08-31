 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class forgotPassword {
	
	public WebDriver driver;
	
//	By id = By.id("user_email");
//	By password = By.id("user_password");
	
	By email = By.cssSelector("[type='email']");
	By sendMeInstruction = By.cssSelector("[type='submit']");

	
	public forgotPassword(WebDriver driver) {
		this.driver=driver;
	}

	
	public WebElement getEmail() {
		
		return driver.findElement(email);	
	}
	public WebElement sendMeInstruction() {
		
		return driver.findElement(sendMeInstruction);	
	}
}
