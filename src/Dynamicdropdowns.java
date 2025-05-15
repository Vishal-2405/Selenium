import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;



public class Dynamicdropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
//		In the below line (//a[@value='VNS'])[2]") this xpath represents the index of 2 
//		because in the "from" city also varanasi is present so that will be considered as
//		a first element to encounter by the selenium bcoz SE will execute from Top left.
//		driver.findElement(By.xpath("(//a[@value='VNS'])[2]")).click();
//		Assert.assertEquals(driver.findElement(By.xpath("(//a[@value='VNS'])[2]")).getText(),"Varanasi (VNS)");
		driver.findElement(By.xpath("(//a[@value='VNS'])[2]")).click();
		

	}

}
