package nopcommerceadmin.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import nopcommerceadmin.pages.Base;
import nopcommerceadmin.pages.Home;
import nopcommerceadmin.pages.Login;

public class HomeTC extends Base{

	Login l;
	Home p;

	@BeforeClass
	public void init() {
		setup();
		l = new Login();
		p=l.doLogin("admin@yourstore.com", "admin");
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		long id = Thread.currentThread().getId();
        System.out.println("homePagetitle method...Thread id is: " + id);
		String title_homepage = p.verify_HomePage_Title();
		Assert.assertEquals(title_homepage, "Dashboard / nopCommerce administration");
	}
	
	
	@Test(priority=2)
	public void verifyHomePage_Logo() {
		long id = Thread.currentThread().getId();
        System.out.println("homePageLogo method...Thread id is: " + id);
		Boolean appLogo = p.verify_HomePage_Logo();
		Assert.assertTrue(appLogo);
	}
	
	@Test(priority=3,enabled=false)
	public void verifyHomePage_dashBoardtext() {
		long id = Thread.currentThread().getId();
        System.out.println("homePageDashBoard method...Thread id is: " + id);
		WebElement dashbardText= p.verify_HomePage_DashBoardString();
		String txt1=dashbardText.getText();
		//Assert.assertEquals(dashbardText, "Dashboard", "Title doesn't match");
	}
	
	@Test(priority=4)
	public void clickCatalog_Link() {
		long id = Thread.currentThread().getId();
        System.out.println("homePagecatalog method...Thread id is: " + id);
		p.click_Product_under_Catalog();
		System.out.println("clicked on Product");
	}
	
	@AfterClass
	public void tear() {
		tearDown();
	}
}