package lan;

import java.io.File;
import java.io.IOException;
 




import org.apache.commons.io.FileUtils;
 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
 
import org.openqa.selenium.TakesScreenshot;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class login {
public static void main(String[] args) throws IOException, InterruptedException
{
	
	
	System.setProperty("webdriver.chrome.driver","E:\\selenium\\c\\chromedriver.exe");
	WebDriver d=new ChromeDriver();
	 
	d.get("http://lanstad.com/epublishing/?r=site/login");
		//String yourtext= d.findElement(By.tagName("body")).getText();
		//System.out.println(yourtext);
		//d.findElement(By.id("LoginForm_username")).sendKeys("darshana@deantaglobal.com");
	
		d.findElement(By.id("LoginForm_username")).sendKeys("darshana@deantaglobal.com");
		d.findElement(By.id("LoginForm_password")).sendKeys("789451");
		//d.findElement(By.className("button big primary")).click();
		
		d.findElement(By.name("yt0")).click();
		/*String a=d.getCurrentUrl();
		
		System.out.println(a);
		
		d.findElement(By.className("configtlink")).click();
		String b=d.getCurrentUrl();
		System.out.println(b);
		Thread.sleep(9000);
		//d.findElement(By.xpath("//*[@class='portlet']//*[text()='Back']")).click();
		//String c=d.getCurrentUrl();
		
		if(a.equals(b))
		{
			System.out.println("pass");
			login.captureScreenShot(d);
			
		}
		else
		{
			System.out.println("fail");
			login.captureScreenShot(d);
			
		}
	}
public static void captureScreenShot(WebDriver ldriver){
	// Take screenshot and store as a file format             
	 File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
	 try {
	// now copy the  screenshot to desired location using copyFile method
	 
	FileUtils.copyFile(src, new File("D:/images/"+System.currentTimeMillis()+".png"));                         
	} catch (IOException e)
	 
	{
	  System.out.println(e.getMessage()); 
	}*/
	}
}