package nopcommerceadmin.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import nopcommerceadmin.pages.Base;
import nopcommerceadmin.pages.Home;
import nopcommerceadmin.pages.Login;
import nopcommerceadmin.pages.Product;

public class ProductTC extends Base {
	Login l;
	Home p;
	Product prod;
	
	public ProductTC(){
		super();
	}

	@BeforeClass
	public void init() {
		setup();
		l = new Login();
		p = l.doLogin("admin@yourstore.com", "admin");
		prod = p.click_Product_under_Catalog();
	}

	@Test(priority = 1)
	public void Producttitle() {
		long id = Thread.currentThread().getId();
        System.out.println("Product Page title method...Thread id is: " + id);
		String prodtitle = prod.getProductTitle();
		//System.out.println("Product Page Title" + prodtitle);
		Assert.assertEquals(prodtitle, "Products / nopCommerce administration");
		
	}

	@Test(priority = 2)
	public void Producttxt() {
		long id = Thread.currentThread().getId();
        System.out.println("Product Page txt method...Thread id is: " + id);
		String txt2=prod.getProductpage_txt();
		//System.out.println("product page text" +  txt2);
		Assert.assertEquals(txt2, "Products");
		
	}
	
	
	@Test
	public void getProdDetails(String Pname){
		long id = Thread.currentThread().getId();
        System.out.println("Product Page Prod Details method...Thread id is: " + id);
		prod.setProdDetails(Pname);
		
		}
	
		
	
	@AfterClass
	public void tear() {
		tearDown();
	}
}
