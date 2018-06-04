package test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class Test2Deliverable extends SeMethods {
	String strtDt=null;
	String endDt=null;
	String taskStartDate=null;
	String taskEndDate=null;

	@Test
	public void myntraTest() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://pt.hexaware.com/WSEM/Source/General/Navigation.aspx");
	//driver.get("https://pt.hexaware.com/WSEM/Source/General/Navigation.aspx");
	driver.findElementById("txtUserName").sendKeys("32579");
	driver.findElementById("txtPassword").sendKeys("Razz@may24");
	driver.findElementById("btnSubmit").click();
	Thread.sleep(3000);
	//driver.switchTo().parentFrame();
	driver.switchTo().frame("Sub");
	driver.switchTo().frame("frmMain");
	
	driver.findElementByXPath("//a[text()='Citi_TTS_SteadyState_BFS']").click();
	driver.switchTo().frame("Sub");
	Thread.sleep(2000);
	driver.findElementByXPath("//div[@id='div3']/div/a/img[@id='join8002']").click();
	driver.findElementByXPath("//img[@id='join8003']").click();
	driver.findElementByXPath("//a[contains(text(),'Project Deliverables')]").click();
	
	//Thread.sleep(1000);
	driver.switchTo().parentFrame();
	System.out.println("I am frame parent");
	driver.switchTo().frame("Sub");
	System.out.println("I am frame 1");
	Thread.sleep(1000);
	driver.switchTo().frame("frmMain");
	System.out.println("I am frame 2");
	
	
	//JavascriptExecutor je=(JavascriptExecutor) driver;
	//je.executeScript("document.getElementById('Add_OnClickLIST_HEAD0-2133').click();");
	//Actions act=new Actions(driver);
	//act.moveToElement(driver.findElementByXPath("(//a[@class='Menu'])[1]/img")).contextClick().build().perform();
	
	//System.out.println(driver.findElementByXPath("//*[@id=\"Add_OnClickLIST_HEAD0-2133\"]").getText());
	//driver.findElementByXPath("//table[@class='clsTable topInnerMenu']").
	Thread.sleep(5000);
	driver.findElementByXPath("//*[@id=\"Add_OnClickLIST_HEAD0-2133\"]").click();
	Thread.sleep(2000);
	String wh = driver.getWindowHandle();
	
	Set<String> whs = driver.getWindowHandles();
	
	for(String child:whs) {
		if(!child.equals(wh)) {
			driver.switchTo().window(child);
		}
	}
	
	Thread.sleep(2000);	
	driver.findElementByLinkText("Testing").click();
	
	Thread.sleep(2000);
	//String wh1 = driver.getWindowHandle();
	driver.switchTo().window(wh);
	driver.switchTo().parentFrame();
	driver.switchTo().frame("Sub");
	driver.switchTo().frame("frmMain");	
	driver.findElementById("DocumentNo").sendKeys("ABC");
	driver.findElementById("Title").sendKeys("ABC");
	driver.findElementById("Description").sendKeys("ABC");
	driver.findElementByXPath("//input[@name='FFE29587WHIZ_StartDate']/following-sibling::a[1]/img").click();	
	
	String wh2 = driver.getWindowHandle();
	Set<String> whs2 = driver.getWindowHandles();
	for(String child1:whs2) {
		if(!child1.equals(wh2)) {
			driver.switchTo().window(child1);
		}
	}
	
	System.out.println(driver.getTitle());
	WebElement findElementByXPath = driver.findElementByXPath("//table[@id='Calendar1']/tbody/tr[3]/td[1]");
	String attribute = findElementByXPath.getAttribute("style");
	if(attribute.contains("white")) {
		System.out.println("yes it is");
	}
	
        int td1;
		for(td1=1;td1<=7;td1++) {
			WebElement findElementByXPath2 = driver.findElementByXPath("//table[@id='Calendar1']/tbody/tr["+3+"]/td["+td1+"]");
			
			String attribute2 = findElementByXPath2.getAttribute("style");
			if(attribute2.contains("white")) {
				continue;
			}
			else if(!attribute2.contains("white")){
				strtDt=findElementByXPath2.getText();
				System.out.println(strtDt);
				findElementByXPath2.click();
				td1=8;
				break;
			}
			
		}
	
	
	Thread.sleep(3000);
	

			driver.switchTo().window(wh2);
			System.out.println("Window is: "+driver.getTitle());
			
			//Thread.sleep(2000);
			
			driver.switchTo().parentFrame();
			driver.switchTo().frame("Sub");
			driver.switchTo().frame("frmMain");
		
     driver.findElementByXPath("//table[@class='clsTable topInnerMenu detailInfo']/tbody/tr[7]/td[2]/a").click();
    
 	Set<String> whs3 = driver.getWindowHandles();
 	for(String child1:whs3) {
 		if(!child1.equals(wh2)) {
 			driver.switchTo().window(child1);
 		}
 	}
 	
 	System.out.println(driver.getTitle());
 	
 	Thread.sleep(2000);
 	int tr;
 	 for(tr=8;tr>=1;tr--) {
    	 for(int td=7;td>=1;td--) {
			WebElement findElementByXPath2 = driver.findElementByXPath("//table[@id='Calendar1']/tbody/tr["+tr+"]/td["+td+"]/a");
			String attribute2 = findElementByXPath2.getAttribute("style");
			if(!attribute2.contains("white")) {
				endDt=findElementByXPath2.getText();
				System.out.println(endDt);
			tr=0;
			findElementByXPath2.click();
			break;
			
		}						
		}
 	 }
 	 


 	Thread.sleep(3000);
 	

 			driver.switchTo().window(wh2);
 			System.out.println("Window is: "+driver.getTitle());
 			
			driver.switchTo().parentFrame();
			driver.switchTo().frame("Sub");
			driver.switchTo().frame("frmMain");
			
			driver.findElementByXPath("//table[@class='clsTable topInnerMenu detailInfo']/tbody/tr[8]/td[2]/input").sendKeys("110"); 	

    	 Select slt=new Select(driver.findElementById("Priority"));
    	 slt.selectByVisibleText("Medium");
    	 
    	 Select clt=new Select(driver.findElementById("ComplexityID"));
    	 clt.selectByVisibleText("Medium");
    	 
    	 driver.findElementById("DeliverableSize").sendKeys("110");
    	 
    	 Select dsu=new Select(driver.findElementById("DeliverableSizeUnitID"));
    	 dsu.selectByVisibleText("Test Case Point");
    	 
    	 Select rb=new Select(driver.findElementById("RequestedBy"));
    	 rb.selectByVisibleText("32972-MOHATHASSHEEM AHMED");
    	 
    	 Thread.sleep(2000);
    	// JavascriptExecutor je=(JavascriptExecutor) driver;
    	 
    	 
    	 WebElement scroll = driver.findElementByXPath("//table[@class='clsTable topInnerMenu detailInfo']/tbody/tr[13]/td");
    	 //je.executeScript("argumants[0].scrollIntoView(true);", scroll);
    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
    	 Thread.sleep(5000); 
    	 
    	
    	 Select rp=new Select(driver.findElementById("ResponsiblePerson"));
    	 rp.selectByVisibleText("32579-REHAN RAZZAQUEE");
    	 
    	 
    	 Select status=new Select(driver.findElementById("Status"));
    	 status.selectByVisibleText("Open");
    	 
    	 
    	 Select wp=new Select(driver.findElementById("PackageID"));
    	 wp.selectByVisibleText("May Release");
    	 
    	 driver.findElementById("CustomFieldNumeric2").sendKeys("0.95");
    	 driver.findElementById("CustomFieldNumeric3").sendKeys("52");
	
    	 driver.findElementByXPath("//a[@class='Menu'][@id='SAVEUI_HEAD0-2133']").click();
    	 Thread.sleep(3000);
    		String whh = driver.getWindowHandle();
    		
    		Set<String> whss = driver.getWindowHandles();
    		
    		for(String child:whss) {
    			if(!child.equals(whh)) {
    				driver.switchTo().window(child);
    			}
    		}
    	
    		System.out.println("Window name: "+driver.getTitle());
    		Thread.sleep(3000);
    		driver.findElementByXPath("//a[text()='Close']").click();
    		Thread.sleep(3000);
    		
    		driver.switchTo().window(whh);
    		System.out.println("Window name: "+driver.getTitle());
    		Thread.sleep(1000);
    		driver.switchTo().parentFrame();
			driver.switchTo().frame("Sub");
			driver.switchTo().frame("frmMain");
    		driver.findElementByXPath("(//a[text()='  Plan Deliverables'])[1]").click();
    		
            Set<String> whs4 = driver.getWindowHandles();
    		
    		for(String child:whs4) {
    			if(!child.equals(whh)) {
    				driver.switchTo().window(child);
    			}
    		}
    		System.out.println(driver.getTitle());
    		
    		WebElement startDate = driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[2]/td[4]/input");
    		System.out.println(startDate.getAttribute("value").toString());
    		
    		WebElement endDate = driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[18]/td[5]/input");
    		System.out.println(endDate.getAttribute("value").toString());
    		
    		taskStartDate=endDate.getAttribute("value").toString().substring(2);
    		System.out.println("taskStartDate "+taskStartDate);
    		
    		String temlateText="Testing - Test Execution";
    		
    		Select temlate=new Select(driver.findElementByXPath("(//table[@class='clsTable'])[3]/tbody/tr/td/select"));
    		temlate.selectByVisibleText(temlateText);
    		
    		Actions act=new Actions(driver);
    		
    		if(temlateText.equalsIgnoreCase("Testing - Full Lifecycle - Citi")) {
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[2]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[2]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[2]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[2]/td[5]/input").sendKeys(endDt+taskStartDate);
    		
            
            Thread.sleep(2000);
            
        	act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[1]")).click().build().perform();
               		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[3]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[3]/td[4]/input").sendKeys("01"+taskStartDate);
        	    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[3]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[3]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[2]")).click().build().perform();
    		
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[4]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[4]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[4]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[4]/td[5]/input").sendKeys(endDt+taskStartDate);
    		Select strRvw=new Select(driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[4]/td[7]/select[1]"));
    		strRvw.selectByVisibleText("REHAN RAZZAQUEE");
    		driver.findElementById("IsOffline304").click();
    		
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[5]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[5]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[5]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[5]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[5]")).click().build().perform();
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[6]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[6]/td[4]/input").sendKeys("01"+taskStartDate);
    		
       		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[6]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[6]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[6]")).click().build().perform();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[7]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[7]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[7]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[7]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[7]")).click().build().perform();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[8]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[8]/td[4]/input").sendKeys("01"+taskStartDate);
    		    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[8]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[8]/td[5]/input").sendKeys(endDt+taskStartDate);
    		Select plnRvw=new Select(driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[8]/td[7]/select[1]"));
    		plnRvw.selectByVisibleText("REHAN RAZZAQUEE");
    		driver.findElementById("IsOffline101").click();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[9]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[9]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[9]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[9]/td[5]/input").sendKeys(endDt+taskStartDate);
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[10]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[10]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[10]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[10]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[10]")).click().build().perform();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[11]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[11]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[11]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[11]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[11]")).click().build().perform();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[12]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[12]/td[4]/input").sendKeys("01"+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[13]")).click().build().perform();
    		    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[12]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[12]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[12]")).click().build().perform();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[13]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[13]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[13]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[13]/td[5]/input").sendKeys(endDt+taskStartDate);
    		Select tcRvw=new Select(driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[13]/td[7]/select[1]"));
    		tcRvw.selectByVisibleText("REHAN RAZZAQUEE");
    		driver.findElementById("IsOffline181").click();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[14]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[14]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[14]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[14]/td[5]/input").sendKeys(endDt+taskStartDate);
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[15]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[15]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[15]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[15]/td[5]/input").sendKeys(endDt+taskStartDate);
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[16]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[16]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[16]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[16]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[16]")).click().build().perform();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[17]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[17]/td[4]/input").sendKeys("01"+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[17]")).click().build().perform();
    	
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[17]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[17]/td[5]/input").sendKeys(endDt+taskStartDate);
    		Select exeRvw=new Select(driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[17]/td[7]/select[1]"));
    		exeRvw.selectByVisibleText("REHAN RAZZAQUEE");
    		driver.findElementById("IsOffline379").click();
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[18]/td[4]/input").clear();    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[18]/td[4]/input").sendKeys("01"+taskStartDate);
    		
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[18]/td[5]/input").clear();
    		driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[18]/td[5]/input").sendKeys(endDt+taskStartDate);
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[18]")).click().build().perform();
    		act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[21]")).click().build().perform();
   	
        	
    		}
    		
    		else if(temlateText.equalsIgnoreCase("Testing - Test Execution")) {
    			
    			driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[2]/td[4]/input").clear();    		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[2]/td[4]/input").sendKeys("01"+taskStartDate);
        		
        	
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[2]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[2]/td[5]/input").sendKeys(endDt+taskStartDate);
        		
                Thread.sleep(1000);
                
            	act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[1]")).click().build().perform();
            	
            	driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[3]/td[4]/input").clear();    		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[3]/td[4]/input").sendKeys("01"+taskStartDate);
        		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[3]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[3]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[2]")).click().build().perform();
        	    
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[4]/td[4]/input").clear();    		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[4]/td[4]/input").sendKeys("01"+taskStartDate);
        		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[4]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[4]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[3]")).click().build().perform();
    			
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[5]/td[4]/input").clear();    		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[5]/td[4]/input").sendKeys("01"+taskStartDate);
        		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[5]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[5]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[4]")).click().build().perform();
        	    
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[6]/td[4]/input").clear();    		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[6]/td[4]/input").sendKeys("01"+taskStartDate);
        		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[6]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[6]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[5]")).click().build().perform();
        	    
        	    driver.findElementByXPath("(//input[@class='clsCheckBox'])[2]").click();
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[7]/td[4]/input").clear(); 
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[7]/td[4]/input").sendKeys("01"+taskStartDate);
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[7]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[7]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    Select exeRvw=new Select(driver.findElementByXPath("//table[@name='TasksTable']/tbody/tr[7]/td[7]/select[1]"));
        		exeRvw.selectByVisibleText("REHAN RAZZAQUEE");
        		
        		
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[8]/td[4]/input").clear(); 
         	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[8]/td[4]/input").sendKeys("01"+taskStartDate);
         	    
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[8]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[8]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[8]")).click().build().perform();
        		
        	    
        	    driver.findElementByXPath("(//input[@class='clsCheckBox'])[4]").click();
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[9]/td[4]/input").clear(); 
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[9]/td[4]/input").sendKeys("01"+taskStartDate);
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[9]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[9]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    Select trRvw=new Select(driver.findElementByXPath("//table[@name='TasksTable']/tbody/tr[9]/td[7]/select[1]"));
        	    trRvw.selectByVisibleText("REHAN RAZZAQUEE");
        	    
        	    
        	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[10]/td[4]/input").clear(); 
         	    driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[10]/td[4]/input").sendKeys("01"+taskStartDate);
         	    
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[10]/td[5]/input").clear();
        		driver.findElementByXPath("(//table[@class='clsTable'])[4]/tbody/tr[10]/td[5]/input").sendKeys(endDt+taskStartDate);
        	    act.moveToElement(driver.findElementByXPath("(//option[contains(text(),'ABHISHEK TIWARI')])[11]")).click().build().perform();
        	  
        	    
    		}
        	
        	
        	
        	
    		//Thread.sleep(2000);
    		//driver.findElementByXPath("//table[@id='TasksTable']/tbody/tr[2]/td[4]/input").click();
    		
   /*		for(WebElement date:findElementsByXPath) {
    * (//table[@class='clsTable'])[4]/tbody/tr[2]/td[4]/input
    * (//table[@class='clsTable'])[4]/tbody/tr[2]/td[5]/input
    * (//option[contains(text(),'ABHISHEK TIWARI')])[1]
    * 
    * //*[@id="TasksTable"]/tbody/tr[3]/td[4]/input
    * //*[@id="TasksTable"]/tbody/tr[3]/td[5]/input
    * (//option[contains(text(),'ABHISHEK TIWARI')])[2]
    * 
    * 
    * //*[@id="TasksTable"]/tbody/tr[4]/td[4]/input
    * //*[@id="TasksTable"]/tbody/tr[4]/td[5]/input
    * (//option[contains(text(),'ABHISHEK TIWARI')])[3]
    * 
    * 
    * //*[@id="TasksTable"]/tbody/tr[5]/td[4]/input
    * //*[@id="TasksTable"]/tbody/tr[5]/td[5]/input
    * (//option[contains(text(),'ABHISHEK TIWARI')])[4]
    * 
    * 
    * //*[@id="TasksTable"]/tbody/tr[6]/td[4]/input
    * //*[@id="TasksTable"]/tbody/tr[6]/td[5]/input
    * (//option[contains(text(),'ABHISHEK TIWARI')])[5]
    * 
    * 
    * (//option[contains(text(),'ABHISHEK TIWARI')])[8]
    * 
    * 
    * //table[@name='TasksTable']/tbody/tr[7]/td[7]/select[1] dropdown
    * 
    * 
    * 
    * 
    * 
    * 
	      (//a[@title='Plan Deliverables'])[1] 
	      //table[@id='TasksTable']/tbody/tr[2]/td[4]/input
	      //table[@id='TasksTable']/tbody/tr[2]/td[5]/input
	      //table[@id='TasksTable']/tbody/tr[2]/td[7]/select/option[@title='ABHISHEK TIWARI'] where name can be changed
		  //table[@id='TasksTable']/tbody/tr[3]/td[4]/input
		 * //table[@id='TasksTable']/tbody/tr[3]/td[5]/input
		 * //table[@id='TasksTable']/tbody/tr[3]/td[7]/select/option[@title='ABHISHEK TIWARI'] where name can be changed
		 * //table[@id='TasksTable']/tbody/tr[4]/td[4]/input
		 * //table[@id='TasksTable']/tbody/tr[4]/td[5]/input
		 * (//input[@type='checkbox'])[2]
		 * //table[@id='TasksTable']/tbody/tr[4]/td[7]/select[1] dropdown
		 * //table[@id='TasksTable']/tbody/tr[4]/td[7]/select[2] dropdown
		 * //table[@id='TasksTable']/tbody/tr[8]/td[7]/select[1] dropdown
		 * 
		 * //table[@id='TasksTable']/tbody/tr[13]/td[7]/select[1] dropdown
		 * //table[@id='TasksTable']/tbody/tr[17]/td[7]/select[1] dropdown
		 * //table[@id='TasksTable']/tbody/tr[18]/td[7]/select
		scroll after each 2 row 
		System.out.println("Date is "+date.getText());
		
		******************* Xpath for excecution template dropdown *****************************
	
		(//table[@class='clsTable'])[3]/tbody/tr/td/select
		Testing - Full Lifecycle - Citi default value
		Testing - Test Execution another value
		
	}
	*/
    	
	
	//driver.close(); 
	//driver.switchTo().frame("link");
	//driver.findElementByXPath("//tr[@class='clsTRNavLinks']/td/a[text()='Projects']").click();
	//System.out.println("Name is "+parentFrame.switchTo().);
	
	
	/*//driver.findElementByXPath("//a[text()='Citi_TTS_SteadyState_BFS']").click();
	int x=driver.findElementByXPath("//a[text()='Citi_TTS_SteadyState_BFS']").getLocation().getX();
	int y=driver.findElementByXPath("//a[text()='Citi_TTS_SteadyState_BFS']").getLocation().getY();
	System.out.println("X Cord "+x);
	System.out.println("Y Cord "+y);*/
   // JavascriptExecutor js=(JavascriptExecutor)driver;	
	//js.executeScript("document.getElementById('join8002').click()");
	//driver.findElementById("txtSearch").sendKeys("abc");
	}
	
}
