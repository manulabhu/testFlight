package qaAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPageObjects;


//@SuppressWarnings("deprecation")
public class HomePageAssertTrueTest extends base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	 public void initialization() throws IOException {
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
	}
	@Test
	
	public void homePageNavigation() throws IOException
	{
	
	
	LandingPageObjects lnd = new LandingPageObjects(driver);
	
	//Validating that element Home Button is displayed in the home page
	org.testng.Assert.assertTrue(lnd.getHomeButton().isDisplayed());
	}
	
	@AfterTest
	 public void tearDown()
	 {
		driver.quit();
	 }
	
	
		
	
}
