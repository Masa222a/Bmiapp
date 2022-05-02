package com.android.example.bmiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.example.bmiapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getSerializableExtra("result") as BmiInfo

        binding.bmiResult.text = result.bmi.toString()
        binding.bodyShape.text = result.bodyType.type
        binding.typeText.text = result.bodyType.text

        binding.back.setOnClickListener { finish() }
    }
}
