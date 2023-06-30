package ru.ffin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Скрытие Cookie Consent Banner")
public class HideCookieConsentBannerTest extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();

    @DisplayName("Согласие с Cookie")
    @Test
    void acceptCookieConsentBanner() {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие Cookie Consent Banner", () -> {
            cifraBrokerMainPage.displayCookieConsent(true);
        });
        step("Согласиться с cookie", () -> {
            cifraBrokerMainPage.acceptCookieConsent();
        });
        step("Проверить отсутствие Cookie Consent Banner", () -> {
            cifraBrokerMainPage.displayCookieConsent(false);
        });
    }
}
