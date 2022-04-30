package com.android.example.bmiapp

class BmiCaluculation {
    fun caluculate(weight: Int, height: Int): BmiInfo? {
        var height = height.toDouble()
        var weight = weight.toDouble()
        var bmi = Math.round(weight / (height / 100) / (height / 100) * 10.0) / 10.0
        var result: BmiInfo?

        if (0 < bmi && bmi < 18.5) {
            result = BmiInfo(bmi, BmiInfo.BodyType.SKINNY.type, BmiInfo.BodyType.SKINNY.text)
        } else if (18.5 <= bmi && bmi < 25) {
            result = BmiInfo(bmi, BmiInfo.BodyType.STANDARD.type, BmiInfo.BodyType.STANDARD.text)
        } else if (25 <= bmi) {
            result = BmiInfo(bmi, BmiInfo.BodyType.OBESITY.type, BmiInfo.BodyType.OBESITY.text)
        } else {
            result = null
        }

        return result
    }
}