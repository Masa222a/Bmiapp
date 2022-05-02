package com.android.example.bmiapp

import java.io.Serializable

data class BmiInfo(val bmi: Double, val bodyType: BodyType): Serializable {
    enum class BodyType(val type: String, val text: String) {
        SKINNY("瘦せ型", "あなたは痩せ気味な体重です。\n現状の体重を増やし健康的な体型を\n目指してください。"),
        STANDARD("標準型", "あなたは標準的な体重です。\n現状の体重を維持しましょう。"),
        OBESITY("肥満型", "あなたは肥満です。\n現状の体重を減らし健康的な体型を\n目指してください。")
    }
}
