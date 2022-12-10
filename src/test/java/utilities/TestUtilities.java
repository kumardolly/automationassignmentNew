package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtilities extends TestBase {
	
	public static void scrollToElement(WebElement e)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		
		//next two lines will show the visibility of specific selected item in view.
		je.executeScript("arguments[0].scrollIntoView(false);", e);
				
		//the scrolling is done to bring the item in the middle of view.
		je.executeScript("window.scrollBy(0,300)", "");					
	}
	
	public static void clickOnElementJS(WebElement e)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", e);	
				
	}
	
	public static void captureScreenshot() throws IOException 
	{
		String str="screenshots";
		File f=new File(str);
		if(!f.isDirectory())
		{f.mkdir();}
		else
		{
			System.out.print("Folder screenshots exists");
		}
		
		TakesScreenshot t=(TakesScreenshot) driver;
		File file = t.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(str+"/"+getDate()+"image.jpg"));   // jpg and png format only.
	
	}
	
	public static void addScreenshot()
	{
		TakesScreenshot t=(TakesScreenshot) driver;
	    String file = t.getScreenshotAs(OutputType.BASE64);
	    String imge="<img src=\"data:image/png;base64,"+file+"\" height=\"600\" width=\"800\" ";
	    Reporter.log(imge);
	}
	public static String getDate()
	{
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss_SSSS");
		String d = sdf.format(dt);
		System.out.println(d);
		return d;
		
	}
	
}
