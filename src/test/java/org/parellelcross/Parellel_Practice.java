package org.parellelcross;

import org.baseclass.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Parellel_Practice extends BaseClas {


	@Test
	public void loginSaucedemo() {

		browserLaunch("chrome");
		maximize();
		urlLaunch("https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);
	}

	@Test
	public  void loginSaucedemo2() {

		browserLaunch("firefox");
		maximize();
		urlLaunch("https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);
	}

	@Test
	public  void Saucedemo3() {

		browserLaunch("chroME");
		maximize();
		urlLaunch("https://www.saucedemo.com");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);
	}

}
















