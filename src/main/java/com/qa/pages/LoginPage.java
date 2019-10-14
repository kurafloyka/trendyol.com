package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase {


    // Page Factory - OR:
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "loginSubmit")
    WebElement loginBtn;




    // Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String checkLoginPopUp() {

        return driver.getPageSource();

    }


    public void setEmail() {

        email.sendKeys(prop.getProperty("email"));
    }

    public void setPassword() {


        password.sendKeys(prop.getProperty("password"));
    }


    public void setPassword(String i) {

        password.sendKeys(i);
    }

    public void clickLoginButton() {


        loginBtn.click();
    }




}
