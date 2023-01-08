package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightpicker.minValue=30
        binding.weightpicker.maxValue=150

        binding.heightpicker.minValue=100
        binding.heightpicker.maxValue=250


        binding.weightpicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }

        binding.heightpicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }


    }

    private fun calculateBMI()
    {
        var height = binding.heightpicker.value
        val heightdouble = height.toDouble()/100

        val weight = binding.weightpicker.value

        val bmi = weight.toDouble()/(heightdouble*heightdouble)

        binding.results.text = String.format("Your BMI is : %.2f",bmi)
        binding.health.text = String.format("Consider %s", healthmessage(bmi))

    }

    private fun healthmessage(bmi: Double): String {
        if(bmi <  18.5)
        {
            return "Under Weight"
        }
        if(bmi<25.0)
            return "Healthy"
        if(bmi<30.0)
            return "Over Weight"
        return "Obese"
    }
}