package com.branstiterts.basic.tests;

import com.branstiterts.basic.objects.UserAccount;
import com.branstiterts.basic.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.log4j.Logger;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class CreateAccountTest extends BaseTest {
    final static Logger logger = Logger.getLogger(CreateAccountTest.class);

    @Test(dataProvider = "accountData")
    public void createAccount(String firstName, String lastName, String email, String password,
                              String dobDay, String dobMonth, String dobYear, String address,
                              String city, String state, String zipCode, String phoneNumber) throws Exception {

        // Create a new user account with the information from our data provider
        logger.info("Creating a new user account...");
        UserAccount userAccount = new UserAccount(firstName, lastName, email, password, dobDay, dobMonth, dobYear, address, city, state, zipCode, phoneNumber);

        HomePage home = new HomePage(driver);
        home.clickLoginButton().createNewAccount(userAccount.getEmail()).setPersonalInfoForm(userAccount);
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"), "Account creation was NOT successful!");
        logger.info("Account creation is complete and has been successful!");
    }
}
