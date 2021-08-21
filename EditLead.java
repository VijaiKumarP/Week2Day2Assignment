package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Vijay");
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		 Thread.sleep(1000);
		 String leadID = driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		 System.out.println(" Lead No : " +leadID);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		 
		 driver.findElement(By.xpath("//a[text()='Edit']")).click();
		 Thread.sleep(3000);
		 String cmpnyOldValue = driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");
		 driver.findElement(By.id("updateLeadForm_companyName")).clear();
		 String CmpnyNwValue="CTS" + Math.random();
		 driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(CmpnyNwValue);
		 
		 driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		 
		 Thread.sleep(2000);
		 if (driver.findElement(By.id("viewLead_companyName_sp")).getText().contains(cmpnyOldValue)) {
			 System.out.println(" New Company Value Updated");
		 }else {
			 System.out.println("Company Value is not Updated");
		 }
		 
		 
	}

}
