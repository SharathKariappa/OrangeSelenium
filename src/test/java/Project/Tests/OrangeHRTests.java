package Project.Tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.Libraries.AppBusinessFunctions;
import Project.Libraries.GlobalVariables;
import Project.Libraries.Initialize;

public class OrangeHRTests extends GlobalVariables{



	// TODO Auto-generated method stub
	@BeforeMethod
	public static void startBrowser()
	{
		try {
			Initialize.StartBrowser();
			Initialize.NavigateToURL();


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



	@Test
	public static void LoginTest()
	{
		AppBusinessFunctions.Login();
        


	}


	@Test
	public static void MandatoryCheckinLoginPage()
	{
		try 
		{
			AppBusinessFunctions.VerifyMandatoryCheckForUsernamePassword();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	
	@Test
	public static void AddUser()
	{
		try {
			AppBusinessFunctions.Login();
			AppBusinessFunctions.accessMenuByText("Admin");
		//	AppBusinessFunctions.addUserToEmployee();
			AppBusinessFunctions.verifyUserByUserName("TesterNK01");
			
         

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



	}
	
	
	/***************************************************************************
	 * Method Name : CreatePostAndVerify()
	 * Created By  : Sharath 
	 * Reviewed By : 
	 * Purpose	   : Create Post and Verify the post created in the feed
	 ****************************************************************************
	 */
	@Test
	public static void CreatePostAndVerify()
	{
		try {
			AppBusinessFunctions.Login();
		//	AppBusinessFunctions.CreatePost("This is my first post");
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@AfterMethod
	public static void CloseBrowser()
	{
		try {
			Initialize.CloseBrowser();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void Cleanup()
	{
		try 
		{
			Process process=Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");//Kill all the running chromedriver process
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



}
