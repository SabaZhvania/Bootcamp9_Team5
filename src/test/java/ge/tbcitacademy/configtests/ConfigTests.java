package ge.tbcitacademy.configtests;


import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import ge.tbcitacademy.configtests.listener.CustomTestListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Configuration.*;

@Listeners({CustomTestListener.class})
public class ConfigTests {
    @BeforeMethod
    public void initialSetup(){
        browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        browserCapabilities = options;
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