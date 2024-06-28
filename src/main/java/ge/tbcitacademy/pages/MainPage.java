package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public SelenideElement searchBar = $(byAttribute("aria-label","Where are you going?")),
            searchBtn = $("button[type='submit']"),
            registerBtn = $(byAttribute("aria-label", "Create an account")),
            signInBtn = $(byAttribute("aria-label", "Sign in")),
            languageSwitcherBtn = $(byAttribute("data-testid", "header-language-picker-trigger")),
            bannerSubTitle = $(byText("Discover dreamy vacation homes all over the world"));
    public ElementsCollection navLinks = $$("nav[data-testid='header-xpb'] a");
}
