package Project.Pages;

import org.openqa.selenium.By;

public class BuzzPage {
	
	public static By postTextArea=By.xpath("//textarea[@placeholder=\"What's on your mind?\"]");
	public static By postButton=By.xpath("//button[text()=' Post ']");
	public static By buzzPostsfeedDiv=By.xpath("//div[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/child::div[@class='oxd-grid-item oxd-grid-item--gutters']");
    public static By postTimeP=By.xpath(".//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-time']");
    public static By postDataP=By.xpath(".//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']");
    public static By postDataPTruncate=By.xpath(".//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text --truncate']");
    public static By postedNameP=By.xpath(".//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-emp-name']");
	public static By successMessage=By.xpath("//div[@id='oxd-toaster_1']/descendant::p[text()='Success']");
    public static By SucessWindow=By.xpath("//div[@id='oxd-toaster_1']");
    public static By feedloadSpinnerdiv=By.xpath("//div[@class='oxd-loading-spinner']");    
	public static By postTimeByIndex(int index)
	{
		return By.xpath("//div[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/child::div[@class='oxd-grid-item oxd-grid-item--gutters']["+index+"] /descendant::p[@class='oxd-text oxd-text--p orangehrm-buzz-post-time']");
	}
    
    public static By postedNameByIndex(int index)
    {
    	return By.xpath("//div[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/child::div[@class='oxd-grid-item oxd-grid-item--gutters']["+index+"] /descendant::p[@class='oxd-text oxd-text--p orangehrm-buzz-post-emp-name']");
    }
    
    
    
}
