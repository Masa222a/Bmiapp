package com.android.example.bmiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.core.content.edit
import androidx.preference.PreferenceManager
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

            if (editHeight == ""){
                Toast.makeText(this, "身長が空欄です。", Toast.LENGTH_SHORT).show()
                Log.d("$editHeight", editHeight)
            } else if (editWeight == "") {
                Toast.makeText(this, "体重が空欄です。", Toast.LENGTH_SHORT).show()
                Log.d("$editWeight", editWeight)
            } else {
                val height = Integer.parseInt(editHeight)
                val weight = Integer.parseInt(editWeight)
                val result = BmiCaluculation().caluculate(weight, height)
                val bmi = result?.bmi
                val bodyType = result?.bodyType
                val text = result?.text
                intent.putExtra("BMI", bmi)
                intent.putExtra("BODYTYPE", bodyType)
                intent.putExtra("TEXT", text)
                startActivity(intent)
                Log.d("HEIGHT", "${editHeight}")
                Log.d("WEIGHT", "${editWeight}")
                Log.d("result", "${result}")
            }
        }

        binding.reset.setOnClickListener { onResetButtonTapped() }
    }

    private fun onResetButtonTapped() {
        binding.weightEd.text.clear()
        binding.heightEd.text.clear()
    }
}