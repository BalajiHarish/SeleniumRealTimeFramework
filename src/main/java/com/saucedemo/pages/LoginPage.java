package com.saucedemo.pages;

import com.saucedemo.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    private final By textboxUsername = By.xpath("//input[@placeholder='Username']");
    private final By textboxPassword = By.xpath("//input[@placeholder='Password']");
    private final By buttonLogin = By.xpath("//input[@value='Login']");

    public void enterUserName(String username) {
        enterText(textboxUsername, username, WaitStrategy.PRESENT, "username_textbox");
    }

    public void enterPassword(String password) {
        enterText(textboxPassword, password, WaitStrategy.PRESENT, "password_textbox");
    }

    public void clickLoginButton() {
        click(buttonLogin, WaitStrategy.CLICKABLE, "login_button");
    }

    public String getLoginPageTitle() {
        return getPageTitle();
    }
}
