package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public void webElementEdit(ChromeDriver fDriverObj, String fLocators,String fLocatorValue,String fValue) {
		
		switch(fLocators) {
		case "ID": 
			fDriverObj.findElement(By.id(fLocatorValue)).sendKeys(fValue);
			break;
		case "CLASS": 
			fDriverObj.findElement(By.className(fLocatorValue)).sendKeys(fValue);
			break;
		case "LINKTEXT":
			fDriverObj.findElement(By.linkText(fLocatorValue)).sendKeys(fValue);
			break;

		default: 
		}
		
	}
	
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
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pWd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		String titleName="My Home | opentaps CRM";
		
		if (titleName.equals(driver.getTitle())) {
			 System.out.println("Home page reached");			
		} else {
			System.out.println("Home page not reached");
		}
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		Thread.sleep(1000);
		
		CreateContact contactObj=new CreateContact();
		contactObj.webElementEdit(driver, "ID", "firstNameField", "Vijay");
		contactObj.webElementEdit(driver, "ID", "lastNameField", "Pandi");
		contactObj.webElementEdit(driver, "ID", "createContactForm_firstNameLocal", "Vijayakumar");
		contactObj.webElementEdit(driver, "ID", "createContactForm_lastNameLocal", "Manju");
		contactObj.webElementEdit(driver, "ID", "createContactForm_departmentName", "IT");
		contactObj.webElementEdit(driver, "ID", "createContactForm_description", "Nothing");
		contactObj.webElementEdit(driver, "ID", "createContactForm_primaryEmail", "Vijay@vmail.com");
		
		WebElement dropDwn = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropDwnEle=new Select(dropDwn);
		dropDwnEle.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		contactObj.webElementEdit(driver, "ID", "updateContactForm_importantNote", "Important Notes");
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		Thread.sleep(1000);
		
		System.out.println(" Result Page Title is : '" +driver.getTitle() +"'");
		
	}

}
