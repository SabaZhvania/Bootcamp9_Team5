package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInPage{
    public SelenideElement passwordInput = $("#password"),
    signInButton =$(byText("Sign in")) ,
    continueWithEmail = $("button[type='submit']");


}
