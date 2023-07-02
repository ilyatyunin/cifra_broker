package ru.ffin.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class JobCifraBrokerPage {
    SelenideElement linkAbout = $("[href='/about']");
    SelenideElement linkJob = $(".submenu-wrap [href='https://job.cifra-broker.ru/']");
    SelenideElement linkUploadDoc = $(".footer-green [type='file']");
    SelenideElement linkFileName = $(".footer-green .custom-file-upload__value");


    public JobCifraBrokerPage goToJobCifraBrokerRu() {
        linkAbout.hover();
        linkJob.click();
        return this;
    }
    public JobCifraBrokerPage uploadDoc(String fileName) {
        linkUploadDoc.uploadFromClasspath(fileName);
        return this;
    }
    public JobCifraBrokerPage scrollToElement(SelenideElement selenideElement) {
        selenideElement.scrollTo();
        return this;
    }
    public JobCifraBrokerPage checkFileName(String fileName) {
        linkFileName.shouldHave(text(fileName));
        return this;
    }
}
