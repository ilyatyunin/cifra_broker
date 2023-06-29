package ru.ffin.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CifraBrokerMainPage {
    SelenideElement MainContainer = $(".main__inner");
    SelenideElement ButtonTradernet = $(".header__profile .btn-login");
    SelenideElement ButtonCifraBank = $("a[href='https://cifra-bank.ru/'].menu__link");
    SelenideElement LinkAbout = $("[href='/about']");
    SelenideElement LinkJob = $(".submenu-wrap [href='https://job.cifra-broker.ru/']");
    SelenideElement ButtonOpenAccount = $(byTagAndText("button", "Открыть счет"));
    SelenideElement ButtonSubmitOpenAccount = $(byTagAndText("button", "Отправить"));
    SelenideElement LinkUploadDoc = $(".footer-green [type='file']");
    SelenideElement LinkFileName = $(".footer-green .custom-file-upload__value");
    SelenideElement FormOpenAccount = $("[name='formOpenAccount']");
    SelenideElement CookieConsentAlert = $(".b-alert");
    SelenideElement ButtonAcceptCookie = $(byTagAndText("button", "Принять"));
    public SelenideElement ResumeForm = $(byTagAndText("h3", "Не нашли вакансию?"));
    SelenideElement PlaceHolderEmail = $("[placeholder='Email']");
    SelenideElement PlaceHolderPassword = $("[placeholder='Пароль']");
    SelenideElement ButtonSubmitCredentials = $("[type='submit']");


    public CifraBrokerMainPage openCifraBrokerPage() {
        open("https://cifra-broker.ru/");
        return this;
    }
    public CifraBrokerMainPage checkSection(String section) {
        MainContainer.shouldHave(text(section));
        return this;
    }
//    Переход на другую страницу
    public CifraBrokerMainPage goToTradernetRu() {
        ButtonTradernet.click();
        return this;
    }
    public CifraBrokerMainPage goToCifraBankRu() {
        ButtonCifraBank.click();
        return this;
    }
    public CifraBrokerMainPage goToJobCifraBrokerRu() {
        LinkAbout.hover();
        LinkJob.click();
        return this;
    }
    public CifraBrokerMainPage uploadDoc(String fileName) {
        LinkUploadDoc.uploadFromClasspath(fileName);
        return this;
    }
    public CifraBrokerMainPage scrollToElement(SelenideElement selenideElement) {
        selenideElement.scrollTo();
        return this;
    }
    public CifraBrokerMainPage checkFileName(String fileName) {
        LinkFileName.shouldHave(text(fileName));
        return this;
    }


    public CifraBrokerMainPage openModalNewAccount() {
        ButtonOpenAccount.click();
        return this;
    }
    public CifraBrokerMainPage submitEmptyInputs() {
        ButtonSubmitOpenAccount.click();
        return this;
    }
    public CifraBrokerMainPage checkValidationInput(String validation) {
        FormOpenAccount.shouldHave(text(validation));
        return this;
    }

//    cookie
    public CifraBrokerMainPage displayCookieConsent(boolean expectedResult) {
        boolean isAlertDisplayed = CookieConsentAlert.isDisplayed();
        assertEquals(expectedResult, isAlertDisplayed);
        return this;
    }
    public CifraBrokerMainPage acceptCookieConsent() {
        ButtonAcceptCookie.click();
        return this;
    }
    public CifraBrokerMainPage checkSocialMedia(String locatorMedia, String urlMedia) {
        $(locatorMedia).parent().shouldHave(href(urlMedia));
        return this;
    }

//    Авторизация на странице tradernet.ru
    public CifraBrokerMainPage setLogin(String login) {
        PlaceHolderEmail.setValue(login);
        return this;
    }
    public CifraBrokerMainPage setPassword(String password) {
        PlaceHolderPassword.setValue(password);
        return this;
    }
    public CifraBrokerMainPage sendCredentials() {
        ButtonSubmitCredentials.click();
        return this;
    }
}
