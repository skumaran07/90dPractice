package twentyOneDaysPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DayTwoNykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		Thread.sleep(2000);
		//2) Mouseover on Brands and Mouseover on Popular
		Actions ac = new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("(//a[@href='#'])[2]"));
		ac.moveToElement(brand).build().perform();
		WebElement popularBtn = driver.findElement(By.xpath("//a[text()='Popular']"));
		ac.moveToElement(popularBtn).build().perform();
		//3) Click L'Oreal Paris
		WebElement loralImg = driver.findElement(By.xpath("//img[@src = \"https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png\"]"));
		loralImg.click();
		//4) Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> newWinSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(newWinSet);
		driver.switchTo().window(winList.get(1));
		String pageTitle = driver.getTitle();
		if(pageTitle.contains("L'Oreal Paris")){
			System.out.println("Title is containing L'Oreal Paris");
		}else {
			System.out.println("Title doesnt contain expected title");
		}
		//5) Click sort By and select customer top rated
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollTo = driver.findElement(By.xpath("//a[@href=\"https://www.nykaa.com/beauty-blog/this-just-in-the-loreal-paris-revitalift-crystal-micro-essence?intcmp=brand-loreal_paris,content-banner,1,this-just-in-the-loreal-paris-revitalift-crystal-micro-essence\"]"));
		js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		Thread.sleep(2000);
		WebElement sortBy = driver.findElement(By.xpath("//span[@class=\"pull-right\"]"));
		sortBy.click();
		driver.findElement(By.xpath("(//div[@class=\"control__indicator radio\"])[4]")).click();
		//6) Click Category and click Shampoo
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", scrollTo);
		driver.findElement(By.xpath(" //div[@class=\"pull-right filter-options-toggle\"]")).click();
		WebElement shampoo = driver.findElement(By.xpath("//span[contains(text(), 'Shampoo')]"));
		shampoo.click();
		Thread.sleep(2000);
		//7) check whether the Filter is applied with Shampoo
		WebElement filterText = driver.findElement(By.xpath("//ul[@class=\"pull-left applied-filter-lists\"]"));
		String textFilter = filterText.getText();
		if(textFilter.contains("Shampoo")) {
			System.out.println("Shampoo is available on filter");
		}else {
			System.out.println("Shampoo not available on filter");
		}
		//8) Click on L'Oreal Paris Colour Protect Shampoo
		WebElement clickShampooImage = driver.findElement(By.xpath("(//img[@class=\"listing-img\"])[2]"));
		clickShampooImage.click();
		Set<String> nxtWindow = driver.getWindowHandles();
		List<String> winList1 = new ArrayList<String>(nxtWindow);
		driver.switchTo().window(winList1.get(2));
		//9) Go to the new window and select size as 175ml
		Thread.sleep(3000);
		WebElement size = driver.findElement(By.xpath("(//span[@class='size-pallets'])[2]"));
		size.click();
		//10) Print the MRP of the product
		WebElement mrp = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']"));
		String mrpVal = mrp.getText();
		int totalMRP = Integer.parseInt(mrpVal.replaceAll("\\D", ""));
		System.out.println("MRP:" +totalMRP);
		//11) Click on ADD to BAG
		WebElement addBagBtn = driver.findElement(By.xpath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']"));
		addBagBtn.click();
		//12) Go to Shopping Bag 
		WebElement shpBag = driver.findElement(By.className("AddBagIcon"));
		shpBag.click();
		Thread.sleep(3000);
		//13) Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("(//div[@class=\"first-col\"])/div")).getText();
		int getGrandTotal = Integer.parseInt(grandTotal.replaceAll("\\D", ""));
		System.out.println("GRAND TOTAL:" +getGrandTotal);
		Thread.sleep(3000);
		//14) Click Proceed
		WebElement clickProceed = driver.findElement(By.xpath("//div[@class='second-col']/button"));
		clickProceed.click();
		Thread.sleep(3000);
		//15) Click on Continue as Guest
		WebElement clickGuess = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		clickGuess.click();
		//16) Print the warning message (delay in shipment)
		WebElement wrnMsg = driver.findElement(By.className("message"));
		String WrnText = wrnMsg.getText();
		System.out.println("Warning Messages:" +WrnText);
		//17) Close all windows
		driver.quit();

	}

}
