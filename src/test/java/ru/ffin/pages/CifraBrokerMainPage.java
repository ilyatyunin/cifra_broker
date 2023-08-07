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
    SelenideElement mainContainer = $(".main__inner");
    SelenideElement buttonTradernet = $(".header__profile .btn-login");
    SelenideElement buttonCifraBank = $("a[href='https://cifra-bank.ru/'].menu__link");
    SelenideElement buttonOpenAccount = $(byTagAndText("button", "Открыть счет"));
    SelenideElement buttonSubmitOpenAccount = $(byTagAndText("button", "Отправить"));
    SelenideElement formOpenAccount = $("[name='formOpenAccount']");
    SelenideElement cookieConsentAlert = $(".b-alert");
    SelenideElement buttonAcceptCookie = $(byTagAndText("button", "Принять"));
    public SelenideElement resumeForm = $(byTagAndText("h3", "Не нашли вакансию?"));
    SelenideElement placeHolderEmail = $("[placeholder='Email']");
    SelenideElement placeHolderPassword = $("[placeholder='Пароль']");
    SelenideElement buttonSubmitCredentials = $("[type='submit']");


    public CifraBrokerMainPage openCifraBrokerPage() {
        open(baseUrl);
        return this;
    }
    public CifraBrokerMainPage checkSection(String section) {
        mainContainer.shouldHave(text(section));
        return this;
    }
//    Переход на другую страницу
    public CifraBrokerMainPage goToTradernetRu() {
        buttonTradernet.click();
        return this;
    }
    public CifraBrokerMainPage goToCifraBankRu() {
        buttonCifraBank.click();
        return this;
    }
    public CifraBrokerMainPage openModalNewAccount() {
        buttonOpenAccount.click();
        return this;
    }
    public CifraBrokerMainPage submitEmptyInputs() {
        buttonSubmitOpenAccount.click();
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
        buttonAcceptCookie.click();
        return this;
    }
    public CifraBrokerMainPage checkSocialMedia(String locatorMedia, String urlMedia) {
        $(locatorMedia).parent().shouldHave(href(urlMedia));
        return this;
    }

//    Авторизация на странице tradernet.ru
    public CifraBrokerMainPage setLogin(String login) {
        placeHolderEmail.setValue(login);
        return this;
    }
    public CifraBrokerMainPage setPassword(String password) {
        placeHolderPassword.setValue(password);
        return this;
    }
    public CifraBrokerMainPage sendCredentials() {
        buttonSubmitCredentials.click();
        return this;
    }
    //    Получение url второй вкладки
    public CifraBrokerMainPage switchSecondTab() {
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
        return this;
    }
}
