package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MsiPage extends BasePage {
    @FindBy(xpath = "//a[text()='Sonraki']")
    public WebElement sonrakiButton;
    @FindBy(xpath = "//span[@aria-label='Geçerli sayfa, sayfa 2']")
    public WebElement ikinciSayfaButton;
    public void verifyPageNumber(String pageNumber){
        String expectedText=pageNumber;
        String actualText=Driver.get().findElement(By.xpath("//span[@aria-label='Geçerli sayfa, sayfa "+pageNumber+"']")).getText();
        Assert.assertEquals(actualText,expectedText);


    }
    public void sayafayaGit(int sayfaNumarasi){

        for (int i = 1; i < sayfaNumarasi; i++) {
            BrowserUtils.scrollToElement(sonrakiButton);
            BrowserUtils.clickWithJS(sonrakiButton);

        }
    }

    public WebElement UruneGetir(int urunSirasi) {
        return Driver.get().findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + urunSirasi + "]"));


    }
}
