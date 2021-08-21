package Week2.Day2;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Select the Language that you know
		String langKnown="VB";
		List<WebElement> checkBoxEle = driver.findElement(By.xpath("(//div[@class='example'])[1]")).findElements(By.tagName("div"));
		for (WebElement webElement : checkBoxEle) {
			if (webElement.getText().equals(langKnown)) {
				webElement.findElement(By.tagName("input")).click();
				System.out.println(" Selected Check Box Name : " +webElement.getText());
			}
			
		}
		
		// Confirm Selenium is checked
		System.out.println("Selenium Checkbox is selected : " +driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).isSelected());
		
		// Deselect only checked
		
		List<WebElement> checkBoxEle1 = driver.findElement(By.xpath("(//div[@class='example'])[3]")).findElements(By.tagName("div"));
		for (WebElement webElement : checkBoxEle1) {
				if ( webElement.findElement(By.tagName("input")).isSelected()==true) {
					webElement.findElement(By.tagName("input")).click();
					System.out.println("De Selected checkbox Name : " + webElement.getText());//webElement.findElement(By.tagName("input")).isSelected());
				}

		}
		
		// Select all the check box
		List<WebElement> checkBoxEle2 = driver.findElement(By.xpath("(//div[@class='example'])[4]")).findElements(By.tagName("div"));
		for (WebElement webElement : checkBoxEle2) {
			webElement.findElement(By.tagName("input")).click();
			System.out.println("Selected checkbox Name : " + webElement.getText());//webElement.findElement(By.tagName("input")).isSelected());
				

		}
		
		driver.close();
	}

}
