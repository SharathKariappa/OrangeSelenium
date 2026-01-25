package Project.Pages;

import org.openqa.selenium.By;

public class AdminUserManagement {
	
	public static By addButton=By.xpath("//button[text()=' Add ']");
	public static By userName=By.xpath("//label[text()='Username']/parent::div//following-sibling::div//child::input [@class='oxd-input oxd-input--active']");
	//public static By userNameElement=By.xpath("//*[@role='listbox']//*[text()='Joy  Smith']");
	public static By userNameElement=By.xpath("(//*[@role='listbox']//*[contains(text(),'Joy')])[1]");
	public static By userRole=By.xpath("//label[text()='User Role']/parent::div//following-sibling::div//child::div[@class='oxd-select-text-input']");
	//public static By userRoleElement=By.xpath("//*[text()='Admin' and not(@class='oxd-text oxd-text--span oxd-main-menu-item--name') and not(@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module')]");
	//public static By userRoleElement=By.xpath("//*[text()='ESS']");
	public static By userRoleElement=By.xpath("//*[@role='listbox']//*[text()='ESS']");
	public static By  employeeName=By.xpath("//input[@placeholder='Type for hints...']");
	public static By status=By.xpath("//label[text()='Status']/parent::div//following-sibling::div//child::div[@class='oxd-select-text-input']");
	
    public static By password=By.xpath("//label[text()='Password']/parent::div//following-sibling::div//child::input[@type='password']");
    public static By confirmPassword=By.xpath("//label[text()='Confirm Password']/parent::div//following-sibling::div//child::input[@type='password']");
    public static By saveUser=By.xpath("//button[text()=' Save ']");
    public static By SucessWindow=By.xpath("//div[@id='oxd-toaster_1']");
    public static By SucessMessage=By.xpath("//div[@id='oxd-toaster_1']//child::p[text()='Success']");
    
    public static By searchUser=By.xpath("//button[text()=' Search ']");
    
    public static By UserRoleByText(String role)
    {
    	return(By.xpath("//*[@role='listbox']//*[text()='"+role+"']"));
    }
    
    public static By statusElementByText(String Status)
    {
    	return(By.xpath("//*[@role='listbox']//*[text()='"+Status+"']"));
    }

}
