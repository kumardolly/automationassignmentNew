package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Assert;
import utilities.TestUtilities;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='inputEmail']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='inputPassword']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement login;
	
	public void loginToApplication(String user,String pass)
	{	
		boolean b;
	
		wait(email);
		b=email.isDisplayed();
		System.out.println("Verify email is present=> "+b);
		Assert.assertEquals(b, true);
		
		
		wait(password);
		b=password.isDisplayed();
		System.out.println("Verify password is present=> "+b);
		Assert.assertEquals(b, true);
		
		wait(login);
		b=login.isDisplayed();
		System.out.println("Verify login is present=> "+b);
		Assert.assertEquals(b, true);
		
		email.sendKeys(user);
		password.sendKeys(pass);
		login.click();
	}
	
	@FindBy(css=".list-group-item")
	private List<WebElement> menu;
	public void itemList()
	{
		int actual=menu.size();
		Assert.assertEquals(actual,3);
		System.out.println("Verify Size of Item Menu ="+actual);
	}
	
	//@FindBy(xpath="//li[contains(text(),'List Item 2')]")
	@FindBy(xpath="//*[@id='test-2-div']/ul/li[2]")
	private WebElement item;
	public boolean isItemDisplayed()
	{		
		boolean b=false;
		try{
			b=item.isDisplayed();
			String itemvalue=item.getText();
			String a="List Item 2 6";
			Assert.assertEquals(itemvalue, a);
			System.out.println("Verify if listitem 2 is displayed="+b);
			} catch(Exception e)
				{
				e.printStackTrace();
				}
		return b;	
	}
	
	@FindBy(xpath="//li[contains(text(),'List Item 2')]/span")
	private WebElement bvalue;
	
	public boolean isItemCorrect()
	{	
		String act=bvalue.getText();
		Assert.assertEquals(act, "6");
		System.out.println("Verify value is 6 or not ==>"+act);
		return false;
	}
	
	
	@FindBy(id="dropdownMenuButton")
	private WebElement ddmButton;
	
	public void D3Button()
	{
		String OptionButton=ddmButton.getText();
		System.out.println("Value of Option Button by default is==> "+OptionButton);
	Assert.assertEquals(OptionButton,"Option 1");
	
	}
	
	@FindBy(linkText="Option 3")
	private WebElement option3Button;
	public void SelectOption_3()
	{
		ddmButton.click();
		wait(option3Button);
		option3Button.click();
		System.out.println("Option 3 Selected from select list");
	}
	
	@FindBy(xpath="//button[text()='Button']")
	private WebElement t4Button;
	
	public boolean test4Button()
	{	
		boolean b=false;
		try {
		b=t4Button.isEnabled();
		Assert.assertEquals(b, true);
		System.out.println("T4 Button1 is enabled=>"+b);
		
		}catch(Exception e)
		{e.printStackTrace();}
		return b;
	}
	
	@FindBy(xpath="//*[@id=\"test-4-div\"]/button[2]")
	private WebElement t4Button2;
	
	public boolean t42()
	{
		boolean b=false;
		try {
		b=t4Button2.isEnabled();
		Assert.assertEquals(b, false);
		System.out.println("T4 Button2 is enabled=>"+b);
		
		}catch(Exception e)
		{e.printStackTrace();}
	
		return b;
	}
	
	@FindBy(id="test5-button")
	private WebElement Button5;
	
	
	@FindBy(xpath="//*[@id='test5-alert']")
	private WebElement Button5Msg;
	
	public boolean test5Button()
	{
		wait(Button5);
		Button5.click();
		
		
		wait(Button5Msg);
		String expMsg=Button5Msg.getText();
		String actMsg="You clicked a button!";
		Assert.assertEquals(actMsg, expMsg);
		System.out.println("Message is displayed after clicking button 5.");
		
		boolean b=false;
		
		try 
		{
		b=Button5.isEnabled();
		Assert.assertEquals(b, false);
		System.out.println("Button for test 5 is disabled");
		}
		catch(Exception e)
		{e.printStackTrace();}
		return b;
	}
	
	@FindBy(xpath="//table/tbody/tr")
	List<WebElement> Rows;
	public void tc06rowcol(int i,int j)
	{
		String exp="Ventosanzap";
		String text=driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")).getText();
		System.out.println("Value of cell at coordinate 2,2 is=>"+text);
		Assert.assertEquals(text, exp);
	}
	private void wait(WebElement e)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
}
