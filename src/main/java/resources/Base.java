package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.BaseRowSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//for fetching browser name from properties file we use this prop object
		//String browserName = prop.getProperty("browser");
		
		//for executing browser name from maven command we use command in maven
		//mvn test -Dbrowser=chrome
		//and in code we give System.getProperty("browser") so it will find the browser property in mvn cmd and
		//set to chrome in above case
		
		//String browserName = System.getProperty("browser");
		//for cucumber framework execution
		String browserName = "chrome";
		
		if (browserName.contains("chrome")) {	
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			
			// To run all your test cases in headless mode i.e browser will not open but test executes in background
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");				
			}
			
			driver = new ChromeDriver(options);
		}
		else if (browserName.equals("firefox")) {
			//firefox driver path details comes here
		} else if (browserName.equals("internetExplorer")) {
			//internetexplorer driver path details comes here
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		try {
			FileUtils.copyFile(source, new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationFile;
	}
}
