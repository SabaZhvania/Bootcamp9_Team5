package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.SignInPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SignInPageSteps {
    SignInPage signInPage = new SignInPage();

    @Step("Validate sign in text is displayed")
    public SignInPageSteps validateSignInPage(){
        signInPage.signInText.shouldBe(visible);
        return this;
    }

    @Step("Validate continue with email is displayed")
    public SignInPageSteps validateContinueWithEmail(){
        signInPage.continueWithEmail.shouldHave(text("Continue with email")).shouldBe(visible);
        return this;
    }

    @Step("Validate social buttons are displayed and clickable")
    public SignInPageSteps validateSocialButtons(){
        signInPage.socialBtns.forEach(b -> b.shouldBe(visible).shouldBe(clickable));
        return this;
    }
}
