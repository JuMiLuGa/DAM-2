

/* 
 * Ejercicio 1: Escribe un programa que pida al usuario ingresar un número y 
 * luego determine si ese número es positivo, negativo o igual a cero. Luego,
 *  muestra el resultado en la pantalla.
*/
fun determinarSigno() {

}

/* 
 * Ejercicio 2: Utiliza un bucle for para imprimir los números del 1 al 20.
*/
fun imprimirNumerosDelUnoAlDiez() {

}

/* 
 * Ejercicio 3: Utiliza un bucle while para imprimir los números del 1 al 10.
*/
fun imprimirNumerosDelUnoAlDiezConWhile() {

}

/*
 * Ejercicio 3.1: Crea un programa que pida al usuario ingresar un número y luego use un bucle 
 * while para imprimir los números desde 1 hasta ese número. 
*/
fun listarNumeros(){
    
}

/* 
 * Ejercicio 4: Crea una función que determine si un número es par o impar utilizando un when.
*/
fun determinarParOImpar() {

}

/* 
 * Ejercicio 5: Escribe un programa que solicite al usuario que ingrese un día de la semana 
 * (por ejemplo, "lunes", "martes", etc.) y luego use la expresión when para determinar si 
 * es un día laborable o un día de fin de semana. Imprime el resultado en la pantalla.
*/
fun determinarDiaSemana(){
    
}

/* 
 * Ejercicio 6: Utiliza un bucle for para imprimir los números pares del 2 al 20.
*/
fun imprimirNumerosParesDelDosAlVeinte() {

}

/* 
 * Ejercicio 7: Utiliza un bucle for para imprimir los números del 10 al 1 en orden descendente.
*/
fun imprimirNumerosDelDiezAlUnoEnOrdenDescendente() {

}

/* 
 * Ejercicio 8: Utiliza un bucle for para sumar los números del 1 al 100 y luego imprimir la suma.
*/
fun sumarNumerosDelUnoAlCien() {

}

/*
 * Ejercicio 9: Crea un juego simple en el que el programa elija un número aleatorio entre 1 y 10, y 
 * el usuario tenga que adivinarlo. Usa un bucle while para permitir al usuario hacer múltiples intentos
 * hasta que adivine el número. Proporciona pistas sobre si el número es mayor o menor en cada intento.
*/
fun adivinarNumero(){

}

/* 
 * Ejercicio 10: Partiendo del conjunto de números (1, 2, 3, 4, 5) creado en la función MAIN, crea la funcion
 * estaNumero() para que le pasemos un número y verifique si un número está o no en el conjunto
*/   

fun estaNumero(){

}


/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

fun main() {
    
    // Prueba los ejercicios aquí
    println("------------EJERCICIO_1-------------")
    determinarSigno(5)
    println(" ")
    println("------------EJERCICIO_2-------------")
    imprimirNumerosDelUnoAlDiez()
    println("")
    println("------------EJERCICIO_3-------------")
    imprimirNumerosDelUnoAlDiezConWhile()
    println("")
    println("------------EJERCICIO_3.1-----------")
    listarNumeros()
    println("")
    println("------------EJERCICIO_4-------------")
    determinarParOImpar(7)
    println("")
    println("------------EJERCICIO_5-------------")
    determinarDiaSemana()
    println("")
    println("------------EJERCICIO_6-------------")
    imprimirNumerosParesDelDosAlVeinte()
    println("")
    println("- - - - - - EJERCICIO_7 - - - - - - ")
    imprimirNumerosDelDiezAlUnoEnOrdenDescendente()
    println("")
    println("")
    println("------------EJERCICIO_8-------------")
    sumarNumerosDelUnoAlCien()
    println("")
    println("------------EJERCICIO_9-------------")
    adivinarNumero()
    println("")
    println("------------EJERCICIO_10------------")
    val numeros = listOf(1, 2, 3, 4, 5)
    estaNumero(3,numeros)
    println("")
    
}
