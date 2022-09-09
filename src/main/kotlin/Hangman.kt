import java.util.*
import kotlin.random.Random

val words = listOf("affix", "avenue", "awkward", "beekeeper", "boggle", "cobweb", "cycle", "disavow", "duplex",
    "equip", "exodus", "funny", "galaxy", "gossip", "icebox", "injury", "ivory", "jackpot", "jelly", "jockey",
    "joking", "joyful", "jumbo", "kayak", "khaki", "kiosk", "lengths", "lucky", "luxury", "lymph", "nightclub",
    "onyx", "ovary", "pajama", "pneumonia", "pshaw", "puppy", "scratch", "staff", "stretch")

var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0


fun main() {
    setUpGame()
}


fun setUpGame() {

    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].uppercase(Locale.getDefault())
    println(word)

    for(i in word.indices){
        guesses.add('_')
    }

    var gameOver = false

    do {
        printGameStatus()
        print("Please enter a letter: ")
        val input = readln()
        if (input.isEmpty()){
            println("That's not a valid input. Please try again ")
        }
        else {
            val letter = input[0].uppercaseChar()
            if(word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter) guesses[i] = letter
                }
                if (!guesses.contains('_')) gameOver = true
                println("Congratulations, you won the game!!!")
            }
            else {
                println("Sorry, that's not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6) gameOver = true
            }
        }
    } while (!gameOver)

    if (mistakes == 6) {
        printGameStatus()
        println("Game Over - You Lost!!!")
        println("The word was: $word")
    }
    else {
        println("Congratulations, you won!!!")
        println("The word was: $word")

    }
}


fun printGameStatus() {
    when(mistakes) {
        0 -> printZeroMistakes()
        1 -> printOneMistakes()
        2 -> printTwoMistakes()
        3 -> printThreeMistakes()
        4 -> printFourMistakes()
        5 -> printFiveMistakes()
        6 -> printSixMistakes()
    }
    print("Word: ")
    for(element in guesses){
        print("$element ")
    }
    println("\nYou have $remainingGuesses guess (es) left")
}


fun printZeroMistakes() {
    println("  |------|-")
    println("  |      |")
    println("  |")
    println("  |")
    println("  |")
    println("  |")
    println(" /|\\")
    println("/ | \\")
}


fun printOneMistakes() {
    println("  |------|-")
    println("  |      |")
    println("  |      O")
    println("  |")
    println("  |")
    println("  |")
    println(" /|\\")
    println("/ | \\")
}


fun printTwoMistakes() {

    println("  |------|-")
    println("  |      |")
    println("  |      O")
    println("  |      |")
    println("  |      |")
    println("  |")
    println(" /|\\")
}


fun printThreeMistakes() {

    println("  |------|-")
    println("  |      |")
    println("  |      O")
    println("  |     /|")
    println("  |      |")
    println("  |")
    println(" /|\\")
    println("/ | \\")
}


fun printFourMistakes() {
    println("  |------|-")
    println("  |      |")
    println("  |      O")
    println("  |     /|\\")
    println("  |      |")
    println("  |")
    println(" /|\\")
    println("/ | \\")
}


fun printFiveMistakes() {
    println("  |------|-")
    println("  |      |")
    println("  |      O")
    println("  |     /|\\")
    println("  |      |")
    println("  |     /")
    println(" /|\\")
    println("/ | \\")
}


fun printSixMistakes() {
    println("  |------|-")
    println("  |      |")
    println("  |      O")
    println("  |     /|\\")
    println("  |      |")
    println("  |     / \\")
    println(" /|\\")
    println("/ | \\")
}
