import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverscope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		total no of links in a web page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
//		total no of links in web page under a footer section
		WebElement footerdriver =driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
//		links in a particular column in a footer section.
		WebElement columndriver = footerdriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());

//		click on each link & open each link in new tab
		for (int i =1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String ClickonTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickonTab);
		}
		Set<String> WH=driver.getWindowHandles();
		Iterator<String>it=WH.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
