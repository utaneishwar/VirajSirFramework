package library_files;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orange_BaseClass 
{

	public WebDriver driver;
	
	public void initBrowser() throws IOException
	{
		driver =new ChromeDriver();
		driver.get(Utility.getdatafromPF("url"));  //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		driver.manage().window().maximize();
	
	}

}
