# NTTDATA EJERCICIO AUTOMATIZACIÓN CON PATRÓN SCREENPLAY
Este proyecto contiene automatización de pruebas utilizando Selenium WebDriver y Cucumber en NTT DATA, implementando el patrón Screenplay.

# Prerrequisitos
Asegúrate de tener las siguientes herramientas y versiones instaladas en tu máquina local:

# IDE IntelliJ IDEA versión 2023.1 o superior

- Apache Maven versión 3.9.8 (configurado en la variable de entorno PATH)
- JDK versión 11.0.20 (configurado en la variable de entorno JAVA_HOME)
- Comandos de instalación
# Clonar el repositorio:

git clone https://github.com/AlexisChasi/screenplay_DemoBlaze.git

Descargar el cromedriver y colocarlo en la ruta especificada, adecuada para la arquitectura del ordenador (en este caso, 64 bits).

![image](https://github.com/user-attachments/assets/37a6383f-7882-4b8d-85f0-68541806fd80)

- Descargar desde: Chrome Driver https://googlechromelabs.github.io/chrome-for-testing/

  ![image](https://github.com/user-attachments/assets/e1dca051-b891-40b2-b661-ca11889579bc)


# Compilar el proyecto:

- Una vez clonado el repositorio, ejecutar mvn install -DskipTests para descargar todas las dependencias del POM.
- O hacer clic derecho en MAVEN y seleccionar "Reload all maven projects".

![image](https://github.com/user-attachments/assets/9f4e7158-9ee2-40e9-bbed-f16c6c19747e)

# Instrucciones para ejecutar los tests
Para ejecutar las pruebas automatizadas, sigue estos pasos:

- Abre el proyecto en IntelliJ IDEA.
- Configura el entorno de ejecución para ejecutar los tests de Cucumber con Screenplay.
- Ejecuta los tests desde IntelliJ IDEA o utilizando Maven.
- Dirígete al archivo RunnerTest en src/test/java/com/nttdata/runner/RunnerTest.java.

  ![image](https://github.com/user-attachments/assets/25469a93-9e0e-4f88-952b-c5d22ee95598)

- Haz clic en Public class RunnerTest y selecciona Run 'Runner Test' asegurándote de especificar el tag @DemoBlaze.

# Reporte
El reporte se genera en una carpeta específica al momento de ejecutar el test:

target/cucumber/cucumber-report.html

Incluye evidencias por cada paso del escenario definido en Gherkin.

# Información adicional
Este proyecto utiliza Selenium WebDriver para interactuar con el navegador, Cucumber para escribir escenarios de prueba en lenguaje natural, y el patrón Screenplay para mejorar la legibilidad y mantenibilidad del código de automatización.

# Ejecucion de la prueba con las correciones
- ejecucion 
![image](https://github.com/user-attachments/assets/73452db6-becd-43d4-9f74-c13b856c192a)

- Consumo de variables con archivo json
![image](https://github.com/user-attachments/assets/ecf8a438-b2b6-47f0-bf70-346ff612e17c)

- Scenario Outline
![image](https://github.com/user-attachments/assets/4778e32c-51c1-430e-bc86-aa181095e08f)




