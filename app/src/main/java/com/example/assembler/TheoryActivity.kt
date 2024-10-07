package com.example.assembler

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.assembler.MainActivity.Companion.idtheme

class TheoryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_theory)

        val textview1 : TextView = findViewById(R.id.textView1)
        val textview2 : TextView = findViewById(R.id.textView2)
        val textview3 : TextView = findViewById(R.id.textView3)
        val textview4 : TextView = findViewById(R.id.textView4)
        val textview5 : TextView = findViewById(R.id.textView5)
        val items = listOf("Введение в Assembler", "Макросредства", "Внешние подпрограммы", "Сложные структуры данных", "Арифметический сопроцессор")
        val button_main : Button = findViewById(R.id.button_main)
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        textview1.setOnClickListener {
            idtheme = 1
            val intent = Intent(this, el_theory::class.java)
            startActivity(intent)
        }

        textview2.setOnClickListener {
            idtheme = 2
            val intent = Intent(this, el_theory::class.java)
            startActivity(intent)
        }

        textview3.setOnClickListener {
            idtheme = 3
            val intent = Intent(this, el_theory::class.java)
            startActivity(intent)
        }

        textview4.setOnClickListener {
            idtheme = 4
            val intent = Intent(this, el_theory::class.java)
            startActivity(intent)
        }

        textview5.setOnClickListener {
            idtheme = 5
            val intent = Intent(this, el_theory::class.java)
            startActivity(intent)
        }

        button_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}