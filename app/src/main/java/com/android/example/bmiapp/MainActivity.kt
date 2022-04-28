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

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val edHeight = pref.getString("HEIGHT", "")
        val edWeight = pref.getString("WEIGHT", "")

        binding.heightEd.setText(edHeight)
        binding.weightEd.setText(edWeight)


        binding.start.setOnClickListener {
//            onStartButtonTapped()

            val editHeight = binding.heightEd.text.toString()
            val editWeight = binding.weightEd.text.toString()

            if (editHeight == ""){
                Toast.makeText(this, "身長が空欄です。", Toast.LENGTH_SHORT).show()
                Log.d("$editHeight", editHeight)
            } else if (editWeight == "") {
                Toast.makeText(this, "体重が空欄です。", Toast.LENGTH_SHORT).show()
                Log.d("$editWeight", editWeight)
            } else {
                onChangeResult(it)
            }
        }

        binding.reset.setOnClickListener { onResetButtonTapped(it) }
    }

//    private fun onStartButtonTapped() {
//        val pref = PreferenceManager.getDefaultSharedPreferences(this)
//        pref.edit {
//            putString("HEIGHT", binding.heightEd.text.toString())
//            putString("WEIGHT", binding.weightEd.text.toString())
//        }
//    }

    private fun onChangeResult(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        val height = Integer.parseInt(binding.heightEd.text.toString())
        val weight = Integer.parseInt(binding.weightEd.text.toString())
        val result = BmiCaluculation().caluculate(weight, height)
        val bmi = result.bmi
        val bodyType = result.bodyType
        intent.putExtra("BMI", bmi)
        Log.d("BMI", "${bmi}")
        Log.d("bodytype", "${bodyType}")
        intent.putExtra("BODYTYPE", bodyType)
        startActivity(intent)
    }

    private fun onResetButtonTapped(view: View?) {
        binding.weightEd.text.clear()
        binding.heightEd.text.clear()
    }
}