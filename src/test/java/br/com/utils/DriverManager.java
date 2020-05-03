package br.com.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private WebDriver driver;
    private String baseUri;

    public DriverManager(String baseUri) {
        this.setSystemProperty();
        this.driver = new ChromeDriver();
        this.baseUri = baseUri;

        this.openBrowser();
    }

    public DriverManager(String baseUri, long implicitwait, long pageLoadWait, long scriptWait) {
        this.setSystemProperty();
        this.setup();
        this.baseUri = baseUri;

        this.openBrowser();
        this.setImplicitWait(implicitwait);
        this.setPageLoadWait(pageLoadWait);
        this.setScriptWait(scriptWait);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--headless");
        this.driver = new ChromeDriver(chromeOptions);
    }

    private void openBrowser() {
        this.openUri();
        this.maximizeWindow();
    }

    private void setSystemProperty() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/br/com/driver/chromedriver.exe");
    }

    private void openUri() {
        this.driver.get(baseUri);
    }

    private void maximizeWindow() {
        this.driver.manage().window().setSize(new Dimension(1440, 900));
    }

    private void setImplicitWait(long time) {
        this.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    private void setPageLoadWait(long time) {
        this.driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    private void setScriptWait(long time) {
        this.driver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
    }
}
