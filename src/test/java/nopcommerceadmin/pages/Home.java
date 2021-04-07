package nopcommerceadmin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends Base {

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/h1") 
	public WebElement txt_dashboard;
	
	@FindBy(xpath = "/html/body/div[3]/aside/a/img[1]")
	public WebElement logo;

	@FindBy(xpath = "(//a[@class='nav-link']/p[contains(text(),'Catalog')])[1]")
	public WebElement txt_Catalog;

	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/ul/li[1]/a/p")
	public WebElement txt_product;
	

	public Home() {
		PageFactory.initElements(driver, this);
	}

	public String verify_HomePage_Title() {
		return driver.getTitle();
	}

	public WebElement verify_HomePage_DashBoardString() {
		return txt_dashboard;
	}

	
	public boolean verify_HomePage_Logo() {
		return logo.isDisplayed();
		
	}
	
	public Product click_Product_under_Catalog() {
		txt_Catalog.click();
		txt_product.click();
		
		return new Product();
	}
	
	
}