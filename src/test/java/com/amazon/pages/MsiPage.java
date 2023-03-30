package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MsiPage extends BasePage {

    public WebElement UruneGetir(int ürünSırası) {
        return Driver.get().findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + ürünSırası + "]"));

    }
}
