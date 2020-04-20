package twentyOneDaysPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//1) Go to https://www.makemytrip.com/
		driver.get("https://www.makemytrip.com");
		//2) Click Hotels
		WebElement hotels = driver.findElement(By.xpath("//a[@class='makeFlex hrtlCenter column']"));
		hotels.click();
		//3) Enter city as Goa, and choose Goa, India
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).click();
		Thread.sleep(5000);
		WebElement cityField = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		cityField.click();
		cityField.sendKeys("Goa");
		Thread.sleep(3000);
		WebElement listOpt = driver.findElement(By.xpath("//p[text()='Goa, India']"));
		listOpt.click();
		//4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5
		WebElement checkInField = driver.findElement(By.xpath("(//div[text()='15'])[2]"));
		checkInField.click();
		WebElement startDate = driver.findElement(By.xpath("//div[@aria-label='Fri May 15 2020']"));
		startDate.click();
		String sDate = startDate.getText();
		int startDateInt = Integer.parseInt(sDate);
		System.out.println(startDateInt);
		int eDate = startDateInt + 5;
		driver.findElement(By.xpath("//input[@id='checkout']")).click();
		WebElement endDate = driver.findElement(By.xpath("(//div[text()='"+eDate+"'])[2]"));
		String text = endDate.getText();
		int endDateInt = Integer.parseInt(text);
		System.out.println(endDateInt);
		endDate.click();
		//5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
		WebElement RandG = driver.findElement(By.xpath("//input[@id='guest']"));
		RandG.click();
		WebElement adult = driver.findElement(By.xpath("//li[@data-cy='adults-2']"));
		adult.click();
		WebElement child = driver.findElement(By.xpath("//li[@data-cy='children-1']"));
		child.click();
		driver.findElement(By.className("ageSelectBox")).click();
		driver.findElement(By.xpath("//option[text()='12']")).click();
		WebElement applyBtn = driver.findElement(By.xpath("//button[@class='primaryBtn btnApply']"));
		applyBtn.click();
		//driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		//6) Click Search button
		WebElement search = driver.findElement(By.xpath("//button[text()='Search']"));
		search.click();
		Thread.sleep(2000);
		WebElement mapView = driver.findElement(By.className("mapCont"));
		mapView.click();
		driver.findElement(By.className("mapClose")).click();    
		//7) Select locality as Baga
		WebElement locality = driver.findElement(By.xpath("//label[@for='mmLocality_checkbox_35']"));
		locality.click();
		//8) Select 5 start in Star Category under Select Filters
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollTo = driver.findElement(By.xpath("//label[@for='mmLocality_checkbox_35']"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		WebElement stars = driver.findElement(By.xpath("//label[text()='5 Star']"));
		stars.click();
		//9) Click on the first resulting hotel and go to the new window
		WebElement firstResult = driver.findElement(By.xpath("//div[@id='Listing_hotel_0']"));
		firstResult.click();
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));
		//10) Print the Hotel Name 
		WebElement hotel = driver.findElement(By.xpath("//h1[@id='detpg_hotel_name']"));
		String hotelName = hotel.getText();
		System.out.println("HOTEL NAME IS:" +hotelName);
		//11) Click MORE OPTIONS link and Select 3Months plan and close
		Thread.sleep(3000);
		WebElement mOption = driver.findElement(By.xpath("//span[text()='MORE OPTIONS']"));
		mOption.click();
		WebElement sixThree = driver.findElement(By.xpath("(//span[@class='latoBold font12 pointer makeFlex hrtlCenter right blueText'])[2]"));
		sixThree.click();
		driver.findElement(By.xpath("//span[@class='close']")).click();
		//12) Click on BOOK THIS NOW
		WebElement viewThisCombo = driver.findElement(By.xpath("//button[text()='VIEW THIS COMBO']"));
		viewThisCombo.click();
		Thread.sleep(3000);
		WebElement bookCombo = driver.findElement(By.xpath("//span[text()='Book this combo']"));
		bookCombo.click();
		//13) Print the Total Payable amount
		driver.findElement(By.xpath("//span[@class='close']")).click();
		WebElement totalPay = driver.findElement(By.xpath("//span[@id='revpg_total_payable_amt']"));
		String pay = totalPay.getText();
		int totalVal = Integer.parseInt(pay.replaceAll("\\D", ""));
		System.out.println("TOTAL PAYABLE VALUE IS:" +totalVal);
		
		//14) Close the browser 
		driver.quit();

	}

}
