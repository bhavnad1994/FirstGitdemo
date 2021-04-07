package nopcommerceadmin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {

	@FindBy(id = "Email")
	public WebElement txt_email;

	@FindBy(id = "Password")
	public WebElement txt_password;

	@FindBy(xpath = "//button[text()='Log in']")
	public WebElement btn_login;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public Home doLogin(String u, String p) {
		txt_email.clear();
		txt_email.sendKeys(u);
		txt_password.clear();
		txt_password.sendKeys(p);
		btn_login.click();

		return new Home();
	}

}
