package ru.ffin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ffin.pages.CifraBankMainPage;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Переход на основной сайт банка")
public class GoToCifraBankWebsiteTest extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();
    CifraBankMainPage cifraBankMainPage = new CifraBankMainPage();

    @DisplayName("Переход на страницу \"Цифра Банк\"")
    @Test
    void goToBankWebsite() {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Перейти на страницу \"Цифра Банк\"", () -> {
            cifraBrokerMainPage.goToCifraBankRu();
        });
        step("Переключиться на вторую вкладку", () -> {
            cifraBankMainPage.switchSecondTab();
        });
        step("Проверить наличие текста \"Интернет-банк\" в хедере", () -> {
            cifraBankMainPage.checkHeaderText("Интернет-банк");
        });
        step("Проверить правильность URL на странице банка", () -> {
            cifraBankMainPage.comparisonOfUrl();
        });
    }
}
