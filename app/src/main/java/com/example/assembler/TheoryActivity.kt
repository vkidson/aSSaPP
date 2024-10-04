package com.example.assembler

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class TheoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_theory)

        val list: ListView = findViewById(R.id.mainList)
        val items = listOf("Введение в Assembler", "Карта")

        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        list.adapter = listAdapter

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    // Открываем новую активность для "Введение в Assembler"
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Действия для "Следующий материал"
                    // Вы можете добавить здесь другую активность или функционал
                }
            }



        }
    }
}