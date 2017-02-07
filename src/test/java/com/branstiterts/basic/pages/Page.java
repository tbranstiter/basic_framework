package com.branstiterts.basic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tbranstiter on 2/3/2017.
 */
public interface Page {

    <T> T goTo();

    static <T> T get(WebDriver driver, Class<T> myClass) {
        return PageFactory.initElements(driver, myClass);
    }
}
