package twentyOneDaysPractice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DaySevenHonda {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivers.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
	//1) Go to https://www.honda2wheelersindia.com/
		driver.get("https://www.honda2wheelersindia.com/");
		driver.findElement(By.xpath("//button[@class='close']")).click();
		
	//2) Click on scooters and click dio
		//Thread.sleep(5000);
		WebElement scooter = driver.findElement(By.xpath("//a[@id='link_Scooter']"));
		wait.until(ExpectedConditions.elementToBeClickable(scooter));
		scooter.click();
		//Thread.sleep(200);
		WebElement dio = driver.findElement(By.xpath("//img[@src='/assets/images/thumb/dioBS6-icon.png']"));
		wait.until(ExpectedConditions.elementToBeClickable(dio));
		dio.click();
		
	//3) Click on Specifications and mouseover on ENGINE
		WebElement spec = driver.findElement(By.xpath("//a[text()='Specifications']"));
		spec.click();
		Actions ac = new Actions(driver);
		WebElement engin = driver.findElement(By.xpath("//a[text()='ENGINE']"));
		wait.until(ExpectedConditions.elementToBeClickable(engin));
		ac.moveToElement(engin).build().perform();
		
	//4) Get Displacement value
		WebElement dispDio = driver.findElement(By.xpath("//span[text()='Displacement']/following-sibling::span"));
		WebElement displac = driver.findElement(By.xpath("//span[text()='Displacement']"));
		wait.until(ExpectedConditions.textToBePresentInElement(displac, "Displacement"));
		String dioDisSt = dispDio.getText();
		Double dioDisVal = Double.parseDouble(dioDisSt.replaceAll("[^0-9.]", ""));
		System.out.println("DISPLACEMENT:  "+dioDisSt);
		
	//5) Go to Scooters and click Activa 125
		//Thread.sleep(5000);
		//ac.moveToElement(scooter).build().perform();
		//ac.click();
		driver.navigate().refresh();
		WebElement scooter1 = driver.findElement(By.xpath("//a[@id='link_Scooter']"));
		scooter1.click();
		WebElement activa125 = driver.findElement(By.xpath("//img[@src='/assets/images/thumb/activa-125new-icon.png']"));
		//wait.until(ExpectedConditions.elementToBeClickable(activa125));
		activa125.click();
		
	//6) Click on Specifications and mouseover on ENGINE
		//driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement spec1 = driver.findElement(By.xpath("//a[text()='Specifications']"));
		wait.until(ExpectedConditions.elementToBeClickable(spec1));
		spec1.click();
		WebElement engin1 = driver.findElement(By.xpath("//a[text()='ENGINE']"));
		wait.until(ExpectedConditions.elementToBeClickable(engin1));
		ac.moveToElement(engin1).build().perform();
		
	//7) Get Displacement value
		WebElement dispAct = driver.findElement(By.xpath("//span[text()='Displacement']/following-sibling::span"));
		String actDisSt = dispAct.getText();
		Double actDisVal = Double.parseDouble(actDisSt.replaceAll("[^0-9.]", ""));
		System.out.println("DISPLACEMENT:  "+actDisSt);
		
	//8) Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
		if(dioDisVal > actDisVal) {
			System.out.println("THE BETTER DISPLACEMENT SCOOTER IS DIO");
		}else {
			System.out.println("THE BETTER DISPLACEMENT SCOOTER IS ACTIVA125");
		}
		
	//9) Click FAQ from Menu 
		WebElement fqa = driver.findElement(By.xpath("//a[text()='FAQ']"));
		wait.until(ExpectedConditions.elementToBeClickable(fqa));
		fqa.click();
		
	//10) Click Activa 125 BS-VI under Browse By Product
		WebElement activaBS = driver.findElement(By.xpath("//a[text()='Activa 125 BS-VI']"));
		wait.until(ExpectedConditions.elementToBeClickable(activaBS));
		activaBS.click();
		
	//11) Click  Vehicle Price 
		WebElement vPrice = driver.findElement(By.xpath("//li[@id='li6']/a"));
		vPrice.click();
		
	//12) Make sure Activa 125 BS-VI selected and click submit
		WebElement drp = driver.findElement(By.xpath("//select[@id='ModelID6']"));
		Select sl = new Select(drp);
		//WebElement drpDownSelect = driver.findElement(By.xpath("(//option[@selected='selected'])[2]"));
		WebElement option = sl.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem);
		if(defaultItem.equalsIgnoreCase("Activa 125 BS-VI")) {
			WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit6']"));
			submitBtn.click();
		}else {
			System.out.println("Corresponding option not selected");
		}
	//13) click the price link
		WebElement priceLink = driver.findElement(By.xpath("//a[text()='Click here to know the price of Activa 125 BS-VI.']"));
		priceLink.click();
		
	//14) Go to the new Window and select the state as Tamil Nadu and  city as Chennai
		Set<String> winSet = driver.getWindowHandles();
		List<String> lwin = new ArrayList<String>(winSet);
		driver.switchTo().window(lwin.get(1));
		WebElement selectState = driver.findElement(By.id("StateID"));
		wait.until(ExpectedConditions.elementToBeClickable(selectState));
		Select sState = new Select(selectState);
		sState.selectByVisibleText("Tamil Nadu");
		WebElement selectCity = driver.findElement(By.id("CityID"));
		Select sCity = new Select(selectCity);
		sCity.selectByVisibleText("Chennai");
		
		
	//15) Click Search
		WebElement serachBtn = driver.findElement(By.xpath("//button[text()='Search']"));
		serachBtn.click();
	//16) Print all the 3 models and their prices
		//WebElement table = driver.findElement(By.xpath("//table[@class='datashow']"));
		//List<WebElement> tRow = table.findElements(By.tagName("tr"));
		//int rowSize = tRow.size();
		//System.out.println("Row" +rowSize);
		//List<WebElement> tCol = tRow.get(1).findElements(By.xpath("(//table[@rules='all']//td)[2]"));
		//System.out.println(tCol.get(0).getText());
		
		String model = "";
		String price = "";
		Map<String, String> map1 =  new LinkedHashMap<String, String>();
		WebElement scooters = driver.findElementByXPath("//table[@id='gvshow']/tbody");
		List<WebElement> allRows = scooters.findElements(By.tagName("tr"));
		for(int i = 0; i < allRows.size(); i++) {
			List<WebElement> allCells = allRows.get(i).findElements(By.tagName("td"));
			if(i == 0) {
				model = allCells.get(1).getText();
				price = allCells.get(2).getText();
			}
			else {
				model = allCells.get(0).getText();
				price = allCells.get(1).getText();
			}
			map1.put(model, price);				
		}
		for (Entry<String,String> e : map1.entrySet()) {
			System.out.println("The Price for model "+e.getKey()+" is "+e.getValue());
		}
		
	//17) Close the Browser
		driver.quit();
		
		System.out.println("Executed Done");

	}

}
