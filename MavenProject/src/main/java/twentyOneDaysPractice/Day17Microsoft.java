package twentyOneDaysPractice;

import java.io.File;
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
import org.testng.Assert;

public class Day17Microsoft {
	
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
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		
		//1) Go to https://azure.microsoft.com/en-in/
		driver.get("https://azure.microsoft.com/en-in/");
		
		//2) Click on Pricing
		WebElement clkPriceMenu = driver.findElement(By.linkText("Pricing"));
		wait.until(ExpectedConditions.elementToBeClickable(clkPriceMenu));
		clkPriceMenu.click();
		
		//3) Click on Pricing Calculator
		WebElement clkPriceCal = driver.findElement(By.linkText("Pricing calculator"));
		wait.until(ExpectedConditions.elementToBeClickable(clkPriceCal));
		clkPriceCal.click();
		
		//4) Click on Containers
		WebElement scrollTo = driver.findElement(By.xpath("//div[contains(@class,'column medium-10')]//div[1]"));
		executor.executeScript("arguments[0].scrollIntoView();", scrollTo);
		WebElement clkContainer = driver.findElement(By.xpath("//button[@value='containers']"));
		wait.until(ExpectedConditions.elementToBeClickable(clkContainer));
		executor.executeScript("arguments[0].click();", clkContainer);
		
		
		//5) Select Container Instances
		WebElement clkContInstance = driver.findElement(By.xpath("(//span[text()='Easily run containers on Azure without managing servers'])[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(clkContInstance));
		clkContInstance.click();
		
		//6) Click on Container Instance Added View
		WebElement instanceView = driver.findElement(By.linkText("View"));
		wait.until(ExpectedConditions.elementToBeClickable(instanceView));
		instanceView.click();
		
		//7) Select Region as "South India"
		WebElement regionField = driver.findElement(By.name("region"));
		Select sl = new Select (regionField);
		sl.selectByValue("south-india");
		
		//8) Set the Duration as 180000 seconds
		WebElement enterDuration = driver.findElement(By.xpath("(//div[@class='wa-textNumber'])[2]/input"));
		enterDuration.clear();
		enterDuration.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		enterDuration.sendKeys("180000");
		
		//9) Select the Memory as 4GB
		WebElement selectMemory = driver.findElement(By.xpath("//select[@name='memory']"));
		Select sl1 = new Select (selectMemory);
		sl1.selectByValue("4");
		
		//10) Enable SHOW DEV/TEST PRICING
		executor.executeScript("arguments[0].scrollIntoView();", selectMemory);
		WebElement devTestPrice = driver.findElement(By.name("devTestSelected"));
		executor.executeScript("arguments[0].click();", devTestPrice);
	
		//11) Select Indian Rupee  as currency
		WebElement currencyDD = driver.findElement(By.xpath("//select[@class='select currency-dropdown']"));
		Select sl2 = new Select (currencyDD);
		sl2.selectByValue("INR");
		
		//12) Print the Estimated monthly price
		WebElement estMonPrice = driver.findElement(By.xpath("//section[@id='azure-calculator']/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/div[6]/div[1]/div[2]/div[2]/span[1]/span[1]"));
		String price= estMonPrice.getText();
		double estPriceVal = Double.parseDouble(price.replace("₹", ""));
		System.out.println("Estimated monthly price:  "  +estPriceVal);
		
		//13) Click on Export to download the estimate as excel
		WebElement clkExport = driver.findElement(By.xpath("//button[@class='calculator-button button-transparent export-button']"));
		clkExport.click();
		Thread.sleep(5000);
		
		//14) Verify the downloded file in the local folder
		File getLatestFile = getLatestFilefromDir("C:\\Users\\Kumaran\\Downloads");
	    String fileName = getLatestFile.getName();
	    Assert.assertTrue(fileName.contains("ExportedEstimate.xlsx"), "Downloaded file name is not matching with expected file name");
	    System.out.println("DOWNLOADED FILE IS AVAILABLE ON LOCAL");
	    
		//15) Navigate to Example Scenarios and Select CI/CD for Containers
	    executor.executeScript("window.scrollTo(0, 0)");
	    WebElement clkExpSce = driver.findElement(By.linkText("Example Scenarios"));
	    wait.until(ExpectedConditions.elementToBeClickable(clkExpSce));
	    clkExpSce.click();
	    WebElement cicdContain = driver.findElement(By.xpath("(//button[@class='solution-architecture-item false'])[2]"));
	    wait.until(ExpectedConditions.elementToBeClickable(cicdContain));
	    cicdContain.click();
	    
		//16) Click Add to Estimate
	    WebElement scrollToBtn = driver.findElement(By.xpath("//h5[text()='Products']"));
	    executor.executeScript("arguments[0].scrollIntoView();", scrollToBtn);
	    WebElement clkAddEst = driver.findElement(By.xpath("//button[contains(@class,'button button--secondary01')]"));
	    wait.until(ExpectedConditions.elementToBeClickable(clkAddEst));
	    clkAddEst.click();
	    Thread.sleep(5000);
	    
		//17) Change the Currency as Indian Rupee
	    WebElement scrollToArrow = driver.findElement(By.xpath("//span[text()='Azure Monitor ']"));
	    executor.executeScript("arguments[0].scrollIntoView();", scrollToArrow);
	    WebElement curDropDown = driver.findElement(By.xpath("//select[@class='select currency-dropdown']"));
	    Select curDD = new Select(curDropDown);
	    curDD.selectByValue("INR");
	    
		//18) Enable SHOW DEV/TEST PRICING
	    WebElement devTestPr = driver.findElement(By.xpath("(//label[@for='devtest-toggler']//div)"));
	    wait.until(ExpectedConditions.elementToBeClickable(devTestPr));
	    executor.executeScript("arguments[0].click();", devTestPr);
	    
		//19) Export the Estimate
	    WebElement clkExpo = driver.findElement(By.xpath("(//button[contains(@class,'calculator-button button-transparent')])[4]"));
	    wait.until(ExpectedConditions.elementToBeClickable(clkExpo));
	    clkExpo.click();
	    Thread.sleep(5000);
	    
		//20) Verify the downloded file in the local folder
	    File getLatestFile1 = getLatestFilefromDir("C:\\Users\\Kumaran\\Downloads");
	    String fileName1 = getLatestFile1.getName();
	    Assert.assertTrue(fileName1.contains("ExportedEstimate (1).xlsx"), "Downloaded file name is not matching with expected file name");
	    System.out.println("SECOND DOWNLOADED FILE IS AVAILABLE ON LOCAL");
	    
	    //21) Close the browsers
	    driver.close();

	}

	private static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}

	
	

}
