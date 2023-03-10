import java.util.*

fun main() {
    val game = NumberGuessingGame()

    // Generate a random 4-digit number for the user to guess.
    game.generateRandomNumber()
    println("Welcome to the Number Guessing Game!")
    println("Press Enter to begin")
    readLine()

    // Ask the user to guess the number until they get it right.
    while (true) {
        println("You may enter a 4-digit number with no repeating numbers: ")
        val userGuess = readLine()

        // Check if the user's guess is valid.
        if (userGuess == null || userGuess.length != 4 || !game.isValidNumber(userGuess)) {
            println("Invalid input. The numbers should not repeat! Try again.")
            continue
        }

        // Calculate the number of digits guessed correctly regardless of their position (n)
        // and the number of digits guessed correctly at their correct position (m).
        val (n, m) = game.calculateGuessResult(userGuess)

        if (m == 4) {
            println("Yay, you got it!")
            break
        } else {
            println("$n:$m")
            println("Try again!")
        }
    }
}