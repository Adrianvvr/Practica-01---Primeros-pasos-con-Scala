# Mini proyecto 3.2 — Análisis de Calificaciones

## Entorno

- Visual Studio Code
- Metals
- Scala 2.12.21
- JDK 17
- sbt

## Descripción

Este proyecto es un script de consola desarrollado en Scala diseñado para gestionar y analizar el rendimiento académico de un grupo de estudiantes a lo largo de dos evaluaciones.

Características principales:

Qué hace el programa: Procesa un listado de notas de estudiantes, determina automáticamente quién aprueba y quién suspende, calcula estadísticas globales del grupo y compara la evolución del rendimiento entre dos periodos distintos.

Lógica de evaluación: Transforma notas numéricas en estados (APROBADO/SUSPENSO) y en clasificaciones de texto más detalladas (EXCELENTE, NOTABLE, etc.) utilizando condicionales (`if`, `else if`, `else`).

Resumen de estadísticas: Calcula de forma dinámica el número total de estudiantes, la cantidad de aprobados y suspensos, y extrae la calificación más alta obtenida iterando sobre las estructuras de datos.

Comparativo final: Compara el número de aprobados entre la primera y la segunda evaluación para determinar si el rendimiento general del grupo ha mejorado, empeorado o se ha mantenido igual.

## Estructura

build.sbt: Es el archivo de configuración de construcción del proyecto gestionado por sbt (Scala Build Tool). Define las propiedades fundamentales para que el entorno sepa cómo compilar el código, estableciendo el nombre de la aplicación y fijando la versión exacta de Scala que se va a utilizar (2.12.21).

Main.scala: Contiene el código fuente principal dentro del objeto Main (extendiendo App para hacer el script ejecutable directamente). Incluye la definición de las colecciones de datos, los bucles de recorrido, las funciones de evaluación y el flujo principal que imprime los resúmenes y comparativas.

## Colecciones utilizadas

List[String]: Se emplea para el listado de nombres de los estudiantes. Al ser inmutable por defecto en Scala, se demuestra su comportamiento utilizando el operador `::` (cons) para añadir un nuevo estudiante, lo cual genera una lista nueva garantizando que la alineación original no se altere.

Array[Int]: Se utiliza para almacenar las calificaciones numéricas de la primera y segunda evaluación, ofreciendo una estructura de tamaño fijo que permite un fácil recorrido y análisis mediante bucles iterativos usando índices.

## Funciones utilizadas

aprobado: Evalúa si nota es >= 5.

estadoNota: Devuelve "APROBADO" o "SUSPENSO".

maxNota: Devuelve la mayor de dos notas.

analizarEvaluacion: Calcula estadísticas y devuelve resultados.

clasificacion: Categoriza nota (EXCELENTE, NOTABLE...).

## Problemas durante el desarrollo y soluciones

Problema 1: La función `analizarEvaluacion` necesitaba devolver dos valores distintos al mismo tiempo (el número total de aprobados y la mejor nota) para usarlos después en la comparación final, pero en Scala estándar una función simple solo devuelve un valor directo.
Solución 1: Se agrupó el resultado retornando un `Array[Int]` al final de la función (`Array(aprobados, mejor)`), desempaquetando luego los valores en el bloque principal asignándolos a variables específicas mediante sus índices (`resultados1(0)` y `resultados1(1)`).

Problema 2: Al utilizar múltiples bucles `while` a lo largo del mismo script para recorrer las colecciones, existía el riesgo de conflictos lógicos si se reutilizaba la misma variable iteradora sin reiniciarla a cero.
Solución 2: Se declararon contadores únicos e independientes (`i`, `k`, `j`, `m`) para cada bloque `while`, garantizando que cada recorrido inicie su ciclo correctamente sin verse afectado por los bucles anteriores.

## Ejecución

```bash
sbt compile
sbt run
```

## Resultados

Listados individuales: Muestra a cada estudiante con su nota y su estado básico (APROBADO/SUSPENSO), y posteriormente con su clasificación cualitativa.

Resúmenes de grupo: Imprime un bloque estadístico por cada evaluación detallando el volumen total de estudiantes, la cantidad de aprobados, suspensos y el pico máximo de nota.

Comparativa de evolución: Emite un informe final que cruza los datos de las dos evaluaciones e indica, mediante un mensaje de texto, si la clase ha mejorado su rendimiento general basándose en la variación del número de aprobados.

Demostración de inmutabilidad: Imprime el estado de la lista de estudiantes original y el de la lista nueva tras añadir un elemento ("Carlos"), comprobando visualmente que la colección base no sufre alteraciones.