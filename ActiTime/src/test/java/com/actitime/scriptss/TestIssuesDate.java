package com.actitime.scriptss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.FWUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LicencesPage;
import com.actitime.pages.LoginPage;

public class TestIssuesDate extends BaseTest {
	@Test
	public void test_CheckIssueDate() throws InterruptedException 
	{
		
		String un = FWUtils.read_XL_Data(READ_XL_DATA,"CheckIssueDate",1,0);
		String pw = FWUtils.read_XL_Data(READ_XL_DATA,"CheckIssueDate",1,1);
		String expectedTitleETP = FWUtils.read_XL_Data(READ_XL_DATA,"CheckIssueDate",1,2);
		String expectedTitleLCP = FWUtils.read_XL_Data(READ_XL_DATA,"CheckIssueDate",1,3);
		String expectedTitleIssueDate = FWUtils.read_XL_Data(READ_XL_DATA,"CheckIssueDate",1,4);
		
		
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,expectedTitleETP);
		Thread.sleep(1000);
		etp.clickOnSettingsMenu();
		Thread.sleep(1000);
		etp.clickOnLicensesLink();
		
		LicencesPage lcp = new LicencesPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver,expectedTitleLCP);
		Thread.sleep(1000);
		lcp.verifyIssueDate(expectedTitleIssueDate);
		Thread.sleep(1000);
		etp.clickOnLogOutLink();

	}

}
