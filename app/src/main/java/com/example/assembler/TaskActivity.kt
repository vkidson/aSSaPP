package com.example.assembler

import android.content.Intent
import kotlinx.coroutines.*
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assembler.MainActivity.Companion.idtask
import com.example.assembler.MainActivity.Companion.idtheme
import kotlinx.coroutines.delay
import java.util.Timer
import kotlin.concurrent.schedule

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task)
        
        var minus : Int = 0
        if (idtheme == 11 || idtheme == 22 || idtheme == 33) {
            idtheme = 6
        }
        if (idtheme == 6) {
            minus = -4
        }

        var color = Color.parseColor("#cdcebf")
        var k : Int = 0

        val num: TextView = findViewById(R.id.number)
        val tasksTextView: TextView = findViewById(R.id.task)
        //val valuesListView: ListView = findViewById(R.id.values)
        val bb : Button = findViewById(R.id.button_next_task)
        val button_main : Button = findViewById(R.id.button_to_main)
        bb.visibility = View.INVISIBLE
        val dbHelper = DBhelper(this)

        val text1 : TextView = findViewById(R.id.textView1)
        val text2 : TextView = findViewById(R.id.textView2)
        val text3 : TextView = findViewById(R.id.textView3)
        val text4 : TextView = findViewById(R.id.textView4)
        val text5 : TextView = findViewById(R.id.textView5)


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


        num.text = idtask.toString()
        tasksTextView.text = taskList[idtask-1].toString()
        val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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

                color = Color.parseColor("#A6D565")
                ViewCompat.setBackgroundTintList(text1, ColorStateList.valueOf(color))

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text1, ColorStateList.valueOf(color))
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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }

                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 1 || minus == 2 || minus == 3) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                        idtask = 1
                        Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                        dbHelper.setDone()
                        val intent = Intent(this, TaskList::class.java)
                        startActivity(intent)
                        finish()
                    }
                }, 200)
            }
            else {
                var color = Color.parseColor("#F47E7E")
                ViewCompat.setBackgroundTintList(text1, ColorStateList.valueOf(color))


                minus += 1
                k += 1

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text1, ColorStateList.valueOf(color))

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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }
                }, 200)
            }
        }


        text2.setOnClickListener {
            if (fl.indexOf(1) == 1) {
                var color = Color.parseColor("#A6D565")
                ViewCompat.setBackgroundTintList(text2, ColorStateList.valueOf(color))

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text2, ColorStateList.valueOf(color))
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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 1 || minus == 2 || minus == 3) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 0) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }
                }, 200)
            }
            else {
                var color = Color.parseColor("#F47E7E")
                ViewCompat.setBackgroundTintList(text2, ColorStateList.valueOf(color))


                minus += 1
                k += 1

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text2, ColorStateList.valueOf(color))

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

                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }
                }, 200)
            }
        }

        text3.setOnClickListener {
            if (fl.indexOf(1) == 2) {
                var color = Color.parseColor("#A6D565")
                ViewCompat.setBackgroundTintList(text3, ColorStateList.valueOf(color))

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text3, ColorStateList.valueOf(color))
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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 1 || minus == 2 || minus == 3) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 0) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }, 200)
            }
            else {
                var color = Color.parseColor("#F47E7E")
                ViewCompat.setBackgroundTintList(text3, ColorStateList.valueOf(color))


                minus += 1
                k += 1

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text3, ColorStateList.valueOf(color))

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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }
                }, 200)
            }
        }

        text4.setOnClickListener {
            if (fl.indexOf(1) == 3) {
                var color = Color.parseColor("#A6D565")
                ViewCompat.setBackgroundTintList(text4, ColorStateList.valueOf(color))

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text4, ColorStateList.valueOf(color))
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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 1 || minus == 2 || minus == 3) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 0) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }, 200)
            }
            else {
                var color = Color.parseColor("#F47E7E")
                ViewCompat.setBackgroundTintList(text4, ColorStateList.valueOf(color))


                minus += 1
                k += 1

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text4, ColorStateList.valueOf(color))

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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }
                }, 200)
            }
        }

        text5.setOnClickListener {
            if (fl.indexOf(1) == 4) {
                var color = Color.parseColor("#A6D565")
                ViewCompat.setBackgroundTintList(text5, ColorStateList.valueOf(color))

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text5, ColorStateList.valueOf(color))
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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 1 || minus == 2 || minus == 3) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                        if (minus == 0) {
                            idtask = 1
                            Toast.makeText(this, "Тест пройден без ошибок!", Toast.LENGTH_SHORT).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }, 200)
            }
            else {
                var color = Color.parseColor("#F47E7E")
                ViewCompat.setBackgroundTintList(text5, ColorStateList.valueOf(color))


                minus += 1
                k += 1

                Handler(Looper.getMainLooper()).postDelayed({
                    color = Color.parseColor("#cdcebf")
                    ViewCompat.setBackgroundTintList(text5, ColorStateList.valueOf(color))

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


                    num.text = idtask.toString()
                    tasksTextView.text = taskList[idtask-1].toString()
                    val values = dbHelper.getValuesForTask(taskIds[idtask-1])
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
                        num.visibility = View.INVISIBLE

                        text1.visibility = View.INVISIBLE
                        text2.visibility = View.INVISIBLE
                        text3.visibility = View.INVISIBLE
                        text4.visibility = View.INVISIBLE
                        text5.visibility = View.INVISIBLE
                        idtask = 1
                        if (minus > 3) {
                            idtask = 1
                            Toast.makeText(this, "У тебя много ошибок, их $k! ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                            if (idtheme == 6) {
                                val intent = Intent(this, TheoryActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            val intent = Intent(this, el_theory::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this, "Тест пройден. Кол-во ошибок: $k.", Toast.LENGTH_LONG).show()
                            dbHelper.setDone()
                            val intent = Intent(this, TaskList::class.java)
                            startActivity(intent)
                            finish()
                        }

                    }
                }, 200)
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
k += 1

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
                        Toast.makeText(this, "У тебя много ошибок. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, el_theory::class.java)
                        startActivity(intent)
                        finish()
                    }
                    Toast.makeText(this, "Тест пройден. Ты совершил $k ошибку(-и)", Toast.LENGTH_LONG).show()
                    finish()
                }
*//*
                if (minus > 3) {
                    idtask = 1
                    Toast.makeText(this, "У тебя много ошибок. ЧИТАЙ ТЕОРИЮ!!!", Toast.LENGTH_LONG).show()
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