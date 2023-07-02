package ru.ffin.tests;

import org.junit.jupiter.api.*;
import ru.ffin.pages.CifraBankMainPage;
import ru.ffin.pages.CifraBrokerMainPage;
import ru.ffin.pages.JobCifraBrokerPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Переход на другие сайты Цифра Банка")
public class TransitionToCifraWebSitesTests extends TestBase {
    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();
    CifraBankMainPage cifraBankMainPage = new CifraBankMainPage();
    JobCifraBrokerPage jobCifraBrokerPage = new JobCifraBrokerPage();
    String fileName = "resume.pdf";
    @DisplayName("Файл в формате .pdf")
    @Tags({
            @Tag("transition"),
            @Tag("regression")
    })
    @Test
    void uploadPdfToResumeForm() {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Перейти на сайт job.cifra-broker.ru", () -> {
            jobCifraBrokerPage.goToJobCifraBrokerRu();
        });
        step("Переключиться на вторую вкладку", () -> {
            cifraBrokerMainPage.switchSecondTab();
        });
        step("Скролл до формы с загрузкой файла", () -> {
            jobCifraBrokerPage.scrollToElement(cifraBrokerMainPage.resumeForm);
        });
        step("Загрузить файл с резюме", () -> {
            jobCifraBrokerPage.uploadDoc(fileName);
        });
        step("Проверить название загруженного файла", () -> {
            jobCifraBrokerPage.checkFileName(fileName);
        });
    }

    String login = "kupolilya@yandex.kz";
    String password = "12345678";

    @DisplayName("Авторизация на сайте tradernet.ru")
    @Tags({
            @Tag("transition"),
            @Tag("smoke"),
            @Tag("regression")
    })
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

    @DisplayName("Переход на страницу \"Цифра Банк\"")
    @Tags({
            @Tag("transition"),
            @Tag("smoke"),
            @Tag("regression")
    })
    @Test
    void goToBankWebsite() {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Перейти на страницу \"Цифра Банк\"", () -> {
            cifraBrokerMainPage.goToCifraBankRu();
        });
        step("Переключиться на вторую вкладку", () -> {
            cifraBrokerMainPage.switchSecondTab();
        });
        step("Проверить наличие текста \"Интернет-банк\" в хедере", () -> {
            cifraBankMainPage.checkHeaderText("Интернет-банк");
        });
        step("Проверить правильность URL на странице банка", () -> {
            cifraBankMainPage.comparisonOfUrl();
        });
    }
}
