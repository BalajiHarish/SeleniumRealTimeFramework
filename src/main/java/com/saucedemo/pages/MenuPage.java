package com.saucedemo.pages;

import com.saucedemo.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class MenuPage extends BasePage {

    private final By buttonMenus = By.id("react-burger-menu-btn");
    private final By buttonLogout = By.xpath("//a[text()='Logout']");

    public void openMenuBar() {
        click(buttonMenus, WaitStrategy.CLICKABLE, "menus_button");
    }

    public void clickLogoutButton() {
        click(buttonLogout, WaitStrategy.CLICKABLE, "logout_button");
    }

}
