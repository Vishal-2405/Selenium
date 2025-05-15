import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Web_table_sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		options.addArguments("force-device-scale-factor=0.8");
		options.addArguments("high-dpi-support=0.8");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sort']")));
		
		List<WebElement>elementsList=driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String>OriginalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("OriginalList="+OriginalList);
//		=OriginalList.stream().sorted().map(l->l.getText()).collect(Collectors.toList());
		driver.findElement(By.xpath("//button[text()='Sort']")).click();
		List<WebElement>sortedelementsList=driver.findElements(By.xpath("//tr/td[1]"));
		List<String>SortedList=sortedelementsList.stream().map(p->p.getText()).collect(Collectors.toList());
		System.out.println("SortedList="+SortedList);
		List<String>Original_Sorted_List=OriginalList.stream().sorted().collect(Collectors.toList());
		System.out.println("Original_Sorted_List="+SortedList);
//		List<String>SortedList=OriginalList.stream().sorted().collect(Collectors.toList());
//		System.out.println(elementsList);
//		System.out.println(SortedList);
//		Assert.assertTrue(elementsList.equals(SortedList));
		
		
		
			
//		
		
	}

}
