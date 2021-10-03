package com.krn.actitime.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.TestBase;
import com.krn.actitime.util.Util;

public class DeleteCustomer extends TestBase {
	@Test
	public void deleteCustomerTest() throws InterruptedException {
		
		WebElement tasksLink = taskPage.getTaskTabLink(driver);
		boolean isTaskLinkDisplayed = tasksLink.isDisplayed();
		Util util = new Util();

		if (isTaskLinkDisplayed) {
			System.out.println("inside task link display - Delete customer");
			//util.explicitWait(driver,tasksLink,xpath , 10);
			tasksLink.click();
			Thread.sleep(10000);
			
			String customerName = xlsreader.getCellData("Data", "deleteCustomer", 1, 0);
			driver.findElement(By.xpath("//div[@class='customersProjectsPanel']//input[@placeholder='Start typing name ...']")).sendKeys(customerName);
			WebElement deleteElement = driver
					.findElement(By.xpath("//div[@class='itemsContainer']//div[text()='"+customerName+"']"));
			
			//scrolldown the page to identify the requested element in the html page
			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", deleteElement);
			boolean isDelementDisplayed = deleteElement.isDisplayed();
		
			if (isDelementDisplayed) {
				//util.explicitWait(driver,deleteElement, "//div[@class='itemsContainer']//div[text()='Mallikarjuna']", 10);
				System.out.println("inside isDelementDisplayed");
				deleteElement.click();
				Thread.sleep(10000);
				
				WebElement deleteItem = driver.findElement(By.xpath("//div[text()='Mallikarjuna' and @title='Mallikarjuna']/..//div[@class='editButton']"));
				util.explicitWait(driver,deleteItem, "//div[text()='Mallikarjuna' and @title='Mallikarjuna']/..//div[@class='editButton']", 10);
				//driver.findElement(By.xpath("//div[text()='Mallikarjuna' and @title='Mallikarjuna']/..//div[@class='editButton']")).click();
				
				/*WebElement actionsElement= driver.findElement(By.xpath("//div[@class='editCustomerPanelHeader']//div[text()='ACTIONS']"));
				util.explicitWait(driver,actionsElement,"//div[@class='editCustomerPanelHeader']//div[text()='ACTIONS']", 10);
				*/
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div[@class='editCustomerPanelHeader']//div[text()='ACTIONS']")).click();
				Thread.sleep(10000);
				
				WebElement deleteButton = driver.findElement(By.xpath("//div[@class='taskManagement_customerPanel']//div[text()='Delete']"));
				util.explicitWait(driver,deleteButton,"//div[@class='taskManagement_customerPanel']//div[text()='Delete']", 10);
				//driver.findElement(By.xpath("//div[@class='taskManagement_customerPanel']//div[text()='Delete']")).click();
			
				WebElement deletePermantelyElement = driver.findElement(By.xpath("//span[text()='Delete permanently']"));
				util.explicitWait(driver,deletePermantelyElement,"//span[text()='Delete permanently']", 10);
				//driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
				
			} else {
				System.out.println("inside isDelementDisplayed else block");
				Assert.assertFalse(!isDelementDisplayed, "Proposed delete element is not displayed");
			}
		} else {
			Assert.assertFalse(!isTaskLinkDisplayed, "tasks tab link is not displayed");
		}
	}
}
