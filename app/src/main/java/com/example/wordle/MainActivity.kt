package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var wordToGuess: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordToGuess = FourLetterWordList.getRandomFourLetterWord() // gets random word
        var guessButton = findViewById<Button>(R.id.guess_button)
        var counter = 0

        var word1 = findViewById<TextView>(R.id.textView6)
        var word1check = findViewById<TextView>(R.id.textView7)
        var word2 = findViewById<TextView>(R.id.textView8)
        var word2check = findViewById<TextView>(R.id.textView9)
        var word3 = findViewById<TextView>(R.id.textView10)
        var word3check = findViewById<TextView>(R.id.textView11)
        var correct_word = findViewById<TextView>(R.id.correct_word)

//        correct_word.setText(wordToGuess)
//        correct_word.visibility = View.GONE

        guessButton.setOnClickListener {
            var wordAttempt = findViewById<EditText>(R.id.word_entry)
            var guess1 = " "
            var guess2 = " "
            var guess3 = " "

            if (counter == 0) {
                guess1 = wordAttempt.text.toString().uppercase()
                word1.setText(guess1)
                word1check.setText(checkGuess(guess1))
            } else if (counter == 1) {
                guess2 = wordAttempt.text.toString().uppercase()
                word2.setText(guess2)
                word2check.setText(checkGuess(guess2))
            } else if (counter == 2) {
                guess3 = wordAttempt.text.toString().uppercase()
                word3.setText(guess3)
                word3check.setText(checkGuess(guess3))

                correct_word.setText(wordToGuess) //displaying the correct word after the 3 guesses
                guessButton.isEnabled = false //greying out the button
                guessButton.isClickable = false //changing the button so that it cant' be clickec
            }
//            else
            //correct_word.visibility = View.VISIBLE
//                correct_word.setText(wordToGuess)
//                guessButton.isEnabled = false
//                guessButton.isClickable = false


            wordAttempt.setText("")// overrides the text box after each word
            counter++


        }
    }


    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String): String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            } else if (guess[i] in wordToGuess) {
                result += "+"
            } else {
                result += "X"
            }
        }
        return result
    }
}