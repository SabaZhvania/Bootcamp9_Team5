package ge.tbcitacademy.configtests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcitacademy.listeners.CustomTestListener;
import ge.tbcitacademy.util.ModdedAllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Configuration.*;

@Listeners({CustomTestListener.class})
public class ConfigTests {
    @BeforeTest(alwaysRun = true)
    public void initialSetup(){
        browser = CHROME;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        SelenideLogger.addListener("AllureSelenide", new ModdedAllureSelenide());
        browserSize = null;
        timeout = 20000;
        reopenBrowserOnFail = true;
        screenshots = true;
        fileDownload = FileDownloadMode.HTTPGET;
        pageLoadTimeout = 20000;
    }

    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}