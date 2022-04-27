package com.android.example.bmiapp

data class BmiInfo(var bmi: Int, val bodyType: BodyType) {
    enum class BodyType {
        SKINNY, STANDARD, OBESITY
    }
}
