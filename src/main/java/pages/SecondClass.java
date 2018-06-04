package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class SecondClass extends ProjectMethods{
	static String s;
	
	public SecondClass() {
				PageFactory.initElements(driver, this);
		}
	
	@FindBy(how=How.XPATH,using = "//p[@class='pdp-selling-price']/strong")
	private WebElement price1;

	public SecondClass fetchPrice1() {
		s=getText(price1);
		System.out.println(s);
		return this;
	}	
	@FindBy(how=How.XPATH,using = "//span[text()='ADD TO BAG']")
	private WebElement addToBag;

	public SecondClass addToBag() {
		click(addToBag);
		return this;
		}
	@FindBy(how=How.XPATH,using = "//span[@class='myntraweb-sprite desktop-iconBag sprites-bag']")
	private WebElement openBag;

	public ThirdClass openBag() throws InterruptedException {
		Thread.sleep(3000);
		click(openBag);
		return new ThirdClass();
		}
	
		
}
