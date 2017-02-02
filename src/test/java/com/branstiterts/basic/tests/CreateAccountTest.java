package com.branstiterts.basic.tests;

import com.branstiterts.basic.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class CreateAccountTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void createAccount() {
        HomePage home = new HomePage(driver);
        home.clickLoginButton().createNewAccount().setPersonalInfoForm();
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
