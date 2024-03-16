package com.example.lessonclass

fun buildAquarium() {
//    val myAquarium = Aquarium()
//    myAquarium.printSize()
//    myAquarium.height = 60
//    myAquarium.printSize()

//    val aquarium1 = Aquarium()
//    aquarium1.printSize()
//    // default height and length
//    val aquarium2 = Aquarium(width = 25)
//    aquarium2.printSize()
//    // default width
//    val aquarium3 = Aquarium(height = 35, length = 110)
//    aquarium3.printSize()
//    // everything custom
//    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
//    aquarium4.printSize()

//    val aquarium6 = Aquarium(numberOfFish = 29)
//    aquarium6.printSize()
//    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")

//    aquarium6.printSize()
//    aquarium6.volume1 = 70
//    aquarium6.printSize()

//    val aquarium7 = Aquarium(length = 25, width = 25, height = 40)
//    aquarium7.printSize()

    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = Aquarium.TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

//fun main() {
//    buildAquarium()
//}

fun makeFish() {
    val shark = AquariumFish.Shark()
    val pleco = AquariumFish.Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main () {
    makeFish()
}