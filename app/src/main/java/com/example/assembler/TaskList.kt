package com.example.assembler

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.assembler.MainActivity.Companion.idtheme

class TaskList : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task_list)

        val taskList : ListView = findViewById(R.id.tList)
        val items = listOf("Введение в ассемблер")
        val tla = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        val button_main : Button = findViewById(R.id.button_main)
        // Установка адаптера для ListView
        taskList.adapter = tla

        taskList.setOnItemClickListener { _, _, i, _ ->
            idtheme = i + 1
            //Log.d("asd", "$idtheme")
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