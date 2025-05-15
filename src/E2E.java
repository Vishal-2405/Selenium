import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

//-----------------------> E2E <--------------------------

public class E2E {

public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

WebDriver driver = new ChromeDriver();

System.setProperty("webdriver.chrome.driver","C:/Users/HP/Documents/chromedriver.exe");

driver.manage().window().maximize();

driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

// Radio button

driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();

// Checkbox

driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_IndArm']")).click();

// Dynamic dropdown

//

driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();

driver.findElement(By.cssSelector("a[value='BLR']")).click();

Thread.sleep(2000);

driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();

driver.findElement(By.xpath("(//a[@value='IXJ'])[2]")).click();

// Calender--> if class with gaps is there we should put . in the gaps to turn it to CSS

driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

// Updated dropdown by looping

driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();

Thread.sleep(2000);

for(int i=0; i<4;i++)

{

driver.findElement(By.id("hrefIncAdt")).click();

}

driver.findElement(By.cssSelector("input[id='btnclosepaxoption']")).click();

// Static dropdown

WebElement Staticdropdown= driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));

Select dropdown= new Select(Staticdropdown);

dropdown.selectByIndex(2);

System.out.println(dropdown.getFirstSelectedOption().getText());

//

System.out.println("The checkbox count is " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());

driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

}

}
