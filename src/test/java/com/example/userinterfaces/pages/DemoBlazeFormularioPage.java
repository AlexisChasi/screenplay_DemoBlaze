package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;


public class DemoBlazeFormularioPage {

    public static final Target nameInput = Target.the("nombre").locatedBy("//input[@id='name']");
    public static final Target countryInput = Target.the("pais").locatedBy("//input[@id='country']");
    public static final Target cityInput = Target.the("ciudad").locatedBy("//input[@id='city']");
    public static final Target cardInput = Target.the("tarjeta").locatedBy("//input[@id='card']");
    public static final Target monthInput = Target.the("mes").locatedBy("//input[@id='month']");
    public static final Target yearInput = Target.the("anio").locatedBy("//input[@id='year']");
    public static final Target purchaseButton = Target.the("BotonCompra").locatedBy("//button[contains(text(),'Purchase')]");
    public static final Target tituloForm = Target.the("TituloFormulario").locatedBy("//h5[@id='orderModalLabel']");
    public static final Target confirmacionCompra = Target.the("TituloConfirmacionCompra").locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");

}
