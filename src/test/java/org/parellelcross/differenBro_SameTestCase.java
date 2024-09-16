package org.parellelcross;

import org.baseclass.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class differenBro_SameTestCase  extends BaseClas{
	
	
	// Different browser - Different website -Same test case
	
	
	public static BaseClas base = new BaseClas();
	
	@Parameters({"browser","urllaunch","product"})
	@Test
	private void mobiles(String browser,String url,String product) throws InterruptedException {

		base.browserLaunch(browser);
		base.urlLaunch(url);
		base.maximize();
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(product);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		
		
		
		 WebElement searchbox2 = driver.findElement(By.name("q"));  
	        searchbox2.sendKeys(product);
	        searchbox2.submit();
		
		
	}
	

}
