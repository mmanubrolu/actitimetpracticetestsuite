package com.krn.actitime.users;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.TestBase;

public class CreateUser extends TestBase {
  @Test
  public void createUserTest() throws InterruptedException {
	  System.out.println("Create user");
	  WebElement userTab = driver.findElement(By.xpath("//div[@id='container_users']"));
	  boolean isUserTabDisplayed = userTab.isDisplayed();
	  if(isUserTabDisplayed) {
		  userTab.click();
		  Thread.sleep(10000);
		  
		  WebElement newUserrbutton = driver.findElement(By.xpath("//div[text()='New User']"));
		  boolean isNewUserButtonDisplayed = newUserrbutton.isDisplayed();
		  
		  if(isNewUserButtonDisplayed) {
			  newUserrbutton.click();
			  Thread.sleep(10000);
			  
			  driver.findElement(By.xpath("//input[@id='createUserPanel_firstNameField']")).sendKeys("Mallikarjuna");
			  driver.findElement(By.xpath("//input[@id='createUserPanel_middleNameField']")).sendKeys("Rao");
			  driver.findElement(By.xpath("//input[@id='createUserPanel_lastNameField']")).sendKeys("Manubrolu");
			  driver.findElement(By.xpath("//input[@id='createUserPanel_emailField']")).sendKeys("mmanubrolu@gmail.com");
			  
			  /*
			  driver.findElement(By.xpath("//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']//div[text()='-- department not assigned --']")).click();
			  driver.findElement(By.xpath("(//div[text()='Production' and @class='item'])[2]")).click();
			  */
			  driver.findElement(By.xpath("//div[@id='createUserPanel_hireDatePlaceholder']//button[text()='Sep 30, 2021']")).click();
			  driver.findElement(By.xpath("//a[@title='Next Month (Control+Right)']")).click();
			  driver.findElement(By.xpath("//span[text()='21']")).click();
			  //driver.findElement(By.xpath("//button[@id='ext-gen690']")).click();
			  
			  driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
			  Thread.sleep(10000);
			  
			  driver.findElement(By.xpath("//div[@class='invitationDialog ui-dialog-content ui-widget-content']/..//span[text()='OK']")).click();
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//div[@class='panelContent']//span[text()='Close']")).click();
			  Thread.sleep(10000);
		  }else {
			  Assert.assertFalse(isNewUserButtonDisplayed, "New user button was not displayed");
		  }
		  
	  }else {
		  Assert.assertFalse(isUserTabDisplayed, "User tab link was not displayed.");
	  }
  }
}
