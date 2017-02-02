package com.branstiterts.basic.objects;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class UserAccount {
    String firstName;
    String lastName;
    String email;
    String password;
    String dobDay;
    String dobMonth;
    String dobYear;
    String address;
    String city;
    String state;
    String zipCode;
    String phoneNumber;

    public UserAccount (String firstName, String lastName, String email, String password,
                        String dobDay, String dobMonth, String dobYear, String address,
                        String city, String state, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dobDay = dobDay;
        this.dobMonth = dobMonth;
        this.dobYear = dobYear;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDobDay() {
        return dobDay;
    }

    public String getDobMonth() {
        return dobMonth;
    }

    public String getDobYear() {
        return dobYear;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
