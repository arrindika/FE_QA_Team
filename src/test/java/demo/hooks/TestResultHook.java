package demo.hooks;

import demo.webdriver.WebdriverInstance;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Scanner;

public class TestResultHook {

    @After
    public void screenshootIfFailed(Scenario scenario){
        if(scenario.isFailed()){
            scenario
                    .embed(((TakesScreenshot) WebdriverInstance.webdriver).getScreenshotAs(OutputType.BYTES), "image/png");
            scenario.write("Scenario Fail");
        }
    }
}
