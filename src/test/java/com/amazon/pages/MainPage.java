package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
@FindBy(id = "sp-cc-accept")
    public WebElement popup;
@FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement userName;
@FindBy(xpath ="//a[text()='Hesabım']" )
    public WebElement hesabımtryCatch;
}
