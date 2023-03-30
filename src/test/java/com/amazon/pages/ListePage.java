package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListePage extends BasePage {
    @FindBy(css = "#createList-announce")
    public WebElement birlisteOlusturButton;
    @FindBy(css = "#list-name")
    public WebElement listeAdıInputBox;
    @FindBy(xpath = "//span[text()='Liste Oluştur']")
    public WebElement listeOlustur;
    @FindBy(xpath = "//span[text()='SetCard Liste']")
    public WebElement listeAdıText;
    @FindBy(xpath = "//h2/a")
    public WebElement eklenenurun;
    @FindBy(xpath = "//span[contains(text(),'Kaldır')]")
    public WebElement kaldirButton;
    @FindBy(xpath = "//img[@alt='Daha fazlası']")
    public WebElement dahaFazlasiButton;
    @FindBy(id = "editYourList")
    public WebElement listeyiYönetButton;
    @FindBy(xpath = "//span[text()='Listeyi sil']")
    public WebElement listeyiSilButton;
    @FindBy(xpath = "//span[text()='Evet']")
    public WebElement evetButton;


    public void yeniListeOlustur(String listeAdı) {
        BrowserUtils.hover(girisHover);
        hesabım("Liste Oluşturun");
        BrowserUtils.waitForClickablility(birlisteOlusturButton,7);
        BrowserUtils.clickWithJS(birlisteOlusturButton);
        BrowserUtils.waitFor(3);
        listeAdıInputBox.clear();
        listeAdıInputBox.sendKeys(listeAdı);
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(listeOlustur);

    }

    public void listeSil() {
        BrowserUtils.waitForVisibility(dahaFazlasiButton, 7);
        BrowserUtils.hover(dahaFazlasiButton);
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(listeyiYönetButton);
        BrowserUtils.scrollToElement(listeyiSilButton);
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(listeyiSilButton);
        BrowserUtils.waitForClickablility(evetButton, 7);
        BrowserUtils.clickWithJS(evetButton);
    }

}
