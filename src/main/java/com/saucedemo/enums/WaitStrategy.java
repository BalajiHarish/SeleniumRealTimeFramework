package com.saucedemo.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 *
 * @author Balaji
 * @see com.saucedemo.factories.ExplicitWaitFactory
 * @see com.saucedemo.pages.BasePage
 */

public enum WaitStrategy {

    CLICKABLE,
    PRESENT,
    VISIBLE,
    NONE
}
