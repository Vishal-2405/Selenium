//Locators
//1.ID
//2.Xpath
//3.Css selector
//4.Name
//5.Class name
//6.Tag name
//7.Link text
//8.Partial link text



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		TO synchronize the time issue we implemented the above code, basically
//		it will wait for 2 seconds to capture * Incorrect user name or password
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("contact@rahulshettyacademy.com");
		driver.findElement(By.name("inputPassword")).sendKeys("Qwert123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
//		CSS syntaxes are 1- tagname.classname 2-tagname#id 3-tagname[attribute="value"]
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("johny");
		driver.findElement(By.xpath("//form/input[2]")).sendKeys("Asadf");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9110654756");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		driver.findElement(By.cssSelector("button[class='logout-btn']")).click();
		driver.close();
		
	}

}
