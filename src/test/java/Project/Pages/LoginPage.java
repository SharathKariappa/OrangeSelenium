package Project.Pages;

import org.openqa.selenium.By;

public class LoginPage {
	
	public static By inputUsername=By.xpath("//input[@name='username']");
	public static By inputPassword=By.xpath("//input[@name='password']");
	public static By buttonLogin=By.xpath("//button[text()=' Login ']");
	public static By spanUsernameMsg=By.xpath("//input[@name='username']/parent::div//following-sibling::span");
	public static By spanPasswordMsg=By.xpath("//input[@name='password']/parent::div//following-sibling::span");

}
