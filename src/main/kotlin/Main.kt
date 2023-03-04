import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val game = NumberGuessingGame()

    // Generate a random 4-digit number for the user to guess.
    game.generateRandomNumber()
    print("Enter a 4-digit number with no repeating digits: ")
    // Ask the user to guess the number until they get it right.
    while (!game.hasUserGuessedNumber()) {
        print("Enter a 4-digit number with no repeating digits: ")
        System.out.flush()
        val userGuess = readLine()

        // Check if the user's guess is valid.
        if (userGuess == null || userGuess.length != 4 || !game.isValidNumber(userGuess)) {
            println("Invalid input. Please enter a 4-digit number with no repeating digits.")
            continue
        }

        // Calculate the number of digits guessed correctly regardless of their position (n)
        // and the number of digits guessed correctly at their correct position (m).
        val (n, m) = game.calculateGuessResult(userGuess)
        println("$n:$m")
    }

    println("Congratulations! You guessed the number correctly.")
}