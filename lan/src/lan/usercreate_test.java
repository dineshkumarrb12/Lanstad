package lan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriverException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class usercreate_test{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
	System.setProperty("webdriver.chrome.driver","E://selenium//c//chromedriver.exe");
	WebDriver d=new ChromeDriver();
	d.get("http://www.lanstad.com/epublishing/?r=site/login");
	Thread.sleep(1500);
	d.findElement(By.name("LoginForm[username]")).sendKeys("darshana@deantaglobal.com");
	d.findElement(By.id("LoginForm_password")).sendKeys("789451");
	d.findElement(By.name("yt0")).click();
	d.findElement(By.partialLinkText("Configuration")).click();
	d.findElement(By.partialLinkText("Users")).click();
	d.findElement(By.partialLinkText("Create User")).click();
	
int totalnorow=usercreate_test.getnoofrow();
	
	for(int i=1;i<totalnorow;i++)
	{
String al=usercreate_test.getData(i,0);
	
	d.findElement(By.id("Users_user_name")).sendKeys(al);
	
	String ml=usercreate_test.getData(i,0);
	d.findElement(By.id("Users_user_lastname")).sendKeys(ml);
	String un=usercreate_test.getData(i,2);
	d.findElement(By.id("Users_user_email")).sendKeys(un);
	
	String st=usercreate_test.getData(i,3);
	d.findElement(By.id("Users_user_password")).sendKeys(st);
	
	WebElement e1=d.findElement(By.id("Users_user_active"));
	Select s1=new Select(e1);
	s1.selectByVisibleText("Yes");
	
	d.findElement(By.id("submit")).click();
	Thread.sleep(1000);
	d.findElement(By.partialLinkText("Back")).click();
	Thread.sleep(1000);
	}
	}
public static String getData(int r,int c) throws EncryptedDocumentException, InvalidFormatException, IOException 
{
	
	FileInputStream fis=new FileInputStream("E:\\selenium\\user\\user_details.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String str=wb.getSheet("sheet1").getRow(r).getCell(c).getStringCellValue();
	return str;
	
}
public static int getnoofrow() throws EncryptedDocumentException, InvalidFormatException, IOException 
{
	FileInputStream fis=new FileInputStream("E:\\selenium\\user\\user_details.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int n=wb.getSheet("sheet1").getLastRowNum();
	return n+1;

	}
}

