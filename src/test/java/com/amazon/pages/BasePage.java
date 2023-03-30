package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement girisHover;
    @FindBy(css = "#searchDropdownBox")
    public WebElement tümKategorilerSelect;
    @FindBy(css = "#twotabsearchtextbox")
    public WebElement araInputBox;
    @FindBy(css = "#nav-search-submit-button")
    public WebElement araButton;
    @FindBy(xpath = "//a//span[text()='SetCard Liste']")
    public WebElement SetCardListe;


    public void hesabım(String tab) {
        BrowserUtils.hover(girisHover);
        BrowserUtils.waitForVisibility(By.xpath("//span[text()='" + tab + "']"), 7);
        Driver.get().findElement(By.xpath("//span[text()='" + tab + "']")).click();


    }

    public void verfyTitle(String expectedTitle) {
        BrowserUtils.waitFor(3);
        Assert.assertEquals(Driver.get().getTitle(),
                expectedTitle);
    }


}
