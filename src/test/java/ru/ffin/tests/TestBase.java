package ru.ffin.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.ffin.helpers.Attach;
import ru.ffin.config.*;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWindow;
import static org.aeonbits.owner.ConfigFactory.*;

public class TestBase {

    private static final WebDriverConfig webDriverConfig = create(WebDriverConfig.class, System.getProperties());
    public static SelenoidConfig selenoidConfig = create(SelenoidConfig.class, System.getProperties());
    @BeforeAll
    static void firstConfigure() {
        Configuration.baseUrl = webDriverConfig.baseUrl();
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();


        if (selenoidConfig.url() != null && selenoidConfig.password() != null && selenoidConfig.login() != null) {
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub", selenoidConfig.login(), selenoidConfig.password(), selenoidConfig.url());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
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
