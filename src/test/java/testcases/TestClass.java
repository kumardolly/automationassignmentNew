package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
public class TestClass {	
	WebDriver dr;
	LoginPage lp;
  @Test
  public void testCase1() {
	
	  lp.loginToApplication("test1@gmail.com", "123");
	  TestUtilities.addScreenshot();

	  lp.isItemDisplayed();
	  lp.itemList();
	  lp.isItemCorrect();
	
	  lp.D3Button();
	  lp.SelectOption_3();
	  TestUtilities.addScreenshot();
	
	  lp.test4Button();
	  lp.t42();
	
	  lp.test5Button();
	  TestUtilities.addScreenshot();
	 
	 lp.tc06rowcol(2, 2);
  } 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr = TestBase.getInstance();
	  lp = new LoginPage(dr);
	  
  }
  @AfterMethod
  public void afterMethod() {
	 dr.quit();
  }

}
