package com.numobiledev.guessthenumber

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var correctAnswer: Int = -1
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()

        restartGame()
    }

    fun restartGame() {
        correctAnswer = generateRandomNumber()
        count = 0
        tvNumber.text = "$correctAnswer"
        flShade.alpha = 0f
    }

    fun initListener() {
        btnClick.setOnClickListener {
            count++
            if (count > correctAnswer) {
                showFail()
            }
            flShade.alpha += 0.1f
            tvNumber.text = "$count"
            Log.d("Correct", "$count")
        }

        btnHoorray.setOnClickListener {
            if (count == correctAnswer) {
                showSuccess()
            } else {
                showFail()
            }
        }
    }

    fun generateRandomNumber(): Int {
        return Random.nextInt(10, 20)
    }

    fun showSuccess() {
        AlertDialog.Builder(this)
            .setTitle("Great!!!")
            .setMessage("Wanna try again?")
            .setPositiveButton("Yes") { dialog, which ->
                restartGame()
            }
            .setNegativeButton("No") { dialog, which ->
                finish()
            }
            .setCancelable(false)
            .show()
    }

    fun showFail() {
        AlertDialog.Builder(this)
            .setTitle("FAILED!!!")
            .setMessage("Better luck next time")
            .setPositiveButton("Try Again") { dialog, which ->
                restartGame()
            }
            .setNegativeButton("Give up") { dialog, which ->
                finish()
            }
            .setCancelable(false)
            .show()
    }
}
