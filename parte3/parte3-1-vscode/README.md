# Mini proyecto 3.1 — Torneo de Twenty-One

## Entorno

- Visual Studio Code
- Metals
- Scala 2.12.21
- JDK 17
- sbt

## Descripción

Este proyecto es un script de consola desarrollado en Scala que simula la gestión y evaluación de un torneo de cartas basado en la mecánica del Blackjack ("Twenty-One").

Características principales:

Estructuras de datos: Utiliza listas y arrays para almacenar a los participantes y sus respectivas puntuaciones a lo largo de varias rondas.

Lógica de evaluación: Implementa funciones que determinan automáticamente si la mano de un jugador es "VÁLIDA" o hace "BUST" (al superar el límite de 21 puntos).

Resumen de estadísticas: Cuenta con una función de análisis que procesa cada ronda para extraer el número de manos válidas, la cantidad de eliminaciones y la puntuación máxima permitida.

Comparativo final: Aplica estructuras de control de flujo (if, else if, else) para cruzar los datos de las distintas rondas, identificar la mejor puntuación global y determinar qué fase del torneo tuvo el mejor desempeño.

## Estructura

build.sbt: Es el archivo de configuración de construcción del proyecto gestionado por sbt (Scala Build Tool). Define las propiedades fundamentales para que el entorno sepa cómo compilar el código, estableciendo el nombre de la aplicación (torneo-twenty-one) y fijando la versión exacta de Scala que se va a utilizar (2.12.21).

Main.scala: Contiene la lógica central y el código fuente del programa. En este archivo se define el objeto Main (que extiende de App para hacer el script ejecutable directamente), los datos de prueba (jugadores y rondas) y todas las funciones encargadas de calcular el estado de las manos, generar los resúmenes estadísticos y comparar los resultados finales.

## Colecciones utilizadas

List[String]: Se utiliza para almacenar los nombres de los jugadores. Al ser una estructura inmutable por defecto en Scala, asegura que el listado de participantes se mantenga constante y sin alteraciones a lo largo de la ejecución.

Array[Int]: Se utiliza para almacenar las puntuaciones de cada ronda (primera y segunda). Ofrece una estructura indexada de tamaño fijo que permite consultar y recorrer los valores de forma directa mediante bucles iterativos.

## Funciones utilizadas

bust: Comprueba si supera 21 puntos.

estadoMano: Indica si la mano es válida.

maxHand: Devuelve el mayor de dos valores.

mejorMano: Calcula la mejor mano entre dos.

ResumenRonda: Muestra resumen y devuelve mejor puntuación.

## Problemas durante el desarrollo y soluciones

Problema 1: La variable que calculaba la mejor puntuación válida (`mejorPuntuacionValida`) se encontraba encapsulada dentro de la función `ResumenRonda`. Al terminar su ejecución el dato se perdía, lo que impedía comparar directamente el resultado de la ronda 1 con el de la ronda 2 al final del script.
Solución 1: Se modificó la firma de la función `ResumenRonda` para añadir un tipo de retorno `: Int` y devolver dicha variable. De este modo, fue posible almacenar el resultado devuelto en variables externas (`mejorRonda1` y `mejorRonda2`) para su posterior comparación condicional.

Problema 2: En el segundo bucle `while` para mostrar las puntuaciones de la ronda 2, la condición evaluaba el contador `i` del primer bucle en lugar de `j`. Dado que `i` ya había alcanzado el límite de elementos, el segundo bucle no llegaba a ejecutarse.
Solución 2: Se corrigió la condición del segundo bucle vinculándola a su variable de control correspondiente (`j < jugadores.length`).

## Ejecución

```bash
sbt compile
sbt run
```

## Resultados

Evaluación por jugador: Imprime el nombre de cada participante junto a su puntuación y su estado correspondiente (VALIDA o BUST) para la primera y segunda ronda.

Resúmenes estadísticos: Al final de cada ronda, muestra un bloque con el total de jugadores, cuántos consiguieron una mano válida, cuántos fueron eliminados (Bust) y cuál fue la mejor puntuación de esa ronda.

Veredicto final: En la última sección, el programa extrae las mejores puntuaciones de ambas rondas y, mediante la estructura condicional, imprime un mensaje final indicando qué ronda fue superior o si hubo un empate (con los datos actuales, el programa indica que ambas rondas tuvieron la misma mejor puntuación, que es 21).