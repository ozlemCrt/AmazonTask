package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GirisYapPage extends BasePage {
    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInputBox;
    @FindBy(css = ".a-button-input")
    public WebElement devametButton;
    @FindBy(css = "#ap_password")
    public WebElement sifreInputBox;
    @FindBy(id = "signInSubmit")
    public WebElement girisYapButton;
    @FindBy(xpath = "//h1")
    public WebElement girisYapText;
    @FindBy(css = "#auth-captcha-guess")
    public WebElement imageInputBox;
    @FindBy(css = "#auth-signin-button")
    public WebElement girisYaTryCatchButton;


    public void girisYap(String email, String password) {
        girisHover.click();
        BrowserUtils.waitFor(3);
        emailInputBox.sendKeys(email);
        devametButton.click();
        sifreInputBox.sendKeys(password);
        girisYapButton.click();
    }
}
