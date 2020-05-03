package br.com.stepdefinitions;

import br.com.utils.DriverManager;
import br.com.utils.TestContext;
import io.cucumber.java.pt.Dado;
import org.openqa.selenium.WebDriver;

public class BasicSteps {
    @Dado("que eu acesso o site")
    public void queEuAcessoOSite() {
        WebDriver driver = new DriverManager(TestContext.getEnvironment(), 10, 10, 10).getDriver();
        TestContext.driver = driver;
    }
}
