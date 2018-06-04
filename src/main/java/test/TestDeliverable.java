package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDeliverable {
		
	@Test
	public void myntraTest() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("https://auth.hexaware.com/Login.aspx?ReturnUrl=%2f%3fwtrealm%3dhttps%253a%252f%252fstationh.hexaware.com%252fNewStationH%252f%26wctx%3dWsFedOwinState%253dFNA-bz9Cx74JLjft-yeIdsCb7TGoMaq8de1qU1PxRFH6UeUKKM_XHk_2150hD_1_LFgL6x_1oOGAgvDO2v0crCdyxzFhPb8sOGU4OFNQ8hMxGfEgX1fO8lYVhwaC4O9v891IdrXG3ZwEp9ch9RbGOJcQszXN-6T1hE5SNBuaYMgnFby5jovevzLL1KsGge2VAjpvd-2pHEvhZRkroRkhc0xds_D7uzUb15hVm-eArKsMrxk7clgl4BIHGGG0CG5o9JqbQuJIocHMWjpfrQq4htOBOFVJAypJZOqVTpEhDqGgea9QIeBuJ-a7pgFLpzwz%26wa%3dwsignin1.0&wtrealm=https%3a%2f%2fstationh.hexaware.com%2fNewStationH%2f&wctx=WsFedOwinState%3dFNA-bz9Cx74JLjft-yeIdsCb7TGoMaq8de1qU1PxRFH6UeUKKM_XHk_2150hD_1_LFgL6x_1oOGAgvDO2v0crCdyxzFhPb8sOGU4OFNQ8hMxGfEgX1fO8lYVhwaC4O9v891IdrXG3ZwEp9ch9RbGOJcQszXN-6T1hE5SNBuaYMgnFby5jovevzLL1KsGge2VAjpvd-2pHEvhZRkroRkhc0xds_D7uzUb15hVm-eArKsMrxk7clgl4BIHGGG0CG5o9JqbQuJIocHMWjpfrQq4htOBOFVJAypJZOqVTpEhDqGgea9QIeBuJ-a7pgFLpzwz&wa=wsignin1.0");
	
	driver.findElementById("txtUserName").sendKeys("32579");
	driver.findElementById("txtPassword").sendKeys("Welcome@may1");
	driver.findElementById("btnSubmit").click();
	
	Thread.sleep(2000);
	driver.findElementByClassName("menuline").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//a[@id='menu_two']/img").click();
	
	/*JavascriptExecutor js=(JavascriptExecutor)driver;
	
	js.executeScript("document.getElementById('accordionRoot3').click()");*/
	Thread.sleep(2000);
	driver.findElementById("Project Processes").click();
	

}
}