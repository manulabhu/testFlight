package qaAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;
import pageObjects.LoginPage;


public class LoginTest extends base {
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	 public WebDriver driver;
	 
	@BeforeTest
	 public void initialization() throws IOException {
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
	}
	@Test
	public void contactUsPageNavigation() throws IOException
	{
	
		LandingPageObjects lnd = new LandingPageObjects(driver);
		lnd.logIn().click();
		
		LoginPage lgn = new LoginPage(driver);
		lgn.enterEmail().sendKeys("abc@gmail.com");
		lgn.enterPassword().sendKeys("abcd");
		lgn.clickLogin().click();
	    log.debug("Login button is clicked");
	
	}

	@AfterTest
	 public void tearDown()
	 {
		driver.quit();
	 }
	
}
