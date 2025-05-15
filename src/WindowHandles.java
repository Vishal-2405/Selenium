import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".blinkingText")));	
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String>window=driver.getWindowHandles();
		Iterator<String> it= window.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow); 
		String ActualEmail=driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentwindow);
		driver.findElement(By.cssSelector("input[class=form-control]")).sendKeys(ActualEmail);
		
		
		
	}

}
