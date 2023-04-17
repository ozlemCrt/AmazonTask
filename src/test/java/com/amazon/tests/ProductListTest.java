package com.amazon.tests;

import com.amazon.pages.LGSoundBarPage;
import com.amazon.pages.MainPage;
import com.amazon.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class ProductListTest extends TestBase {
   /** 1. amazon.in
       2. search "lg soundbar"
       3. select lg brand checkbox
       4. read product price and name
       5. print product price and name in desc order of price via code.
       6. if price is not present then consider price as zero
    eg:-
            12000 : lg soundbar slbajsbd
42000 : lg soundbar Eh12368
    */
   @Test
   public void test() {
      MainPage mainPage=new MainPage();
      LGSoundBarPage lgSoundBarPage=new LGSoundBarPage();
      extentLogger = report.createTest("Sort Products");
      extentLogger.info(" amazon.in");
      driver.get("https://www.amazon.in/");
      extentLogger.info("search lg soundbar");
      mainPage.araInputBox.sendKeys("LG sound bar");
      mainPage.araButton.click();
      extentLogger.info("select lg brand checkbox");
      lgSoundBarPage.lgSelect.click();
      extentLogger.info("print product price and name in desc order of price via code.");
     //lgSoundBarPage.write();
      lgSoundBarPage.trySort();




   }
}
