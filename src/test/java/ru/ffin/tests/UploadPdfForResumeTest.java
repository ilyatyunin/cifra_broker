package ru.ffin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ffin.pages.CifraBankMainPage;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Загрузка файла на странице https://job.cifra-broker.ru/")
public class UploadPdfForResumeTest extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();
    CifraBankMainPage cifraBankMainPage = new CifraBankMainPage();

    String fileName = "resume.pdf";
    @DisplayName("Файл в формате .pdf")
    @Test
    void uploadPdfToResumeForm() {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Перейти на сайт job.cifra-broker.ru", () -> {
            cifraBrokerMainPage.goToJobCifraBrokerRu();
        });
        step("Переключиться на вторую вкладку", () -> {
            cifraBankMainPage.switchSecondTab();
        });
        step("Скролл до формы с загрузкой файла", () -> {
            cifraBrokerMainPage.scrollToElement(cifraBrokerMainPage.ResumeForm);
        });
        step("Загрузить файл с резюме", () -> {
            cifraBrokerMainPage.uploadDoc(fileName);
        });
        step("Проверить название загруженного файла", () -> {
            cifraBrokerMainPage.checkFileName(fileName);
        });
    }
}
