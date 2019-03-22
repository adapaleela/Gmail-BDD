package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Composepage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[text()='Compose']")
	public WebElement comp;
	
	@FindBy(xpath="//*[@class='gb_cb gbii']")
	public WebElement profilepic;
	
	@FindBy(linkText="Sign out")
	public WebElement signout;
	
	public Composepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickprofilepic()
	{
		profilepic.click();
	}
	
	public void clicksignout()
	{
		signout.click();
	}
	
}
