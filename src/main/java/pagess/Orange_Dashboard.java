package pagess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orange_Dashboard 
{
	
	private @FindBy(xpath ="//*[@class='oxd-userdropdown-name']") WebElement usernameofDashboard;
	private @FindBy(xpath ="//*[text()='Logout']") WebElement LogoutBtn;
	//	private @FindBy(xpath ="//*[text()=\" Login \"]") WebElement loginbtn;
	
	public Orange_Dashboard(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}
	
	public String getTextOfUsername() throws InterruptedException
	{
		Thread.sleep(5000);
		String Result=usernameofDashboard.getText();   // text
		return Result;
	}

	public void ClicksOnUsername()
	{
		usernameofDashboard.click();
	}
	
	public void ClicksonLogout()
	{
		LogoutBtn.click();
	}
	
	
}
