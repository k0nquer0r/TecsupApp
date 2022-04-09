package com.example.tecsupapp.kotlin

fun main() {
    // 1. variables - constantes
    // var = variable
    var nombre = "Jorge"
    nombre = "Enrique"

    // val = constante
    val clave = "clave"

    // 2. Tipos de datos
    var myInt: Int = 55
    var myString: String = "example@gmail.com"
    var myDouble: Double = 64.45
    var myFloat: Float = 55.5F
    var myBoolean: Boolean = true

    // 3. Arreglos
    val myArray = arrayOf(1,2,3,4,5)
    println(myArray[4])

    // Arreglo Mixtos
    val myArrayMixto = arrayOf(1,2,"frank",true,12.3)
    println(myArrayMixto[4])

    val myArrayEnteros = intArrayOf(1,2,3)

    // 4. Condicionales
    val numberDay = 26
    if (numberDay == 30){
        println("Es fin de mes")
    }else if (numberDay > 26){
        println("El numero es mayor")
    } else {
        println("El numero es menor")
    }

    val respuesta: String = if (numberDay == 30){
        "Es fin de mes"
    }else if (numberDay > 26){
        "El numero es mayor"
    } else {
        "El numero es menor"
    }
    println(respuesta)
}