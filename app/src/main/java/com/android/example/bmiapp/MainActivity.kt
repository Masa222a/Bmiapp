package com.android.example.bmiapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.example.bmiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            val editHeight = binding.heightEd.text.toString()
            val editWeight = binding.weightEd.text.toString()

            when {
                editHeight == "" -> {
                    Toast.makeText(this, "身長が空欄です。", Toast.LENGTH_SHORT).show()
                }
                editWeight == "" -> {
                    Toast.makeText(this, "体重が空欄です。", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val height = Integer.parseInt(editHeight)
                    val weight = Integer.parseInt(editWeight)
                    val result = BmiCaluculation().caluculate(weight, height)
                    intent.putExtra("result", result)

                    startActivity(intent)
                }
            }
        }

        binding.reset.setOnClickListener { onResetButtonTapped() }
    }

    private fun onResetButtonTapped() {
        binding.weightEd.text.clear()
        binding.heightEd.text.clear()
    }
}