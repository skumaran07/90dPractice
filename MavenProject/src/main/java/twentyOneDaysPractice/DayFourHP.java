package twentyOneDaysPractice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DayFourHP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//1) Go to https://store.hp.com/in-en/
		driver.get("https://store.hp.com/in-en/");
		//2) Mouse over on Laptops menu and click on Pavilion
		WebElement laptop = driver.findElement(By.xpath("//li[@class='level0 nav-2 level-top ui-menu-item laptops-tablets-li']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(laptop).click().build().perform();
		Thread.sleep(3000);
		WebElement pavilion = driver.findElement(By.xpath("//span[text()='Pavilion Gaming']"));
		pavilion.click();
		//3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
		Thread.sleep(3000);
		WebElement processor = driver.findElement(By.xpath("(//span[text()='Processor'])[2]"));
		processor.click();
		WebElement intCore7 = driver.findElement(By.xpath("(//input[@class='product-filter-checkbox'])[2]"));
		intCore7.click();
		//4) Hard Drive Capacity -->More than 1TB
		//5) Select Sort By: Price: Low to High
		//6) Print the First resulting Product Name and Price

	}

}
