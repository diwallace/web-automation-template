package br.com.stepdefinitions;

import br.com.utils.TestContext;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @AfterStep
    public void stepPrint(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot)TestContext.driver).getScreenshotAs(OutputType.BYTES);

        scenario.embed("<pre>".getBytes(), "text/html");
        scenario.embed(screenshot, "image/png");
        scenario.embed("</pre>".getBytes(), "text/html");
    }
}
