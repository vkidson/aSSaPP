package com.example.assembler

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.assembler.MainActivity.Companion.idtheme

class el_theory : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_el_theory)

        val but_next : Button = findViewById(R.id.button_next)
        val but_back : Button = findViewById(R.id.button_back)
        val but_test : Button = findViewById(R.id.button_to_test)
        val textView : TextView = findViewById(R.id.mainText)
        val button_main : Button = findViewById(R.id.button_main)

        val filename = when (idtheme) {
            1 -> "first.txt"
            2 -> "second.txt"
            3 -> "third.txt"
            4 -> "fourth.txt"
            5 -> "fifth.txt"
            else -> {finish()}
        }
        but_next.translationZ = 2f
        but_test.translationZ = 1f
        val inputStream = assets.open(filename.toString())
        val text = inputStream.bufferedReader().use { it.readText() }
        textView.text = text
        textView.movementMethod = ScrollingMovementMethod()

        // Разделение текста
        val parts = text.split(Regex("\\n\\s*\\n"), limit = 10) // Разделяем по первой новой строке
        var k = 0
        textView.text = parts[k] // Первая часть до новой строки

        but_next.setOnClickListener {
            if (k < parts.size - 1) {
                k +=1
                textView.text = parts[k]
                textView.scrollTo(0,0)

            }
            if (k == parts.size - 1) {
                but_next.translationZ = 1f
                but_test.translationZ = 2f
                but_test.setBackgroundColor(Color.GREEN)

                but_next.visibility = View.INVISIBLE
                but_test.visibility = View.VISIBLE
            }
        }
        // Обработчик кнопки "Назад" (если нужно)
        but_back.setOnClickListener {
            if (k != 0) {
                k -= 1
                textView.text = parts[k]
                textView.scrollTo(0,0)

                but_next.translationZ = 2f
                but_test.translationZ = 1f
                but_test.setBackgroundColor(Color.GREEN)

                but_next.visibility = View.VISIBLE
                but_test.visibility = View.GONE
            }
            else {
                finish()
            }
        }

        but_test.setOnClickListener {
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }

        button_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}