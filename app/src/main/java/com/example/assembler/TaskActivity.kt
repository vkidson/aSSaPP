package com.example.assembler

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
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

        val num: TextView = findViewById(R.id.number)
        val tasksTextView: TextView = findViewById(R.id.task)
        val valuesListView: ListView = findViewById(R.id.values)
        val bb : Button = findViewById(R.id.button_next_task)
        bb.visibility = View.INVISIBLE
        val dbHelper = DBhelper(this) // Убедитесь, что здесь правильное имя класса

        // Получение всех задач
        val tasks = dbHelper.getAllTasks()
        val taskList = mutableListOf<String>()
        val taskIds = mutableListOf<Int>()

        val valu = mutableListOf<String>()
        val fl = mutableListOf<Int>()

        for (task in tasks) {
            taskList.add("${task.second}\n")
            taskIds.add(task.first)
            Log.d("asd", "$taskList")
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

            if (i == fl.indexOf(1)) {
                fl.clear()
                valu.clear()
                taskList.clear()
                taskIds.clear()
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
                for (value in values) {
                    valu.add(value.second)
                    fl.add(value.first)
                }
                val valuesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, valu)

                // Установка адаптера для ListView
                valuesListView.adapter = valuesAdapter
            }
            else {
                Toast.makeText(this, "Ответ неверный!", Toast.LENGTH_SHORT).show()
            }
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