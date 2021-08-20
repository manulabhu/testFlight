package extraTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://SeleniumDownload//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		
		//Select Currency
				WebElement Currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			    Select dropdownCurrency = new Select (Currency);
			    dropdownCurrency.selectByValue("INR");
			    System.out.println(dropdownCurrency.getFirstSelectedOption().getText());
			    Thread.sleep(2000);
			    dropdownCurrency.selectByIndex(2);
				System.out.println(dropdownCurrency.getFirstSelectedOption().getText());
				
		
		// TODO Auto-generated method stub

	}

}
