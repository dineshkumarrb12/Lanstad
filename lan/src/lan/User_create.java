package lan;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class User_create {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "E://selenium//c//chromedriver.exe");
	WebDriver d=new ChromeDriver();
	d.get("http://www.lanstad.com/epublishing/?r=site/login");
	d.findElement(By.id("LoginForm_username")).sendKeys("darshana@deantaglobal.com");
	d.findElement(By.id("LoginForm_password")).sendKeys("789451");
	d.findElement(By.name("yt0")).click();
	d.findElement(By.partialLinkText("Configuration")).click();
	d.findElement(By.partialLinkText("Users")).click();
	d.findElement(By.partialLinkText("Create User")).click();
	
int totalnorow=User_create.getnoofrow();
	
	for(int i=1;i<totalnorow;i++)
	{
String al=User_create.getData(i,0);
	
	d.findElement(By.id("Users_user_name")).sendKeys(al);
	
	String ml=User_create.getData(i,1);
	d.findElement(By.id("Users_user_lastname")).sendKeys(ml);
	String un=User_create.getData(i,2);
	d.findElement(By.id("Users_user_email")).sendKeys(un);
	
	
	
	
	int length=9;
	System.out.println(geek_Password(length)); 
	
	String password = String.valueOf(geek_Password(length));
	
	//String st=User_create.getData(i,3);
	d.findElement(By.id("Users_user_password")).sendKeys(password);
	
	
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

static char[] geek_Password(int len) 
{ System.out.println("Generating password using random() : "); 
System.out.print("Your new password is : "+len+"\n"); 

String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
String numbers = "0123456789";


String values = Capital_chars + Small_chars + 
                numbers; 

// Using random method 
Random rndm_method = new Random(); 

char din[] = new char[len]; 
System.out.print("\npassword\t\n"+ din+"\n");
for (int i = 0; i < len; i++) 
{ 
    // Use of charAt() method : to get character value 
    // Use of nextInt() as it is scanning the value as int 
    din[i] = 
      values.charAt(rndm_method.nextInt(values.length())); 
    System.out.print("\npasswordddddddddddddddd\t\n"+ din[i]+"\n");
} 
System.out.print(din);
return din;
	
}
}