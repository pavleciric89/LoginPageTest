package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseUtil {

    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 5);
    }

    By emailInputField = By.id("qaEmail");
    By passInputField = By.id("qaPassword");
    By loginBtn = By.className("login_btn");
    By successfulLoginMessage = By.className("welcome_message");
    By backToLoginBtn = By.className("back_to_login_btn");



    public void enterEmail(String Email){
        driver.findElement(emailInputField).sendKeys(Email);
    }
    public void enterPassword(String Password){
        driver.findElement(passInputField).sendKeys(Password);
    }
    public boolean isPasswordMasked(){
        return (driver.findElement(By.id("qaPassword")).getAttribute("type").equals("password"));
    }
    public void clickOnLoginButton(){
        driver.findElement(loginBtn).click();
    }
    public void pressEnterToLogin(){
        driver.findElement(By.className("login_btn")).sendKeys(Keys.RETURN);
    }
    public void clickOnBackToLoginButton(){
        driver.findElement(backToLoginBtn).click();
    }
    public boolean successfulLoginMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulLoginMessage)).isDisplayed();
    }

    public boolean isEnabledLogin() {
        return  driver.findElement(By.className("login_btn")).isEnabled();
    }


}
