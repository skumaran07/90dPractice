package twentyOneDaysPractice;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
		
//7) Select Fuel Type as Petrol
		WebElement fuelType = driver.findElement(By.xpath("//h3[contains(text(),'Fuel Type')]"));
		js.executeScript("arguments[0].scrollIntoView();", fuelType);
		wait.until(ExpectedConditions.elementToBeClickable(fuelType));
		//fuelType.click();
		js.executeScript("arguments[0].click()", fuelType);
		WebElement petrol = driver.findElement(By.xpath("//span[text()='Petrol']"));
		petrol.click();
		
//8) Select Best Match as "KM: Low to High"
		WebElement sort = driver.findElement(By.xpath("//select[@id='sort']"));
		wait.until(ExpectedConditions.elementToBeClickable(sort));
		Select sl = new Select(sort);
		sl.selectByValue("2");
		
//9) Validate the Cars are listed with KMs Low to High
		Thread.sleep(3000);
		List<WebElement> kmElem = driver.findElements(By.xpath("//table[@class='card-detail__vehicle-data']//td[1]//span"));
		List<String> strAllKmsList = new ArrayList<String>();
		List<Integer> intAllKmsList = new ArrayList<Integer>();
		for(WebElement kms : kmElem) {
			strAllKmsList.add(kms.getText());
			intAllKmsList.add(Integer.parseInt(kms.getText().replaceAll("\\D", "")));
		}
		boolean sort1 = false; 
		System.out.println(intAllKmsList);
//validate kms sorted or not
		for(int i=0; i<intAllKmsList.size()-1; i++) {
			if(intAllKmsList.get(i) < intAllKmsList.get(i+1)) {
				sort1 = true;
			}else {
				System.out.println("KMS Not Sorted");
			}
			
			
		}
	
//10) Add the least KM ran car to Wishlist
		Collections.sort(intAllKmsList);
		int minKM = intAllKmsList.get(0);
		String format = NumberFormat.getInstance(Locale.US).format(intAllKmsList.get(0))+" km";
		System.out.println(format);
		WebElement wishList = driver.findElement(By.xpath("//span[text()='"+format+"']/ancestor::div[@class='card-detail-block']/preceding-sibling::div//span[contains(@class,'shortlist-icon')]"));
		js.executeScript("arguments[0].click()", wishList);
	
//11) Go to Wishlist and Click on More Details
		Thread.sleep(5000);
		WebElement wishListwin = driver.findElement(By.xpath("//li[contains(text(),'Compare')]"));
		wishListwin.click();
		WebElement moreDetail = driver.findElement(By.xpath("//a[contains(text(),'More details')]"));
		wait.until(ExpectedConditions.elementToBeClickable(moreDetail));
		moreDetail.click();
	
//12) Print all the details under Overview in the Same way as displayed in application 
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));
		//WebElement overView = driver.findElement(By.xpath("//div[@class='overview-list padding-bottom10']"));
		//System.out.println(overView.getText());
		//Set<WebElement> labelSet = (Set<WebElement>) 
		List<WebElement> featureElementList = driver.findElementsByXPath("//div[@id='overview']//li/div[@class='equal-width text-light-grey']");
		List<WebElement> valueElemenetList = driver.findElementsByXPath("//div[@id='overview']//li/div[@class='equal-width dark-text']");
		Map<String, String> features = new LinkedHashMap<String, String>();
		for (int i = 1; i <= featureElementList.size(); i++) 
		{
			String feature = driver.findElementByXPath("//div[@id='overview']//li["+i+"]/div[@class='equal-width text-light-grey']").getText().trim();
			String value = driver.findElementByXPath("//div[@id='overview']//li["+i+"]/div[@class='equal-width dark-text']").getText().trim();
			features.put(feature, value);
		}
		System.out.println('\n'+"OverView of the selected Car"+'\n');
		for (Map.Entry<String, String> eachEntry : features.entrySet()) 
		{
			System.out.println(eachEntry.getKey()+'\t'+'\t'+eachEntry.getValue());
		}
		
//13) Close the browser.
	
	
	}
}
