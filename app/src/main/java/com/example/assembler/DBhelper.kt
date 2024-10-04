package com.example.assembler

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(val context: Context) :
    SQLiteOpenHelper(context, "base", null ,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query1 = "CREATE TABLE task (id INT PRIMARY KEY, task TEXT)"
        val query2 = "CREATE TABLE task_values (task_id INT, value TEXT, FOREIGN KEY(task_id) REFERENCES task(id))"
        db!!.execSQL(query1)
        db!!.execSQL(query2)

        // Вставка данных в таблицу task
        val insertTask1 = "INSERT INTO task (id, task) VALUES (1, 'Задача 1')"
        val insertTask2 = "INSERT INTO task (id, task) VALUES (2, 'Задача 2')"
        db.execSQL(insertTask1)
        db.execSQL(insertTask2)

        // Вставка данных в таблицу task_values
        val insertValue1_1 = "INSERT INTO task_values (task_id, value) VALUES (1, 'Значение 1')"
        val insertValue1_2 = "INSERT INTO task_values (task_id, value) VALUES (1, 'Значение 2')"
        val insertValue1_3 = "INSERT INTO task_values (task_id, value) VALUES (1, 'Значение 3')"
        val insertValue1_4 = "INSERT INTO task_values (task_id, value) VALUES (1, 'Значение 4')"
        db.execSQL(insertValue1_1)
        db.execSQL(insertValue1_2)
        db.execSQL(insertValue1_3)
        db.execSQL(insertValue1_4)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS task")
        db!!.execSQL("DROP TABLE IF EXISTS task_values")
        onCreate(db)
    }

    fun getAllTasks(): List<Pair<Int, String>> {
        val tasks = mutableListOf<Pair<Int, String>>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT id, task FROM task", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val task = cursor.getString(1)
                tasks.add(Pair(id, task))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return tasks
    }

    fun getValuesForTask(taskId: Int): List<String> {
        val values = mutableListOf<String>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT value FROM task_values WHERE task_id = ?", arrayOf(taskId.toString()))

        if (cursor.moveToFirst()) {
            do {
                val value = cursor.getString(0)
                values.add(value)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return values
    }


}