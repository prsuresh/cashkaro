package ckpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ForgotPasswordPage {
	protected WebDriver driver;
	private By signInButton = By.linkText("SIGN IN");
	
	//private By joinFreeButton=By.linkText("JOIN FREE");
	
	private By createAccountLink = By.id("link-signup");
	private By emailTextBox = By.id("Email");
	private By passwordTextBox = By.id("Passwd");
	private By loginBtn = By.id("signIn");
	private By errorMsgTxt = By.id("errormsg_0_Passwd");
	private By joinFreeButon= By.linkText("JOIN FREE");
	private By forgotPwd=By.linkText("Forgot Password?");
    private  By fromEmail=By.id("from_email");
	
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public  void clickForgotPwdBtn() {
		System.out.println("clicking on Forgot Password button");
		WebElement signInBtnElement=driver.findElement(forgotPwd);
		if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
			signInBtnElement.click();
		else System.out.println("Element not found");
		//return new SignInPage(driver);
	}
	
	public  void clickJoinBtn() {
		System.out.println("clicking on Join Free button");
		WebElement signInBtnElement=driver.findElement(joinFreeButon);
		if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
			signInBtnElement.click();
		else System.out.println("Element not found");
		//return new SignInPage(driver);
	}
	
	
	public void clickImagesLink() {
		//It should have a logic to click on images link
		//And it should navigate to google images page
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle="Google";
		return getPageTitle().contains(expectedPageTitle);
	}
}

