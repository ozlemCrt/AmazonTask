package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class LGSoundBarPage extends BasePage {
    Map<Double, String> priceSort = new TreeMap<>();
    @FindBy(xpath = "//li[@id='p_89/LG']//i")
    public WebElement lgSelect;
    @FindBy(xpath = "//h2")
    public List<WebElement> productList;

    public void trySort() {
        BrowserUtils.waitFor(3);
        List<String> elementsText = BrowserUtils.getElementsText(productList);
        WebElement element = null;
        Double pricefinal;
        String result = "";
        for (String s : elementsText) {
            try {
                element = Driver.get().findElement(By.xpath("//span[text()='" + s + "']/../../../..//span[@class='a-price-whole']"));
                String str = element.getText();
                result = str.replace(",", ".");
                pricefinal = Double.parseDouble(result);
            } catch (Exception e) {
                pricefinal = 0.00;
            }
            priceSort.put(pricefinal, s);
        }
        priceSort.forEach((k, v) -> System.out.println(k + " : " + v + "\n"));
    }

    public Map<Double, String> productPriceSort() {
        BrowserUtils.waitFor(3);
        List<String> elementsText = BrowserUtils.getElementsText(productList);
        for (String s : elementsText) {
            if (s.equals("LG GX-DZ 3.1 Channel Soundbar with Dolby Atmos with HDMI Connectivity (Black)")) {
                priceSort.put(0.00, s);
            } else {
                WebElement element = null;
                Double pricefinal = 0.00;
                element = Driver.get().findElement(By.xpath("//span[text()='" + s + "']/../../../..//span[@class='a-price-whole']"));
                String str = element.getText();
                String result = str.replace(",", ".");
                pricefinal = Double.parseDouble(result);
                priceSort.put(pricefinal, s);
            }
        }
        return priceSort;
    }

    public void write() {
        Map<Double, String> map = productPriceSort();
        map.forEach((k, v) -> System.out.println(k + " : " + v + "\n"));
    }


}

