package cromePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class priceAverage {
	WebDriver driver;
	String url ="https://www.croma.com";
	int[] pricelist = new int[11];
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\eclipse-workspace\\libs\\chromedriver.exe");
	        
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	}
	@Test
	public void invokeBrowser() {
		driver.get(url);
	}
	@Test(dependsOnMethods = "invokeBrowser")
	public void searchRefrigerator() {
		driver.navigate().refresh();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait for the search input to be visible and enter the search term
	    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchV2")));
	    searchInput.sendKeys("refrigerator");
	    searchInput.sendKeys(Keys.RETURN);
	    driver.navigate().refresh();
	}
	
	@Test(dependsOnMethods="searchRefrigerator")
		public void filter() {
			driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])[2]")).click();
//			driver.findElement(By.xpath("//div[@class='sort-by-category']//li[@class='item']//span[text()=\"LG\"]")).click();
			
		}
	
	
	@Test(dependsOnMethods ="filter")
	public void getPriceOf1Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[1]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[0] =price;
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf2Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[2]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[2] =price;
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf3Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[3]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[3] =price;
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf4Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[4]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[4] =price;
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf5Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[5]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[5] =price;
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf6Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[6]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[6] =price;
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf7Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[7]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[7] =price;
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf8Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[8]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[8] =price;
	}@Test(dependsOnMethods ="filter")
	public void getPriceOf9Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[9]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[9] =price;
	
	}
	@Test(dependsOnMethods ="filter")
	public void getPriceOf10Product() {
		String l = driver.findElement(By.xpath("(//span[@class='amount plp-srp-new-amount'])[10]")).getText();
	System.out.println(l);
	String numericString = l.replaceAll("[₹,]","");
	int price =  Integer.parseInt(numericString);
	pricelist[10] =price;
	}
	@Test(dependsOnMethods ="getPriceOf10Product")
	public void Average() {
		int sum=0;
		int average=0;
		int n= 0;
		for(int i =0;  i<pricelist.length;i++) {
			 sum=sum+pricelist[i];
			 n=i;
			 
		}
         		average = sum/n;
         		System.out.println(sum);
         		System.out.println(n);
         		System.out.println(average);
	}
	
}


