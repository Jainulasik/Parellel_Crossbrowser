package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {

	public static WebDriver driver ;

	public static void browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();	
		}
			
		else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	
	}


	

	public static void windowsCommands() {

		driver.manage().window().maximize();

	}

	public static void sendText(WebElement keys, String user) {
		keys.sendKeys(user);

	}

	public static void buttonClick(WebElement clickk) {
		clickk.click();

	}

	public void navigation() {
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void robot(int value) throws AWTException {

		Robot r = new Robot();
		r.keyPress(value);
		r.keyRelease(value);
	}

	public static void dropDowns(WebElement select, int index) {
		Select s = new Select(select);
		s.selectByIndex(index);
	}

	public static void dropDown2(WebElement select, String text) {
		Select s = new Select(select);
		s.selectByVisibleText(text);
	}

	public static void actions(WebElement moveto) {
		Actions a = new Actions(driver);
		a.moveToElement(moveto).perform();
	}

	public static void actions2(WebElement contectclick) {
		Actions a = new Actions(driver);
		a.contextClick(contectclick).perform();

	}

	public static void javaScriptex(String name, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (name.equalsIgnoreCase("Scroll up")) {
			js.executeScript("window.scrollBy(0, -1500)");
		} else if (name.equalsIgnoreCase("Scroll down")) {
			js.executeScript("window.scrollBy(0, 2500)");

		}

		else if (name.equalsIgnoreCase("move desired position")) {
			js.executeScript("arguments[0].scrollIntoView()", element);
		}

	}

	public static void actionsMethods(WebElement element, String value) {

		Actions ac = new Actions(driver);
		if (value == "click") {
			ac.click(element).build().perform();
		}

		else if (value == "doubleclick") {
			ac.doubleClick(element).build().perform();
		} else if (value == "contectclick") {
			ac.contextClick(element).build().perform();

		} else if (value == "movetoelement") {
			ac.moveToElement(element).build().perform();
		}

	}

	public static void selectMethods2(WebElement element, String name, int index) {
		Select s = new Select(element);

		if (name == "index") {
			s.selectByIndex(index);
		} else if (name == "text") {
			s.selectByVisibleText(name);
		} else if (name == "value") {
			s.selectByValue(name);
		}

	}

	public static void alert(String type) {
		Alert al = driver.switchTo().alert();

		if (type == "accept") {
			al.accept();
		} else if (type == "dismiss") {
			al.dismiss();
		}

	}

	public static void screencapture(String capturr) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File a = ts.getScreenshotAs(OutputType.FILE);
		File b = new File("C:\\Users\\Lenovo\\Desktop\\Screenshot\\" + capturr + ".png");
		FileUtils.copyFile(a, b);
	}

	public static void waitt(int seconds) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public String readExcel(int row, int cell) throws IOException {

		File f = new File("D:\\Username.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(row);
		Row row2 = sheet.getRow(row);
		Cell cell2 = row2.getCell(cell);

		CellType cellType = cell2.getCellType();

		String value = null;
		switch (cellType) {
		case STRING:
			cell2.getStringCellValue();

			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell2)) {
				Date dateCellValue = cell2.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				sdf.format(dateCellValue);
			}

			else {
				double numericCellValue = cell2.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				String string = valueOf.toString();

			}
			break;

		default:
			System.out.println("undefined format");
			break;
		}

		return value;

	}

	public static void winHandles() {

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		for (String handles : windowHandles) {
			System.out.println(handles);
			driver.switchTo().window(handles);
			String title = driver.getTitle();
			System.out.println(title);

		}
	}

	public static void frame(WebElement fram) {
		driver.switchTo().frame(fram);
	}

	public static void quitt() {
		driver.quit();
	}

	public static void closee() {
		driver.close();
	}

}
