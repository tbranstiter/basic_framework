package com.branstiterts.basic.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.branstiterts.basic.utility.Constant;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class HomePage implements Page {
    final static Logger logger = Logger.getLogger(HomePage.class);

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className = "login")
    private WebElement loginButton;

    public LoginPage clickLoginButton() {
        logger.debug("Clicking the login button");
        loginButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    @Override
    public HomePage goTo() {
        logger.debug("Browsing to the following URL: " + Constant.URL);
        driver.get(Constant.URL);
        return this;
    }
}
