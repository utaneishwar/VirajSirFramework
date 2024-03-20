package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import library_files.Orange_BaseClass;
import library_files.Utility;
import pagess.Orange_Dashboard;
import pagess.Orange_Login;

public class Orange_TestClass extends Orange_BaseClass
{
	Orange_Login login ;
	Orange_Dashboard Dashboard;
	String testcaseID;
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initBrowser();     // url  //directly called in nonstatic area dfrom base class
		login =new Orange_Login(driver);
		// create object of pom1
		Dashboard=new Orange_Dashboard(driver);
		// create object of pom2

	}


	@BeforeMethod
	public void LoginToApp() throws InterruptedException, IOException
	{   	 // usrname();           getdatafromPF(key);      
		login.username(Utility.getdatafromPF("username"));    // Admin
		login.passsword(Utility.getdatafromPF("Pwd"));     // admin123
		login.login();       // click on login button
	
	}


	@Test(priority=1)
	public void VerifyDashboardText() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		testcaseID="TC_001";
		String actualresult = Dashboard.getTextOfUsername();       //  igoeu ubmwco     //Bob Tester
		System.out.println(actualresult);
		String expectedResult=Utility.getDataFromExcelsheet(2, 0);  //igoeu ubmwco   //Bob Tester    //Priya Jadhav



		if(actualresult.equals(expectedResult))
		{
			System.out.println("verify Text Successfully");
		}
		else
		{
			System.out.println("test case failed");
		}

	}
	@Test (priority=2)
	public void VerifyTitleOfPage() throws Exception
	{
		testcaseID="TC_002";
		String titleofpage = driver.getTitle();        			 // OrangeHRM  // Driver got from base_class 
		String expectedTitle = Utility.getDataFromExcelsheet(1, 0);    //OrangeHRM
	    if(titleofpage.equals(expectedTitle))
	    {
	    	System.out.println("Title of page is correct");
	    }
	    else
	    {
	    	System.out.println("Mismatched Title of page");
	    }
	    throw new Exception();
		//  Assert.fail();
		
		
	}

	@AfterMethod
	public void Logout(ITestResult result) throws IOException, InterruptedException
	{	
		if(result.getStatus()==result.FAILURE)
		{
			Utility .CapturScreenshot(driver,testcaseID);
		}
		
		
		Dashboard.ClicksOnUsername();
		Dashboard.ClicksonLogout();
		Thread.sleep(5000); 
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		driver.close();
	//	Thread.sleep(10000);   // if we get Socket exception so that time we have to apply thread
	}
}
