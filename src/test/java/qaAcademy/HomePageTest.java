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
public class HomePageTest extends base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	LandingPageObjects lnd;
	
	@BeforeTest
	 public void initialization() throws IOException {
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
	}
	//@SuppressWarnings("unused")
	@Test
	
	public void homePageNavigation() throws IOException
	{
	
	
     lnd = new LandingPageObjects(driver);
	
	//Validating title of home page and some navigations
	String title = lnd.getTitle().getText();
	
	org.testng.Assert.assertEquals(title, "FEATURED COURSES123");
	

	
	log.error("Debug is not working");
	
	log.error("Debug is not working");
	
	}
	
	
	
	@AfterTest
	 public void tearDown()
	 {
		driver.quit();
	 }
}
