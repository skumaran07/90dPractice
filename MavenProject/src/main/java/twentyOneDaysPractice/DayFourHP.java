package twentyOneDaysPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class DayFourHP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--diable-notifications");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		ChromeDriver driver = new ChromeDriver(options);
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
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollTo = driver.findElement(By.xpath("(//span[text()='Processor'])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		WebElement hardWare = driver.findElement(By.xpath("//span[text()='More than 1 TB']"));
		hardWare.click();
		
		//5) Select Sort By: Price: Low to High
		Thread.sleep(5000);
		WebElement sortBy = driver.findElement(By.id("sorter"));
		Select sl = new Select(sortBy);
		sl.selectByVisibleText("Price : Low to High");
		
		//6) Print the third resulting Product Name and Price     // Add cart button not available for first result product
		WebElement firstProd = driver.findElement(By.xpath("//a[@class='product-item-link']"));
		System.out.println("FIRST PRODUCTS NAME:  "+firstProd.getText());
		WebElement prodPrice = driver.findElement(By.xpath("//span[@id='product-price-8728']"));
		String priceString = prodPrice.getText();
		int priceVal = Integer.parseUnsignedInt(priceString.replaceAll("\\D", ""));
		System.out.println("PRODUCT PRICE VALUE:  " +priceVal);
		
		//7) Click on Add to Cart
		Thread.sleep(5000);
		WebElement scrollIcon = driver.findElement(By.xpath("//span[@title='In stock']"));
		js.executeScript("arguments[0].scrollIntoView();", scrollIcon);
		WebElement addCartBtn = driver.findElement(By.xpath("//button[@title='Add To Cart']"));
		addCartBtn.click();
		
		//8) Click on Shopping Cart icon --> Click on View and Edit Cart
		Thread.sleep(5000);
		WebElement shopIcon = driver.findElement(By.xpath("//a[@class='action showcart']"));
		shopIcon.click();
		WebElement viewCart = driver.findElement(By.xpath("//span[text()='View and edit cart']"));
		viewCart.click();
		
		//9) Check the Shipping Option --> Check availability at Pincode
		Thread.sleep(5000);
		WebElement pinAvail = driver.findElement(By.name("pincode"));
		pinAvail.sendKeys("600028");
		WebElement checkBtn = driver.findElement(By.xpath("//button[text()='check']"));
		checkBtn.click();
		Thread.sleep(5000);
		
		//10) Verify the order Total against the product price
		//11) Proceed to Checkout if Order Total and Product Price matches
		//12) Click on Place Order
		//13) Capture the Error message and Print
		//14) Close Browser
		
		System.out.println("EXECUTION DONE");
		

	}

}
