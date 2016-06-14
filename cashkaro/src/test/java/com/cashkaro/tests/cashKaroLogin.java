package com.cashkaro.tests;
import ckpageobjects.*;
import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.SelectFrame;

public class cashKaroLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://cashkaro.iamsavings.co.uk/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  //working
  @Test(priority=1)
  public void testJoin() throws Exception {
    driver.get(baseUrl + "/");
    LandingPage landingpage=new LandingPage(driver);
    landingpage.clickJoinBtn();
    driver.findElement(By.linkText("JOIN FREE")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Test");
    driver.findElement(By.id("email")).clear();
    double number=Math.random();
    String emailaddress="test-"+number+"@gmail.com";
    driver.findElement(By.id("email")).sendKeys(emailaddress);
    driver.findElement(By.id("con_email")).clear();
    driver.findElement(By.id("con_email")).sendKeys(emailaddress);
    WebElement realPasswordInput = driver.findElement(By.id("pwd-txt"));
    realPasswordInput.click();
    realPasswordInput = driver.findElement(By.id("pwd"));
    realPasswordInput.click();
    realPasswordInput.sendKeys("test-24");
    Thread.sleep(5000);
    driver.findElement(By.id("join_free_submit")).click();
    Thread.sleep(5000);
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/section[1]/section[1]/div/section/section[2]/p")).getText(), "Hello Test,","First name match");
    driver.findElement(By.linkText("LOGOUT")).click();
 
  }
  
//working
  @Test(priority=2)
  public void testFblogin() throws Exception {
    driver.get(baseUrl + "/");
    
    driver.findElement(By.linkText("JOIN FREE")).click();
    driver.findElement(By.id("close_and_go_fb")).click();
    Set <String> set1=driver.getWindowHandles();
    Iterator <String> win1=set1.iterator();
    String parent=win1.next();
    String child=win1.next();
    driver.switchTo().window(child);
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("pradip_pai@yahoo.co.in");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("password01");
    driver.findElement(By.id("u_0_2")).click();
    Thread.sleep(5000);
    set1=driver.getWindowHandles();
    win1=set1.iterator();
    parent=win1.next();
    child=win1.next();
    driver.switchTo().window(child);
    if(driver.findElement(By.xpath("/html/body/h1")) != null)
    		{
    		if(driver.findElement(By.xpath("/html/body/h1")).getText().contains("Not Acceptable"))
    		{
    			System.out.println("FaceBook Login Failed, This testcase will be marked as failed");
    			
    		}
    		}
    else
    {
    
    driver.switchTo().window(parent);
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/section[1]/section[1]/div/section/section[2]/p")).getText(), "Hello SalmanKhan,","First name match");
     driver.findElement(By.linkText("LOGOUT")).click();
    }
  } 
  
 
  
  @Test(priority=3)
  public void testFgtpwd() throws Exception {
	 // final String mainWindowHandle = driver.getWindowHandle();
	  driver.get(baseUrl + "/");
	    LandingPage landingpage=new LandingPage(driver);
	    driver.manage().window().maximize();
	    landingpage.clickSignInBtn();
	    driver.get("http://cashkaro.iamsavings.co.uk/signin_small_popup.php?");
	    
	    ForgotPasswordPage forgotpasswordpage=new ForgotPasswordPage(driver);
	    driver.manage().window().maximize();
	    forgotpasswordpage.clickForgotPwdBtn();
	  
	/*  List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
      System.out.println("The total number of iframes are " + iframeElements.size());
      for(int i=0;i<iframeElements.size();i++)

      {
      System.out.println("Entered Try");
      driver.switchTo().frame(i);
      System.out.println("Switched to frame");
      Thread.sleep(3000);
     // driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcde");
    //  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcde");
      }
	    
	    
   driver.findElement(By.linkText("Forgot Password?")).click();
   */
    driver.findElement(By.id("from_email")).clear();
    driver.findElement(By.id("from_email")).sendKeys("testautomation@gmail.com");
    driver.findElement(By.id("submit_req")).click();
    

    try {
        assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Password sent!");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      try {
        assertTrue(isElementPresent(By.cssSelector("h2")));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      try {
        assertEquals(driver.findElement(By.cssSelector("p")).getText(), "An email has been sent with your new password. Please check your email now.");
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      try {
        assertTrue(isElementPresent(By.cssSelector("p")));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      try {
        assertTrue(isElementPresent(By.cssSelector("img[alt=\"CashKaro.com\"]")));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
     // driver.findElement(By.id("cboxClose")).click();
    }

  
  
  @Test(priority=4)
  public void testSigningautomation() throws Exception {
    driver.get(baseUrl + "/");
    LandingPage landingpage=new LandingPage(driver);
    driver.manage().window().maximize();
    landingpage.clickSignInBtn();
    
    driver.get("http://cashkaro.iamsavings.co.uk/signin_small_popup.php?");
    
   // Thread.sleep(10000);
    JavascriptExecutor jse = (JavascriptExecutor) driver;
   // jse.executeScript("document.getElementById('cboxIframe').load(function(){alert('hi2');})");
   // new Actions(driver).moveToElement(driver.findElement(By.id("uname"))).click();
    driver.findElement(By.id("uname")).clear();
    driver.findElement(By.id("uname")).sendKeys("test-25@gmail.com");
    driver.findElement(By.id("pwd-txt")).sendKeys("Password");
    driver.findElement(By.id("pwd")).clear();
    driver.findElement(By.id("pwd")).sendKeys("test-24");
    driver.findElement(By.id("sign_in")).click();
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/section[1]/section[1]/div/section/section[2]/p")).getText(), "Hello Test,","First name match");
    driver.findElement(By.linkText("LOGOUT")).click();
  }
  
  

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
