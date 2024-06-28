package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public SelenideElement dismissButton = $(byAttribute("aria-label","Dismiss sign-in info.")),
            popupText = $(withText("Sign in, save money"));
}
