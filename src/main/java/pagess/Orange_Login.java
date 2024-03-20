package pagess;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orange_Login
{
	WebDriver driver;
			@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")private WebElement UN;
			 @FindBy(xpath ="//*[@name=\"password\"]") private WebElement PSW;
			@FindBy(xpath ="//*[text()=\" Login \"]") private WebElement loginbtn;
			//constructor 
	public Orange_Login(WebDriver driver)  // open driver
	{
		this.driver=driver;  // https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		PageFactory.initElements(driver, this);
	}
	
	public void username(String username) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		UN.sendKeys(username);  //Admin
	}
							//admin123
	public void passsword(String password) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PSW.sendKeys(password);
	}
	public void login() throws InterruptedException
	{
		Thread.sleep(2000);
		loginbtn.click();
	}
	
	
	
}
