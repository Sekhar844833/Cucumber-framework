package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {
	WebDriver driver;
	public void open()
						// To launch chrome Browser
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://examples.codecharge.com/TaskManager/Default.php");
	}
						// Method to select the Task type and to search it in the Task table
	public void typeTask()
	{
		driver.findElement(By.xpath("(//option[@value='1'])[5]")).click();
		driver.findElement(By.xpath("//input[@name='DoSearch']")).click();
	}
	public void Screenshot() throws IOException
	{
						//To take screenshot 
		TakesScreenshot ts=((TakesScreenshot)driver);
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("src\\test\\resources\\Screenshot\\TaskScreenshot.jpg"));
	}
						// Method to check added task details is in the list or not
	public void Assert()
	{
		String d=driver.findElement(By.xpath("//a[text()='CTS']")).getText();
		Assert.assertEquals("CTS", d);
	}
}
