import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender_handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "24";
		String month = "11";
		String year = "2027";
		String[] expectedlist= {month,date,year};
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button__icon")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElement(By.xpath("//abbr[text()='November']")).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		

		List<WebElement> ActualList= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<ActualList.size();i++)
		{
			ActualList.get(i).getAttribute("value");
			Assert.assertEquals(ActualList.get(i).getAttribute("value"), expectedlist[i]);
		}
		
	}

}
