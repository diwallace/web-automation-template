package br.com.utils;

import org.openqa.selenium.WebDriver;

public class TestContext {
    public static WebDriver driver;

    public static void clearContext() {
        driver = null;
    }

    public static String getEnvironment() {
        if(System.getProperty("environment").equals("qa") || System.getProperty("environment").equals(null)) {
            return Environment.qa.getBaseUri();
        } else {
            return Environment.dev.getBaseUri();
        }
    }
}
