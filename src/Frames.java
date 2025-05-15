import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
//		Switch to frame by web element method
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class=demo-frame]")));
		
//		Switch to frame by ID
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		
		
		
		driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(Source, Target).build().perform();
		driver.switchTo().defaultContent();
		
	}

}
