package com.krn.actitime.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.krn.actitime.testbase.TestBase;

public class DeleteUser extends TestBase {
  @Test
  public void deleteUserTest() throws InterruptedException {
	  System.out.println("Delete user");
	  Thread.sleep(10000);
	  WebElement userTab = driver.findElement(By.xpath("//div[@id='container_users']"));
	  boolean isUserTabDisplayed = userTab.isDisplayed();
	
	  if(isUserTabDisplayed) {
		  userTab.click();
		  Thread.sleep(10000);
		  WebElement deleteItem= driver.findElement(By.xpath("//table[@class='userNameContainer']//span[text()='Manubrolu, Mallikarjuna Rao.']"));
		  
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", deleteItem);
		  deleteItem.click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//div[text()='DELETE']")).click();
		  Thread.sleep(10000);
		  driver.switchTo().alert().accept();
	  } else {
		  Assert.assertFalse(!isUserTabDisplayed, "User tab link was not displayed.");
	  }
  }
}
