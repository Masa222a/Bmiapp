package com.android.example.bmiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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

        var editHeight = binding.heightEd.text.toString()
        var editWeight = binding.weightEd.text.toString()

        binding.start.setOnClickListener {
            onStartButtonTapped()

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

    fun onStartButtonTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putString("HEIGHT", binding.heightEd.text.toString())
            putString("HEIGHT", binding.weightEd.text.toString())
        }
    }

    fun onChangeResult(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("BMI", view?.id)
        startActivity(intent)
    }

    fun onResetButtonTapped(view: View?) {
        binding.weightEd.text.clear()
        binding.heightEd.text.clear()
    }
}