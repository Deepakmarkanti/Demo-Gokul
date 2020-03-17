package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver getDriver(String key) {
		switch(key) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();

		case "ie":
			WebDriverManager.iedriver().arch32().setup();
			return new InternetExplorerDriver();

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();

		default :
			throw new UnsupportedOperationException("Incorrect key");
		}
	}
}
