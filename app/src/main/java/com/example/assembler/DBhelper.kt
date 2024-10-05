package com.example.assembler

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.assembler.MainActivity.Companion.idtheme

class DBhelper(val context: Context) :
    SQLiteOpenHelper(context, "base", null ,15) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query1 = "CREATE TABLE task (id INT PRIMARY KEY, task TEXT, theme INT)"
        val query2 = "CREATE TABLE task_values (task_id INT, value TEXT, f INT, FOREIGN KEY(task_id) REFERENCES task(id))"
        db!!.execSQL(query1)
        db!!.execSQL(query2)

        // Вставка данных в таблицу task
        val insertTask1 = "INSERT INTO task (id, task, theme) VALUES (1, 'Какие системные программы используются при разработке и отладке программ на языке ассемблера?', 1)"
        val insertTask2 = "INSERT INTO task (id, task, theme) VALUES (2, 'Сколько байтов памяти зарезервирует следующая последовательность операторов:'" + "'\n X1 DW 5  \n'" +
                "'X2 DB 3 DUP(?), 7  \n'" +
                "'X3 DW 6 DUP(?)\n', 1)"
        val insertTask3 = "INSERT INTO task (id, task, theme) VALUES (3, 'Что такое физический и логический адреса в микропроцессорах 80х86?', 1)"
        val insertTask4 = "INSERT INTO task (id, task, theme) VALUES (4, 'Какие регистры микропроцессора могут участвовать в формировании физического адреса при выборке команд, при обращении к переменным?', 1)"
        val insertTask5 = "INSERT INTO task (id, task, theme) VALUES (5, 'Какие три атрибута имеет переменная?', 1)"
        val insertTask6 = "INSERT INTO task (id, task, theme) VALUES (6, 'Какие ошибки имеются в каждом из приведенных далее фрагментов программ:'" + "' \n CONST EOU   256  \n'" +
                "' ...  \n'" +
                "' MOV  CONST, AX  \n', 1)"
        val insertTask7 = "INSERT INTO task (id, task, theme) VALUES (7, 'Х   DB ?  \n'" +
                "'  ...  \n'" +
                "'  MOV X, AX\n', 1)"
        val insertTask8 = "INSERT INTO task (id, task, theme) VALUES (8, 'X   DB ?  \n'" +
                "'  Y   DB 25  \n'" +
                "'  ...  \n'" +
                "' MOV   X, Y\n', 1)"
        val insertTask9 = "INSERT INTO task (id, task, theme) VALUES (9, 'MOV [BX][BP], AX', 1)"
        db!!.execSQL(insertTask1)
        db!!.execSQL(insertTask2)
        db!!.execSQL(insertTask3)
        db!!.execSQL(insertTask4)
        db!!.execSQL(insertTask5)
        db!!.execSQL(insertTask6)
        db!!.execSQL(insertTask7)
        db!!.execSQL(insertTask8)
        db!!.execSQL(insertTask9)


        // Вставка данных в таблицу task_values
        val insertValue1_1 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'Компиляторы', 0)"
        val insertValue1_2 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'Дебаггеры', 1)"
        val insertValue1_3 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'Интерпретаторы', 0)"
        val insertValue1_4 = "INSERT INTO task_values (task_id, value, f) VALUES (1, 'Операционные системы', 0)"
        db!!.execSQL(insertValue1_1)
        db!!.execSQL(insertValue1_2)
        db!!.execSQL(insertValue1_3)
        db!!.execSQL(insertValue1_4)
        val insertValue2_1 = "INSERT INTO task_values (task_id, value, f) VALUES (2, '13 байт', 0)"
        val insertValue2_2 = "INSERT INTO task_values (task_id, value, f) VALUES (2, '18 байт', 1)"
        val insertValue2_3 = "INSERT INTO task_values (task_id, value, f) VALUES (2, '20 байт', 0)"
        val insertValue2_4 = "INSERT INTO task_values (task_id, value, f) VALUES (2, '22 байта', 0)"
        db!!.execSQL(insertValue2_1)
        db!!.execSQL(insertValue2_2)
        db!!.execSQL(insertValue2_3)
        db!!.execSQL(insertValue2_4)
        val insertValue3_1 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'Логический адрес — это адрес, который используется для обращения к памяти, физический — это реальный адрес в памяти.', 1)"
        val insertValue3_2 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'Логический адрес — это адрес в регистре, физический — это адрес в ОЗУ.  ', 0)"
        val insertValue3_3 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'Логический адрес — это адрес, заданный пользователем, физический — адрес, определяемый устройствами.', 0)"
        val insertValue3_4 = "INSERT INTO task_values (task_id, value, f) VALUES (3, 'Логический адрес и физический адрес — это одно и то же понятие.  ', 0)"
        db!!.execSQL(insertValue3_1)
        db!!.execSQL(insertValue3_2)
        db!!.execSQL(insertValue3_3)
        db!!.execSQL(insertValue3_4)
        val insertValue4_1 = "INSERT INTO task_values (task_id, value, f) VALUES (4, 'AX, BX  ', 0)"
        val insertValue4_2 = "INSERT INTO task_values (task_id, value, f) VALUES (4, 'SI, DI', 0)"
        val insertValue4_3 = "INSERT INTO task_values (task_id, value, f) VALUES (4, 'CS, DS', 1)"
        val insertValue4_4 = "INSERT INTO task_values (task_id, value, f) VALUES (4, 'IP, SP', 0)"
        db!!.execSQL(insertValue4_1)
        db!!.execSQL(insertValue4_2)
        db!!.execSQL(insertValue4_3)
        db!!.execSQL(insertValue4_4)
        val insertValue5_1 = "INSERT INTO task_values (task_id, value, f) VALUES (5, 'Имя, тип, размер', 0)"
        val insertValue5_2 = "INSERT INTO task_values (task_id, value, f) VALUES (5, 'Имя, значение, адрес', 1)"
        val insertValue5_3 = "INSERT INTO task_values (task_id, value, f) VALUES (5, 'Тип, вид, код', 0)"
        val insertValue5_4 = "INSERT INTO task_values (task_id, value, f) VALUES (5, 'Имя, значение, версия', 0)"
        db!!.execSQL(insertValue5_1)
        db!!.execSQL(insertValue5_2)
        db!!.execSQL(insertValue5_3)
        db!!.execSQL(insertValue5_4)
        val insertValue6_1 = "INSERT INTO task_values (task_id, value, f) VALUES (6, 'Переполнение', 0)"
        val insertValue6_2 = "INSERT INTO task_values (task_id, value, f) VALUES (6, 'Нет объявления переменной', 1)"
        val insertValue6_3 = "INSERT INTO task_values (task_id, value, f) VALUES (6, 'Неверный тип', 0)"
        val insertValue6_4 = "INSERT INTO task_values (task_id, value, f) VALUES (6, 'Ошибка синтаксиса', 0)"
        db!!.execSQL(insertValue6_1)
        db!!.execSQL(insertValue6_2)
        db!!.execSQL(insertValue6_3)
        db!!.execSQL(insertValue6_4)
        val insertValue7_1 = "INSERT INTO task_values (task_id, value, f) VALUES (7, 'Неинициализированная переменная', 1)"
        val insertValue7_2 = "INSERT INTO task_values (task_id, value, f) VALUES (7, 'Неверный тип', 0)"
        val insertValue7_3 = "INSERT INTO task_values (task_id, value, f) VALUES (7, 'Ошибка синтаксиса', 0)"
        val insertValue7_4 = "INSERT INTO task_values (task_id, value, f) VALUES (7, 'Нет доступа к памяти', 0)"
        db!!.execSQL(insertValue7_1)
        db!!.execSQL(insertValue7_2)
        db!!.execSQL(insertValue7_3)
        db!!.execSQL(insertValue7_4)
        val insertValue8_1 = "INSERT INTO task_values (task_id, value, f) VALUES (8, 'Смешение типов', 0)"
        val insertValue8_2 = "INSERT INTO task_values (task_id, value, f) VALUES (8, 'X не инициализирован', 1)"
        val insertValue8_3 = "INSERT INTO task_values (task_id, value, f) VALUES (8, 'Неверный тип', 0)"
        val insertValue8_4 = "INSERT INTO task_values (task_id, value, f) VALUES (8, 'Нет разрешения', 0)"
        db!!.execSQL(insertValue8_1)
        db!!.execSQL(insertValue8_2)
        db!!.execSQL(insertValue8_3)
        db!!.execSQL(insertValue8_4)
        val insertValue9_1 = "INSERT INTO task_values (task_id, value, f) VALUES (9, 'Неверный тип операндов', 0)"
        val insertValue9_2 = "INSERT INTO task_values (task_id, value, f) VALUES (9, 'Ошибка адресации', 0)"
        val insertValue9_3 = "INSERT INTO task_values (task_id, value, f) VALUES (9, 'Нет доступа к памяти', 0)"
        val insertValue9_4 = "INSERT INTO task_values (task_id, value, f) VALUES (9, 'Неверная синтаксическая запись', 1)"
        db!!.execSQL(insertValue9_1)
        db!!.execSQL(insertValue9_2)
        db!!.execSQL(insertValue9_3)
        db!!.execSQL(insertValue9_4)
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