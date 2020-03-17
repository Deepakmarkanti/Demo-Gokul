package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class LoginPageObjects extends LoadableComponent<LoginPageObjects>{
private WebDriver driver;
	
	public LoginPageObjects(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver = d;
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public static WebElement loginbutton;
	
	@FindBy(how=How.ID,using="Email")
	public static WebElement email;
	
	@FindBy(how=How.ID,using="Password")
	public static WebElement password;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	public static WebElement lgbutton;
	
	@FindBy(how=How.XPATH, using="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public static WebElement logoutbutton;

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login"));
		
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		
	}

}
