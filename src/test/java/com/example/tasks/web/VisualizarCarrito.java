package com.example.tasks.web;

import com.example.userinterfaces.pages.DemoBlazePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VisualizarCarrito implements Task {
    public static Performable VerCarrito () {
        return instrumented(VisualizarCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DemoBlazePage.iconocarro, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DemoBlazePage.iconocarro)
        );
    }
}
