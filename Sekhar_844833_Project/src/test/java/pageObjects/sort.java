package pageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sort {
	WebDriver driver;
	public void open()
	{
						// To launch chrome Browser
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://examples.codecharge.com/TaskManager/Default.php");
	}
						// Method to sort the task list according to Finish Date
	public void clickfinishDate() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td/table[2]/tbody/tr[1]/td[8]/a")).click();
	}
						// Method to check added task details is in the list or not
	public void Assert()
	{
		String e=driver.findElement(By.xpath("//a[text()='CTS']")).getText();
		Assert.assertEquals("CTS", e);
	}
}
