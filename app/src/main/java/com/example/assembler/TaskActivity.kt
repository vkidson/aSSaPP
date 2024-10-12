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
        //val valuesListView: ListView = findViewById(R.id.values)
        val bb : Button = findViewById(R.id.button_next_task)
        val button_main : Button = findViewById(R.id.button_to_main)
        bb.visibility = View.INVISIBLE
        val dbHelper = DBhelper(this) // Убедитесь, что здесь правильное имя класса

        val text1 : TextView = findViewById(R.id.textView1)
        val text2 : TextView = findViewById(R.id.textView2)
        val text3 : TextView = findViewById(R.id.textView3)
        val text4 : TextView = findViewById(R.id.textView4)
        val text5 : TextView = findViewById(R.id.textView5)

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

        if (valu.size == 5) {
            text1.text = valu[0]
            text2.text = valu[1]
            text3.text = valu[2]
            text4.text = valu[3]
            text5.text = valu[4]
            text5.visibility = View.VISIBLE
        }
        else {
            text1.text = valu[0]
            text2.text = valu[1]
            text3.text = valu[2]
            text4.text = valu[3]
            text5.visibility = View.INVISIBLE
        }




        text1.setOnClickListener {
            if (fl.indexOf(1) == 0) {
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
                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    if (minus == 1 || minus == 2 || minus == 3) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден. Кол-во ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }
                    idtask = 1
                    Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                    finish()
                }

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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this, "Тест пройден. Кол-вл ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }

                }
            }
        }


        text2.setOnClickListener {
            if (fl.indexOf(1) == 1) {
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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    if (minus == 1 || minus == 2 || minus == 3) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден. Кол-во ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }
                    if (minus == 0) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                        finish()
                    }

                }

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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this, "Тест пройден. Кол-вл ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }

                }
            }
        }

        text3.setOnClickListener {
            if (fl.indexOf(1) == 2) {
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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    if (minus == 1 || minus == 2 || minus == 3) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден. Кол-во ошибок $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }
                    if (minus == 0) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this, "Тест пройден. Кол-вл ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }

                }
            }
        }

        text4.setOnClickListener {
            if (fl.indexOf(1) == 3) {
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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    if (minus == 1 || minus == 2 || minus == 3) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден. Кол-во ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }
                    if (minus == 0) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this, "Тест пройден. Кол-вл ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }

                }
            }
        }

        text5.setOnClickListener {
            if (fl.indexOf(1) == 4) {
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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    if (minus == 1 || minus == 2 || minus == 3) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден. Кол-во ошибок $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }
                    if (minus == 0) {
                        idtask = 1
                        Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

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

                if (valu.size == 5) {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.text = valu[4]
                    text5.visibility = View.VISIBLE
                }
                else {
                    text1.text = valu[0]
                    text2.text = valu[1]
                    text3.text = valu[2]
                    text4.text = valu[3]
                    text5.visibility = View.INVISIBLE
                }

                if (idtask == taskIds.size) {
                    idtask = 1
                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок, их $minus!. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else {
                        Toast.makeText(this, "Тест пройден. Кол-вл ошибок: $minus.", Toast.LENGTH_LONG).show()
                        finish()
                    }

                }
            }
        }


        //val valuesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, valu)

            // Установка адаптера для ListView
        //valuesListView.adapter = valuesAdapter

        /*valuesListView.setOnItemClickListener { _, _, i, _ ->
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

                    if (minus > 3) {
                        idtask = 1
                        Toast.makeText(this, "У тебя более 3-х ошибок. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    Toast.makeText(this, "Тест пройден. Ты совершил $minus ошибку(-и)", Toast.LENGTH_LONG).show()
                    finish()
                }
*//*
                if (minus > 3) {
                    idtask = 1
                    Toast.makeText(this, "У тебя более 3-х ошибок. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, el_theory::class.java)
                    startActivity(intent)
                    finish()
                }*//*



            }

        }*/

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