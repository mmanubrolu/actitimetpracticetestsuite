package com.krn.actitime.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.TestBase;


public class CreateCustomer extends TestBase {
  @Test
  public void createCustomerTest() throws InterruptedException {
	  System.out.println("Create customer");
	  WebElement tasksLink = driver.findElement(By.xpath("//div[@id='container_tasks']"));
	  boolean isTaskLinkDisplayed = tasksLink.isDisplayed();
	  if(isTaskLinkDisplayed) {
		  tasksLink.click();
		  Thread.sleep(10000);
		  WebElement addNewCustomer = driver.findElement(By.xpath("//div[text()='Add New']"));
		  boolean isAddNewCustomerLinkDisplayed = addNewCustomer.isDisplayed();
		  if(isAddNewCustomerLinkDisplayed) {
			  addNewCustomer.click();
			  Thread.sleep(10000);
			  WebElement addCustomer = driver.findElement(By.xpath("//div[text()='+ New Customer']"));
			  boolean isAddCustomerLinkDisplayed = addCustomer.isDisplayed();
			  
			  if(isAddCustomerLinkDisplayed) {
				  addCustomer.click();
				  Thread.sleep(10000);
				  driver.findElement(By.xpath("//input[@placeholder='Enter Customer Name' and @autocomplete='off']")).sendKeys("Mallikarjuna");
				  driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("Added mallikarjuna manubrolu customer");
				  driver.findElement(By.xpath("//div[text()='- Select Customer -' and @class='emptySelection']")).click();
				  Actions actions = new Actions(driver);
				  actions.sendKeys(Keys.ARROW_DOWN).build();
				  actions.sendKeys(Keys.ENTER).build().perform();
				
				  driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
				  Thread.sleep(10000);
				  
			  }else {
				  Assert.assertFalse(isAddCustomerLinkDisplayed, "add customer link was not displayed");
			  }
			  
		  } else {
			  Assert.assertFalse(isAddNewCustomerLinkDisplayed, "add new customer link was not displayed");
		  }
		  
	  } else {
		  Assert.assertFalse(isTaskLinkDisplayed, "Task link was not dispalyed");
	  }
  }
}
