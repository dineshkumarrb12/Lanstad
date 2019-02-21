package lan;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class task_creation {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "E://selenium//c//chromedriver.exe");
	WebDriver d=new ChromeDriver();
	d.get("http://www.lanstad.com/epublishing/?r=site/login");
	d.findElement(By.id("LoginForm_username")).sendKeys("darshana@deantaglobal.com");
	d.findElement(By.id("LoginForm_password")).sendKeys("789451");
	d.findElement(By.name("yt0")).click();
	d.findElement(By.partialLinkText("Configuration")).click();
	
	d.findElement(By.partialLinkText("Milestone")).click();
	

	int totalnorow=milestone_creation.getnoofrow();
	
	for(int i=1;i<totalnorow;i++)
	{
		
		WebElement e1=d.findElement(By.id("companysel"));
		Select s1=new Select(e1);
		s1.selectByVisibleText("Taylor and Francis");
		
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		//Thread.sleep(1000);
		WebElement e2=d.findElement(By.id("typesel"));
		Select s2=new Select(e2);
		s2.selectByVisibleText("UK");
		
		//Thread.sleep(1000);
		
	WebElement e3=d.findElement(By.id("catsel"));
	Select s3=new Select(e3);
	s3.selectByVisibleText("FSM");
	
	//Thread.sleep(1000);
	
	d.findElement(By.xpath("//span[text()='Create Task']")).click();
	
	//Thread.sleep(1000);
	
	String al=task_creation.getData(i,0);
	
	d.findElement(By.id("TasksTemplate_task_name")).sendKeys(al);
	
	String ml=task_creation.getData(i,1);
d.findElement(By.id("TasksTemplate_milestone_id")).sendKeys(ml);
	
	//List<WebElement> list = d.findElements(By.id("radiobtns"));
	d.findElement(By.xpath("//input[@name='selectline' and @value='1']")).click();
	
	d.findElement((By.xpath("//input[@class='betterform application']"))).sendKeys("(.*?).*");
	
	String un=task_creation.getData(i,2);
	
	d.findElement(By.id("TasksTemplate_task_description")).sendKeys(un);
	d.findElement(By.className("tat_taskStartdate")).clear();
	
	String st=task_creation.getData(i,3);
	
	d.findElement(By.className("tat_taskStartdate")).sendKeys(st);
	d.findElement(By.className("tat_taskDuedate")).clear();
	
	String et=task_creation.getData(i,4);
	
	d.findElement(By.className("tat_taskDuedate")).sendKeys(et);
	d.findElement(By.id("submit")).click();
	
	//Thread.sleep(1000);
	
	d.navigate().refresh();
	
	
	}

}
	public static String getData(int r,int c) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream fis=new FileInputStream("E:\\selenium\\milestone\\task\\Task_creation.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String str=wb.getSheet("sheet1").getRow(r).getCell(c).getStringCellValue();
		return str;
		
	}
	public static int getnoofrow() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("E:\\selenium\\milestone\\task\\Task_creation.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int n=wb.getSheet("sheet1").getLastRowNum();
		return n+1;
	}
}