package com.android.example.bmiapp

class BmiCaluculation {
    private lateinit var result: BmiInfo

    fun caluculate(weight: Int, height: Int): BmiInfo {
        var bmi = weight / height * height

        if (bmi < 18.5) {
            var result = BmiInfo(bmi, BmiInfo.BodyType.SKINNY)
        } else if (bmi < 25) {
            var result = BmiInfo(bmi, BmiInfo.BodyType.STANDARD)
        } else if (25 < bmi) {
            var result = BmiInfo(bmi, BmiInfo.BodyType.OBESITY)
        }

        return result
    }
}