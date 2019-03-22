package tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailglue 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public Scenario s;
	public Homepage hp;
	public Loginpage lp;
	public Composepage cp;
	public Properties p;
	
	@Before()
	public void method(Scenario s) throws Exception
	{
		this.s=s;
		File f=new File("E:\\leelajava\\gmailtest\\src\\test\\resources\\repository\\propertiesfile.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
	}
	
	@Given("^launch site using chrome$")
	public void method2()
	{
		System.setProperty("webdriver.chrome.driver",p.getProperty("cpath"));
		driver=new ChromeDriver();
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
		cp=new Composepage(driver);
		driver.get(p.getProperty("url"));
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hp.uid));
		driver.manage().window().maximize();
	}
	@When("^enter userid as \"(.*)\"$")
	public void method3(String x)
	{
		hp.filluid(x);
	}
	@And("^click userid next$")
	public void method4()
	{
		wait.until(ExpectedConditions.elementToBeClickable(hp.uidnext));
		hp.clickuidnext();
	}
	@And("^enter password as \"(.*)\"$")
	public void method5(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillpwd(x);
	}
	@And("^click password next$")
	public void method6()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lp.pwdnext));
		lp.clickpwdnext();
	}
	@And("^do logout$")
	public void method7()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cp.profilepic));
		cp.clickprofilepic();
		wait.until(ExpectedConditions.elementToBeClickable(cp.signout));
	}
	@And("^close site$")
	public void method8()
	{
		driver.close();
	}
}
