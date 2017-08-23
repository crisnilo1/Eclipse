package Imaps;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class loginGoogle extends TestGoogle {
	@BeforeClass(groups={"loginGoogle","MapTest"})
		 
	public void SetUpLogin (){
		driver.get("https://accounts.google.com/ServiceLogin/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}
	  
	@Test (groups = {"LoginGoogle","MapTest"})
	public void loginG() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("@gmail.com");//add email
		driver.findElement(By.xpath("//*[@id='identifierNext']/content")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("xxxxxxxxx");//add password
		driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	
}
