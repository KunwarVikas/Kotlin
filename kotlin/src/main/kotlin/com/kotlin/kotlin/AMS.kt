import java.util.*

fun main(args: Array<String>){
    println("Hello Kunwar!")
    dayOfWeek()
    if (args[0].toInt() < 12) println("Good morning, Kotlin")  else println("Good night, Kotlin" )
    println("${if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin"}")

    var returnMsg = getFortuneCookie(getBirthday())
    println("Your return fortune is $returnMsg")
    for (i in 1..10){
        var returnMsg = getFortuneCookie(getBirthday())
        println("Your return fortune is $returnMsg")
        if(returnMsg.equals("Things will go well for you today.")) break
    }

    repeat(10){
        var returnMsg = getFortuneCookie(getBirthday())
        println("Your return fortune is $returnMsg")
        //if(returnMsg.equals("Things will go well for you today.")) break
        //break and continue doesn't work with repeat
    }

    print(sum(5,5))

}

fun dayOfWeek(){
    println("What day is it today?")
    var day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println("day:$day")
    println (when(day){
        1-> "Sunday"
        2-> "Monday"
        3-> "Tuesday"
        4->  "Wednesday"
        5->  "Thursday"
        6->  "Friday"
        7->  "Saturday"
        else -> "Time has stopped"
    })
}

fun getFortuneCookie(birthDate:Int=20):String{
var fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")
    val index =when(birthDate){
        in 28..31->4
        in 1..7->1
        else -> birthDate.div(fortunes.size)
    }
    return fortunes[index]
}

fun getBirthday():Int{
    print("enter your birth date:")
    return readLine()?.toIntOrNull() ?: 1
}

fun sum(a:Int, b:Int):Int{
    return a+b
}
