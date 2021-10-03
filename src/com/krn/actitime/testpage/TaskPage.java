package com.krn.actitime.testpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskPage {
	public void clickOnTaskTabLink(WebDriver driver ) {
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
	}
	
	public WebElement  getTaskTabLink(WebDriver driver ) {
		return driver.findElement(By.xpath("//div[@id='container_tasks']"));
	}

}
