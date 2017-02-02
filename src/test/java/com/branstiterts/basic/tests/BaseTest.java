package com.branstiterts.basic.tests;

import com.branstiterts.basic.utility.Constant;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tbranstiter on 2/2/2017.
 */
public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @DataProvider(name = "accountData")
    public Iterator<Object[]> provider() throws InterruptedException, FileNotFoundException, IOException {
        List<Object[]> testCases = new ArrayList<Object[]>();
        String[] data = null;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(Constant.ACCOUNT_DATA_CSV));
            String line;

            // Skip first line (header line)
            String headerLine = br.readLine();

            while((line = br.readLine()) != null) {
                data = line.split(Constant.DELIMITER);
                testCases.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return testCases.iterator();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
