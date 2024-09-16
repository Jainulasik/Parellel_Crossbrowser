package org.crossbrowser;

import org.baseclass.BaseClas;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Cross_Browse extends BaseClas {

	public static BaseClas base = new BaseClas();
	

	
	@Parameters({"browser"})
	@Test
	public static void Telegram (String brows) {
		base.browserLaunch(brows);
		base.urlLaunch("https://www.facebook.com");
		maximize();
		
		
	}
	
	
	@Parameters({"browser1"})
	@Test
	public static void Instagram (String brows1) {
		base.browserLaunch(brows1);
		base.urlLaunch("https://www.instagram.com");
		maximize();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
