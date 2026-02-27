package Project.Libraries;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Project.Pages.BuzzPage;

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
			WebDriverWait ww=new WebDriverWait(getDriver(), 50);
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
	    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wd=new WebDriverWait(getDriver(),50);
		wd.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathValue));
		WebElement ele=getDriver().findElement(xpathValue);
		str=ele.getText();
		return str;
	}
	
	
	/***************************************************************************
	 * Method Name : List<List<String>> GetDataFromTable(By rowXpath,By columnXpath)
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : Method to read data from table row-wise using List<List<String>>
	 ****************************************************************************
	 */

	public static List<List<String>> GetDataFromTable(By rowXpath,By columnXpath)
	{
		List<List<String>> tableData = new ArrayList<>();
		try {
			WebDriverWait wd = new WebDriverWait(getDriver(), 10);
			wd.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rowXpath));
			List<WebElement> rows = getDriver().findElements(rowXpath);
			for(WebElement row :rows)
			{
				List<WebElement> colums=row.findElements(columnXpath);
				List<String>rowData=new ArrayList<String>();
				
				for(WebElement col : colums)
				{
					rowData.add(col.getText());
				}
				tableData.add(rowData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableData;
	}
	
	
	
	/***************************************************************************
	 * Method Name : List<Map<String,String>> GetDataFromTable(By rowXpath,By columnXpath)
	 * Created By  :  Sharath
	 * Reviewed By : 
	 * Purpose	   : Method to read data from table row-wise using List<Map<String,String>>
	 ****************************************************************************
	 */
	
	public static List<Map<String,String>> GetdataFromTableUsingMaps(By rowXpath,By columnXpath,By headerXPath)
	{
		List<Map<String, String>>tableData=new ArrayList<Map<String,String>>();
		try 
		{
			WebDriverWait wd=new WebDriverWait(getDriver(), 20);
			wd.until(ExpectedConditions.presenceOfElementLocated(headerXPath));
			List<WebElement>headers=new ArrayList<WebElement>();
			List<String>headerNames=new ArrayList<String>();		
			
			headers=getDriver().findElements(headerXPath);
			for(WebElement header:headers)
			{
				headerNames.add(header.getText());
			}
			
			
			
			
			List<WebElement>rows=getDriver().findElements(rowXpath);
			for(WebElement row : rows)
			{
				
				List<WebElement>colums=row.findElements(columnXpath);
				Map<String,String>rowData=new LinkedHashMap<String, String>();
				
				for(int i=0;i<colums.size();i++)
				{
					rowData.put(headerNames.get(i), colums.get(i).getText());
					
				}
				
			tableData.add(rowData);	
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tableData;
	}
	
	
	
	

/***************************************************************************
 * Method Name : List<Map<String,String>> getDataFromBuzzFeed()
 * Created By  : Sharath
 * Reviewed By : 
 * Purpose	   : get data from buzz feed and return List<Map<String,String>>
 ****************************************************************************/
public static List<Map<String,String>> getDataFromBuzzFeed()
{
	List<Map<String,String>> tabledata=new ArrayList<Map<String,String>>();
	try 
	{   
		System.out.println("Starting to get data from feed");
		WebDriverWait wd=new WebDriverWait(getDriver(), 25);
		wd.until(ExpectedConditions.presenceOfAllElementsLocatedBy(BuzzPage.buzzPostsfeedDiv));
		List<WebElement> rows=getDriver().findElements(BuzzPage.buzzPostsfeedDiv);
		System.out.println("Number of posts : "+rows.size());
		for(WebElement row:rows)
		{
			//add try catch post data
				Map<String,String>rowData=new LinkedHashMap<String, String>();
				String postTime=row.findElement(BuzzPage.postTimeP).getText();
				String postEmpname = row.findElement(BuzzPage.postedNameP).getText();;
				String postData="";
				try {
					
					postData=row.findElement(BuzzPage.postDataP).getText();
				    } 
				catch (NoSuchElementException e) 
				    {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Using alternate locator to get employee name since : "+e.getMessage());
					postEmpname = row.findElement(BuzzPage.postDataPTruncate).getText();
				    }
				rowData.put("Employee Name", postEmpname);
				rowData.put("Post Time", postTime);
				rowData.put("Post Data", postData);
				tabledata.add(rowData);
			
//			catch (NoSuchElementException e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("Skipping current row since : "+e.getMessage());
//			
//			}			
		}

		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return tabledata;
}


/***************************************************************************
 * Method Name : Void WaitForLoadSpinnerToDisappear(By spinnerXpath)
 * Created By  : Sharath
 * Reviewed By : 
 * Purpose	   : Wait for the load spinner to disappear
 ****************************************************************************/
public static void WaitForLoadSpinnerToDisappear(By spinnerXpath)
{
	
	try 
	{
		WebDriverWait wd=new WebDriverWait(getDriver(), 20);
		wd.until(ExpectedConditions.invisibilityOfElementLocated(spinnerXpath));
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
