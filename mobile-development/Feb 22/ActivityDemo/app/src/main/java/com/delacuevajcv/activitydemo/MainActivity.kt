package com.delacuevajcv.activitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_b.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("lifecycle", "onCreate MainActivity")

        btn_next.setOnClickListener {
            next()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "onResume MainActivity")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "onStart MainActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "onPause MainActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "onStop MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "onDestroy MainActivity")
    }

    fun next() {
        val intent = Intent(this, BActivity::class.java)
        startActivity(intent)
    }
}
