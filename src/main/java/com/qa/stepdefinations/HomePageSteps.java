package com.qa.stepdefinations;

import static com.qa.util.TestBase.prop;

import com.qa.pages.ErkekPage;
import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import cucumber.api.java.en.Then;

import java.io.IOException;

public class HomePageSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ErkekPage erkekPage = new ErkekPage();

    @Then("^user is on login page$")
    public void user_is_on_login_page() {

        Assert.assertEquals(true, homePage.getTitlePage().contains("Erkek Giyim, Erkek Kıyafetleri, Erkek Modası | Trendyol"));
        homePage.openLoginPopUp();


    }

    @Then("^user enter username and password$")
    public void user_enters_username_and_password() throws InterruptedException {

        //Assert.assertEquals(true, loginPage.checkLoginPopUp().contains("Hemen Üye Ol"));


        loginPage.setEmail();
        loginPage.setPassword();
        loginPage.clickLoginButton();

        Thread.sleep(3000);

        homePage.accountNavigation();

        Assert.assertEquals(true, homePage.checkOrders());


    }


    @Then("^close the main popup$")
    public void closeTheMainPopup() throws InterruptedException {

        homePage.closePopUp();

        Thread.sleep(10000);
    }

    @Then("^user enter username without password$")
    public void userEnterEmailWithoutPassword() throws InterruptedException {

        loginPage.setEmail();
        loginPage.clickLoginButton();

        Thread.sleep(3000);

        homePage.accountNavigation();

        Assert.assertEquals(true, homePage.checkOrders());
    }


    @Then("^go to man butique$")
    public void goToManButique() throws IOException {

        erkekPage.goToManButique();

        erkekPage.checkAllManButiqueUrl();

    }


}