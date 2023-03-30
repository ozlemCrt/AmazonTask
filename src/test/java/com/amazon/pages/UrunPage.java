package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UrunPage extends BasePage {
    @FindBy(css = "#add-to-wishlist-button-submit")
    public WebElement listeyeEkleButton;
    @FindBy(xpath = "//a[text()='Listenizi Görüntüleyin']")
    public WebElement listeniziGörüntüleyinButton;
    @FindBy(css = "#productTitle")
    public WebElement urunAdı;
}
