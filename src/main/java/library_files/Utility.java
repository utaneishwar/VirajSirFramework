package library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility 
{

	//	@Test  
	// code for ExcelSheet
	public static String getDataFromExcelsheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException, InterruptedException
	{
		FileInputStream file =new FileInputStream("C:\\Users\\intel\\eclipse-workspace\\VirajFramework\\src\\test\\resources\\TestData\\getdata.xlsx");
		Thread.sleep(2000);
		String expectedvalue = WorkbookFactory.create(file).getSheet("Sheet2").getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		return expectedvalue;

	}
	
	@Test
	// code for Screenshot
	public static void CapturScreenshot(WebDriver driver,String testcaseID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file =new File("C:\\Users\\intel\\eclipse-workspace\\VirajFramework\\Screenshot\\"+testcaseID+".jpg");
		FileHandler.copy(source, file);
	}
	
	
	@Test
	// code for properties 				//url //username
	public static String getdatafromPF(String key) throws IOException 
	{	
		// code for open configue.properties
		FileInputStream source =new FileInputStream("C:\\Users\\intel\\eclipse-workspace\\VirajFramework\\src\\test\\resources\\TestData\\config.properties");
		Properties prop =new Properties(); 
		prop.load(source);
		String value=prop.getProperty(key); //url 
		return value;        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		
	}
}
//// for my understanding		
//// interview Questions
//	// execeute first Static block and then main method ;
//	static   // Static Block
//	{
//		//Utility u =new Utility();    // 
//		System.out.println("static block");
//	}
//	// Non-Static Block
//	{
//
//		System.out.println("nonstatic block");
//	}
//	   public static void main(String [] args )    // length of array is zero 
//	{
//		Utility u =new Utility();
//		System.out.println("main method");
//		System.out.println(args[0]);    // java.lang.ArrayIndexOutOfBoundsException 
//	}
//	   }


	




