package testcases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SecondClass;
import wdMethods.ProjectMethods;

public class TC001_MyntraVerifyHomePage extends ProjectMethods{
	@BeforeTest
	
	public void setData() {
		testCaseName="TC001_MyntraHomePage";
		testDescription="veryfy Myntra home ";
		testNodes="Home";
		category="Smoke";
		authors="Rehan";
		browserName="chrome";
		//dataSheetName="TC001";
		
	}
	@Test()
	public void verifyMyntraHome() throws InterruptedException {
		
		new HomePage()
		.searchSunglasses()
		.searchClick()
		.percentage()
		.choseColor()
		.second()
		.fetchPrice1()
		.addToBag()
		.openBag()
		.cartPrice();
				
	}

}
