package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass{

		
		@Test(priority=1)
		public void login() {
		LoginPage login = new LoginPage(driver);
		login.enterUsername("standard_user");
		login.enterPasswor("secret_sauce");
		login.clickLogin();
		 Reporter.log("logged into application");
		}
		@Test(priority=2)
		public void verifyTitle() {
		String actual_title = driver.getTitle();
		String exp_title = "Swag Labsddd";
		if(actual_title.equalsIgnoreCase(exp_title)){
			 Reporter.log("Title is matched");
		}
		else
			 Reporter.log("Title mis matched");
		}
		
		@Test(priority=3)
		public void logout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[.='Open Menu']")).click();
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		By ele = By.id("logout_sidebar_link");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
		logout.click();
		 Reporter.log("logged out from application");
		}
		
	
	

}
