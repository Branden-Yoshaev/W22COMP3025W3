package com.lh1137913.w22comp3025w3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.core.widget.addTextChangedListener
import com.lh1137913.w22comp3025w3.databinding.ActivityMainBinding
import com.lh1137913.w22comp3025w3.databinding.ActivityTipCalcBinding
import java.text.NumberFormat

class TipCalcActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipCalcBinding
    private var initialMealCost = 0.0
    private var tipPercent = 15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //If the user changes the meal amount, recalculates the tip
        binding.mealPreTipEditText.addTextChangedListener {
            initialMealCost = if (!it.isNullOrBlank())
                it.toString().toDouble()
            else
                0.0

            calculateTip()
        }

        //If the user changes the tip amount, recalculate tge tip
        binding.tipPercentSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, newValue: Int, p2: Boolean) {
                tipPercent = newValue
                calculateTip()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        Log.i("Lifecycle", "MainActivity.onCreate() called")
    }

    private fun calculateTip()
    {
        var tip = initialMealCost*tipPercent / 100
        binding.tipPercentTextView.text = "${tipPercent}%"

        val currencyFormat = NumberFormat.getCurrencyInstance()
        binding.tipTotalTextView.text = currencyFormat.format(tip)
        binding.amountWithTipTextView.text = currencyFormat.format(tip+initialMealCost)
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