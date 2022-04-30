package com.android.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.example.bmiapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getSerializableExtra("BMI")
        val bodyType = intent.getSerializableExtra("BODYTYPE")
        val text = intent.getSerializableExtra("TEXT")

        Log.d("Rbmi", "${bmi}")
        Log.d("RbodyType", "${bodyType}")
        binding.bmiResult.text = bmi.toString()
        binding.bodyShape.text = bodyType.toString()
        binding.typeText.text = text.toString()

        binding.back.setOnClickListener { finish() }
    }
}