package Imaps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestGoogle {
	static WebDriver driver;
	
	@BeforeSuite(groups={"loginGoogle","MapTest"})
		public void setUpBeforeTest() throws Exception {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			Thread.sleep(1000);
			//driver.get("https://www.google.com.br/maps");
			
		}
	@AfterSuite(groups = { "loginGoogle","MapTest" })
	public static void tearDownAfterTest() throws Exception {

		driver.close();
	}
	
}
