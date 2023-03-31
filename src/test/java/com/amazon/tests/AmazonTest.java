package com.amazon.tests;

import com.amazon.pages.*;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {
    MainPage mainPage = new MainPage();
    GirisYapPage girisYapPage = new GirisYapPage();
    ListePage listePage = new ListePage();
    MsiPage msiPage = new MsiPage();
    UrunPage urunPage = new UrunPage();

    @Test
    public void test() {
        extentLogger = report.createTest("Alışveriş Listesi");
        extentLogger.info("https://www.amazon.com.tr/ sitesi açılır.");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Ana sayfanın açıldığı kontrol edilir.");
        String expextedTitle = "Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi";
        mainPage.verfyTitle(expextedTitle);
        extentLogger.info("Çerez tercihlerinden Çerezleri kabul et seçilir.");
        try {
            BrowserUtils.waitFor(3);
            BrowserUtils.clickWithJS(mainPage.popup);
        } catch (Exception e) {
            BrowserUtils.clickWithJS(mainPage.hesabımtryCatch);
        }
        extentLogger.info("Siteye login olunur.");
        girisYapPage.girisYap(ConfigurationReader.get("userEmail"), ConfigurationReader.get("password"));
        extentLogger.info("Login işlemi kontrol edilir.");
        try {
            Assert.assertEquals(mainPage.userName.getText(), ConfigurationReader.get("userName"));
        } catch (Exception e) {
            girisYapPage.sifreInputBox.sendKeys(ConfigurationReader.get("password"));
            BrowserUtils.waitForClickablility(girisYapPage.imageInputBox, 7);
            girisYapPage.imageInputBox.sendKeys("sfynpt");
            girisYapPage.girisYaTryCatchButton.click();
            BrowserUtils.waitForClickablility(girisYapPage.sifreInputBox,7);
            webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(girisYapPage.sifreInputBox)));
            girisYapPage.sifreInputBox.sendKeys(ConfigurationReader.get("password"));
            Assert.assertEquals(mainPage.userName.getText(), ConfigurationReader.get("userName"));
        }
        extentLogger.info("Hesabım bölümünden “SetCard Liste” isimli yeni bir liste oluşturulur.");
        listePage.yeniListeOlustur("SetCard Liste");
        extentLogger.info("Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.");
        BrowserUtils.waitFor(3);
        Select select = new Select(mainPage.tümKategorilerSelect);
        select.selectByVisibleText("Bilgisayarlar");
        extentLogger.info("Bilgisayar kategorisi seçildiği kontrol edilir.");
        BrowserUtils.waitFor(3);
        Assert.assertTrue(select.getFirstSelectedOption().isDisplayed());
        extentLogger.info("Arama alanına msi yazılır ve arama yapılır.");
        listePage.araInputBox.sendKeys("msi");
        listePage.araButton.click();
        extentLogger.info("Arama yapıldığı kontrol edilir.");
        msiPage.verfyTitle("Amazon.com.tr : msi");
        extentLogger.info("Arama sonuçları sayfasından 2. sayfa açılır.");
        String expectedurun = msiPage.UruneGetir(2).getText();
        msiPage.UruneGetir(2).click();
        extentLogger.info("2. sayfanın açıldığı kontrol edilir.");
        Assert.assertEquals(urunPage.urunAdı.getText(), expectedurun);
        extentLogger.info("Sayfadaki 2. ürün oluşturulan “SetCard Liste” listesine eklenir.");
        urunPage.listeyeEkleButton.click();
        urunPage.listeniziGörüntüleyinButton.click();
        extentLogger.info("2. Ürünün listeye eklendiği kontrol edilir.");
        BrowserUtils.waitFor(3);
        Assert.assertTrue(listePage.eklenenurun.isDisplayed());
        extentLogger.info("Hesabım - Alışveriş Listesi sayfasına gidilir.");
        BrowserUtils.hover(listePage.girisHover);
        listePage.SetCardListe.click();
        extentLogger.info("“Alışveriş Listesi” sayfası açıldığı kontrol edilir.");
        Assert.assertTrue(listePage.listeAdıText.isDisplayed());
        extentLogger.info("Eklenen ürün SetCard Liste’sinden silinir.");
        BrowserUtils.waitForClickablility(listePage.kaldirButton, 7);
        BrowserUtils.clickWithJS(listePage.kaldirButton);
        extentLogger.info("Oluşturulan SetCard Listesi silinir.");
        listePage.listeSil();
        extentLogger.info("Silme işleminin gerçekleştiği kontrol edilir.");
        BrowserUtils.waitForVisibility(listePage.birlisteOlusturButton,7);
        Assert.assertTrue(listePage.birlisteOlusturButton.isDisplayed());
        extentLogger.info("Üye çıkış işlemi yapılır.");
        listePage.hesabım("Çıkış Yap");
        extentLogger.info("Çıkış işleminin yapıldığı kontrol edilir.");
        Assert.assertTrue(girisYapPage.girisYapText.isDisplayed());
    }
}
