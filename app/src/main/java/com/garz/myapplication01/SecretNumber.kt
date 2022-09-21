package com.garz.myapplication01

import java.util.*

class SecretNumber {
    var secretNumbernumber: Int = Random().nextInt(10) + 1
    var count: Int = 0

    fun validate(number: Int): Int {
        count++
        return number - secretNumbernumber
    }
    fun reset(){
        count = 0;
        this.secretNumbernumber = Random().nextInt(10) + 1
    }

}

fun main() {
    val secretNumber = SecretNumber()
    println(secretNumber.secretNumbernumber)
    println("${secretNumber.validate(2)},count:${secretNumber.count}")
}