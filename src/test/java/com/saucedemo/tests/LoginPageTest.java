package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest {

    public LoginPageTest() {}

    LoginPage loginPage = new LoginPage();

    @Test
    public void login() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
}
