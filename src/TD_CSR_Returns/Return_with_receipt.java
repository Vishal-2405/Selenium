package TD_CSR_Returns;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Return_with_receipt {
	
	@Test
	public void return_with_receipt() throws InterruptedException {
		// TODO Auto-generated method stub
		String Username = "Tmodi";
		String Password = "Password123@";
		String OrderId= "DT1000380288";
		
		ChromeOptions options = new ChromeOptions();
//		options.setAcceptInsecureCerts(true);
		options.addArguments("force-device-scale-factor=0.8");
		options.addArguments("high-dpi-support=0.8");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		System.out.println("Order status in MAO is "+ driver.findElement(By.xpath("//span[@title='Fulfilled']")).getText());
		String Order_Status = driver.findElement(By.xpath("//span[@title='Fulfilled']")).getText();
		if (Order_Status.equals("Fulfilled"))
		{
			driver.findElement(By.cssSelector("div[class='button-bar'] a[data-component-id='ViewOrderStatusNextGen']")).click();
			Set<String>window=driver.getWindowHandles();
			Iterator<String> it= window.iterator();
			String parentwindow = it.next();
			String childwindow = it.next();
			driver.switchTo().window(childwindow);
			String Payment_status=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@id='co-order-status-header-payment-status-label']"))).getText();
			System.out.println("Payment_Status in CSR is "+Payment_status);
			Thread.sleep(9000);
			driver.findElement(By.xpath("//manh-icon[@class='manh-icon-sm manh-icon manh-icon-menu']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-focus-indicator.mat-tooltip-trigger.mat-menu-item"))).click();
			Thread.sleep(9000);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-focus-indicator.manh-button-secondary.mr-2.mat-button.mat-button-base"))).click();
//			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-select-arrow-wrapper.ng-tns-c107-25"))).click();
			Thread.sleep(9000);
//			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@data-component-id='data-component-id']"))).click();
			
			driver.findElement(By.id("mat-select-value-7")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-option-32"))).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-select-value-9"))).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-option-56"))).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'PROCEED TO REVIEW')]"))).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".olm-main-text-bold.center-align"))).getText();
			System.out.println("Return Credit = "+driver.findElement(By.cssSelector(".olm-main-text-bold.center-align")).getText());
			System.out.println("Refund Total = "+driver.findElement(By.xpath("//body/root[1]/my-app[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/div[1]/manh-app[2]/create-return-main[1]/div[1]/div[2]/div[1]/create-return-items[1]/div[1]/div[1]/return-line-details[1]/manh-panel[1]/return-order-summary[1]/div[1]/div[2]/div[1]/div[4]/h5[3]")).getText());
			driver.findElement(By.xpath("//span[contains(text(),'CONFIRM RETURN')]")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".manh-wrap-2lines.manh-wrap-word.ng-star-inserted"))).click();
			String RO_Creation = driver.findElement(By.cssSelector(".manh-wrap-2lines.manh-wrap-word.ng-star-inserted")).getText();
			String Return_OrderID=RO_Creation.substring(7, 14);
			
			System.out.println("Return Order ID = "+Return_OrderID);
			driver.findElement(By.xpath("//span[contains(text(),'CLOSE')]")).click();	
		}else
		{
			System.out.println("Order is not fulfilled & is not eligible for return");
			
		}
		driver.switchTo().defaultContent();
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-component-id='orderId']")));
		
		
	}

}
