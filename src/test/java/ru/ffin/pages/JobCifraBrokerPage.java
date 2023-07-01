package ru.ffin.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class JobCifraBrokerPage {
    SelenideElement LinkAbout = $("[href='/about']");
    SelenideElement LinkJob = $(".submenu-wrap [href='https://job.cifra-broker.ru/']");
    SelenideElement LinkUploadDoc = $(".footer-green [type='file']");
    SelenideElement LinkFileName = $(".footer-green .custom-file-upload__value");


    public JobCifraBrokerPage goToJobCifraBrokerRu() {
        LinkAbout.hover();
        LinkJob.click();
        return this;
    }
    public JobCifraBrokerPage uploadDoc(String fileName) {
        LinkUploadDoc.uploadFromClasspath(fileName);
        return this;
    }
    public JobCifraBrokerPage scrollToElement(SelenideElement selenideElement) {
        selenideElement.scrollTo();
        return this;
    }
    public JobCifraBrokerPage checkFileName(String fileName) {
        LinkFileName.shouldHave(text(fileName));
        return this;
    }
}
