



package com.example.tasks.web;

import com.example.userinterfaces.pages.DemoBlazeCarritoPage;

import com.example.userinterfaces.pages.DemoBlazeFormularioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerificarCompra implements Task {
    public static Performable VerificarCompraTitulo () {
        return instrumented(VerificarCompra.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DemoBlazeFormularioPage.confirmacionCompra, isVisible()).forNoMoreThan(10).seconds()

        );
    }
}
