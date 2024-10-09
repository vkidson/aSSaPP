package com.example.assembler

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.assembler.MainActivity.Companion.idtheme

class DBhelper(val context: Context) :
    SQLiteOpenHelper(context, "base", null ,36) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query1 = "CREATE TABLE task (id INT PRIMARY KEY, task TEXT, theme INT)"
        val query2 = "CREATE TABLE task_values (task_id INT, theme INT, value TEXT, f INT, FOREIGN KEY(task_id) REFERENCES task(id))"
        db!!.execSQL(query1)
        db!!.execSQL(query2)

        // ВОПРОСЫ 1 ТЕМА
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
        val insertTask10 = "INSERT INTO task (id, task, theme) VALUES (10, '', 1)"
        db!!.execSQL(insertTask1)
        db!!.execSQL(insertTask2)
        db!!.execSQL(insertTask3)
        db!!.execSQL(insertTask4)
        db!!.execSQL(insertTask5)
        db!!.execSQL(insertTask6)
        db!!.execSQL(insertTask7)
        db!!.execSQL(insertTask8)
        db!!.execSQL(insertTask9)
        db!!.execSQL(insertTask10)

        // ОТВЕТЫ НА ВОПРОСЫ 1 ТЕМА
        val insertValue1_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (1, 1,'Компиляторы', 0)"
        val insertValue1_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (1, 1,'Дебаггеры', 1)"
        val insertValue1_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (1, 1,'Интерпретаторы', 0)"
        val insertValue1_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (1, 1,'Операционные системы', 0)"
        db!!.execSQL(insertValue1_1)
        db!!.execSQL(insertValue1_2)
        db!!.execSQL(insertValue1_3)
        db!!.execSQL(insertValue1_4)
        val insertValue2_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (2, 1,'13 байт', 0)"
        val insertValue2_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (2, 1,'18 байт', 1)"
        val insertValue2_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (2, 1,'20 байт', 0)"
        val insertValue2_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (2, 1,'22 байта', 0)"
        db!!.execSQL(insertValue2_1)
        db!!.execSQL(insertValue2_2)
        db!!.execSQL(insertValue2_3)
        db!!.execSQL(insertValue2_4)
        val insertValue3_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (3, 1,'Логический адрес для обращения к памяти, физический — реальный адрес в памяти.', 1)"
        val insertValue3_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (3, 1,'Логический — это адрес в регистре, физический — адрес в ОЗУ.  ', 0)"
        val insertValue3_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (3, 1,'Логический — задается пользователем, физический — определяется устройствами.', 0)"
        val insertValue3_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (3, 1,'Логический и физический адреса — это одно и то же понятие.  ', 0)"
        db!!.execSQL(insertValue3_1)
        db!!.execSQL(insertValue3_2)
        db!!.execSQL(insertValue3_3)
        db!!.execSQL(insertValue3_4)
        val insertValue4_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (4, 1,'AX, BX  ', 0)"
        val insertValue4_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (4, 1,'SI, DI', 0)"
        val insertValue4_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (4, 1,'CS, DS', 1)"
        val insertValue4_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (4, 1,'IP, SP', 0)"
        db!!.execSQL(insertValue4_1)
        db!!.execSQL(insertValue4_2)
        db!!.execSQL(insertValue4_3)
        db!!.execSQL(insertValue4_4)
        val insertValue5_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (5, 1,'Имя, тип, размер', 0)"
        val insertValue5_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (5, 1,'Имя, значение, адрес', 1)"
        val insertValue5_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (5, 1,'Тип, вид, код', 0)"
        val insertValue5_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (5, 1,'Имя, значение, версия', 0)"
        db!!.execSQL(insertValue5_1)
        db!!.execSQL(insertValue5_2)
        db!!.execSQL(insertValue5_3)
        db!!.execSQL(insertValue5_4)
        val insertValue6_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (6, 1,'Переполнение', 0)"
        val insertValue6_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (6, 1,'Нет объявления переменной', 1)"
        val insertValue6_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (6, 1,'Неверный тип', 0)"
        val insertValue6_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (6, 1,'Ошибка синтаксиса', 0)"
        db!!.execSQL(insertValue6_1)
        db!!.execSQL(insertValue6_2)
        db!!.execSQL(insertValue6_3)
        db!!.execSQL(insertValue6_4)
        val insertValue7_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (7, 1,'Неинициализированная переменная', 1)"
        val insertValue7_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (7, 1,'Неверный тип', 0)"
        val insertValue7_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (7, 1,'Ошибка синтаксиса', 0)"
        val insertValue7_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (7, 1,'Нет доступа к памяти', 0)"
        db!!.execSQL(insertValue7_1)
        db!!.execSQL(insertValue7_2)
        db!!.execSQL(insertValue7_3)
        db!!.execSQL(insertValue7_4)
        val insertValue8_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (8, 1,'Смешение типов', 0)"
        val insertValue8_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (8, 1,'X не инициализирован', 1)"
        val insertValue8_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (8, 1,'Неверный тип', 0)"
        val insertValue8_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (8, 1,'Нет разрешения', 0)"
        db!!.execSQL(insertValue8_1)
        db!!.execSQL(insertValue8_2)
        db!!.execSQL(insertValue8_3)
        db!!.execSQL(insertValue8_4)
        val insertValue9_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (9, 1,'Неверный тип операндов', 0)"
        val insertValue9_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (9, 1,'Ошибка адресации', 0)"
        val insertValue9_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (9, 1,'Нет доступа к памяти', 0)"
        val insertValue9_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (9, 1,'Неверная синтаксическая запись', 1)"
        db!!.execSQL(insertValue9_1)
        db!!.execSQL(insertValue9_2)
        db!!.execSQL(insertValue9_3)
        db!!.execSQL(insertValue9_4)
        val insertValue10_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 0)"
        val insertValue10_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 0)"
        val insertValue10_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 0)"
        val insertValue10_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 0)"
        db!!.execSQL(insertValue10_1)
        db!!.execSQL(insertValue10_2)
        db!!.execSQL(insertValue10_3)
        db!!.execSQL(insertValue10_4)


        //ВОПРОСЫ 2 ТЕМА
        val insertTask21 = "INSERT INTO task (id, task, theme) VALUES (11, 'Что позволяет делать макроассемблер?', 2)"
        val insertTask2_2 = "INSERT INTO task (id, task, theme) VALUES (12, 'Какие преимущества имеет использование макрокоманд?', 2)"
        val insertTask2_3 = "INSERT INTO task (id, task, theme) VALUES (13, 'Что позволяет делать макрокоманда на языке ассемблера?', 2)"
        val insertTask2_4 = "INSERT INTO task (id, task, theme) VALUES (14, 'Как определяется макрокоманда в коде?', 2)"
        val insertTask2_5 = "INSERT INTO task (id, task, theme) VALUES (15, 'Какая команда завершает определение макрокоманды?', 2)"
        val insertTask2_6 = "INSERT INTO task (id, task, theme) VALUES (16, 'Какое из следующих утверждений верно для фактических параметров макрокоманды?', 2)"
        val insertTask2_7 = "INSERT INTO task (id, task, theme) VALUES (17, 'Какой механизм принципиально отличается от механизма макрокоманд?', 2)"
        val insertTask2_8 = "INSERT INTO task (id, task, theme) VALUES (18, 'Что происходит при вызове подпрограммы с помощью команды CALL?', 2)"
        val insertTask2_9 = "INSERT INTO task (id, task, theme) VALUES (19, 'Что такое макрорасширение?', 2)"
        val insertTask2_10 = "INSERT INTO task (id, task, theme) VALUES (20, 'На какие группы можно разделить псевдокоманды ассемблера для задания макроопределений?', 2)"
        val insertTask2_11 = "INSERT INTO task (id, task, theme) VALUES (21, '', 2)"

        db!!.execSQL(insertTask21)
        db!!.execSQL(insertTask2_2)
        db!!.execSQL(insertTask2_3)
        db!!.execSQL(insertTask2_4)
        db!!.execSQL(insertTask2_5)
        db!!.execSQL(insertTask2_6)
        db!!.execSQL(insertTask2_7)
        db!!.execSQL(insertTask2_8)
        db!!.execSQL(insertTask2_9)
        db!!.execSQL(insertTask2_10)
        db!!.execSQL(insertTask2_11)

        //ОТВЕТЫ НА ВОПРОСЫ 2 ТЕМА
        val insertValue2_1_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (11, 2,'Выполнять команду один раз', 0)"
        val insertValue2_1_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (11, 2,'Помечать секции команд одним именем', 1)"
        val insertValue2_1_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (11, 2,'Автоматически исправлять ошибки', 0)"
        val insertValue2_1_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (11, 2,'Упрощать работу с подпрограммами', 0)"
        val insertValue2_1_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (11, 2,'Генерировать код на высоком уровне', 0)"

        db!!.execSQL(insertValue2_1_1)
        db!!.execSQL(insertValue2_1_2)
        db!!.execSQL(insertValue2_1_3)
        db!!.execSQL(insertValue2_1_4)
        db!!.execSQL(insertValue2_1_5)

        val insertValue2_2_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (12, 2,'Увеличение вероятности ошибки', 0)"
        val insertValue2_2_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (12, 2,'Уменьшение времени отладки', 1)"
        val insertValue2_2_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (12, 2,'Увеличение дублирующих усилий программистов', 0)"
        val insertValue2_2_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (12, 2,'Повышение сложности программы', 0)"

        db!!.execSQL(insertValue2_2_1)
        db!!.execSQL(insertValue2_2_2)
        db!!.execSQL(insertValue2_2_3)
        db!!.execSQL(insertValue2_2_4)

        val insertValue2_3_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (13, 2,'Переключаться на другие языки программирования', 0)"
        val insertValue2_3_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (13, 2,'Выполнять функции языков высокого уровня', 1)"
        val insertValue2_3_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (13, 2,'Упрощать код машинного языка', 0)"
        val insertValue2_3_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (13, 2,'Увеличивать объем программы', 0)"
        val insertValue2_3_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (13, 2,'Игнорировать параметры', 0)"

        db!!.execSQL(insertValue2_3_1)
        db!!.execSQL(insertValue2_3_2)
        db!!.execSQL(insertValue2_3_3)
        db!!.execSQL(insertValue2_3_4)
        db!!.execSQL(insertValue2_3_5)

        val insertValue2_4_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (14, 2,'С помощью команды CALL', 0)"
        val insertValue2_4_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (14, 2,'Псевдокомандой MACRO', 1)"
        val insertValue2_4_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (14, 2,'Псевдокомандой CALL', 0)"
        val insertValue2_4_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (14, 2,'С помощью команды RETURN', 0)"
        val insertValue2_4_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (14, 2,'Псевдокомандой START', 0)"

        db!!.execSQL(insertValue2_4_1)
        db!!.execSQL(insertValue2_4_2)
        db!!.execSQL(insertValue2_4_3)
        db!!.execSQL(insertValue2_4_4)
        db!!.execSQL(insertValue2_4_5)

        val insertValue2_5_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (15, 2,'ENDM', 1)"
        val insertValue2_5_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (15, 2,'END', 0)"
        val insertValue2_5_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (15, 2,'BEGIN', 0)"
        val insertValue2_5_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (15, 2,'EXIT', 0)"
        val insertValue2_5_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (15, 2,'FINISH', 0)"

        db!!.execSQL(insertValue2_5_1)
        db!!.execSQL(insertValue2_5_2)
        db!!.execSQL(insertValue2_5_3)
        db!!.execSQL(insertValue2_5_4)
        db!!.execSQL(insertValue2_5_5)

        val insertValue2_6_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (16, 2,'Они могут указываться в любом порядке', 0)"
        val insertValue2_6_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (16, 2,'Их можно не указывать', 0)"
        val insertValue2_6_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (16, 2,'Они не могут содержать символы', 0)"
        val insertValue2_6_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (16, 2,'Их можно вызывать только один раз', 0)"
        val insertValue2_6_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (16, 2,'Их нужно указывать в том же порядке, как они в макроопределении', 1)"

        db!!.execSQL(insertValue2_6_1)
        db!!.execSQL(insertValue2_6_2)
        db!!.execSQL(insertValue2_6_3)
        db!!.execSQL(insertValue2_6_4)
        db!!.execSQL(insertValue2_6_5)

        val insertValue2_7_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (17, 2,'Механизм вызова подпрограмм', 1)"
        val insertValue2_7_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (17, 2,'Механизм обработки данных', 0)"
        val insertValue2_7_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (17, 2,'Механизм вывода информации', 0)"
        val insertValue2_7_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (17, 2,'Механизм управления памятью', 0)"
        val insertValue2_7_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (17, 2,'Механизм выполнения операций', 0)"

        db!!.execSQL(insertValue2_7_1)
        db!!.execSQL(insertValue2_7_2)
        db!!.execSQL(insertValue2_7_3)
        db!!.execSQL(insertValue2_7_4)
        db!!.execSQL(insertValue2_7_5)

        val insertValue2_8_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (18, 2,'Исполняется следующая команда', 0)"
        val insertValue2_8_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (18, 2,'Все регистры обнуляются', 0)"
        val insertValue2_8_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (18, 2,'Устанавливается новый стек', 0)"
        val insertValue2_8_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (18, 2,'Сохраняется адрес возврата', 1)"
        val insertValue2_8_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (18, 2,'Параметры передаются по значению', 0)"

        db!!.execSQL(insertValue2_8_1)
        db!!.execSQL(insertValue2_8_2)
        db!!.execSQL(insertValue2_8_3)
        db!!.execSQL(insertValue2_8_4)
        db!!.execSQL(insertValue2_8_5)

        val insertValue2_9_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (19, 2,'Вызов подпрограммы с параметрами', 0)"
        val insertValue2_9_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (19, 2,'Замена имени макрокоманды на совпадающую подпрограмму', 0)"
        val insertValue2_9_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (19, 2,'Замена имени макрокоманды на последовательность команд', 1)"
        val insertValue2_9_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (19, 2,'Инициализация новой переменной', 0)"
        val insertValue2_9_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (19, 2,'Вызов системной библиотеки', 0)"

        db!!.execSQL(insertValue2_9_1)
        db!!.execSQL(insertValue2_9_2)
        db!!.execSQL(insertValue2_9_3)
        db!!.execSQL(insertValue2_9_4)
        db!!.execSQL(insertValue2_9_5)

        val insertValue2_10_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (20, 2,'Общего назначения и условные', 0)"
        val insertValue2_10_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (20, 2,'Процедурные и функциональные', 0)"
        val insertValue2_10_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (20, 2,'Логические и арифметические', 0)"
        val insertValue2_10_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (20, 2, 'Графические и таблицы', 0)"
        val insertValue2_10_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (20, 2, 'Общего назначения, повторения, условные, управления листингом', 1)"

        db!!.execSQL(insertValue2_10_1)
        db!!.execSQL(insertValue2_10_2)
        db!!.execSQL(insertValue2_10_3)
        db!!.execSQL(insertValue2_10_4)
        db!!.execSQL(insertValue2_10_5)

        val insertValue2_11_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 0)"
        val insertValue2_11_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 0)"
        val insertValue2_11_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 0)"
        val insertValue2_11_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 0)"
        db!!.execSQL(insertValue2_11_1)
        db!!.execSQL(insertValue2_11_2)
        db!!.execSQL(insertValue2_11_3)
        db!!.execSQL(insertValue2_11_4)
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
        val cursor = db.rawQuery("SELECT f, value FROM task_values WHERE theme = '$idtheme' AND task_id = ?", arrayOf(taskId.toString()))

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