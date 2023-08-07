package ru.ffin.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CifraBrokerMainPage {
    private SelenideElement mainContainer = $(".main__inner"),
            goToTradernetButton = $(".header__profile .btn-login"),
            goToCifraBankButton = $("a[href='https://cifra-bank.ru/'].menu__link"),
            OpenAccountButton = $(byTagAndText("button", "Открыть счет")),
            SubmitOpenAccountButton = $(byTagAndText("button", "Отправить")),
            formOpenAccount = $("[name='formOpenAccount']"),
            cookieConsentAlert = $(".b-alert"),
            AcceptCookieButton = $(byTagAndText("button", "Принять")),
            placeHolderEmail = $("[placeholder='Email']"),
            placeHolderPassword = $("[placeholder='Пароль']"),
            SubmitCredentialsButton = $("[type='submit']");
    public SelenideElement resumeForm = $(byTagAndText("h3", "Не нашли вакансию?"));


    public CifraBrokerMainPage openCifraBrokerPage() {
        open(baseUrl);
        return this;
    }
    public CifraBrokerMainPage checkSection(String section) {
        mainContainer.shouldHave(text(section));
        return this;
    }
//    Переход на другую страницу
    public CifraBrokerMainPage goToCifraBankRu() {
        goToCifraBankButton.click();
        return this;
    }
    public CifraBrokerMainPage openModalNewAccount() {
        OpenAccountButton.click();
        return this;
    }
    public CifraBrokerMainPage submitEmptyInputs() {
        SubmitOpenAccountButton.click();
        return this;
    }
    public CifraBrokerMainPage checkValidationInput(String validation) {
        formOpenAccount.shouldHave(text(validation));
        return this;
    }

//    cookie
    public CifraBrokerMainPage displayCookieConsent(boolean expectedResult) {
        boolean isAlertDisplayed = cookieConsentAlert.isDisplayed();
        assertEquals(expectedResult, isAlertDisplayed);
        return this;
    }
    public CifraBrokerMainPage acceptCookieConsent() {
        AcceptCookieButton.click();
        return this;
    }
    public CifraBrokerMainPage checkSocialMedia(String locatorMedia, String urlMedia) {
        $(locatorMedia).parent().shouldHave(href(urlMedia));
        return this;
    }

    //    Получение url второй вкладки
    public CifraBrokerMainPage switchSecondTab() {
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
        return this;
    }
}
