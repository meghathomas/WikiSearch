package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	public static WebDriver driver;
	public static Scenario scenario;
	
	public static WebDriver initiateDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("lang=en-GB");
		driver = new ChromeDriver(options);
		return driver;
	}
	
	public static void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public static void openUrl(String url) throws IOException {
		driver.get(getURL(url));
	}
	
	public static void findElementByXpathAndClick(String element) throws IOException {
		driver.findElement(By.xpath(Utils.getXpath(element))).click();
	}
	
	public static void findElementByXpathAndSendKeys(String searchText, String element) throws IOException {
		driver.findElement(By.xpath(Utils.getXpath(element))).sendKeys(searchText); 
	}
	
	public static String findElementByXpathAndExtractAttributeValue(String element, String attribute) throws IOException {
		return driver.findElement(By.xpath(Utils.getXpath(element))).getAttribute(attribute);  
	}
	
	public static int findElementByXpathAndExtractNumberOfElements(String element) throws IOException {
		List<WebElement> namespace = driver.findElements(By.xpath(Utils.getXpath(element)));
		int count = namespace.size();
		return count;  
	}
	
	public static String getXpath(String xpath) throws IOException {			
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\xpath.properties");
			prop.load(fis);
			return prop.getProperty(xpath);			
	}
	
	public static String getURL(String element) throws IOException {		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\Properties.properties");
		prop.load(fis);
		String url = prop.getProperty(element);
		return url;	
	}
	
	public static String currentDateTime() {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());		
		return timeStamp ;
	}

	public static void takeScreenShot(Scenario scenario) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png",currentDateTime());		
	}
	
	public static void quitBrowser() {	
		driver.quit();
	}

	public static String findElementByXpathAndExtractData(String element) throws IOException {	
		return driver.findElement(By.xpath(Utils.getXpath(element))).getText();
		
	}
	
}
