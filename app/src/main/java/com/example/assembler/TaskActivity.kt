package com.example.assembler

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assembler.MainActivity.Companion.idtask
import com.example.assembler.MainActivity.Companion.idtheme

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task)

        var minus : Int = 0

        val num: TextView = findViewById(R.id.number)
        val tasksTextView: TextView = findViewById(R.id.task)
        val valuesListView: ListView = findViewById(R.id.values)
        val bb : Button = findViewById(R.id.button_next_task)
        val button_main : Button = findViewById(R.id.button_to_main)
        bb.visibility = View.INVISIBLE
        val dbHelper = DBhelper(this) // Убедитесь, что здесь правильное имя класса

        // Получение всех задач
        //Log.d("qwe", "$idtheme")
        val tasks = dbHelper.getAllTasks()
        val taskList = mutableListOf<String>()
        val taskIds = mutableListOf<Int>()

        val valu = mutableListOf<String>()
        val fl = mutableListOf<Int>()

        for (task in tasks) {
            taskList.add("${task.second}\n")
            taskIds.add(task.first)
            //Log.d("asd", "$taskList")
        }

        // Получение значений для первой задачи (например, с ID = 1)
        num.text = idtask.toString()
        tasksTextView.text = taskList[idtask-1].toString()
        val values = dbHelper.getValuesForTask(taskIds[idtask-1]) // Получаем значения для первой задачи
        for (value in values) {
            valu.add(value.second)
            fl.add(value.first)
        }
        val valuesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, valu)

            // Установка адаптера для ListView
        valuesListView.adapter = valuesAdapter

        valuesListView.setOnItemClickListener { _, _, i, _ ->
            Log.d("asd", "${taskIds.size} $idtask")
            if (i == fl.indexOf(1)) {
                fl.clear()
                valu.clear()
                taskList.clear()
                taskIds.clear()
                idtask += 1

                if (idtask == taskIds.size) {
                    idtask = 1
                    Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                    finish()
                }

                for (task in tasks) {
                    taskList.add("${task.second}\n")
                    taskIds.add(task.first)
                    //Log.d("asd", "$taskList")
                }

                // Получение значений для первой задачи (например, с ID = 1)
                num.text = idtask.toString()
                tasksTextView.text = taskList[idtask-1].toString()
                val values = dbHelper.getValuesForTask(taskIds[idtask-1]) // Получаем значения для первой задачи
                for (value in values) {
                    valu.add(value.second)
                    fl.add(value.first)
                }
                val valuesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, valu)

                // Установка адаптера для ListView
                valuesListView.adapter = valuesAdapter


            }
            else {
                minus += 1

                fl.clear()
                valu.clear()
                taskList.clear()
                taskIds.clear()
                idtask += 1

                for (task in tasks) {
                    taskList.add("${task.second}\n")
                    taskIds.add(task.first)
                    //Log.d("asd", "$taskList")
                }

                // Получение значений для первой задачи (например, с ID = 1)
                num.text = idtask.toString()
                tasksTextView.text = taskList[idtask-1].toString()
                val values = dbHelper.getValuesForTask(taskIds[idtask-1]) // Получаем значения для первой задачи
                for (value in values) {
                    valu.add(value.second)
                    fl.add(value.first)
                }
                val valuesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, valu)

                // Установка адаптера для ListView
                valuesListView.adapter = valuesAdapter

                if (idtask == taskIds.size) {
                    idtask = 1

                    if (minus >= 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    Toast.makeText(this, "Тест пройден. Ты совершил $minus ошибку(-и)", Toast.LENGTH_LONG).show()
                    finish()
                }
/*
                if (minus >= 3) {
                    idtask = 1
                    Toast.makeText(this, "У тебя более 3-х ошибок. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                    finish()
                }*/



            }

        }

        button_main.setOnClickListener {
            idtask = 1
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*if (flag == true) {
            bb.setOnClickListener {
                idtask += 1
                for (task in tasks) {
                    taskList.add("${task.second}\n")
                    taskIds.add(task.first)
                    Log.d("asd", "$taskList")
                }

                // Получение значений для первой задачи (например, с ID = 1)
                num.text = idtask.toString()
                tasksTextView.text = taskList[idtask-1].toString()
                val values = dbHelper.getValuesForTask(taskIds[idtask-1]) // Получаем значения для первой задачи
                val valuesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, values)

                // Установка адаптера для ListView
                valuesListView.adapter = valuesAdapter
            }
        }
        else {
            Toast.makeText(this, "Ответ неверный!", Toast.LENGTH_SHORT)
        }*/

    }


}