package com.example.assembler

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.assembler.MainActivity.Companion.idtheme

class TheoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_theory)

        val list: ListView = findViewById(R.id.mainList)
        val items = listOf("Введение в Assembler", "Макросредства", "Внешние подпрограммы", "Сложные структуры данных", "Арифметический сопроцессор")
        val button_main : Button = findViewById(R.id.button_main)

        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        list.adapter = listAdapter

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    idtheme = 1
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                }
                1 -> {
                    idtheme = 2
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                }
                2 -> {
                    idtheme = 3
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                }
                3 -> {
                    idtheme = 4
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                }
                4 -> {
                    idtheme = 5
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                }
            }
        }
        button_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}