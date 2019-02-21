package lan;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dashboard_pop_up {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "E://selenium//c//chromedriver.exe");
	WebDriver d=new ChromeDriver();
	d.get("http://www.lanstad.com/epublishing/?r=site/login");
	d.findElement(By.id("LoginForm_username")).sendKeys("techsupport@deantaglobal.com");
	d.findElement(By.id("LoginForm_password")).sendKeys("123456");
	d.findElement(By.name("yt0")).click();
	
	Thread.sleep(5000);
	d.findElement(By.xpath("//a[@class='close-reveal-modal close-reveal-modalas']")).click();
	Thread.sleep(3000);
	
	d.findElement(By.partialLinkText("Configuration")).click();
	}
	}