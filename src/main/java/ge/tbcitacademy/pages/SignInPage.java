package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInPage {
    public SelenideElement signInText = $(byText("Sign in or create an account")),
    continueWithEmail = $("button[type='submit']");
    public ElementsCollection socialBtns = $$(".access-panel__social-buttons a");
}
