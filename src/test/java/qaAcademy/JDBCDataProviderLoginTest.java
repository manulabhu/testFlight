package qaAcademy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;
import pageObjects.LoginPage;


public class JDBCDataProviderLoginTest extends base{
	 public WebDriver driver;
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 
 @BeforeTest
 public void initialization() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		//log.info("driver is initialized and maximized");
 }
	
 @Test
 public void differentUserLogin() throws IOException, SQLException
	{
	
	    driver.get(prop.getProperty("url"));
		LandingPageObjects lnd = new LandingPageObjects(driver);
		lnd.logIn().click();
		log.debug("Login button is clicked");
		
		//Connect with mysql database and get the login data
		
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "admin");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentialInfo where user = 'admin'");
		
		while(rs.next())
		{
			
		LoginPage lgn = new LoginPage(driver);
		lgn.enterEmail().sendKeys(rs.getString("userid"));
		lgn.enterPassword().sendKeys(rs.getString("password"));
		lgn.clickLogin().click();
		    
        System.out.println(rs.getString("userid"));
        System.out.println(rs.getString("password"));
		}
		
		
	  
	    
	   
	
	}
	
 
 
 @AfterTest
 public void tearDown()
 {
	 driver.quit();
 }

}
