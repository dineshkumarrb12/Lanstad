package lan;

import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class project_creation {
	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		//String l="http://www.lanstad.com/epublishing/?r=site/login";
		d.get("http://www.lanstad.com/epublishing/?r=site/login");
		String q=String.valueOf(d);	
	String n="http://www.lanstad.com/epublishing/?r=configuration";
		if (n.equals(q))
		{
			d.findElement(By.partialLinkText("Milestone")).click();
		}
		else
		{
			d.findElement(By.partialLinkText("Permissions")).click();
		}
		
		
	}
}