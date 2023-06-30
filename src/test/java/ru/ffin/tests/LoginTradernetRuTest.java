package ru.ffin.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Авторизация на странице tradernet.ru")
public class LoginTradernetRuTest extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();

    String login = "kupolilya@yandex.kz";
    String password = "12345678";

    @DisplayName("Авторизация по логину и паролю")
    @Test
    @Disabled("Содержимое страницы авторизации недоступно из-за защиты от роботов")
    void successAuthorization() {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Перейти на сайт tradernet.ru", () -> {
            cifraBrokerMainPage.goToTradernetRu();
        });
        step("Ввести логин", () -> {
            cifraBrokerMainPage.setLogin(login);
        });
        step("Ввести пароль", () -> {
            cifraBrokerMainPage.setPassword(password);
        });
        step("Нажать \"Войти в систему\"", () -> {
            cifraBrokerMainPage.sendCredentials();
        });
    }
}
