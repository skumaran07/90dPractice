package twentyOneDaysPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DaySevenHonda {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
	//1) Go to https://www.honda2wheelersindia.com/
		driver.get("https://www.honda2wheelersindia.com/");
		driver.findElement(By.xpath("//button[@class='close']")).click();
		
	//2) Click on scooters and click dio
		//Thread.sleep(5000);
		WebElement scooter = driver.findElement(By.xpath("//a[@id='link_Scooter']"));
		wait.until(ExpectedConditions.elementToBeClickable(scooter));
		scooter.click();
		//Thread.sleep(200);
		WebElement dio = driver.findElement(By.xpath("//img[@src='/assets/images/thumb/dioBS6-icon.png']"));
		wait.until(ExpectedConditions.elementToBeClickable(dio));
		dio.click();
		
	//3) Click on Specifications and mouseover on ENGINE
		WebElement spec = driver.findElement(By.xpath("//a[text()='Specifications']"));
		spec.click();
		Actions ac = new Actions(driver);
		WebElement engin = driver.findElement(By.xpath("//a[text()='ENGINE']"));
		wait.until(ExpectedConditions.elementToBeClickable(engin));
		ac.moveToElement(engin).build().perform();
		
	//4) Get Displacement value
		WebElement disp = driver.findElement(By.xpath("//span[text()='Displacement']/following-sibling::span"));
		System.out.println("DISPLACEMENT:  "+disp.getText());
		
	//5) Go to Scooters and click Activa 125
		//Thread.sleep(5000);
		//ac.moveToElement(scooter).build().perform();
		//ac.click();
		driver.navigate().refresh();
		WebElement scooter1 = driver.findElement(By.xpath("//a[@id='link_Scooter']"));
		scooter1.click();
		WebElement activa125 = driver.findElement(By.xpath("//img[@src='/assets/images/thumb/activa-125new-icon.png']"));
		//wait.until(ExpectedConditions.elementToBeClickable(activa125));
		activa125.click();
		
	//6) Click on Specifications and mouseover on ENGINE
		//driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement spec1 = driver.findElement(By.xpath("//a[text()='Specifications']"));
		wait.until(ExpectedConditions.elementToBeClickable(spec));
		spec1.click();
		wait.until(ExpectedConditions.elementToBeClickable(engin));
		ac.moveToElement(engin).build().perform();
		
	//7) Get Displacement value
		//WebElement disp = driver.findElement(By.xpath("//span[text()='Displacement']/following-sibling::span"));
		System.out.println("DISPLACEMENT:  "+disp.getText());
		
		System.out.println("Executed Done");

	}

}
