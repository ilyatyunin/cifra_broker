package ru.ffin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Наличие основных разделов на Главной странице")
public class PrimarySectionsOnMainPageTests extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();

    @ValueSource(strings = {
            "Готовые инвестиционные решения",
            "Широкие возможности для достижения ваших целей",
            "Команда экспертов по фондовому рынку",
            "Новости компании"
    })
    @DisplayName("Проверка заголовков на главной странице:")
    @ParameterizedTest(name = "Заголовок {0}")
    void checkPrimarySectionsOnMainPage(String section) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие заголовка " + section, () -> {
            cifraBrokerMainPage.checkSection(section);
        });
    }
}
