package twentyOneDaysPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day11SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		System.setProperty("webdriver.chrome.silentOutput", "false");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
	//1) Go to https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
	//2) Mouse over on Toys, Kids' Fashion & more and click on Toys
		//driver.findElement(By.xpath("//button[text()='NOT NOW']")).click();
		WebElement toyNav = driver.findElement(By.xpath("//span[contains(text(), 'Fashion & more')]"));
		wait.until(ExpectedConditions.elementToBeClickable(toyNav));
		Actions ac = new Actions(driver);
		ac.moveToElement(toyNav).build().perform();
		WebElement toyHeaderMenu = driver.findElement(By.xpath("//span[text()='Toys']"));
		toyHeaderMenu.click();
		
	//3) Click Educational Toys in Toys & Games
		WebElement eduToys = driver.findElement(By.xpath("//div[text()='Educational Toys']"));
		wait.until(ExpectedConditions.elementToBeClickable(eduToys));
		eduToys.click();
		
	//4) Click the Customer Rating 4 star and Up 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollTo = driver.findElement(By.xpath("(//button[text()='View More '])[2]"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		WebElement starFour = driver.findElement(By.xpath("//label[@for='avgRating-4.0']"));
		wait.until(ExpectedConditions.elementToBeClickable(starFour));
		starFour.click();
		
	//5) Click the offer as 40-50
		WebElement scrollTo2 = driver.findElement(By.xpath("//div[@class='price-input']"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo2);
		WebElement offers = driver.findElement(By.xpath("//label[@for='discount-40%20-%2050']"));
		wait.until(ExpectedConditions.elementToBeClickable(offers));
		offers.click();
		
	//6) Check the availability for the pincode
		WebElement pincode = driver.findElement(By.xpath("//div[@class='pincode-enter js-pincode-enter']/input"));
		pincode.clear();
		pincode.sendKeys("600036");
		WebElement checkBtn = driver.findElement(By.xpath("//div[@class='pincode-enter js-pincode-enter']/button"));
		checkBtn.click();
		
	//7) Click the Quick View of the first product 
		Thread.sleep(5000);
		WebElement scroll3 = driver.findElement(By.xpath("//h1[@class='category-name']"));
		wait.until(ExpectedConditions.elementToBeClickable(scroll3));
		js.executeScript("arguments[0].scrollIntoView();", scroll3);
		WebElement qukView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
		wait.until(ExpectedConditions.elementToBeClickable(qukView));
		qukView.click();
		
	//8) Click on View Details
		WebElement viewDetail = driver.findElement(By.xpath("//a[contains(text(),\"view details\")]"));
		viewDetail.click();
		
	//9) Capture the Price of the Product and Delivery Charge
		WebElement priceString = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String priceStr = priceString.getText();
		int priceVal = Integer.parseInt(priceStr);
		System.out.println("PRODUCT PRICE:  " +priceVal);
		WebElement delPrice = driver.findElement(By.xpath("(//span[@class='availCharges'])[2]"));
		String delPriceStr = delPrice.getText();
		int delPriceVal = Integer.parseInt(delPriceStr.replaceAll("\\D", ""));
		System.out.println("DELIVERY PRICE:  " +delPriceVal);
		int actualPrice = priceVal + delPriceVal;
		
		WebElement addCart = driver.findElement(By.xpath("//div[@id='add-cart-button-id']"));
		addCart.click();
		
		WebElement youPayString = driver.findElement(By.xpath("(//span[@class='price'])[2]"));
		String uPay = youPayString.getText();
		int youPayVal = Integer.parseInt(uPay.replaceAll("\\D", ""));
		System.out.println("YOR PAY AMOUNT: " +youPayVal);
		
	//10) Validate the You Pay amount matches the sum of (price+deliver charge)
		if(actualPrice == youPayVal) {
			System.out.println("AMOUNTS ARE MATCHED");
		}else {
			System.out.println("AMOUNT NOT MATCHED");
		}
		
	//11) Search for Sanitizer
		WebElement searchField = driver.findElement(By.xpath("//input[@name='keyword']"));
		searchField.clear();
		searchField.sendKeys("Sanitizer", Keys.ENTER);
		
	//12) Click on Product "BioAyurveda Neem Power Hand Sanitizer"
		WebElement saniProd = driver.findElement(By.xpath("//img[@class='product-image ']"));
		wait.until(ExpectedConditions.elementToBeClickable(saniProd));
		saniProd.click();
		
	//13) Capture the Price and Delivery Charge
		Set<String> windSet = driver.getWindowHandles();
		List<String> windList = new ArrayList<String>(windSet);
		driver.switchTo().window(windList.get(1));
		WebElement santPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		wait.until(ExpectedConditions.visibilityOf(santPrice));
		String santPricStr = santPrice.getText();
		int santPricVal = Integer.parseInt(santPricStr);
		System.out.println("SANITIZER PRICE: " +santPricVal);
		int totalSanProdVal = santPricVal + delPriceVal;
		System.out.println("TOTAL SANITIZER CHARGERS: " +totalSanProdVal);
				
	//14) Click on Add to Cart
		WebElement addCartSanit = driver.findElement(By.xpath("//div[@id='add-cart-button-id']"));
		wait.until(ExpectedConditions.elementToBeClickable(addCartSanit));
		addCartSanit.click();
		
	//15) Click on Cart 
		WebElement cartClk = driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-cart-icon-white-2']"));
		Thread.sleep(5000);
		cartClk.click();
		
	//16) Validate the Proceed to Pay matches the total amount of both the products
		WebElement proceedtoPayBtn = driver.findElement(By.xpath("//input[@class='btn btn-xl rippleWhite cart-button']"));
		String btnText = proceedtoPayBtn.getAttribute("value");
		int proceedPayVal = Integer.parseInt(btnText.replaceAll("[^0-9]", ""));
		System.out.println("AMOUNT OF PROCEED TO PAY:  " +proceedPayVal);
		int sumOfProd = youPayVal + totalSanProdVal;
		if (proceedPayVal == sumOfProd) {
			System.out.println("PROCEED TO PAY MATCH WITH PRODUCT TOTALS");
		} else {
			System.out.println("AMOUNT NOT MATCHED");
		}
	//17) Close all the windows
		driver.quit();
			

	}

}
