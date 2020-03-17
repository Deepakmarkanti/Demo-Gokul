package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class RegisterPageObjects extends LoadableComponent<RegisterPageObjects> {
private WebDriver driver;
	
	public RegisterPageObjects(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver = d;
	}
	
	@FindBy(how=How.ID,using="gender-male")
	public static WebElement gender;
	
	@FindBy(how=How.ID,using="FirstName")
	public static WebElement firstname;
	
	@FindBy(how=How.ID,using="LastName")
	public static WebElement lastname;
	
	@FindBy(how=How.ID,using="Email")
	public static WebElement email;
	
	@FindBy(how=How.ID, using="Password")
	public static WebElement password;
	
	@FindBy(how=How.ID, using="ConfirmPassword")
	public static WebElement confirmpassword;
	
	@FindBy(how=How.ID, using="register-button")
	public static WebElement regbutton;

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("register"));
			
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("http://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();	
	}

}
