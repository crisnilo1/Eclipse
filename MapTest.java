package Imaps;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class MapTest extends TestGoogle {

	@BeforeClass
	public void setupBeforeLogin() {
		driver.get("https://www.google.com.br/maps");
	}

	@AfterMethod
	public void tearDownTest() {
		driver.get("https://www.google.com.br/maps");
	}

	@Test(enabled = true)
	public void searchAdress() throws Exception {
		adressDescription("Triad Institute");
		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//div/h3/span[@jstcache='714']"))
						.getText().contains("Itriad instituto triad de pesquisa e desenvolvimento"));
		Thread.sleep(3000);
	}

	@Test(enabled = true)
	public void routeShoppingTriad() throws Exception {
		driver.findElement(By.xpath("//*[@id='searchbox-directions']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sb_ifc51']/input")).sendKeys("Amazonas Shopping");
		driver.findElement(By.xpath("//*[@id='directions-searchbox-0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sb_ifc52']/input")).sendKeys("Triad Institute");
		driver.findElement(By.xpath("//*[@id='directions-searchbox-1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='omnibox-directions']/div/div[2]/div/div/div[1]/div[2]/button/div[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='pane']/div/div[2]/div/div/div[5]/div/div[2]")).click();
		//verify test
		Assert.assertTrue(driver
				.findElement(By
						.xpath("//*[@id='pane']/div/div[2]/div/div/div[5]/div/div[1]/div/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/h2"))
				.getText().contains("Amazonas Shopping"));
	}

	@Test(enabled = true)
	public void sendRoutMobile() throws Exception {

		driver.findElement(By.xpath("//*[@id='searchbox-directions']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sb_ifc51']/input")).sendKeys("Amazonas Shopping");
		driver.findElement(By.xpath("//*[@id='directions-searchbox-0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sb_ifc52']/input")).sendKeys("Triad Institute");
		driver.findElement(By.xpath("//*[@id='directions-searchbox-1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='omnibox-directions']/div/div[2]/div/div/div[1]/div[2]/button/div[1]"))
				.click();
		// click link for send cellphone
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='pane']/div/div[2]/div/div/div[4]/div[2]/div[2]/button")).click();
		Thread.sleep(2000);
		// Select mobile
		driver.findElement(By
				.xpath("//*[@id='modal-dialog-widget']/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[1]/span[3]/span[1]/button"))
				.click();
		// Send for my cellphone
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='snackbar']/div/div")).getText()
				.contains("Enviado para Lenovo VIBE K10."));

	}

	void adressDescription(String description) {
		driver.findElement(By.xpath("//*[@id='searchboxinput']")).sendKeys(description);
		driver.findElement(By.id("searchbox-searchbutton")).click();

	}

}