import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Manja {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	 
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		
		 String pswd=getData(driver);
		 
		
		String uname="Rahukl";
		String psw=pswd;
		driver.findElement(By.id("inputUsername")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(psw);
		driver.findElement(By.cssSelector(".submit.signInBtn")).click();
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='login-container'] h2")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello Rahukl,");
		
		
		
		
		
		
	}
	public static String getData(WebDriver driver) throws InterruptedException
	{
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		driver.findElement(By.cssSelector(".forgot-pwd-container")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("random");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("random");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("random");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String infomsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".infoMsg"))).getText();
		String tempPWD=infomsg.substring(31, 49);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(5000);
		return tempPWD;
	}

}
