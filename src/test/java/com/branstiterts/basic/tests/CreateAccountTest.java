package com.branstiterts.basic.tests;

import com.branstiterts.basic.objects.UserAccount;
import com.branstiterts.basic.pages.HomePage;
import org.testng.annotations.Test;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class CreateAccountTest extends BaseTest {

    @Test(dataProvider = "accountData")
    public void createAccount(String firstName, String lastName, String email, String password,
                              String dobDay, String dobMonth, String dobYear, String address,
                              String city, String state, String zipCode, String phoneNumber) throws Exception {
        // Create a new user account with the information from our data provider
        UserAccount userAccount = new UserAccount(firstName, lastName, email, password, dobDay, dobMonth, dobYear, address, city, state, zipCode, phoneNumber);

        HomePage home = new HomePage(driver);
        home.clickLoginButton().createNewAccount(userAccount.getEmail()).setPersonalInfoForm(userAccount);
    }
}
