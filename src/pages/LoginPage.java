package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage
{
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "i-icon-profile")
	private WebElement loginLink;
	
	@FindBy(how = How.ID, using = "signInLink")
	private WebElement signInLink;
	
	@FindBy(how = How.ID, using = "mobileNoInp")
	private WebElement mobileNum;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[2]/div/div/div[3]/iframe")
	private WebElement iframe;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	public void enterMobileNumber(String number) throws InterruptedException
	{
		loginLink.click();
		signInLink.click();
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		mobileNum.sendKeys(number);
	}
}
