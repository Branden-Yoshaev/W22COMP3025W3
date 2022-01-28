package com.lh1137913.w22comp3025w3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class TipCalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_calc)
        Log.i("Lifecycle", "MainActivity.onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "MainActivity.onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "MainActivity.onResume() called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "MainActivity.onStop() called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "MainActivity.onPause() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "MainActivity.onDestroy() called")
    }
}