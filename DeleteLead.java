package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		String userName="demosalesmanager";
		String pWd="crmsfa";
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(pWd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		String titleName="My Home | opentaps CRM";
		if (titleName.equals(driver.getTitle())) {
			 System.out.println("Home page reached");			
		} else {
			System.out.println("Home page not reached");
		}
		 
		 driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.linkText("Find Leads")).click();
		 
		 driver.findElement(By.xpath("(//a[@class='x-tab-right'])[2]")).click();
		 
		 driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9080669208");
		 
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 
		 Thread.sleep(1000);
		 String leadID = driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		 System.out.println(" Lead No : " +leadID);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		 
		 driver.findElement(By.xpath("//a[text()='Delete']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		 driver.findElement(By.xpath("(//div[@class='x-form-item x-tab-item'])[1]//input")).sendKeys(leadID);
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 
		 Thread.sleep(2000);
		 String recordInfo = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		 if (recordInfo.equals("No records to display")) {
			System.out.println("Lead Deleted successfully");
		}
	}

}
