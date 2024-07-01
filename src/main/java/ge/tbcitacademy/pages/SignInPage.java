package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    public SelenideElement emailInput = $("#username");
    public SelenideElement passwordInput = $("#password");
    public SelenideElement signInButton = $("button[type='submit']");
}
