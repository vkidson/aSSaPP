package com.example.assembler

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.assembler.MainActivity.Companion.idtheme

class DBhelper(val context: Context) :
    SQLiteOpenHelper(context, "base", null ,9) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query1 = "CREATE TABLE task (id INT PRIMARY KEY, task TEXT, theme INT)"
        val query2 = "CREATE TABLE task_values (task_id INT, value TEXT, f INT, FOREIGN KEY(task_id) REFERENCES task(id))"
        db!!.execSQL(query1)
        db!!.execSQL(query2)

        // Вставка данных в таблицу task
        val insertTask1 = "INSERT INTO task (id, task, theme) VALUES (1, 'Какой командой в TASM можно выполнить переход на другую метку?', 1)"
        val insertTask2 = "INSERT INTO task (id, task, theme) VALUES (2, 'Какая команда используется для сложения двух регистров?', 1)"
        val insertTask3 = "INSERT INTO task (id, task, theme) VALUES (3, 'Какой командой можно инкрементировать значение в регистре?', 1)"
        db!!.execSQL(insertTask1)
        db!!.execSQL(insertTask2)
        db!!.execSQL(insertTask3)


        // Вставка данных в таблицу task_values
        val insertValue1_1 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'MOV', 0)"
        val insertValue1_2 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'SUB', 0)"
        val insertValue1_3 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'JMP', 1)"
        val insertValue1_4 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'ADD', 0)"
        db!!.execSQL(insertValue1_1)
        db!!.execSQL(insertValue1_2)
        db!!.execSQL(insertValue1_3)
        db!!.execSQL(insertValue1_4)
        val insertValue2_1 = "INSERT INTO task_values (task_id, value, f) VALUES (2, 'MUL', 0)"
        val insertValue2_2 = "INSERT INTO task_values (task_id, value, f) VALUES (2, 'ADD', 1)"
        val insertValue2_3 = "INSERT INTO task_values (task_id, value, f) VALUES (2, 'DIV', 0)"
        val insertValue2_4 = "INSERT INTO task_values (task_id, value, f) VALUES (2, 'INC', 0)"
        db!!.execSQL(insertValue2_1)
        db!!.execSQL(insertValue2_2)
        db!!.execSQL(insertValue2_3)
        db!!.execSQL(insertValue2_4)
        val insertValue3_1 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'DEC', 0)"
        val insertValue3_2 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'ADD', 0)"
        val insertValue3_3 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'PUSH', 0)"
        val insertValue3_4 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'INC', 1)"
        db!!.execSQL(insertValue3_1)
        db!!.execSQL(insertValue3_2)
        db!!.execSQL(insertValue3_3)
        db!!.execSQL(insertValue3_4)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS task")
        db!!.execSQL("DROP TABLE IF EXISTS task_values")
        onCreate(db)
    }

    fun getAllTasks(): List<Triple<Int, String, Int>> {

        val tasks = mutableListOf<Triple<Int, String, Int>>()
        val db = this.readableDatabase

        val cursor = db.rawQuery("SELECT id, task, theme FROM task WHERE theme = '$idtheme'", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val task = cursor.getString(1)
                val theme = cursor.getInt(2)

                tasks.add(Triple(id, task, theme))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }

    fun getValuesForTask(taskId: Int): List<Pair<Int, String>> {
        val values = mutableListOf<Pair<Int, String>>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT f, value FROM task_values WHERE task_id = ?", arrayOf(taskId.toString()))

        if (cursor.moveToFirst()) {
            do {
                val f = cursor.getInt(0)
                val value = cursor.getString(1)
                values.add(Pair(f, value))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return values
    }


}