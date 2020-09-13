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
import com.actitime.pages.LoginPage;
import com.google.common.annotations.VisibleForTesting;

public class TestValidLoginPage extends BaseTest{
	
    @Test
	public void validlogin_Test()
	{	
		String un = FWUtils.read_XL_Data(READ_XL_DATA,"ValidLoginPage",1,0);
		String pw = FWUtils.read_XL_Data(READ_XL_DATA,"ValidLoginPage",1,1);
		String expectedTitleETP = FWUtils.read_XL_Data(READ_XL_DATA,"ValidLoginPage",1,2);
		
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		FWUtils.verifyPageTitle(driver,expectedTitleETP);
		etp.clickOnLogOutLink();

	}

}
