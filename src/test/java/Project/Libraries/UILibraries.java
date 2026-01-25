package Project.Libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UILibraries extends GlobalVariables {
	
	/***************************************************************************
	 * Method Name : EnterText(By xpathValue,String strVal)
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : 
	 ****************************************************************************
	 */
 public static void EnterText(By xpathValue,String strVal)
 {
	 try {
		 
		 WebDriverWait wd=new WebDriverWait(getDriver(), 15);
		 wd.until(ExpectedConditions.elementToBeClickable(xpathValue));
		 WebElement ele=getDriver().findElement(xpathValue);

		 ele.sendKeys(strVal);
		 waitFor(2);
 
		 
	 } catch (Exception e) {
		 // TODO: handle exception
		 e.printStackTrace();
	 }
 }
 
	/***************************************************************************
	 * Method Name : ClickElement(By xpathValue)
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : 
	 ****************************************************************************
	 */
 public static void ClickElement(By xpathValue)
 {
	 try {
		 WebDriverWait ww=new WebDriverWait(getDriver(), 15);
	//	 ww.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathValue));
		 ww.until(ExpectedConditions.elementToBeClickable(xpathValue));
		 WebElement ele=getDriver().findElement(xpathValue);
		 
		 
		 ele.click();

	 } catch (Exception e) {
		 // TODO: handle exception
		 e.printStackTrace();
	 }

 }
 
	/***************************************************************************
	 * Method Name : waitFor()
	 * Created By  :  
	 * Reviewed By : 
	 * Purpose	   : 
	 ****************************************************************************
	 */
	public static void waitFor(long seconds) {
		try {
			Thread.sleep(seconds*1000);

		}
		catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	/***************************************************************************
	 * Method Name : IsDisplayed(By xpathValue)
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : verify whether the webelement is displayed
	 ****************************************************************************
	 */
	public static boolean IsDisplayed(By xpathValue)
	{
		try 
		{
			WebDriverWait ww=new WebDriverWait(getDriver(), 20);
			//ww.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathValue));
			ww.until(ExpectedConditions.visibilityOfElementLocated(xpathValue));
			WebElement ele=getDriver().findElement(xpathValue);
			if(ele.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	/***************************************************************************
	 * Method Name : String GetTextFromElement(By xpathValue)
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : 
	 ****************************************************************************
	 */
	
	public static String GetTextFromElement(By xpathValue)
	{
		String str="";
		WebDriverWait wd=new WebDriverWait(getDriver(), 10);
		wd.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathValue));
		WebElement ele=getDriver().findElement(xpathValue);
		str=ele.getText();
		return str;
	}
	
 
}
