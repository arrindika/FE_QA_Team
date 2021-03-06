package demo.webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class WebdriverInstance {

  public static WebDriver webdriver;

  public static void initialize() {
    ChromeOptions options = new ChromeOptions();
    //set chromeOptions. You can check here: https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--incognito", "--start-maximized");
    //set desired capabilities
    options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
    options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
    //instantiate webdriver
    webdriver = new ChromeDriver(options);
    //maximize kalo pake mac gbisa maximize
    webdriver.manage().window().maximize();
    //set implicit wait
    webdriver.manage().timeouts()
        .implicitlyWait(5, TimeUnit.SECONDS);
  }

  public static void quit() {
    webdriver.quit();
  }

}
