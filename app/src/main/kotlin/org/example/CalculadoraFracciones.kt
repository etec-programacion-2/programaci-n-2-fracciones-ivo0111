package org.example
import java.util.Scanner

fun mostrarMenu() {
    println("=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    println("Ingrese su opción: ")
}
fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion {
    println(mensaje)
    print("Numerador: ")
    val numerador = scanner.nextInt()
    scanner.nextLine()
    print("Denominador: ")
    val denominador = scanner.nextInt()
    scanner.nextLine()
    if (numerador == 0 || denominador == 0){
        throw IllegalArgumentException("Los valores no pueden ser cero")
    }
    return Fraccion(numerador, denominador)
}
fun realizarSuma (scanner:Scanner) {
    val f1 = leerFraccion(scanner, "Primera fraccioón")
    val f2 = leerFraccion(scanner, "segunda fracción")
    println("Suma: ${f1+f2}")
}
fun realizarResta (scanner:Scanner) {
    val f1 = leerFraccion(scanner, "Primera fraccioón")
    val f2 = leerFraccion(scanner, "segunda fracción")
    println("resta: ${f1-f2}")
}
fun realizarDivision (scanner:Scanner) {
    val f1 = leerFraccion(scanner, "Primera fraccioón")
    val f2 = leerFraccion(scanner, "segunda fracción")
    println("División: ${f1/f2}")
}
fun realizarMultiplicacion (scanner:Scanner) {
    val f1 = leerFraccion(scanner, "Primera fraccioón")
    val f2 = leerFraccion(scanner, "segunda fracción")
    println("Multiplicación: ${f1*f2}")
}
fun realizarComparacion(scanner:Scanner){
    val f1 = leerFraccion(scanner, "Primera fraccioón")
    val f2 = leerFraccion(scanner, "segunda fracción")
    when {
        f1>f2 -> println("$f1 es mayor a $f2")
        f1<f2 -> println("$f1 es menor a $f2")
        else -> println("$f1 es mayor a $f2")
    }
}
fun convertirADecimal(scanner:Scanner) {
    val f1 = leerFraccion(scanner, "Fracción a convertir")
    println("$f1 = ${f1.aDecimal()}")
}
fun crearDesdeDecimal(scanner:Scanner){
    println("Decimal para convertir")
    val decimal = scanner.nextDouble()
    scanner.nextLine()
    if (decimal == 0.0){
        throw IllegalArgumentException("No puede ser cero")
    }
    println(Fraccion.desdeDecimal(decimal))
}
fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")
    
    val f1 = Fraccion(1, 2)  // 1/2
    val f2 = Fraccion(1, 3)  // 1/3
    
    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1 + f2}")
    println("Resta: $f1 - $f2 = ${f1 - f2}")
    println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
    println("División: $f1 / $f2 = ${f1 / f2}")
    println("¿$f1 > $f2? ${f1 > f2}")
    println("$f1 en decimal: ${f1.aDecimal()}")
}