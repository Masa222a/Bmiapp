package com.android.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.example.bmiapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getStringExtra("BMI")
        val bodytype = intent.getStringExtra("BODYTYPE")

        binding.bmiResult.text = bmi.toString()
        binding.bodyShape.text = bodytype.toString()

        binding.back.setOnClickListener { finish() }
    }
}