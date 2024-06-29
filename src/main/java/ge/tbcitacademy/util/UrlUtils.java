package ge.tbcitacademy.util;

import org.testng.Assert;

public class UrlUtils {

    public static void assertUrlContainsParameters(String url, String... parameters) {
        for (String parameter : parameters) {
            Assert.assertTrue(url.contains(parameter), parameter + " not found in URL: " + url);
        }
    }
}