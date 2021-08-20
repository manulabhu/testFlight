package qaAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;


public class PracticePageTest extends base {
	 public WebDriver driver;
    public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	 public void initialization() throws IOException {
			driver = initializeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
	}
	@Test
	public void navigatePractice() throws IOException
	{
	
		
		LandingPageObjects lnd = new LandingPageObjects(driver);
		lnd.Practice().click();
	    log.debug("Practice button is clicked");
		
	
	
	}
	
	@AfterTest
	 public void tearDown()
	 {
		driver.quit();
	 }

}
