package Project.Libraries;

import org.openqa.selenium.WebDriver;

public class GlobalVariables {
	
	public static WebDriver driver;
	public static String ChromeDriver=System.getProperty("user.dir")+"\\src\\test\\resources\\WebDrivers\\chromedriver.exe";

	
	public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver> ();
	
	
	public static WebDriver getDriver() {
		return webdriver.get();
	}
	
}
