package com.krn.actitime.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.krn.actitime.util.Util;

public class TestBase {

	public WebDriver driver;
	public static Properties prop;

	@BeforeClass
	public void openBrowser() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\malli\\workspace\\actitimepracticeproject\\actitimepracticeproject\\src\\com\\krn\\actitime\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browser = prop.getProperty(Util.BROWSER);
		if (browser.endsWith(Util.BROWSER_NAME)) {
			System.setProperty("webdriver.gecko.driver", "C:\\Malli Softwares\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty(Util.URL));
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Util.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void login() throws InterruptedException {
		String userName = prop.getProperty(Util.USER_NAME);
		String password = prop.getProperty(Util.PASSWORD);
		if (!userName.isEmpty() && !password.isEmpty()) {
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
			driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password);
			driver.findElement(By.xpath("//div[text()='Login ']")).click();
			Thread.sleep(10000);
		} else {
			System.err.println("User was not able to login due to user name or password empty/wrong");
		}

	}

	@AfterMethod
	public void logout() throws InterruptedException {
		Util util = new Util();
		Thread.sleep(10000);
		WebElement logOut = driver.findElement(By.id("logoutLink"));

		if (logOut.isDisplayed()) {
			logOut.click();
			Thread.sleep(10000);

			driver.findElement(By.xpath("//input[@id='username']")).clear();
			driver.findElement(By.xpath("//input[@name='pwd']")).clear();
		} else {
			System.err.println("logout link was not displayed");

			util.takeScreenShot();
		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
