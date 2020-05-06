package twentyOneDaysPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day14zalando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//1) Go to https://www.zalando.com/
		driver.get("https://www.zalando.com/");
		
		//2) Get the Alert text and print it
		Alert al = driver.switchTo().alert();
		System.out.println("ALERT POPUP TEXT: " +al.getText());
		
		//3) Close the Alert box and click on Zalando.uk
		al.accept();
		WebElement clkZalandoUK = driver.findElement(By.xpath("//a[@class='nav_link nav_link-gb']"));
		clkZalandoUK.click();
		
		//4) Click Women--> Clothing and click Coat 
		WebElement clkWomenBtn = driver.findElement(By.xpath("(//span[text()='Women'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(clkWomenBtn));
		clkWomenBtn.click();
		Actions ac = new Actions(driver);
		WebElement clothMenu = driver.findElement(By.xpath("//span[text()='Clothing']"));
		ac.moveToElement(clothMenu).build().perform();
		WebElement coatMenu = driver.findElement(By.xpath("//span[text()='Coats']"));
		coatMenu.click();
		
		//5) Choose Material as cotton (100%) and Length as thigh-length
		
				
		//6) Click on Q/S designed by MANTEL - Parka coat
		
		
		//7) Check the availability for Color as Olive and Size as 'M'
		
		
		//8) If the previous preference is not available, check  availability for Color Navy and Size 'M'
		
		

	}

}
