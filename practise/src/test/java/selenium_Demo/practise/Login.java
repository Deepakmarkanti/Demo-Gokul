package selenium_Demo.practise;

import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import utility.DriverFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login {
	WebDriver driver;

	LoginPageObjects login;

	@Test (dataProvider="credentials")
	public void login(String urname, String pass) {
		LoginPageObjects.email.sendKeys(urname);
		LoginPageObjects.password.sendKeys(pass);
		LoginPageObjects.lgbutton.click();
		WebElement account = LoginPageObjects.logoutbutton;  
		String name = account.getText();
		Assert.assertTrue(name.contains("Log out"));
		LoginPageObjects.logoutbutton.click();
		LoginPageObjects.loginbutton.click();
	}

	@DataProvider(name = "credentials")
	public String[][] dp() {
		return new String[][] {
			new String[] {"some@gmail.com","testing123"},
			new String[] {"abctyu@gmail.com","testing123"},
			new String[] {"oiuygt@gmail.com","testing123"},
		};
	}

	@BeforeTest
	public void beforeTest() {
		driver = DriverFactory.getDriver("chrome");
		login = PageFactory.initElements(driver, LoginPageObjects.class);
		login.get();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
