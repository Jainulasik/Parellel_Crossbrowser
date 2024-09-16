package org.parellelcross;

import org.baseclass.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser extends BaseClas {

	//Testing - DIffrent browser > Different Test case .

	public static BaseClas base = new BaseClas();



	@Parameters({"browser","searchkeys"})
	@Test
	public static void testMobiles1(String brows,String searchh) {
		base.browserLaunch(brows);
		base.maximize();
		base.urlLaunch("https://www.amazon.in");
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys(searchh);
		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}


	




}
