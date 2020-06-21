package flightfinder;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class flightFinderUcuzaBilet {

	@Test
	public void f() throws InterruptedException {

//	    Define Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		Maximize the window and open the link
		driver.manage().window().maximize();
		driver.get("https://www.ucuzabilet.com/");

//		Manage time outs
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

//		Select Round Trip radio button
		driver.findElement(By.xpath("//label[@for='rbRoundtrip']")).click();

//		Check direct flights only
		driver.findElement(By.xpath("//label[@for='directFlightsOnly']")).click();
		Thread.sleep(3000);

//		Write from which airport
		WebElement fromwhere = driver.findElement(By.id("from_text"));
		fromwhere.sendKeys("IST");
		Thread.sleep(3000);
		fromwhere.sendKeys(Keys.ARROW_DOWN);
		fromwhere.sendKeys(Keys.ENTER);

//		Write to which airport
		WebElement towhere = driver.findElement(By.id("to_text"));
		towhere.sendKeys("IZM");
		Thread.sleep(3000);
		towhere.sendKeys(Keys.ARROW_DOWN);
		towhere.sendKeys(Keys.ENTER);

//		Select to date of departure 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

//		Select to date of return
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//a[@class='ui-state-default'][contains(text(),'30')]")).click();		 
		
//		Select to number of travelers
		driver.findElement(By.cssSelector(".totalPassengerLabel")).click();
		Thread.sleep(3000);

		for (int i = 1; i < 3; i++) 
		{
		driver.findElement(By.xpath("//div[@id='traditionalSearch']/div/div/div/div[3]/div/div[3]/div/div/div/div/div/div/div[2]/span/i")).click();
		}

		driver.findElement(By.cssSelector(".btn.btn-primary.btn-close-mobile")).click();

//		Click search button
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".searchForm-btn-web")).click();

//		driver.quit();
	}
}
