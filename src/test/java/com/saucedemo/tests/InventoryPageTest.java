package com.saucedemo.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.MenuPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public final class InventoryPageTest extends BaseTest {

    private InventoryPageTest() {}

    LoginPage loginPage = new LoginPage();
    MenuPage menuPage = new MenuPage();
    InventoryPage inventoryPage = new InventoryPage();

    @Test(priority = 0)
    public void login() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Test(priority = 1)
    public void landing() {
        Assertions.assertThat(inventoryPage.getInventoryPageURL())
                .isEqualTo("https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 2)
    public void logout() {
        menuPage.openMenuBar();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        menuPage.clickLogoutButton();
        Assertions.assertThat(loginPage.getLoginPageTitle())
                .isEqualTo("Swag Labs");
    }
}
