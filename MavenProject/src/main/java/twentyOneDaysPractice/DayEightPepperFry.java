package twentyOneDaysPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DayEightPepperFry {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		System.setProperty("webdriver.chrome.silentOutput", "false");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
	//1) Go to https://www.pepperfry.com/
		driver.get("https://www.pepperfry.com/");
		
	//2) Mouseover on Furniture and click Office Chairs under Chairs
		Actions ac = new Actions(driver);
		WebElement furnish = driver.findElement(By.xpath("//a[text()='Furniture']"));
		wait.until(ExpectedConditions.elementToBeClickable(furnish));
		ac.moveToElement(furnish).build().perform();
		WebElement offChair = driver.findElement(By.xpath("//a[text()='Office Chairs']"));
		offChair.click();
		
	//3) click Executive Chairs
		WebElement exeChairs = driver.findElement(By.xpath("(//div[@class='cat-wrap-img'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(exeChairs));
		exeChairs.click();
		
	//4) Change the minimum Height as 50 in under Dimensions
		//WebElement closeAdd = driver.findElement(By.xpath("//span[@class='wewidgeticon we_close icon-large']"));
		//closeAdd.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollTo = driver.findElement(By.xpath("(//div[@class='clip__filter-title'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		WebElement minHeight = driver.findElement(By.className("clipFilterDimensionHeightValue"));
		minHeight.clear();
		minHeight.sendKeys("50", Keys.ENTER);
		
	//5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
		//WebElement blackChair = driver.findElement(By.xpath("(//div[@class='card-img-wrp center-xs'])[2]/a"));
		//wait.until(ExpectedConditions.elementToBeClickable(blackChair));
		//ac.moveToElement(blackChair).build().perform();
		Thread.sleep(3000);
		WebElement wishList = driver.findElement(By.xpath("(//a[@class='clip-heart-icn pf-right'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(wishList));
		//Thread.sleep(5000);
		wishList.click();
		
	//6) Mouseover on Homeware and Click Pressure Cookers under Cookware
		WebElement homeWare = driver.findElement(By.xpath("//a[text()='Homeware']"));
		ac.moveToElement(homeWare).build().perform();
		WebElement prCooker = driver.findElement(By.xpath("//a[text()='Pressure Cookers']"));
		prCooker.click();
		
	//7) Select Prestige as Brand
		WebElement prestige = driver.findElement(By.xpath("//label[@for='brandsnamePrestige']"));
		wait.until(ExpectedConditions.elementToBeClickable(prestige));
		prestige.click();
		
	//8) Select Capacity as 1-3 Ltr
		Thread.sleep(2000);
		WebElement liter = driver.findElement(By.xpath("//label[@for='capacity_db1_Ltr_-_3_Ltr']"));
		wait.until(ExpectedConditions.elementToBeClickable(liter));
		liter.click();
		
	//9) Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
		//Thread.sleep(2000);
		WebElement scrollTo2 = driver.findElement(By.xpath("//a[text()='Duo Hard Anodised Clip-On Aluminium Cooker 3 Ltr']"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo2);
		WebElement nakshCooker = driver.findElement(By.xpath("//a[@data-productname='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']"));
		nakshCooker.click();
	//10) Verify the number of items in Wishlist
		WebElement wishIcon = driver.findElement(By.xpath("pf-icon pf-icon-heart header_tab wistlist_img pending_alert active"));
		wishIcon.click();
		WebElement itmWishLit = driver.findElement(By.xpath("//span[@id='wishlist_mini_cart']"));
		wait.until(ExpectedConditions.elementToBeClickable(itmWishLit));
		System.out.println("TOTAL ITEM NUMBER IS: " +itmWishLit.getText());
		
	//11) Navigate to Wishlist
	//12) Move Pressure Cooker only to Cart from Wishlist
	//13) Check for the availability for Pincode 600128

	}

}
