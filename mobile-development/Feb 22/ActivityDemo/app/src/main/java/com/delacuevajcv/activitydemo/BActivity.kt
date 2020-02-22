package com.delacuevajcv.activitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_b.*

class BActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lifecycle", "onCreate BActivity")
        setContentView(R.layout.activity_b)
        btn_next.setOnClickListener {
            next()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "onResume BActivity")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "onStart BActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "onPause BActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "onStop BActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "onDestroy BActivity")
    }

    fun next() {
        val intent = Intent(this, CActivity::class.java)
        startActivity(intent)
    }
}
