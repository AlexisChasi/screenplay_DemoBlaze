
package com.example.tasks.web;

import com.example.userinterfaces.pages.DemoBlazeCarritoPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarCompra implements Task {
    public static Performable ComprarProductos () {
        return instrumented(RealizarCompra.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DemoBlazeCarritoPage.TituloCarrito, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(DemoBlazeCarritoPage.placeOrderButton, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DemoBlazeCarritoPage.placeOrderButton)
        );
    }
}
