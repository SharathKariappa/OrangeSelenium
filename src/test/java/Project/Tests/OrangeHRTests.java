package Project.Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Project.DataReaders.JsonReader;
import Project.Entity.LoginData;
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


@DataProvider(name="LoginDataPossitveScenario")
public static Object[][] getLoginData() throws Exception
{
	List<LoginData> list=JsonReader.getSpecificdata("LoginDataPossitveScenario",LoginData.class);
	if (list == null || list.isEmpty()) {
        // Return empty dataset so TestNG will skip the parameterized test instead of failing with NPE
        return new Object[0][0];
    }
	
	Object[][] data=new Object[list.size()][1];
	for(int i=0;i<list.size();i++)
	{
		data[i][0]=list.get(i);
	}
	return data;
}



	@Test(dataProvider="LoginDataPossitveScenario")
	public static void LoginTestWithData(LoginData loginData)
	{
		if (loginData == null) 
		{
            throw new IllegalArgumentException("LoginData row is null");
        }
		AppBusinessFunctions.UserLogin(loginData.getUsername(), loginData.getPassword());
		

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
		    AppBusinessFunctions.addUserToEmployee();
			AppBusinessFunctions.verifyUserByUserName("TesterNK01");
			
         

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



	}
	
	
	/***************************************************************************
	 * Method Name : CreatePostAndVerify()
	 * Created By  : Sharath 
	 * Reviewed By : Added Review comments-updated
	 * Purpose	   : Create Post and Verify the post created in the feed
	 ****************************************************************************
	 */
	@Test
	public static void CreatePostAndVerify()
	{
		String timeStamp="";
		String postData="This is my first post";
		try {
			AppBusinessFunctions.Login();
			timeStamp = AppBusinessFunctions.CreateBuzzPost(postData);
			AppBusinessFunctions.VerifyBuzzPostByTimeStamp(timeStamp,postData);

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
