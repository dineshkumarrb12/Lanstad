package lan; 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class User_creation {
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("http://www.lanstad.com/epublishing/?r=site/login");
		
	}
public static String inputs(int a,int b) throws EncryptedDocumentException, InvalidFormatException, IOException
{
	FileInputStream inp=new FileInputStream("D:\\dinesh 6.7.2017\\selenium\\inputs\\login_details.xlsx");
	Workbook dinesh=WorkbookFactory.create(inp);
	String str=dinesh.getSheet("sheet1").getRow(0).getCell(1).getStringCellValue();
	
	return null;
	
}
}
