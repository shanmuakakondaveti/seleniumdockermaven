package org.wtt.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumDocker{  


	private static WebDriver driver;
	
//	public static void main(String[] args) {
//		SeleniumDocker docker =new SeleniumDocker();
//		try {
//			docker.setUp();
//			docker.simpleTest();
//			docker.testCheckBox();
//			docker.checkLink();
//			docker.afterTest();
//		} catch (MalformedURLException e) {
	
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@BeforeSuite
	public void setupBeforeSuite(ITestContext context) {
		TestRunner testRunner = (TestRunner) context;
		testRunner.setOutputDirectory("D://SampleTestNgReports");
	}	


	@BeforeTest
	public void setUp() throws MalformedURLException {

		//declaration and instantiation of objects/variables  
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://selenium.engazewell.com/wd/hub"), capabilities);
		//System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chrome driver\\chromedriver.exe");
		//WebDriver driver2=new ChromeDriver();
		System.out.println("driver loaded.........================----------------......ra worst");
	}
	
	
	@AfterTest
	public void afterTest() throws MalformedURLException {
		// declaration and instantiation of objects/variables  
		driver.quit();
	}

	@Test(priority=1)
	public void simpleTest() throws MalformedURLException {
		// Launch website  
		driver.navigate().to("https://www.Javatpoint.com"); 
		Assert.assertEquals("Tutorials List - Javatpoint", driver.getTitle());
	}


	@Test(priority=2)
	public void testCheckBox() throws MalformedURLException {

		WebElement element=driver.findElement(By.xpath("//*[@id=\"link\"]/div/ul/li[3]/a"));
		element.click();
		WebElement element2=driver.findElement(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/h1"));
		String expectedText = element2.getText();
		System.out.println("checkBox():"+expectedText);
		Assert.assertEquals("Java Tutorial", expectedText);
		driver.navigate().refresh();
	}


	@Test(priority=3)
	public void checkLink() throws MalformedURLException { 
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).submit();

		String expected = driver.findElement(By.xpath("/html/body/div[7]/div/div[9]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/a/h3")).getText();
		String actual="Javatpoint: Tutorials List";
		System.out.println("checkLine():"+expected);
		Assert.assertEquals(actual, expected);

	}

}  

