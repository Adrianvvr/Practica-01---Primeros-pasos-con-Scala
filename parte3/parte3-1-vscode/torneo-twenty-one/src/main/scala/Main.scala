object Main extends App {
  println("¡Bienvenido al Torneo Twenty-One!")

  val jugadores = List(
    "Alex",
    "Chen",
    "Marta",
    "Sindhu",
    "Luis"
  )

  val puntuaciones = Array(
    18,
    24,
    21,
    20,
    26
  )

  def bust(puntuacion:Int):Boolean={
    if (puntuacion > 21)
        true
    else
        false
  }

  def estadoMano(puntuacion:Int):String={
    if (puntuacion > 21)
      "BUST"
    else
      "VALIDA"
  }

  def maxHand(valor1:Int, valor2:Int):Int={
    if (valor1 == valor2)
        0
    else if (valor1 > valor2)
        valor1
    else
        valor2
  }

  def mejorMano(handA: Int, handB: Int): Int={
    if (bust(handA) && bust(handB))
      0
    else if (bust(handA) && !bust(handB))
      handB
    else if (!bust(handA) && bust(handB))    
      handA
    else
      maxHand(handA, handB) 
  }

  var i = 0
  while (i < jugadores.length){
    println(jugadores(i) + "-> " + puntuaciones(i)+ " -> " + estadoMano(puntuaciones(i)))
    i += 1
  }

  def ResumenRonda(listaJugadores:List[String], listaPuntuaciones:Array[Int]): Int = {
    println("--- Resumen de la ronda ---")
    println("Número de jugadores: " + listaJugadores.length)
    var i = 0
    var manosValidas = 0
    var mejorPuntuacionValida = 0
    
    while (i < listaPuntuaciones.length){
      if(estadoMano(listaPuntuaciones(i)) == "VALIDA"){
        manosValidas += 1
        if(listaPuntuaciones(i) > mejorPuntuacionValida){
          mejorPuntuacionValida = listaPuntuaciones(i)
        }
      }
      i += 1
    }
    
    println("Manos válidas: " + manosValidas)
    var malas = listaJugadores.length - manosValidas
    println("Bust: " + malas)
    println("Mejor puntuación válida: " + mejorPuntuacionValida)
    
    mejorPuntuacionValida
  }
  
  val mejorRonda1 = ResumenRonda(jugadores, puntuaciones)

  val puntuacionesRonda2 = Array(
    22,
    19,
    20,
    21,
    17
  )
  
  var j = 0
  while (j < jugadores.length){
    println(jugadores(j) + "-> " + puntuacionesRonda2(j)+ " -> " + estadoMano(puntuacionesRonda2(j)))
    j += 1
  }
  
  val mejorRonda2 = ResumenRonda(jugadores, puntuacionesRonda2)

  println("\n--- Puntuaciones Ronda 2 (foreach) ---")
  puntuacionesRonda2.foreach( k => println("Puntuacion " + k + ": " + estadoMano(k)))

  println("=== RESULTADO FINAL ===")
  println("Mejor puntuación de la primera ronda: " + mejorRonda1)
  println("Mejor puntuación de la segunda ronda: " + mejorRonda2)
  
  if (mejorRonda1 == mejorRonda2) {
    println("Ambas rondas tuvieron la misma mejor puntuación.")
  } else if (mejorRonda1 > mejorRonda2) {
    println("La primera ronda tuvo la mejor puntuación.")
  } else {
    println("La segunda ronda tuvo la mejor puntuación.")
  }
}