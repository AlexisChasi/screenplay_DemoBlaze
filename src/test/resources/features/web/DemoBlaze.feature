Feature: Flujo de Compra en Demoblaze

    @DemoBlaze
    Scenario Outline: Compra de productos con datos desde JSON
        Given el cliente inicia la aplicacion DemoBlaze
        When agrega un producto al carrito
        And agrega otro producto al carrito
        Then visualizo el carrito
        And realizo la orden
        And completo el formulario de pedido con los siguientes datos:
            | <nombre>       | <pais>       | <ciudad>     | <tarjeta>   | <mes>   | <anio>  |
        And confirmo el pedido
        Then verifico la confirmación de la compra

        Examples:
            | nombre       | pais       | ciudad     | tarjeta   | mes   | anio  |
            | Alexis Chasi | Ecuador    | Quito      | 0000000   | JULIO | 2028 |
