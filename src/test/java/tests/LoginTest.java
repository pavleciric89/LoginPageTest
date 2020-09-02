package tests;

import base.BaseUtil;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends BaseUtil {

    @Test
    public void TC_ETS_Login_001(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("admin@eryce.com");
        loginPage.enterPassword("Asdasd12#");
        loginPage.clickOnLoginButton();
        test.log(Status.INFO, "Valid credentials");
        Assert.assertTrue(loginPage.successfulLoginMessage());

    }
    @Test
    public void TC_ETS_Login_002(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("admin@eryce.com");
        loginPage.enterPassword("Asdasd123#");
        loginPage.clickOnLoginButton();
        test.log(Status.INFO, "Enter a valid Email and invalid Password (to contain capital letter and numerical character)");
        Assert.assertFalse(loginPage.successfulLoginMessage());

    }
    @Test
    public void TC_ETS_Login_003(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("admin1@eryce.com");
        loginPage.enterPassword("Asdasd12#");
        loginPage.clickOnLoginButton();
        test.log(Status.INFO, "Enter a invalid Email and valid Password");
        Assert.assertFalse(loginPage.successfulLoginMessage());
    }
    @Test
    public void TC_ETS_Login_004(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("adminadmin@eryce.com");
        loginPage.enterPassword("Asdasdasd12#");
        loginPage.clickOnLoginButton();
        test.log(Status.INFO, "Enter a invalid Email and invalid Password (to contain capital letter and numerical character)");
        Assert.assertFalse(loginPage.successfulLoginMessage());
    }
    @Test
    public void TC_ETS_Login_005(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("Asdasd12#");
        test.log(Status.INFO, "Leave the Email field blank and enter a valid Password");
        Assert.assertFalse(loginPage.isEnabledLogin());
    }
    @Test
    public void TC_ETS_Login_006(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("adminadmin@eryce.com");
        test.log(Status.INFO, "Enter a valid Email and leave the Password field blank");
        Assert.assertFalse(loginPage.isEnabledLogin());
    }
    @Test
    public void TC_ETS_Login_007(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("admin@eryce.com");
        loginPage.enterPassword("Asdasd12#");
        loginPage.pressEnterToLogin();
        test.log(Status.INFO, "Verify if the 'Enter' key of the keyboard is working correctly on the login page, with a valid credentials");
        Assert.assertTrue(loginPage.successfulLoginMessage());
    }
    @Test
    public void TC_ETS_Login_008(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("admin@eryce.com");
        loginPage.enterPassword("asdasd12#");
        loginPage.clickOnLoginButton();
        test.log(Status.INFO, "Enter a valid Email and invalid Password without required capital letter");
        Assert.assertFalse(loginPage.successfulLoginMessage());
    }
    @Test
    public void TC_ETS_Login_009(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("admin@eryce.com");
        loginPage.enterPassword("Asdasdasd#");
        loginPage.clickOnLoginButton();
        test.log(Status.INFO, "Enter a valid Email and invalid Password without required numerical character");
        Assert.assertFalse(loginPage.successfulLoginMessage());
    }
    @Test
    public void TC_ETS_Login_010(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("asdasd12#");
        test.log(Status.INFO, "Verify if the data in Password field is masked");
        Assert.assertTrue(loginPage.isPasswordMasked());
    }

}

