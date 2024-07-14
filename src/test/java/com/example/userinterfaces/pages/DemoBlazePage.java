package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoBlazePage {

    public static final Target samsung = Target.the("celular1").locatedBy("//a[contains(text(),'Samsung galaxy s6')]");
    public static final Target nokia = Target.the("celular2").locatedBy("//a[contains(text(),'Nokia lumia 1520')]");
    public static final Target iconocarro = Target.the("IconoCarro").locatedBy("//a[@id='cartur']");
    public static final Target HOME_LINK = Target.the("home link").locatedBy("//a[@class='nav-link' and contains(text(),'Home')]");
}
