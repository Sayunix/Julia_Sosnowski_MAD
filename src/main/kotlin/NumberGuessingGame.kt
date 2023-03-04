import java.util.*

class NumberGuessingGame {
    private var randomNumber: String? = null
    private val scanner = Scanner(System.`in`)

    /**
     * Generates a random 4-digit number with no repeating digits for the user to guess.
     */
    fun generateRandomNumber() {
        val random = Random()
        val digits = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        var number = ""

        // Shuffle the digits and add the first four to the number.
        for (i in 9 downTo 6) {
            val j = random.nextInt(i + 1)
            digits[j] = digits[i].also { digits[i] = digits[j] }
        }

        for (i in 0..3) {
            number += digits[i]
        }

        randomNumber = number
    }

    /**
     * Checks if the user's guess is valid (i.e., a 4-digit number with no repeating digits).
     */
    fun isValidNumber(guess: String): Boolean {
        return guess.length == 4 && guess.toSet().size == 4
    }

    /**
     * Calculates the number of digits guessed correctly regardless of their position (n)
     * and the number of digits guessed correctly at their correct position (m).
     */
    fun calculateGuessResult(guess: String): Pair<Int, Int> {
        var n = 0
        var m = 0

        for (i in 0..3) {
            if (randomNumber?.contains(guess[i]) == true) {
                n++
                if (guess[i] == randomNumber!![i]) {
                    m++
                }
            }
        }

        return Pair(n, m)
    }

    /**
     * Checks if the user has guessed the number correctly.
     */
    fun hasUserGuessedNumber(): Boolean {
        return randomNumber == scanner.nextLine()
    }
}