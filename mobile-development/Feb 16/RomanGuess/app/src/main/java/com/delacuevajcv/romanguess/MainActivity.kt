package com.delacuevajcv.romanguess

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val romanConverter = RomanNumeralGenerator()
    var correctAnswer = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reStartGame()

        initOnClickListeners()
    }

    fun reStartGame() {
        correctAnswer = generateRandomNumber()
        val romanNumeral = convertToRomanNumeral(correctAnswer)
        Log.d("Correct", "$correctAnswer")
        tvNumber.text = romanNumeral
        setChoices()
    }

    fun initOnClickListeners() {
        btnA.setOnClickListener {
            checkAnswer(btnA.text.toString().toInt())
        }
        btnB.setOnClickListener {
            checkAnswer(btnB.text.toString().toInt())
        }
        btnC.setOnClickListener {
            checkAnswer(btnC.text.toString().toInt())
        }
        btnD.setOnClickListener {
            checkAnswer(btnD.text.toString().toInt())
        }
    }

    fun checkAnswer(choice: Int) {
        if (choice == correctAnswer) {
            Toast.makeText(this, "You answer is correct!", Toast.LENGTH_SHORT).show()
            flParent.setBackgroundColor(Color.GREEN)
        } else {
            Toast.makeText(this, "WRONG!!!", Toast.LENGTH_SHORT).show()
            flParent.setBackgroundColor(Color.RED)
        }

        reStartGame()
    }

    fun generateRandomNumber():Int {
        return Random.nextInt(1, 50)
    }

    fun convertToRomanNumeral(number: Int): String {
        return romanConverter.convert(number)
    }

    fun setChoices() {
        val randomChoice = Random.nextInt(1, 4)
        when (randomChoice) {
            1 -> {
                btnA.text = "$correctAnswer"
                btnB.text = "${generateRandomNumber()}"
                btnC.text = "${generateRandomNumber()}"
                btnD.text = "${generateRandomNumber()}"
            }
            2 -> {
                btnB.text = "$correctAnswer"
                btnA.text = "${generateRandomNumber()}"
                btnC.text = "${generateRandomNumber()}"
                btnD.text = "${generateRandomNumber()}"
            }
            3 -> {
                btnC.text = "$correctAnswer"
                btnA.text = "${generateRandomNumber()}"
                btnB.text = "${generateRandomNumber()}"
                btnD.text = "${generateRandomNumber()}"
            }
            4 -> {
                btnD.text = "$correctAnswer"
                btnA.text = "${generateRandomNumber()}"
                btnB.text = "${generateRandomNumber()}"
                btnC.text = "${generateRandomNumber()}"
            }
        }
    }
}
