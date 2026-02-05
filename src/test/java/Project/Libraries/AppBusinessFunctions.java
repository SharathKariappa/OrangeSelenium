package Project.Libraries;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Project.Pages.AdminUserManagement;
import Project.Pages.HomePage;
import Project.Pages.LoginPage;

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

//	create method for add 2 number 

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
			UILibraries.EnterText(AdminUserManagement.employeeName, "Joy");
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
		List<List<String>> tableData=new ArrayList<>();
		try {

			UILibraries.EnterText(AdminUserManagement.userName, userName);
			UILibraries.ClickElement(AdminUserManagement.searchUser);
			tableData=UILibraries.GetDataFromTable(AdminUserManagement.rowsUserTable, AdminUserManagement.columnsUserTable);
		   	for(List<String> row :tableData)
		   	{
		   		System.out.println(row.get(1) +"----"+row.get(2));
		   		
		   	}
             System.out.println("Done");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
