package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class RegistrationPage {

    public SelenideElement LoginRegistrationPageHeader = $(byText("Sign in or create an account")),
    EmailInput = $("#username"),
    ContinueWithEmailButton = $("button[type='submit']").$(byText("Continue with email")),
    InvalidEmailErrorMessage = $("#username-note"),
    SignInWithGoogleButton = $("a[title='Sign in with Google']"),
    PasswordInput = $("#new_password"),
    ConfirmPasswordInput = $("#confirmed_password"),
    CreateAccountButton = $(byText("Create account"));
}
