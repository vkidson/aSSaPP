package com.example.assembler

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.Key.VISIBILITY
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import java.io.File

class el_theory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_el_theory)

        val but_next : Button = findViewById(R.id.button_next)
        val but_back : Button = findViewById(R.id.button_back)

        val textView : TextView = findViewById(R.id.mainText)

        val inputStream = assets.open("first.txt")
        val text = inputStream.bufferedReader().use { it.readText() }
        textView.text = text

        // Разделение текста
        val parts = text.split(Regex("\\n\\s*\\n"), limit = 10) // Разделяем по первой новой строке
        var k = 0
        textView.text = parts[k] // Первая часть до новой строки

        but_next.setOnClickListener {
            if (k < parts.size - 1) {
                k +=1
                textView.text = parts[k]
            }
        }
        // Обработчик кнопки "Назад" (если нужно)
        but_back.setOnClickListener {
            if (k != 0) {
                k -= 1
                textView.text = parts[k]
            }
            else {
                finish()
            }
        }
    }
}