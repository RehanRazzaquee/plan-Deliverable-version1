package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class ThirdClass extends ProjectMethods{
	SecondClass sc=new SecondClass();
	public ThirdClass() {
				PageFactory.initElements(driver, this);
		}
	
	@FindBy(how=How.XPATH,using = "//div[@class='amount red']/div ")
	private WebElement cartPrice;

	public ThirdClass cartPrice() {
		
		String r=getText(cartPrice);
		System.out.println(r);
		r=r.replace(",","");
		if(SecondClass.s.equals(r)) {
		System.out.println("Price is successfully Validated");
		}
		else 
		System.out.println("Price doesn't match");
		return this;
	}	
	
		
	}

