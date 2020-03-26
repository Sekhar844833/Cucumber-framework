package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchTask {
	WebDriver driver;
	public void open()
	{
						// To launch chrome Browser
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://examples.codecharge.com/TaskManager/Default.php");
	}
	public void typeTask()
	{
						// To select the type of the task
		driver.findElement(By.xpath("(//option[@value='1'])[5]")).click();
	}
	public void search()
	{
						// To search the task
		driver.findElement(By.xpath("//input[@name='DoSearch']")).click();
	}
						// Method to check added task details is in the list or not	
	public void Assert()
	{
		String d=driver.findElement(By.xpath("//a[text()='CTS']")).getText();
		Assert.assertEquals("CTS", d);
	}
}
