package com.krn.actitime.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.krn.actitime.testbase.TestBase;

public class Util extends TestBase {
	public static String BROWSER_NAME="firefox";
	public static String BROWSER="browser";
	public static String URL="url";
	public static int IMPLICIT_TIMEOUT=30;
	public static int PAGELOAD_TIMEOUT=30;
	public static String USER_NAME="userName";
	public static String PASSWORD="password";
	
	public  void takeScreenShot() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\malli\\workspace\\actitimepracticeproject\\sample.png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void explicitWait(WebDriver driver1, WebElement element, String locator, int timeInSeconds) {
		
		System.out.println("element :: " + element );
		System.out.println("locator :: " + locator );
		WebDriverWait webDriverWait = new WebDriverWait(driver1, timeInSeconds);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		Actions actions = new Actions(driver1);
		System.out.println("before click" );
		actions.moveToElement(element).click().perform();
		System.out.println("after click" );
		
		
	}
	
}
