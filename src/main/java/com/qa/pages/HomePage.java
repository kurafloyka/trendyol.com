package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase {


    @FindBy(xpath = "//i[@class='icon navigation-icon-user']")
    @CacheLookup
    WebElement loginPopUpButton;

    @FindBy(xpath = "//*[@id=\"popupContainer\"]/div/div[2]/a/span[1]")
    @CacheLookup
    WebElement closeManPopUp;


    public void openLoginPopUp() {

        loginPopUpButton.click();
    }

    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    @FindBy(xpath = "//i[@class='icon navigation-icon-user']")
    WebElement account;


    @FindBy(xpath = "//a[text()=' Siparişlerim ']")
    WebElement orders;


//	public void clickOnUpdateInformationLink() {
//		Actions action = new Actions(driver);
//		action.moveToElement(accountLink).build().perform();
//		updateUserName.click();
//
//	}


    public String getTitlePage() {

        return driver.getTitle();

    }


    public void closePopUp() {

        closeManPopUp.click();

    }


    public void accountNavigation() {


        Actions action = new Actions(driver);
        action.moveToElement(account).build().perform();
    }

    public Boolean checkOrders() {


        return orders.isDisplayed();

    }

}
