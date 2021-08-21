package Week2.Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithRadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// first Radio button		
		driver.findElement(By.id("yes")).click();
// Second Radio button		
		List<WebElement> objElements = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]")).findElements(By.tagName("label"));
		for (WebElement webElement : objElements) {
			String attributeVal = webElement.getAttribute("for");
			
			if (attributeVal.equals("java")) {
				continue;
			}
			String attrValue = webElement.findElement(By.tagName("input")).getAttribute("value");
			if (Integer.parseInt(attrValue)==1) {
				System.out.println("Selected Radio button name is : '"+ webElement.getAttribute("for") +"'");
				
			}
			
	//		System.out.println(webElement.getAttribute("for"));
		//	webElement.findElement(By.tagName("input")).click();
		 }

// Third Radio button
		int age=1;
		int bAge = 0;
		List<WebElement> radioButtonList = driver.findElements(By.name("age"));
		if (age<=20) {
			bAge=0;
		} else if(age >= 21 && age <=40 ) {
			bAge=1;
		}
		else if(age > 40 ) {
			bAge=2;
		}
		switch (bAge) {
		case 0:
			radioButtonList.get(bAge).click();
			System.out.println("Age between 1 to 20 is selected");
			break;
		case 1:
			radioButtonList.get(bAge).click();
			System.out.println("Age between 21 to 40 is selected");
			break;
		case 2:
			radioButtonList.get(bAge).click();
			System.out.println("Age above 40 is selected");
			break;
		default:
			break;
		}
		
		/*
		for (WebElement radioButton : radioButtonList) {
			System.out.println(radioButton.getAttribute("value") + "  -  " + (radioButton.getAttribute("class")));
			System.out.println("Text Value : " + radioButton.getText());

		}
		*/
		//driver.close();
		
	}

}
