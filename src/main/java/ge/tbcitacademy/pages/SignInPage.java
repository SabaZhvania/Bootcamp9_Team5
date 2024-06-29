package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInPage extends CommonPage{
    public SelenideElement signInText = $(byText("Sign in or create an account")),
    getEmailInput = $("#username"),
    getPasswordInput = $("#password"),
    getSignInButton =$(byText("Sign in")) ,
    continueWithEmail = $("button[type='submit']");
    public ElementsCollection socialBtns = $$(".access-panel__social-buttons a");

}
