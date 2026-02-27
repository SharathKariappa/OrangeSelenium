package Project.Libraries;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Initialize extends GlobalVariables {
	
	/***************************************************************************
	 * Method Name : StartBrowser()
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : Start Browser and launch URL
	 ****************************************************************************
	 */

	public static void StartBrowser()
	{
		try 
		{
		
        System.setProperty("webdriver.chrome.driver",ChromeDriver);
        ChromeOptions cp=new ChromeOptions();
        cp.addArguments("start-maximized");
        //cp.addArguments("headless");
		//cp.addArguments("guest"); // if launched using guest profile , all extensions like AdBlocker will be disabled which u allow add to comeup
        
		
//		cp.addArguments("user-data-dir=C:/Profiles/");//copy the profile path folder into some temp folders and assign to "user-data-dir". If original profile path is used, it will create issues and execution stops
//		cp.addArguments("profile-directory=Default"); // specify which chrome profile to be used . Here its default. you can specify the custom profile names also
//		cp.addArguments("--remote-debugging-port=9222");
		
		//driver=new ChromeDriver(cp);  //This is to run without thread local to handle parallel execution
		webdriver.set(new ChromeDriver(cp));  //This is to run with thread local to handle parallel execution using testng

		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	
	/***************************************************************************
	 * Method Name : NavigateToURL()
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   :  launch URL
	 ****************************************************************************
	 */
	public static void NavigateToURL() {
		try {
			getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
//start browser for thread Local with differentt browsers	
	public static WebDriver launchBrowser(String browser){
		try{
		
//			switch (browser.toLowerCase()) {
//			case "chrome":
				ChromeOptions chOptions=new ChromeOptions();
				Map<String, Object> chromePrefs=new HashMap<String, Object>();
				chromePrefs.put("credientials enable service", false);
				chOptions.setExperimentalOption("prefs", chromePrefs);
				//chOptions.addArguments("--no-sandbox");
				//chOptions.addArguments("--headless");
				chOptions.addArguments("enable-automation");
				chOptions.addArguments("window-size=1900,1000");
				chOptions.addArguments("--disable-gpu"); 
				chOptions.addArguments("--disable-plugins","--disable-extensions","--disable.popup.blocking");
				String PC_CHROME_DRIVER_LOCATION = ChromeDriver;
				System.setProperty("webdriver.chrome.driver", PC_CHROME_DRIVER_LOCATION);
				String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36 *uZzzPqkAW0d#NoPTc0$o4Sv";
				chOptions.addArguments("--user-agent=" + userAgent);
				webdriver.set(new ChromeDriver(chOptions));
//				break;
//			case "firefox":
//				System.setProperty("webdriver.gecko.driver", GekkoDriver);
// 
//				FirefoxOptions firefoxOptions = new FirefoxOptions();
// 
//				// Set user-agent
//				String FirfoxuserAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:102.0) Gecko/20100101 Firefox/102.0 *uZzzPqkAW0d#NoPTc0$o4Sv";
//				firefoxOptions.addPreference("general.useragent.override", FirfoxuserAgent);
// 
//				// Disable plugins, popups, etc.
//				firefoxOptions.addPreference("plugin.state.flash", 0);
//				firefoxOptions.addPreference("dom.disable_open_during_load", false);
//				firefoxOptions.addPreference("dom.popup_maximum", 0);
//				firefoxOptions.addPreference("media.navigator.permission.disabled", true);
// 
//				// Headless and window size (optional)
//				// firefoxOptions.addArguments("--headless");  // if needed
//				firefoxOptions.addArguments("--width=1900");
//				firefoxOptions.addArguments("--height=1000");
// 
//				webdriver.set(new FirefoxDriver(firefoxOptions));
// 
//				break;
//			case "edge":
//				System.setProperty("webdriver.ie.driver", IEDriver);
// 
//				DesiredCapabilities capabilities = new DesiredCapabilities();
//				capabilities.setCapability("ignoreZoomSetting", true);
//				capabilities.setCapability("nativeEvents", false);
//				capabilities.setCapability("requireWindowFocus", true);
//				capabilities.setCapability("enablePersistentHover", true);
//				capabilities.setCapability("unexpectedAlertBehaviour", "accept");
//				capabilities.setCapability("ignoreProtectedModeSettings", true);
//				capabilities.setCapability("introduceFlakinessByIgnoringSecurityDomains", true);
// 
//				// IE does not support user-agent switching directly via capability
//				// You'd need to set it at the OS level or use a proxy workaround
// 
//				webdriver.set(new InternetExplorerDriver());
//				break;
//			}

 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("there is an exception arised during the execution of the method launchBrowser "+e);

		}
		return webdriver.get();
	}
	
	
	/***************************************************************************
	 * Method Name : CloseBrowser()
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : quits the driver and close all associated browsers
	 ****************************************************************************
	 */	
	public static void CloseBrowser()
	{
		try 
		{
			getDriver().quit();
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
