package ru.ffin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Отображение иконок и ссылок соцсетей в футере")
public class DisplaySocialMediaTests extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();

    @CsvSource({
            "Telegram, .icon-telegram-filled, https://t.me/vse_v_cifre",
            "VK, .icon-vkontakte, https://vk.com/cifra.broker",
            "YouTube, .icon-youtube-play, https://www.youtube.com/channel/UCov52Rv9qZTkVu9WERSwccg"
    })
    @DisplayName("Проверка наличия в футере иконки")
    @ParameterizedTest(name = "{0}")
    void checkSocialMedia(String media, String locatorMedia, String urlMedia) {
        step("Открыть главную страницу", () -> {
            cifraBrokerMainPage.openCifraBrokerPage();
        });
        step("Проверить наличие ссылки на кнопке соцсети " + media, () -> {
            cifraBrokerMainPage.checkSocialMedia(locatorMedia, urlMedia);
        });
    }
}
