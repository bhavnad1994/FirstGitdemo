package nopcommerceadmin.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Product extends Base {
	
	public Product() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//h1[@class='float-left']")
	public WebElement txt_Product;

	@FindBy(xpath = "//select[@id='SearchCategoryId']")
	public WebElement dropdown_category ;
	
	public String getProductTitle() {
		return driver.getTitle();
	}
	
	public String getProductpage_txt() {
		return txt_Product.getText();
				
	}
	
	
	@FindBy(id="SearchProductName")
	public WebElement txt_ProductName;
	
	@FindBy(id="SearchCategoryId")
	public WebElement txt_category;
	
	@FindBy(id="go-to-product-by-sku")
	public WebElement btn_go;
	
	public void click_go_button_on_Product() {
		btn_go.click();
	}
	
	public void setProdDetails(String pname) {
		txt_ProductName.clear();
		txt_ProductName.sendKeys(pname);
		click_go_button_on_Product();
	}
	
	public static void select_Option_In_DropDown_ByVisibleText(WebElement element, String sVisibleTextOptionToSelect) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(sVisibleTextOptionToSelect);
           
        } catch (NoSuchElementException e) {
            System.out.println("Option value not find in dropdown");
        
        }
    }
	
	public static void select_Option_In_DropDown_ByValue(WebElement element, int indexVal) {
        try {
            Select select = new Select(element);
            select.selectByIndex(indexVal);
        } catch (NoSuchElementException e) {
            System.out.println("Option value not find in dropdown");
        }
    }
	
	public static boolean verify_Values_In_Dropdown(List<WebElement> listOfElements, String[] strValues) {
		boolean bValue=false;
		List<String> list = new ArrayList<String>();
		for (String strValue : strValues) {
			boolean bflag = false;
			for (WebElement element : listOfElements) {
				String elementValue = element.getText();
				if (strValue.equals(elementValue)) {
					bflag= true;
				}
			}
			if (!bflag)
				list.add(strValue);
		}
		if (list.size() > 0) {
			for(String strList : list) {
				System.out.println("Value not present in dropdown: "+strList);
			}
			//Assign false if any of the value not found in dropdown
			bValue = false;
		} else {
			//Assign true if all values found in dropdown
			System.out.println("All value(s) found in dropdown");
			bValue=true;
		}
		return bValue;
	}
}
