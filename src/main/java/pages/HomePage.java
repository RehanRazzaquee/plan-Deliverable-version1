package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import wdMethods.ProjectMethods;

public class HomePage extends ProjectMethods{
	
	

	public HomePage() {		
		PageFactory.initElements(driver,this);
	}	

	@FindBy(how=How.XPATH,using="//*[@id='desktop-header-cnt']/div[2]/div[3]/input")
	private WebElement search;

	public HomePage searchSunglasses() {
		//WebElement eleLogin = locateElement("class","decorativeSubmit");
		type(search, "Sunglasses");
		return this;		
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='desktop-submit']/span")
	private WebElement searchButton;

	public HomePage searchClick() {
		click(searchButton);
		return this;		
	}

	@FindBy(how=How.XPATH,using="(//label[@class='common-customRadio vertical-filters-label'])[5]")
	private WebElement sortPercentage;

	public HomePage percentage() {
		click(sortPercentage);
		return this;		
	}

	
	
	@FindBy(how=How.XPATH,using = "//label[@style='background-color: rgb(94, 177, 96);']")
	private WebElement color;

	public HomePage choseColor() throws InterruptedException {
		Thread.sleep(3000);
		click(color);
		System.out.println(driver.findElementsByXPath("//h4[contains(text(),'Unisex')]/following::span[4][contains(text(),'(40% OFF)')]").size());
		return this;
	}
	@FindBy(how=How.XPATH,using = "(//li[@class='product-base'][2])")
	private WebElement secondItem;

	public SecondClass second() {
		click(secondItem);
		return new SecondClass();
	}
	
	


}
