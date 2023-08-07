package ru.ffin.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class JobCifraBrokerPage {
    private SelenideElement
            linkAbout = $("[href='/about']"),
            linkJob = $(".submenu-wrap [href='https://job.cifra-broker.ru/']"),
            linkUploadDoc = $(".footer-green [type='file']"),
            linkFileName = $(".footer-green .custom-file-upload__value");


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
