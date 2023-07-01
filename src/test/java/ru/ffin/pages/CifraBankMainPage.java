package ru.ffin.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CifraBankMainPage {
    public CifraBankMainPage comparisonOfUrl() {
        String expectedUrl = "https://cifra-bank.ru/";
        String actualUrl = getWebDriver().getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "Открылся неверный URL");
        return this;
    }
    public CifraBankMainPage checkHeaderText(String text) {
        $(".header_top").shouldHave(text(text));
        return this;
    }
}
