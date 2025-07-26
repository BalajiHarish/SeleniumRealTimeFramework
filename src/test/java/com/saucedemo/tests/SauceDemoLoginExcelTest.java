package com.saucedemo.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import com.saucedemo.annotations.FrameworkAnnotations;
import com.saucedemo.enums.TestCategories;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class SauceDemoLoginExcelTest extends BaseTest {

    private SauceDemoLoginExcelTest() {
    }

    private LoginPage loginPage;
    private MenuPage menuPage;
    private InventoryPage inventoryPage;

    //@FrameworkAnnotations(testCategories = {TestCategories.SMOKE}) //-> This is used in extent reports but since allure report does not support this, we are not using this annotation here.
    @Test
    @Description("Verify that user can log in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Functionality")
    public void loginAndLogoutTest1(Map<String, String> data) throws InterruptedException {

        loginPage = new LoginPage();
        menuPage = new MenuPage();
        inventoryPage = new InventoryPage();

        loginPage.enterUserName(data.get("username"));
        loginPage.enterPassword(data.get("password"));
        loginPage.clickLoginButton();
        Thread.sleep(5000);

        Assertions.assertThat(inventoryPage.getInventoryPageURL())
                .isEqualTo("https://www.saucedemo.com/inventory.html");

        menuPage.openMenuBar();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        menuPage.clickLogoutButton();
        Assertions.assertThat(loginPage.getLoginPageTitle())
                .isEqualTo("Swag Labs");
    }

    //@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class) //-> This is handled using Annotation Transformer Listener
    //@FrameworkAnnotations(testCategories = {TestCategories.REGRESSION})
    @Test
    @Description("Verify that user can log in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Functionality")
    public void loginAndLogoutTest2(Map<String, String> data) {

        loginPage = new LoginPage();
        menuPage = new MenuPage();
        inventoryPage = new InventoryPage();

        loginPage.enterUserName(data.get("username"));
        loginPage.enterPassword(data.get("password"));
        loginPage.clickLoginButton();

        Assertions.assertThat(inventoryPage.getInventoryPageURL())
                .isEqualTo("https://www.saucedemo.com/inventory.html");

        menuPage.openMenuBar();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        menuPage.clickLogoutButton();
        Assertions.assertThat(loginPage.getLoginPageTitle())
                .isEqualTo("Swag Labs");
    }

}
