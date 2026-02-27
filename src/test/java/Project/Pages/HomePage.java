package Project.Pages;

import org.openqa.selenium.By;

public class HomePage {
	
	public static By pLoggedInName=By.xpath("//p[text()='Owais lastNameteste']");
	public static By divSearchBar=By.xpath("//div[@class='oxd-main-menu-search']");
	public static By pageHeader=By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	public static By buzzMenuItem=By.xpath("//a[@href='/web/index.php/buzz/viewBuzz']");
    
    
    public static By menuPathByText(String str)
    {
    	return By.xpath("//a[@href='/web/index.php/"+str.toLowerCase()+"/view"+str+"Module']");
    }
}
