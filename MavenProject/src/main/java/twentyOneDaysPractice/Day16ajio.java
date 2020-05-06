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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day16ajio {

	public static void main(String[] args) throws InterruptedException {
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
		
		//1) Go to https://www.ajio.com/  
		driver.get("https://www.ajio.com/shop/women");
		
		//2) Enter Bags in the Search field and Select Bags in Women Handbags  
		WebElement serachField = driver.findElement(By.name("searchVal"));
		wait.until(ExpectedConditions.visibilityOf(serachField));
		//serachField.clear();
		//serachField.click();
		serachField.sendKeys("Bags");
		Thread.sleep(5000);
		WebElement handsBag = driver.findElement(By.xpath("(//a[@class='search-suggestionList  '])[2]"));
		handsBag.click();
		
		//3) Click on five grid and Select SORT BY as "What's New"  
		WebElement fiveGrid = driver.findElement(By.xpath("//div[@class='five-grid']"));
		wait.until(ExpectedConditions.elementToBeClickable(fiveGrid));
		fiveGrid.click();
		WebElement sortBy = driver.findElement(By.xpath("//div[@class='filter-dropdown']//select[1]"));
		Select s = new Select(sortBy);
		s.selectByValue("newn");
		
		//4) Enter Price Range Min as 2000 and Max as 5000  
		WebElement priceMenu = driver.findElement(By.xpath("(//div[@class='facet-head '])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(priceMenu));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", priceMenu);
		//priceMenu.click();
		WebElement minPrice = driver.findElement(By.name("minPrice"));
		minPrice.sendKeys("2000", Keys.TAB);
		WebElement maxPrice = driver.findElement(By.name("maxPrice"));
		maxPrice.sendKeys("5000");
		WebElement goBtn = driver.findElement(By.xpath("//button[@class='rilrtl-button ic-toparw']"));
		goBtn.click();
		
		//5) Click on the product "Puma Ferrari LS Shoulder Bag"  
		WebElement brandsMenu = driver.findElement(By.xpath("//span[text()='brands']"));
		executor.executeScript("arguments[0].click();", brandsMenu);
		WebElement more = driver.findElement(By.id("verticalsizegroupformat"));
		wait.until(ExpectedConditions.elementToBeClickable(more));
		executor.executeScript("arguments[0].click();", more);
		WebElement checkBoxOpt = driver.findElement(By.xpath("//label[@for='modal-Puma']"));
		executor.executeScript("arguments[0].click();", checkBoxOpt);
		WebElement apyBtn = driver.findElement(By.xpath("//button[contains(@class,'rilrtl-button apply-popup-button')]"));
		wait.until(ExpectedConditions.elementToBeClickable(apyBtn));
		apyBtn.click();
		WebElement pumaBag = driver.findElement(By.xpath("(//img[contains(@class,'rilrtl-lazy-img ')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(pumaBag));
		pumaBag.click();
		Set<String> windSet = driver.getWindowHandles();
		List<String> windList = new ArrayList<String>(windSet);
		driver.switchTo().window(windList.get(1));
		
		//6) Verify the Coupon code for the price above 2690 is applicable for your product, if applicable the get the Coupon Code and Calculate the discount price for the coupon 
		WebElement offerCondition = driver.findElement(By.xpath("//div[contains(text(),'2690 and Above')]"));
		String availText = offerCondition.getText();
		if(availText.contains("2690 and Above")) {
			WebElement couponCode = driver.findElement(By.xpath("//div[@class='promo-title']"));
			//WebElement couponCode = driver.findElement(By.xpath("//div[@class='promo-title-blck']//div[1]/br"));
			String coupenText = couponCode.getText();
			String[] code = coupenText.split("\\s");
			System.out.println("COUPON CODE IS: " +code[2]);
			
		}
		
		//7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available  
		WebElement pinCode = driver.findElement(By.xpath("//span[contains(@class,'edd-pincode-msg-details edd-pincode-msg-details-pointer')]"));
		pinCode.click();
		WebElement pinCode1 = driver.findElement(By.name("pincode"));
		pinCode1.sendKeys("682001");
		WebElement confirmBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
		confirmBtn.click();
		WebElement expDeliveryDate = driver.findElement(By.xpath("//span[@class='edd-message-success-details-highlighted']"));
		System.out.println("EXPECTED DELIVER DATE: " +expDeliveryDate.getText());
		
		//8) Click on Other Informations under Product Details and Print the Customer Care address, phone and email  
		WebElement otherInfo = driver.findElement(By.xpath("//div[text()='Other information']"));
		otherInfo.click();
		WebElement cCareAddress = driver.findElement(By.xpath("//span[contains(text(), 'Bangalore 560068')]"));
		String address = cCareAddress.getText();
		System.out.println("CUSTOMER CARE ADDRESS: " +address);
		
		//9) Click on ADD TO BAG and then GO TO BAG  
		WebElement addToBag = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		addToBag.click();
		Thread.sleep(5000);
		WebElement goToBag = driver.findElement(By.xpath("//span[text()='GO TO BAG']"));
		wait.until(ExpectedConditions.elementToBeClickable(goToBag));
		executor.executeScript("arguments[0].click();", goToBag);
		//goToBag.click();
		
		//10) Check the Order Total before apply coupon 
		WebElement total = driver.findElement(By.xpath("//span[@class='price-value bold-font']"));
		String TotalString = total.getText();
		String ss = TotalString.replaceAll("Rs.", "");
		String sss = ss.replaceAll(",", "");
		double ordetTotal = Double.parseDouble(sss);
		System.out.println("TOTAL ORDER BEFORE COUPON " +ordetTotal);
		
		//11) Enter Coupon Code and Click Apply  
		WebElement ApyCoupon = driver.findElement(By.id("couponCodeInput"));
		//String cCode = code[2];
		ApyCoupon.sendKeys("EPIC");
		WebElement applyBtn = driver.findElement(By.xpath("//button[text()='Apply']"));
		applyBtn.click();
		Thread.sleep(5000);
		
		//12) Verify the Coupon Savings amount(round off if it in decimal) under Order Summary and the matches the amount calculated in Product details
		WebElement aftOrderAmo = driver.findElement(By.xpath("//span[@class='price-value bold-font']"));
		String aftTotalString = aftOrderAmo.getText();
		String ss1 = aftTotalString.replaceAll("Rs.", "");
		String sss1 = ss1.replaceAll(",", "");
		double aftOrdetTotal = Double.parseDouble(sss1);
		System.out.println("TOTAL ORDER AFTER COUPON " +Math.round(aftOrdetTotal));
		
		//13) Click on Delete and Delete the item from Bag  
		WebElement deleteBtn = driver.findElement(By.xpath("//div[text()='Delete']"));
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		deleteBtn.click();
		WebElement deleteAll = driver.findElement(By.xpath("//div[text()='DELETE']"));
		wait.until(ExpectedConditions.elementToBeClickable(deleteAll));
		deleteAll.click();
		
		
		//14) Close all the browsers
		driver.quit();

	}

}
