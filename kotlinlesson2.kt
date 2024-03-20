package com.example.myapplication

import java.util.*

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    var food = ""
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}

fun fishFood1 (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish0() {
    val day = randomDay()
    val food = "pellets"
    println ("Today is $day and the fish eat $food")
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
}

fun feedTheFish1() {
    val day = randomDay()
    val food = fishFood1(day)
    println ("Today is $day and the fish eat $food")
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" ->  true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater1 (day: String, temperature: Int = 40, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

fun feedTheFish2() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun feedTheFish3() {
    val day = randomDay()
    println("Change water: ${ shouldChangeWater1(day)}")
}

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun createList() {
    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")
}

fun useSeq() {
    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun main(args:Array<String>) {
    val isUnit = println("This is an expression")
    println(isUnit)
    println("-----------------")

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
    println("-----------------")

    val temperature1 = 10
    val message = "The water temperature is ${ if (temperature1 > 50) "too warm" else "OK" }."
    println(message)
    println("-----------------")

    feedTheFish0()
    println("-----------------")

    feedTheFish()
    println("-----------------")

    feedTheFish1()
    println("-----------------")

    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter
    println("-----------------")

    feedTheFish2()
    println("-----------------")

    feedTheFish3()
    println("-----------------")

    println( decorations.filter {it[0] == 'p'})
    println("-----------------")

    println(createList());
    println("-----------------")

    useSeq()
    println("-----------------")

    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("Flat: ${mylist.flatten()}")
    println("-----------------")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("filtered: ${lazyMap2.toList()}")
    println("-----------------")

    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))
    println("-----------------")

    val waterFilter1: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter1(dirtyLevel))
    println("-----------------")

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter2))
    println("-----------------")

    fun increaseDirty( start: Int ) = start + 1
    println(updateDirty(15, ::increaseDirty))
    println("-----------------")

    var dirtyLevel1 = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel1 + 23}
    println(dirtyLevel)
    println("-----------------")
}