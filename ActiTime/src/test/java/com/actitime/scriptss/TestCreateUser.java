package com.actitime.scriptss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.FWUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.TaskListPage;

public class TestCreateUser extends BaseTest{
	@Test
	public void test_CreateUser() throws InterruptedException
	{			
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,"actiTIME - Enter Time-Track");
		etp.clickOnTaskTab();
		
		TaskListPage tls = new TaskListPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,"actiTIME - Task List");
		tls.clickOnAddNewBTN();
		tls.clickOnPlusNwCustomer();
		Thread.sleep(1000);
		tls.setNewCustomerName("BPS234312");
		tls.clickonPlusCreateCusomerBTN();
		tls.listofCustomers();
		etp.clickOnLogOutLink();
		
		
	

	}

}
