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

import static com.codeborne.selenide.Selenide.closeWindow;

public class TestBase {
    @BeforeAll
    static void firstConfigure() {
//        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        String[] browser = System.getProperty("browser", "chrome:100.0").split(":");
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.remote = System.getProperty("selenoid_url");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last Screeshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Attach.getVideoUrl();

        closeWindow();
    }
}
