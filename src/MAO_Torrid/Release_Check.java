package MAO_Torrid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.Map;

public class Release_Check {
	@Test
	public void release_check() throws InterruptedException {
		// TODO Auto-generated method stub
		String Username = "Tmodi";
		String Password = "Password123@";
		String OrderId= "DT1000559179";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://trrds-auth.omni.manh.com/org_login#/order");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
		driver.findElement(By.id("login-username")).sendKeys(Username);
		driver.findElement(By.id("login-password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='login-submit']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[value='Home']"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-icon[@aria-label='menu']"))).click();
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Orders']"))).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		Thread.sleep(9000);
		driver.findElement(By.cssSelector("input[data-component-id='orderId']")).sendKeys(OrderId);
		driver.findElement(By.cssSelector(".material-icons.form-control.remove-filter-field")).click();
		driver.findElement(By.id("btnApply")).click();
		Thread.sleep(9000);
		driver.findElement(By.cssSelector("div[class='datatable-body-cell-label'] input[type='checkbox']")).click();
		System.out.println("Order status is "+ driver.findElement(By.xpath("//span[@title='Released']")).getText());
		driver.findElement(By.cssSelector("a[data-component-id='ViewDetails']")).click();
		Thread.sleep(9000);
		WebElement staticDropdown=driver.findElement(By.xpath("//select[@name='select-details']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Release Details");
			
		
	}

}
