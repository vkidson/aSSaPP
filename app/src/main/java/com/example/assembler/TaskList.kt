package com.example.assembler

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.assembler.MainActivity.Companion.idtheme

class TaskList : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task_list)

        //val taskList : ListView = findViewById(R.id.tList)
        //val items = listOf("Введение в ассемблер", "Макрокоманды", "Внешние подпрограммы", "Сложные структуры данных", "Арифметический сопроцессор")
       // val tla = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        val button_main : Button = findViewById(R.id.button_main)
        val text1 : TextView = findViewById(R.id.textView1)
        val text2 : TextView = findViewById(R.id.textView2)
        val text3 : TextView = findViewById(R.id.textView3)
        val text4 : TextView = findViewById(R.id.textView4)
        val text5 : TextView = findViewById(R.id.textView5)

        text1.setOnClickListener {
            idtheme = 1
            //Log.d("asd", "$idtheme")
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }
        text2.setOnClickListener {
            idtheme = 2
            //Log.d("asd", "$idtheme")
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }
        text3.setOnClickListener {
            idtheme = 3
            //Log.d("asd", "$idtheme")
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }
        text4.setOnClickListener {
            idtheme = 4
            //Log.d("asd", "$idtheme")
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }
        text5.setOnClickListener {
            idtheme = 5
            //Log.d("asd", "$idtheme")
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }

        // Установка адаптера для ListView

        button_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

