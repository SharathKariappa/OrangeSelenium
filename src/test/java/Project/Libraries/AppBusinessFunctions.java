package Project.Libraries;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import Project.Pages.AdminUserManagement;
import Project.Pages.BuzzPage;
import Project.Pages.HomePage;
import Project.Pages.LoginPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppBusinessFunctions extends GlobalVariables{

	/***************************************************************************
	 * Method Name : Login()
	 * Created By  : Sharath-Updated in TestBranch
	 * Reviewed By : Updated-2
	 * Purpose	   : add purpose
	 ****************************************************************************
	 */

	public static void Login()
	{
		try {
			UILibraries.EnterText(LoginPage.inputUsername, "Admin");
			UILibraries.EnterText(LoginPage.inputPassword, "admin123");
			UILibraries.ClickElement(LoginPage.buttonLogin);
			
			if(UILibraries.IsDisplayed(HomePage.divSearchBar))
			{

			}
			else
			{
				Assert.fail("Login Failed !!! Homepage not displayed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



	/***************************************************************************
	 * Method Name : VerifyMandatoryCheckForUsername()()
	 * Created By  : Sharath
	 * Reviewed By : 
	 * Purpose	   : 
	 ****************************************************************************
	 */

	public static void VerifyMandatoryCheckForUsernamePassword()
	{
		try 
		{
			UILibraries.EnterText(LoginPage.inputUsername, "");
			UILibraries.EnterText(LoginPage.inputPassword, "");
			UILibraries.ClickElement(LoginPage.buttonLogin);	
			if(UILibraries.IsDisplayed(LoginPage.spanUsernameMsg))
			{
				System.out.println();
			}
			else
			{
				Assert.fail("UserName Mandatory message not displayed");
			}

			if(UILibraries.IsDisplayed(LoginPage.spanPasswordMsg))
			{

			}
			else
			{
				Assert.fail("Password Mandatory message not displayed");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}



	/***************************************************************************
	 * Method Name : accessMenuByText(String strMenu) 
	 * Created By  : Sharath
	 * Reviewed By : 
	 * Purpose	   : Select menu based on the menu name passed as argument-strMenu
	 ****************************************************************************
	 */

	public static void accessMenuByText(String strMenu) 
	{
		try 
		{

			UILibraries.ClickElement(HomePage.menuPathByText(strMenu));
			//		    if (UILibraries.GetTextFromElement(HomePage.pageHeader).equals(strMenu)) 
			//		    {
			//				System.out.println("Admin page launched");

			//			}
			//		    else
			//		    {
			//		    	System.out.println("page not found");

			//		    }

			Assert.assertEquals(UILibraries.GetTextFromElement(HomePage.pageHeader), strMenu);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	
	/***************************************************************************
	 * Method Name : accessAdditionalMenuByXpath(By menuXpath) 
	 * Created By  : Sharath
	 * Reviewed By : 
	 * Purpose	   : Select menu based on the  xpath passed as argument-menuXpath and verify the page header with strMenu passed as argument
	 ****************************************************************************
	 */
	public static void accessAdditionalMenuByXpath(By menuXpath, String strMenu)
	{
		try 
		{
			
			UILibraries.ClickElement(menuXpath);
			Assert.assertEquals(UILibraries.GetTextFromElement(HomePage.pageHeader), strMenu);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
     
	

	/***************************************************************************
	 * Method Name : addUserToEmployee()
	 * Created By  : Sharath
	 * Reviewed By : 
	 * Purpose	   : Create user for Employee
	 ****************************************************************************
	 */
	public static void addUserToEmployee()
	{
		String strSuccess="";
		try 
		{
			UILibraries.ClickElement(AdminUserManagement.addButton);
			UILibraries.ClickElement(AdminUserManagement.userRole);
			UILibraries.ClickElement(AdminUserManagement.UserRoleByText("ESS"));
			UILibraries.EnterText(AdminUserManagement.employeeName, "john");
			UILibraries.ClickElement(AdminUserManagement.userNameElement);
			UILibraries.ClickElement(AdminUserManagement.status);
			UILibraries.ClickElement(AdminUserManagement.statusElementByText("Disabled"));
			UILibraries.EnterText(AdminUserManagement.userName, "TesterNK01");
			UILibraries.EnterText(AdminUserManagement.password,"Test@123");
			UILibraries.EnterText(AdminUserManagement.confirmPassword, "Test@123");
			UILibraries.ClickElement(AdminUserManagement.saveUser);

			if(UILibraries.IsDisplayed(AdminUserManagement.SucessWindow))
			{
				strSuccess=UILibraries.GetTextFromElement(AdminUserManagement.SucessMessage);
				Assert.assertEquals(strSuccess, "Success","User Not Added Sucessfully");

			}
			else
			{
				Assert.fail("Success message not displayed");
			}


		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}


	/***************************************************************************
	 * Method Name : verifyUserByUserName(String userName)
	 * Created By  : Sharath
	 * Reviewed By : 
	 * Purpose	   : Search user by user name and verify if user exists
	 ****************************************************************************/
	public static void verifyUserByUserName(String userName)
	{
		//List<List<String>> tableData=new ArrayList<>();--used when using List<List<String>> to get data from table
		List<Map<String,String>>tableData=new ArrayList<Map<String,String>>();
		try {
            Boolean flag=false;
			UILibraries.EnterText(AdminUserManagement.userName, userName);
			UILibraries.ClickElement(AdminUserManagement.searchUser);
			//tableData=UILibraries.GetDataFromTable(AdminUserManagement.rowsUserTable, AdminUserManagement.columnsUserTable);--used when using List<List<String>> to get data from table
			tableData=UILibraries.GetdataFromTableUsingMaps(AdminUserManagement.rowsUserTable, AdminUserManagement.columnsUserTable,AdminUserManagement.tableHeader);
			System.out.println("Number of rows found: "+tableData.size());
			
			for(Map<String, String> row : tableData)
			{
				if(row.get("Username").equals(userName))
				{
					flag=true;
					break;
				}
				
			}
			if(!flag)
			{
				Assert.fail("User Not Found");
			}
			else
			{
				System.out.println(userName +": User Found");
			}
			
			
//			--used when using List<List<String>> to get data from table
			//		   	for(List<String> row :tableData)
//		   	{
//		   		if(userName.equals(row.get(1)))
//		   		{
//		   			flag=true;
//		   			break;
//		   		}
//		   			   		
//		   	}
//		   	if (!flag) 
//		   	{
//				Assert.fail(userName+" -Not Found");
//			}
//		   	else
//		   	{
//		   		System.out.println(userName+" : User found ");
//		   	}
		   	

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	/***************************************************************************
	 * Method Name : CreateBuzzPost(String Post)
	 * Created By  : Sharath
	 * Reviewed By : 
	 * Purpose	   : Create a buzz post and verify if it is successfully created
	 ****************************************************************************/

public static String CreateBuzzPost(String Post)
{
    try 
    {
        AppBusinessFunctions.accessAdditionalMenuByXpath(HomePage.buzzMenuItem, "Buzz");
        UILibraries.WaitForLoadSpinnerToDisappear(BuzzPage.feedloadSpinnerdiv);
        UILibraries.EnterText(BuzzPage.postTextArea, Post);
        UILibraries.ClickElement(BuzzPage.postButton);

        // capture timestamp right after clicking the post button
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm a");
        String timestamp = now.format(fmt);

        if(UILibraries.IsDisplayed(BuzzPage.SucessWindow))
        {
            Assert.assertEquals(UILibraries.GetTextFromElement(BuzzPage.successMessage), "Success", "Post Not Created");
        }
        else
        {
            Assert.fail("Success message not displayed");
        }

        return timestamp;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}


/***************************************************************************
 * Method Name : VerifyBuzzPostByTimeStamp(String timeStamp)	
 * Created By  : Sharath
 * Reviewed By : 
 * Purpose	   : Verify if a buzz post is successfully created by timestamp
 ****************************************************************************/

public static void VerifyBuzzPostByTimeStamp(String timeStamp,String actPostData)
{
	List<Map<String,String>>tableData=new ArrayList<Map<String,String>>();
	Boolean flag=false;
	try 
	{
		AppBusinessFunctions.accessAdditionalMenuByXpath(HomePage.buzzMenuItem, "Buzz");
		System.out.println("Buzz page opened to verify");
		tableData=UILibraries.getDataFromBuzzFeed();
		for(Map<String,String> row:tableData)
		{
			if (row.get("Post Time").equals(timeStamp.toUpperCase()))
			{
				Assert.assertEquals(row.get("Post Data"), actPostData,"Incorrect Post Data at "+timeStamp);
				flag=true;
				
			}
			
		}
		
		if(!flag)
		{
			Assert.fail("No Post Found in :"+timeStamp);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	

}








}