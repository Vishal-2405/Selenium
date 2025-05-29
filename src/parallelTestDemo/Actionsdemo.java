package parallelTestDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actionsdemo {
	
	@Test
	public static void action() {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		//Moves cursor to a specific element & click & type 
//		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Iphone").build().perform();
		//Moves cursor to a specific element	
		a.moveToElement(move).build().perform();
		//driver.close();

	}

}
