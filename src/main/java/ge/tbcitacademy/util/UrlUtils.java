package ge.tbcitacademy.util;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.Wait;

public class UrlUtils {

    public static void validateUrlContainsParameters(String... parameters) {
        for (String parameter : parameters) {
            Wait().withTimeout(Duration.ofSeconds(10))
                    .until(driver -> WebDriverRunner.url().contains(parameter));
        }
    }
}