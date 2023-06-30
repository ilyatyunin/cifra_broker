package ru.ffin.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.ffin.pages.CifraBankMainPage;
import ru.ffin.pages.CifraBrokerMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Валидация полей на странице открытии счета")
public class ValidationModalNewAccountTest extends TestBase {

    CifraBrokerMainPage cifraBrokerMainPage = new CifraBrokerMainPage();

    @ValueSource(strings = {
            "Поле обязательно для заполнения",
            "E-mail введен некорректно. Пример: example@mail.ru",
            "Телефон введен некорректно. Пример: +7 (901) 123-45-67",
            "Чтобы продолжить, необходимо ваше согласие"
    })
    @DisplayName("Валидация полей в модалке Открой счет:")
    @ParameterizedTest(name = "Поле {0}")
    void validationInputsModal(String validation) {
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
}
