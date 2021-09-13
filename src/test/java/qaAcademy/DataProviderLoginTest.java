package qaAcademy;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;
import pageObjects.LoginPage;



public class DataProviderLoginTest extends base{
	 public WebDriver driver;
	 public static Logger log =LogManager.getLogger(base.class.getName());
	
	 
 @BeforeTest
 public void initialization() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		//log.info("driver is initialized and maximized");
 }
	
 @Test(dataProvider="loginData")
 public void differentUserLogin(String User, String Password, String Text) throws IOException
	{
	
	    driver.get(prop.getProperty("url"));
		LandingPageObjects lnd = new LandingPageObjects(driver);
		lnd.logIn().click();
		log.debug("Login button is clicked");
		
		LoginPage lgn = new LoginPage(driver);
	    lgn.enterEmail().sendKeys(User);
	    lgn.enterPassword().sendKeys(Password);
	    lgn.clickLogin().click();
	    log.info(Text);
	
	   
	
	}
	
 @DataProvider
 public Object[][] loginData()
 {
	 // We providing three types of data to two sets of user
 Object[][]  data = new Object[2][3];
 
 data[0][0]="restricteduser@gmail.com";
 data[0][1]="123456";
 data[0][2]="Restricted user";
 
 data[1][0]="nonrestricteduser@gmail.com";
 data[1][1]="12345";
 data[1][2]="Non restricted user";
 
 return data;
 
 }
 
 @AfterTest
 public void tearDown()
 {
	 driver.quit();
 }

}
