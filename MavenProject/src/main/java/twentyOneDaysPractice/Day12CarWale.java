package twentyOneDaysPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day12CarWale {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
//1) Go to https://www.carwale.com/
		driver.get("https://www.carwale.com/");
//2) Click on Used
		WebElement usedOption = driver.findElement(By.xpath("//li[@data-tabs='usedCars']"));
		usedOption.click();
		
//3) Select the City as Chennai
		WebElement enterCity = driver.findElement(By.id("usedCarsList"));
		//enterCity.clear();
		enterCity.sendKeys("chennai");
		Thread.sleep(3000);
		//enterCity.sendKeys("chennai", Keys.RETURN);
		enterCity.sendKeys(Keys.TAB);
		
//4) Select budget min (8L) and max(12L) and Click Search
		//WebElement selectBudget = driver.findElement(By.id("budgetBtn"));
		//wait.until(ExpectedConditions.elementToBeClickable(selectBudget));
		//selectBudget.click();
		//WebElement minField = driver.findElement(By.id("minInput"));
		//Thread.sleep(5000);
		int min = 8;
		WebElement minVal = driver.findElement(By.xpath("//li[@data-min-price='"+min+"']"));
		minVal.click();
		int max = 12;
		WebElement maxVal = driver.findElement(By.xpath("//li[@data-max-price='"+max+"']"));
		maxVal.click();
		WebElement searchBtn = driver.findElement(By.xpath("//button[@id='btnFindCar']"));
		searchBtn.click();
		
//5) Select Cars with Photos under Only Show Cars With
		Thread.sleep(3000);
		//WebElement closeBtn = driver.findElement(By.id("closeLocIcon"));
		//WebElement location = driver.findElement(By.id("placesQuery"));
		//wait.until(ExpectedConditions.elementToBeClickable(location));
	//	location.sendKeys("chennai", Keys.DOWN, Keys.ENTER);
		Thread.sleep(3000);
		
		//closeBtn.click();
		WebElement clickCarWithPh = driver.findElement(By.name("CarsWithPhotos"));
		wait.until(ExpectedConditions.elementToBeClickable(clickCarWithPh));
		clickCarWithPh.click();
		
//6) Select Manufacturer as "Hyundai" --> Creta
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollTo = driver.findElement(By.xpath("//input[@name='search']"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		WebElement selectHyundai = driver.findElement(By.xpath("//li[@data-manufacture-en='Hyundai']"));
		wait.until(ExpectedConditions.elementToBeClickable(selectHyundai));
		js.executeScript("arguments[0].click()", selectHyundai);
		//selectHyundai.click();
		WebElement creta = driver.findElement(By.xpath("//span[text()='Creta']"));
		wait.until(ExpectedConditions.elementToBeClickable(creta));
		//creta.click();
		js.executeScript("arguments[0].click()", creta);

	}

}
