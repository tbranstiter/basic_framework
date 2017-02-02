package com.branstiterts.basic.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class LoginPage {
    final static Logger logger = Logger.getLogger(LoginPage.class);

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-heading")
    private WebElement heading;

    @FindBy(id = "email_create")
    private WebElement userEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement submitEmailButton;

    public boolean isPageLoaded() {
        return heading.getText().contains("AUTHENTICATION");
    }

    public CreateAccountPage createNewAccount(String email) {
        logger.debug("Entering the email for the account to be created");
        userEmail.sendKeys(email);
        submitEmailButton.click();
        return PageFactory.initElements(driver, CreateAccountPage.class);
    }
}
