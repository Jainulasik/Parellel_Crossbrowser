package org.crossbrowser;

import org.baseclass.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ParellelBrowser extends BaseClas{
                                                                      //NOT at Same Time >>one or more Testcase - same browser and multiple browser >>>> Cross browser
	                                                                  //At Same Time >> one or more Testcase - same browser and multiple browser >>> parellel browser
	@Test                                         
	public void OrangeHrmlogin() {

		browserLaunch("chrome");
        urlLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		implicitwait(2);

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123"+Keys.ENTER);


		System.out.println("Orange hrm successfully launched");
	}
	
	@Test
	public void Adactin_login() {

		browserLaunch("edge");
		urlLaunch("https://adactinhotelapp.com/");
        driver.findElement(By.id("username")).sendKeys("Asik");
		driver.findElement(By.id("password")).sendKeys("Asik232425");
		driver.findElement(By.id("login")).click();

		System.out.println("Adactin -Successfully launched");


	}


}
