package selenium_Demo.practise;

import org.testng.annotations.Test;

import pageObjects.RegisterPageObjects;
import utility.DriverFactory;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegisLogin {
WebDriver driver;
	
	RegisterPageObjects register;

	@Test
	public void registration() throws InterruptedException {
		
		RegisterPageObjects.gender.click();
		RegisterPageObjects.firstname.sendKeys("abc");
		RegisterPageObjects.lastname.sendKeys("tyu");
		RegisterPageObjects.email.sendKeys("abctyu@gmail.com");
		RegisterPageObjects.password.sendKeys("testing123");
		RegisterPageObjects.confirmpassword.sendKeys("testing123");
		RegisterPageObjects.regbutton.click();
		Thread.sleep(2000);
		String success = driver.findElement(By.className("result")).getText();
		Assert.assertTrue(success.contains("Your registration completed"));
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();

	}

	@BeforeTest
	public void beforeTest() {
		driver = DriverFactory.getDriver("chrome");
		register = PageFactory.initElements(driver, RegisterPageObjects.class);
		register.get();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
