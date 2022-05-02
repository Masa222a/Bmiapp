package com.android.example.bmiapp

class BmiCaluculation {
    fun caluculate(weight: Int, height: Int): BmiInfo? {
        val height: Double = height.toDouble()
        val weight: Double = weight.toDouble()
        val bmi = Math.round(weight / (height / 100) / (height / 100) * 10.0) / 10.0
        return if (0 < bmi && bmi < 18.5) {
            BmiInfo(bmi, bodyType = BmiInfo.BodyType.SKINNY)
        } else if (18.5 <= bmi && bmi < 25) {
            BmiInfo(bmi, bodyType = BmiInfo.BodyType.STANDARD)
        } else if (25 <= bmi) {
            BmiInfo(bmi, bodyType = BmiInfo.BodyType.OBESITY)
        } else {
            null
        }
    }
}
