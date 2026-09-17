object Main extends App {

  val estudiantes = List(
    "Ana",
    "Luis",
    "Marta",
    "Pedro",
    "Sofia"
  )

  val notas = Array(
    8,
    4,
    10,
    6,
    3
  )

  def aprobado(nota: Int): Boolean = {
    if (nota >= 5)
      true
    else
      false
  }

  def estadoNota(nota: Int): String = {
    if (aprobado(nota))
      "APROBADO"
    else
      "SUSPENSO"
  }

  def maxNota(a: Int, b: Int): Int = {
    if (a > b)
      a
    else
      b
  }

  var i = 0
  while (i < estudiantes.length) {
    println(estudiantes(i) + " -> " + notas(i) + " -> " + estadoNota(notas(i)))
    i += 1
  }

  def analizarEvaluacion(listaEstudiantes: List[String], listaNotas: Array[Int]): Array[Int] = {
    var k = 0
    var aprobados = 0
    var suspensos = 0
    var mejor = 0

    while (k < listaNotas.length) {
      if (aprobado(listaNotas(k))) {
        aprobados += 1
      } else {
        suspensos += 1
      }
      mejor = maxNota(mejor, listaNotas(k))
      k += 1
    }

    println("--- Resumen del grupo ---")
    println("Estudiantes: " + listaEstudiantes.length)
    println("Aprobados: " + aprobados)
    println("Suspensos: " + suspensos)
    println("Mejor nota: " + mejor)

    Array(aprobados, mejor)
  }

  val resultados1 = analizarEvaluacion(estudiantes, notas)
  val aprobados1 = resultados1(0)
  val mejor1 = resultados1(1)

  def clasificacion(nota: Int): String = {
    if (nota == 9 || nota == 10) {
      "EXCELENTE"
    } else if (nota == 7 || nota == 8) {
      "NOTABLE"
    } else if (nota == 5 || nota == 6) {
      "APROBADO"
    } else {
      "SUSPENSO"
    }
  }

  var j = 0
  while (j < estudiantes.length) {
    println(estudiantes(j) + " -> " + notas(j) + " -> " + clasificacion(notas(j)))
    j += 1
  }

  val notasSegundaEvaluacion = Array(
    9,
    5,
    8,
    7,
    6
  )

  println()
  var m = 0
  while (m < estudiantes.length) {
    println(estudiantes(m) + " -> " + notasSegundaEvaluacion(m) + " -> " + estadoNota(notasSegundaEvaluacion(m)))
    m += 1
  }

  val resultados2 = analizarEvaluacion(estudiantes, notasSegundaEvaluacion)
  val aprobados2 = resultados2(0)
  val mejor2 = resultados2(1)

  println("--- Comparación de evaluaciones ---")
  println("Mejor nota de la primera evaluación: " + mejor1)
  println("Mejor nota de la segunda evaluación: " + mejor2)
  println("Número de aprobados de la primera: " + aprobados1)
  println("Número de aprobados de la segunda: " + aprobados2)

  if (aprobados2 > aprobados1) {
    println("El grupo ha mejorado.")
  } else if (aprobados2 < aprobados1) {
    println("El grupo ha empeorado.")
  } else {
    println("El grupo se ha mantenido igual.")
  }

  println("--- Uso de listas ---")
  val nuevosEstudiantes = "Carlos" :: estudiantes

  println("Lista original: " + estudiantes)
  println("Lista nueva: " + nuevosEstudiantes)
}