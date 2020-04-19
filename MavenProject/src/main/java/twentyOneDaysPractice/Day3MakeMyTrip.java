package twentyOneDaysPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		
		driver.findElement(By.xpath("//label[@for='city']")).click();
		Thread.sleep(3000);
		WebElement cityField = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		
		cityField.sendKeys("Goa");
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
		

	}

}
