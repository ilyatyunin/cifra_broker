package ru.ffin.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ffin.pages.CifraBankMainPage;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Главная страница Цифра Брокер")
public class CifraBrokerMainTests extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();
    CifraBankMainPage cifraBankMainPage = new CifraBankMainPage();

    @ValueSource(strings = {
            "Готовые инвестиционные решения",
            "Широкие возможности для достижения ваших целей",
            "Команда экспертов по фондовому рынку",
            "Новости компании"
    })
    @ParameterizedTest(name = "Проверка заголовка {0} на главной странице")
    @DisplayName("Наличие основных разделов на Главной странице")
    void checkPrimarySectionsOnMainPage(String section) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие заголовка " + section, () -> {
            cifraBrokerMainPage.checkSection(section);
        });
    }

    String fileName = "resume.pdf";
    @Test
    @DisplayName("Загрузка файла с резюме .pdf на странице https://job.cifra-broker.ru/")
    void uploadPdfForResume() {
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

    String login = "kupolilya@yandex.kz";
    String password = "12345678";

    @Test
    @Disabled("Содержимое страницы авторизации недоступно из-за защиты от роботов")
    @DisplayName("Авторизация на странице tradernet.ru")
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

    @Test
    @DisplayName("Переход на страницу \"Цифра Банк\"")
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


    @ValueSource(strings = {
            "Поле обязательно для заполнения",
            "E-mail введен некорректно. Пример: example@mail.ru",
            "Телефон введен некорректно. Пример: +7 (901) 123-45-67",
            "Чтобы продолжить, необходимо ваше согласие"
    })
    @ParameterizedTest
    @DisplayName("Валидация полей при открытии счета")
    void openModalNewAccount(String validation) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Открыть модалку \"Откройте счёт\"", () -> {
            cifraBrokerMainPage.openModalNewAccount();
        });
        step("Отправить пустые поля на проверку", () -> {
            cifraBrokerMainPage.submitEmptyInputs();
        });
        step("Проверить наличие валидации " + validation, () -> {
            cifraBrokerMainPage.checkValidationInput(validation);
        });
    }

    @Test
    @DisplayName("Скрытие Cookie Consent Banner")
    void hideCookieConsent() {
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

    @CsvSource({
            "Telegram, .icon-telegram-filled, https://t.me/vse_v_cifre",
            "VK, .icon-vkontakte, https://vk.com/cifra.broker",
            "YouTube, .icon-youtube-play, https://www.youtube.com/channel/UCov52Rv9qZTkVu9WERSwccg"
    })

    @ParameterizedTest(name = "Проверка наличия иконки {0} в футере")
    @DisplayName("Отображение иконок и ссылок соцсетей в футере")
    void checkSocialMedia(String media, String locatorMedia, String urlMedia) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие ссылки на кнопке соцсети " + media, () -> {
            cifraBrokerMainPage.checkSocialMedia(locatorMedia, urlMedia);
        });
    }
}
