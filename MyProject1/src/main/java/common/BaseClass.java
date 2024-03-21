package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass implements Iconstant{

	static {
		System.setProperty(chrome_key, chrome_value);
	}
	protected WebDriver driver ;
	String url= Utils.getPropertyValue(config_path, "URL");
	
	@BeforeTest
	public void openBrowser() {
	ChromeOptions options = new ChromeOptions();
	 driver = new ChromeDriver();
	 Reporter.log("Browser is opened");
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void closeBrowser() {
	//driver.close();
	driver.quit();
	 Reporter.log("Browser is closed");
	}

}
