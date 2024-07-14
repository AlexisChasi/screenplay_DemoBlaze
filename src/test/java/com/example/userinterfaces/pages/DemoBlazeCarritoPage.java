package com.example.userinterfaces.pages;
import net.serenitybdd.screenplay.targets.Target;
public class DemoBlazeCarritoPage {
    public static final Target TituloCarrito = Target.the("TituloCarrito").locatedBy("//h2[contains(text(),'Products')]");
    public static final Target placeOrderButton = Target.the("BotonOrden").locatedBy("//button[contains(text(),'Place Order')]");
}

