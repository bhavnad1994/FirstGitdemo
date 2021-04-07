package nopcommerceadmin.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import nopcommerceadmin.pages.Base;
import nopcommerceadmin.pages.Home;
import nopcommerceadmin.pages.Login;

public class LoginTC extends Base {
	Login l;
	Home h;
		
	public LoginTC() {
		super();
	}
	
	@BeforeClass
	public void init() {
		setup();
		l=new Login();
	}
	
	@Test(priority=1)
	public void loginTest() {
		long id = Thread.currentThread().getId();
        System.out.println("Login page Title method...Thread id is: " + id);
		//l.doLogin("admin@yourstore.com","admin");
		h=l.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
