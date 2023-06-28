package ru.ffin.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.ffin.helpers.Attach;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void firstConfigure() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
