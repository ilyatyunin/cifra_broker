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
    @DisplayName("Загрузка файла в формате .pdf")
    @Tags({
            @Tag("transition")
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

    @DisplayName("Переход на страницу \"Цифра Банк\"")
    @Tags({
            @Tag("transition"),
            @Tag("smoke")
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
