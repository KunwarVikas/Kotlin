fun main(args:Array<String>){
    print(whatShouldIDoToday("happy"))
    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel?")
    println(whatShouldIDoToday(readLine()!!))
    testFiltersAndMaps()
}


fun testFiltersAndMaps(){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    print(spices.filter { it.contains("curry") }.sortedBy { it.length })
    print(spices.filter { it.startsWith('c') && it.endsWith('e') })
    print(spices.filter { it[0]=='c' && it[it.length-1]=='e'})
    print(spices.take(3).filter{it.startsWith('c')})

}

fun whatShouldIDoToday(mood:String, weather:String="Sunny", temperature:Int=24):String {
    return when {
        isVeryHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHappySunny(mood, weather) -> "go for a walk"
        else -> "Stay home and read."
    }
}

fun isVeryHot(temperature: Int)  = temperature>30
fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
        mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"
