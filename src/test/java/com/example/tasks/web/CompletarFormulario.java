package com.example.tasks.web;

import com.example.userinterfaces.pages.DemoBlazeFormularioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletarFormulario implements Task {

    private final String nombre;
    private final String pais;
    private final String ciudad;
    private final String tarjeta;
    private final String mes;
    private final String año;

    public CompletarFormulario(String nombre, String pais, String ciudad, String tarjeta, String mes, String año) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.tarjeta = tarjeta;
        this.mes = mes;
        this.año = año;
    }

    public static CompletarFormulario conDatos(String nombre, String pais, String ciudad, String tarjeta, String mes, String año) {
        return instrumented(CompletarFormulario.class, nombre, pais, ciudad, tarjeta, mes, año);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DemoBlazeFormularioPage.tituloForm, isVisible()).forNoMoreThan(10).seconds(),

                WaitUntil.the(DemoBlazeFormularioPage.nameInput, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombre).into(DemoBlazeFormularioPage.nameInput),

                WaitUntil.the(DemoBlazeFormularioPage.countryInput, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(pais).into(DemoBlazeFormularioPage.countryInput),

                WaitUntil.the(DemoBlazeFormularioPage.cityInput, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(ciudad).into(DemoBlazeFormularioPage.cityInput),

                WaitUntil.the(DemoBlazeFormularioPage.cardInput, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(tarjeta).into(DemoBlazeFormularioPage.cardInput),

                WaitUntil.the(DemoBlazeFormularioPage.monthInput, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(mes).into(DemoBlazeFormularioPage.monthInput),

                WaitUntil.the(DemoBlazeFormularioPage.yearInput, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(año).into(DemoBlazeFormularioPage.yearInput)
        );
    }
}
