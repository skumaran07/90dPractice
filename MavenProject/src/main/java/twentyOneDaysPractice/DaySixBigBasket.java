package twentyOneDaysPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DaySixBigBasket {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
	//1) Go to https://www.bigbasket.com/
		driver.get("https://www.bigbasket.com/");
	//2) mouse over on  Shop by Category 
		Thread.sleep(5000);
		WebElement shopCate = driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(shopCate).build().perform();			
		
	//3)Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 
		Thread.sleep(5000);
		WebElement foodGrainMenu = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(foodGrainMenu));
		//WebElement riceSubMenu = driver.findElement(By.xpath("(//a[@class='ng-binding l2select'])[2]"));
		Actions ac2 = new Actions(driver);
		ac2.moveToElement(foodGrainMenu).build().perform();
		Thread.sleep(5000);
		
		WebElement riceSubMenu = driver.findElement(By.xpath("(//a[@class='ng-binding l2select'])[2]"));
		riceSubMenu.click();
		//Actions ac1 = new Actions(driver);
		//ac1.moveToElement(riceSubMenu).build().perform();
	//4) Click on Boiled & Steam Rice
		WebElement boiledRiceSubMenu = driver.findElement(By.xpath("(//a[@ng-href='/pc/foodgrains-oil-masala/rice-rice-products/boiled-steam-rice/?nc=nb'])[2]"));
		boiledRiceSubMenu.click();
		
	//5) Choose the Brand as bb Royal
		WebElement cate = driver.findElement(By.xpath("(//span[text()='Category'])"));
		wait.until(ExpectedConditions.visibilityOf(cate));
	//6) Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
	//7) print the price of Rice

	}

}
