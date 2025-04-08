package com.example.assembler

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.assembler.MainActivity.Companion.idtheme

class DBhelper(val context: Context) :
    SQLiteOpenHelper(context, "base", null ,54) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query1 = "CREATE TABLE task (id INT PRIMARY KEY, task TEXT, theme INT)"
        val query2 =
            "CREATE TABLE task_values (task_id INT, theme INT, value TEXT, f INT, FOREIGN KEY(task_id) REFERENCES task(id))"
        val query3 = "CREATE TABLE done (id INT PRIMARY KEY, value INT)"
        db!!.execSQL(query1)
        db!!.execSQL(query2)
        db!!.execSQL(query3)

        //ТАБЛИЦА ДЛЯ ГАЛОК
       /* val insertDone1 = "INSERT INTO done (id, value) VALUES (1, 0)"
        val insertDone2 = "INSERT INTO done (id, value) VALUES (2, 0)"
        val insertDone3 = "INSERT INTO done (id, value) VALUES (3, 0)"
        val insertDone4 = "INSERT INTO done (id, value) VALUES (4, 0)"
        val insertDone5 = "INSERT INTO done (id, value) VALUES (5, 0)"
        val insertDone6 = "INSERT INTO done (id, value) VALUES (6, 0)"
        db!!.execSQL(insertDone1)
        db!!.execSQL(insertDone2)
        db!!.execSQL(insertDone3)
        db!!.execSQL(insertDone4)
        db!!.execSQL(insertDone5)
        db!!.execSQL(insertDone6)*/

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
        val insertValue10_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 1)"
        val insertValue10_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 1)"
        val insertValue10_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 1)"
        val insertValue10_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (10, 1,'', 1)"
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
        val insertTask2_8 = "INSERT INTO task (id, task, theme) VALUES (18, 'Что происходит при вызове подпрограммы с помощью команды `CALL`?', 2)"
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

        val insertValue2_11_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 1)"
        val insertValue2_11_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 1)"
        val insertValue2_11_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 1)"
        val insertValue2_11_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (21, 2,'', 1)"
        db!!.execSQL(insertValue2_11_1)
        db!!.execSQL(insertValue2_11_2)
        db!!.execSQL(insertValue2_11_3)
        db!!.execSQL(insertValue2_11_4)

        //ВОПРОСЫ 3 ТЕМА
        val insertTask3_1 = "INSERT INTO task (id, task, theme) VALUES (22, 'Каким образом происходит подключение внешней функции в исполняемом файле', 3)"
        val insertTask3_2 = "INSERT INTO task (id, task, theme) VALUES (23, 'Каковы способы передачи параметров разных типов', 3)"
        val insertTask3_3 = "INSERT INTO task (id, task, theme) VALUES (24, 'Каковы достоинства и недостатки способа передачи параметров подпрограммы через стек', 3)"
        val insertTask3_4 = "INSERT INTO task (id, task, theme) VALUES (25, 'Как возможно реализовать доступ к параметрам подпрограммы без применения регистра bp', 3)"
        val insertTask3_5 = "INSERT INTO task (id, task, theme) VALUES (26, 'Как можно выполнить выход из подпрограммы с удалением ее параметров из стека, не используя параметры в команде ret', 3)"
        val insertTask3_6 = "INSERT INTO task (id, task, theme) VALUES (27, 'Что такое рекурсивные подпрограммы?', 3)"
        val insertTask3_7 = "INSERT INTO task (id, task, theme) VALUES (28, 'Для чего используется параметр-значение в подпрограмме?', 3)"
        val insertTask3_8 = "INSERT INTO task (id, task, theme) VALUES (29, 'Для чего используется параметр-ссылка в подпрограмме?', 3)"
        val insertTask3_9= "INSERT INTO task (id, task, theme) VALUES (30, 'Для чего используется параметр-указатель в подпрограмме?', 3)"
        val insertTask3_10 = "INSERT INTO task (id, task, theme) VALUES (31, '', 3)"

        db!!.execSQL(insertTask3_1)
        db!!.execSQL(insertTask3_2)
        db!!.execSQL(insertTask3_3)
        db!!.execSQL(insertTask3_4)
        db!!.execSQL(insertTask3_5)
        db!!.execSQL(insertTask3_6)
        db!!.execSQL(insertTask3_7)
        db!!.execSQL(insertTask3_8)
        db!!.execSQL(insertTask3_9)
        db!!.execSQL(insertTask3_10)


        //ОТВЕТЫ НА ВОПРОСЫ 3 ТЕМА
        val insertValue3_1_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (22, 3,'TASM main.obj func.obj', 0)"
        val insertValue3_1_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (22, 3,'TDLINK main.asm func.obj', 0)"
        val insertValue3_1_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (22, 3,'TD32 main.obj func.obj', 0)"
        val insertValue3_1_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (22, 3,'TDLINK main.obj func.obj', 1)"
        db!!.execSQL(insertValue3_1_1)
        db!!.execSQL(insertValue3_1_2)
        db!!.execSQL(insertValue3_1_3)
        db!!.execSQL(insertValue3_1_4)

        val insertValue3_2_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (23, 3,'Все параметры передаются по значению', 0)"
        val insertValue3_2_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (23, 3,'Параметры передаются по ссылке только для строк', 0)"
        val insertValue3_2_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (23, 3,'Параметры могут передаваться как по значению, так и по ссылке', 1)"
        val insertValue3_2_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (23, 3,'Параметры передаются только в виде указателей', 0)"
        db!!.execSQL(insertValue3_2_1)
        db!!.execSQL(insertValue3_2_2)
        db!!.execSQL(insertValue3_2_3)
        db!!.execSQL(insertValue3_2_4)

        val insertValue3_3_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (24, 3,'Стек обеспечивает быстродействие, но не может передавать большие объемы данных', 0)"//
        val insertValue3_3_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (24, 3,'Стек позволяет легко управлять памятью, но требует много регистров', 0)"
        val insertValue3_3_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (24, 3,'Стек прост в использовании и экономит память, но уязвим к переполнению', 1)"
        val insertValue3_3_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (24, 3,'Стек сложен в реализации, но обеспечивает безопасность данных', 0)"
        db!!.execSQL(insertValue3_3_1)
        db!!.execSQL(insertValue3_3_2)
        db!!.execSQL(insertValue3_3_3)
        db!!.execSQL(insertValue3_3_4)

        val insertValue3_4_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (25, 3,'Использовать фиксированные адреса параметров', 1)"
        val insertValue3_4_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (25, 3,'Использовать регистры х86', 0)"
        val insertValue3_4_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (25, 3,'Использовать только локальные переменные', 0)"
        val insertValue3_4_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (25, 3,'Никак', 0)"
        db!!.execSQL(insertValue3_4_1)
        db!!.execSQL(insertValue3_4_2)
        db!!.execSQL(insertValue3_4_3)
        db!!.execSQL(insertValue3_4_4)

        val insertValue3_5_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (26, 3,'Использовать команду pop для удаления параметров', 1)"
        val insertValue3_5_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (26, 3,'Использовать команду leave после выполнения', 0)"
        val insertValue3_5_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (26, 3,'Использовать команду xor для очистки стека', 0)"
        val insertValue3_5_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (26, 3,'Использовать команду add для изменения указателя стека', 0)"
        db!!.execSQL(insertValue3_5_1)
        db!!.execSQL(insertValue3_5_2)
        db!!.execSQL(insertValue3_5_3)
        db!!.execSQL(insertValue3_5_4)

        val insertValue3_6_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (27, 3,'Могут вызываться только один раз за выполнение программы', 0)"
        val insertValue3_6_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (27, 3,'Не могут принимать параметры', 0)"
        val insertValue3_6_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (27, 3,'Вызывают сами себя при выполнении', 1)"
        val insertValue3_6_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (27, 3,'Выполняются только в параллельных потоках', 0)"
        db!!.execSQL(insertValue3_6_1)
        db!!.execSQL(insertValue3_6_2)
        db!!.execSQL(insertValue3_6_3)
        db!!.execSQL(insertValue3_6_4)

        val insertValue3_7_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (28, 3,'Позволяет непосредственно изменять глобальные переменные', 0)"
        val insertValue3_7_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (28, 3,'Используется для передачи копии данных и защищает исходные от изменений', 1)"
        val insertValue3_7_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (28, 3,'Позволяет возвращать несколько значений сразу', 0)"
        val insertValue3_7_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (28, 3,'Используется для создания новых подпрограмм в процессе выполнения', 0)"
        db!!.execSQL(insertValue3_7_1)
        db!!.execSQL(insertValue3_7_2)
        db!!.execSQL(insertValue3_7_3)
        db!!.execSQL(insertValue3_7_4)

        val insertValue3_8_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (29, 3,'Позволяет изменять исходные значения переменных, передавая их по адресу', 1)"
        val insertValue3_8_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (29, 3,'Для обеспечения безопасности и защиты данных от изменений', 0)"
        val insertValue3_8_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (29, 3,'Делает код подпрограммы менее читабельным и сложным', 0)"
        val insertValue3_8_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (29, 3,'Позволяет передавать только неизменяемые типы данных', 0)"
        db!!.execSQL(insertValue3_8_1)
        db!!.execSQL(insertValue3_8_2)
        db!!.execSQL(insertValue3_8_3)
        db!!.execSQL(insertValue3_8_4)

        val insertValue3_9_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (30, 3,'Используется для создания локальных копий переменных и защиты исходных', 0)"//
        val insertValue3_9_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (30, 3,'Делает программу более медленной за счёт дополнительных операций разыменования', 0)"
        val insertValue3_9_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (30, 3,'Позволяет передавать адрес переменной, для изменения исходного значения', 1)"//
        val insertValue3_9_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (30, 3,'Для работы с массивами и структурами данных', 0)"
        db!!.execSQL(insertValue3_9_1)
        db!!.execSQL(insertValue3_9_2)
        db!!.execSQL(insertValue3_9_3)
        db!!.execSQL(insertValue3_9_4)

        val insertValue3_10_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (31, 3,'', 1)"
        val insertValue3_10_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (31, 3,'', 1)"
        val insertValue3_10_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (31, 3,'', 1)"
        val insertValue3_10_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (31, 3,'', 1)"
        db!!.execSQL(insertValue3_10_1)
        db!!.execSQL(insertValue3_10_2)
        db!!.execSQL(insertValue3_10_3)
        db!!.execSQL(insertValue3_10_4)

        //ВОПРОСЫ 4 ТЕМА
        val insertTask4_1 = "INSERT INTO task (id, task, theme) VALUES (32, 'Каковы принципы работы с типом данных типа `множетсво`?', 4)"
        val insertTask4_2 = "INSERT INTO task (id, task, theme) VALUES (33, 'Как вычисляется число байт занимаемых множеством?', 4)"
        val insertTask4_3 = "INSERT INTO task (id, task, theme) VALUES (34, 'Переменная какого типа может быть элементом массива?', 4)"
        val insertTask4_4 = "INSERT INTO task (id, task, theme) VALUES (35, 'Каким образом обрабатывать переменные типа запись на языке ассемблера?', 4)"
        val insertTask4_5 = "INSERT INTO task (id, task, theme) VALUES (36, 'Как описывается структура с помощью псевдокоманды `STRUC`?', 4)"
        val insertTask4_6 = "INSERT INTO task (id, task, theme) VALUES (37, 'Каковы особенности обращения к полям структуры при их вызове?', 4)"
        val insertTask4_7 = "INSERT INTO task (id, task, theme) VALUES (38, 'Что обозначает команда `lea bx, R1`?', 4)"
        val insertTask4_8 = "INSERT INTO task (id, task, theme) VALUES (39, 'Какой из типов данных организует косвенную адресацию?', 4)"
        val insertTask4_9 = "INSERT INTO task (id, task, theme) VALUES (40, 'Что происходит, если псевдокоманда `STRUC` используется для создания структуры с несколькими компонентами?', 4)"
        val insertTask4_10 = "INSERT INTO task (id, task, theme) VALUES (41, 'Что является основной трудностью при работе с динамическими типами данных?', 4)"
        val insertTask4_11 = "INSERT INTO task (id, task, theme) VALUES (42, '', 4)"
        db!!.execSQL(insertTask4_1)
        db!!.execSQL(insertTask4_2)
        db!!.execSQL(insertTask4_3)
        db!!.execSQL(insertTask4_4)
        db!!.execSQL(insertTask4_5)
        db!!.execSQL(insertTask4_6)
        db!!.execSQL(insertTask4_7)
        db!!.execSQL(insertTask4_8)
        db!!.execSQL(insertTask4_9)
        db!!.execSQL(insertTask4_10)
        db!!.execSQL(insertTask4_11)

        //ОТВЕТЫ 4 ТЕМА
        val insertValue4_1_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (32, 4,'Множество реализуется через массив с фиксированным размером', 0)"
        val insertValue4_1_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (32, 4,'Множество - последовательность битов, где каждый бит соответствует элементу', 1)"
        val insertValue4_1_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (32, 4,'Множество реализуется с использованием стека', 0)"
        val insertValue4_1_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (32, 4,'Множество невозможно реализовать на ассемблере', 0)"
        db!!.execSQL(insertValue4_1_1)
        db!!.execSQL(insertValue4_1_2)
        db!!.execSQL(insertValue4_1_3)
        db!!.execSQL(insertValue4_1_4)

        val insertValue4_2_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (33, 4,'ByteSize = (Max / 8) - (Min / 8) + 1', 1)"
        val insertValue4_2_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (33, 4,'ByteSize = (Min / 8) – (Max / 8) + 1', 0)"
        val insertValue4_2_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (33, 4,'ByteSize = (Max / 8) + (Min / 8) – 1', 0)"
        val insertValue4_2_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (33, 4,'ByteSize = (Max / 8) – (Min / 8) – 1', 0)"
        db!!.execSQL(insertValue4_2_1)
        db!!.execSQL(insertValue4_2_2)
        db!!.execSQL(insertValue4_2_3)
        db!!.execSQL(insertValue4_2_4)

        val insertValue4_3_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (34, 4,'Файловый', 0)"
        val insertValue4_3_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (34, 4,'Целочисленный', 0)"
        val insertValue4_3_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (34, 4,'Любой, кроме целочисленного', 0)"
        val insertValue4_3_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (34, 4,'Любой, кроме файлового', 1)"
        db!!.execSQL(insertValue4_3_1)
        db!!.execSQL(insertValue4_3_2)
        db!!.execSQL(insertValue4_3_3)
        db!!.execSQL(insertValue4_3_4)

        val insertValue4_4_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (35, 4,'Каждое поле записи обрабатывается отдельно через индексы', 1)"
        val insertValue4_4_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (35, 4,'Поля записи обрабатываются как указатели на память', 0)"
        val insertValue4_4_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (35, 4,'Записи не поддерживаются в ассемблере', 0)"
        val insertValue4_4_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (35, 4,'Записи хранятся в общем регистре', 0)"
        db!!.execSQL(insertValue4_4_1)
        db!!.execSQL(insertValue4_4_2)
        db!!.execSQL(insertValue4_4_3)
        db!!.execSQL(insertValue4_4_4)

        val insertValue4_5_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (36, 4,'Создает экземпляр данных сразу', 0)"
        val insertValue4_5_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (36, 4,'Оформляется под сегмент данных', 1)"
        val insertValue4_5_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (36, 4,'Не требует объявления полей', 0)"
        val insertValue4_5_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (36, 4,'Не содержит определение полей', 0)"
        db!!.execSQL(insertValue4_5_1)
        db!!.execSQL(insertValue4_5_2)
        db!!.execSQL(insertValue4_5_3)
        db!!.execSQL(insertValue4_5_4)

        val insertValue4_6_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (37, 4,'Пустые поля можно не указывать', 0)"
        val insertValue4_6_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (37, 4,'Изменять поля с определением нескольких компонентов можно', 0)"
        val insertValue4_6_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (37, 4,'Поля, изменения которых не требуются, пропускаются, но запятые остаются', 1)"
        val insertValue4_6_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (37, 4,'Все поля должны быть инициализированы', 0)"
        db!!.execSQL(insertValue4_6_1)
        db!!.execSQL(insertValue4_6_2)
        db!!.execSQL(insertValue4_6_3)
        db!!.execSQL(insertValue4_6_4)

        val insertValue4_7_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (38, 4,'Изменяет значение поля R1', 0)"
        val insertValue4_7_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (38, 4,'Очищает запись R1', 0)"
        val insertValue4_7_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (38, 4,'Загружает адрес записи R1 в регистр bx', 1)"
        val insertValue4_7_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (38, 4,'Создает новую запись R1', 0)"
        db!!.execSQL(insertValue4_7_1)
        db!!.execSQL(insertValue4_7_2)
        db!!.execSQL(insertValue4_7_3)
        db!!.execSQL(insertValue4_7_4)

        val insertValue4_8_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (39, 4,'Массивы', 0)"
        val insertValue4_8_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (39, 4,'Записи', 0)"
        val insertValue4_8_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (39, 4,'Множества', 0)"
        val insertValue4_8_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (39, 4,'Динамические типы данных', 1)"
        db!!.execSQL(insertValue4_8_1)
        db!!.execSQL(insertValue4_8_2)
        db!!.execSQL(insertValue4_8_3)
        db!!.execSQL(insertValue4_8_4)

        val insertValue4_9_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (40, 4,'Компоненты будут инициализированы автоматически', 0)"
        val insertValue4_9_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (40, 4,'Поля, содержащие более одного компонента, переопределить нельзя', 1)"
        val insertValue4_9_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (40, 4,'Структура не будет создана', 0)"
        val insertValue4_9_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (40, 4,'Система проигнорирует это', 0)"
        db!!.execSQL(insertValue4_9_1)
        db!!.execSQL(insertValue4_9_2)
        db!!.execSQL(insertValue4_9_3)
        db!!.execSQL(insertValue4_9_4)

        val insertValue4_10_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (41, 4,'Простота использования', 0)"
        val insertValue4_10_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (41, 4,'Необходимость ручного управления памятью', 0)"
        val insertValue4_10_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (41, 4,'Сложности организации косвенных ссылок и управление памятью', 1)"
        val insertValue4_10_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (41, 4,'Ограничения на размер переменной', 0)"
        db!!.execSQL(insertValue4_10_1)
        db!!.execSQL(insertValue4_10_2)
        db!!.execSQL(insertValue4_10_3)
        db!!.execSQL(insertValue4_10_4)

        val insertValue4_11_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (42, 4,'', 1)"
        val insertValue4_11_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (42, 4,'', 1)"
        val insertValue4_11_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (42, 4,'', 1)"
        val insertValue4_11_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (42, 4,'', 1)"
        db!!.execSQL(insertValue4_11_1)
        db!!.execSQL(insertValue4_11_2)
        db!!.execSQL(insertValue4_11_3)
        db!!.execSQL(insertValue4_11_4)


        //ВОПРОСЫ 5 ТЕМА
        val insertTask5_1 = "INSERT INTO task (id, task, theme) VALUES (43, 'Какое устройство выполняет операции с плавающей запятой в процессорах Intel?', 5)"
        val insertTask5_2 = "INSERT INTO task (id, task, theme) VALUES (44, 'Сколько 80-битных регистров содержит сопроцессор?', 5)"
        val insertTask5_3 = "INSERT INTO task (id, task, theme) VALUES (45, 'Что обозначает поле ST в слове состояния сопроцессора?', 5)"
        val insertTask5_4 = "INSERT INTO task (id, task, theme) VALUES (46, 'Какая команда использует верхний регистр стека в качестве операнда?', 5)"
        val insertTask5_5 = "INSERT INTO task (id, task, theme) VALUES (47, 'Какое значение поля управления определяет способ округления?', 5)"
        val insertTask5_6 = "INSERT INTO task (id, task, theme) VALUES (48, 'Какое слово определяет, что сопроцессор обнаружил ошибку?', 5)"
        val insertTask5_7 = "INSERT INTO task (id, task, theme) VALUES (49, 'Какова основная функция слова признаков (тэгов)?', 5)"
        val insertTask5_8 = "INSERT INTO task (id, task, theme) VALUES (50, 'Что обозначает значение тегов 10 в слове признаков?', 5)"
        val insertTask5_9 = "INSERT INTO task (id, task, theme) VALUES (51, 'Какова маска разрешения прерываний, если прерывания запрещены?', 5)"
        val insertTask5_10 = "INSERT INTO task (id, task, theme) VALUES (52, 'Какой тип числовых данных не работает с арифметическим сопроцессором?', 5)"
        val insertTask5_11 = "INSERT INTO task (id, task, theme) VALUES (53, '', 5)"
        db!!.execSQL(insertTask5_1)
        db!!.execSQL(insertTask5_2)
        db!!.execSQL(insertTask5_3)
        db!!.execSQL(insertTask5_4)
        db!!.execSQL(insertTask5_5)
        db!!.execSQL(insertTask5_6)
        db!!.execSQL(insertTask5_7)
        db!!.execSQL(insertTask5_8)
        db!!.execSQL(insertTask5_9)
        db!!.execSQL(insertTask5_10)
        db!!.execSQL(insertTask5_11)

        //ОТВЕТЫ 5 ТЕМА
        val insertValue5_1_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (43, 5,'Арифметический сопроцессор', 1)"
        val insertValue5_1_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (43, 5,'Математический процессор', 0)"
        val insertValue5_1_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (43, 5,'Целочисленный процессор', 0)"
        val insertValue5_1_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (43, 5,'Графический процессор', 0)"
        db!!.execSQL(insertValue5_1_1)
        db!!.execSQL(insertValue5_1_2)
        db!!.execSQL(insertValue5_1_3)
        db!!.execSQL(insertValue5_1_4)

        val insertValue5_2_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (44, 5,'4', 0)"
        val insertValue5_2_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (44, 5,'6', 0)"
        val insertValue5_2_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (44, 5,'8', 1)"
        val insertValue5_2_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (44, 5,'16', 0)"
        db!!.execSQL(insertValue5_2_1)
        db!!.execSQL(insertValue5_2_2)
        db!!.execSQL(insertValue5_2_3)
        db!!.execSQL(insertValue5_2_4)

        val insertValue5_3_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (45, 5,'Стековый флаг', 0)"
        val insertValue5_3_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (45, 5,'Указатель вершины стека', 1)"
        val insertValue5_3_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (45, 5,'Код ошибки', 0)"
        val insertValue5_3_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (45, 5,'Временный регистр', 0)"
        db!!.execSQL(insertValue5_3_1)
        db!!.execSQL(insertValue5_3_2)
        db!!.execSQL(insertValue5_3_3)
        db!!.execSQL(insertValue5_3_4)

        val insertValue5_4_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (46, 5,'FLOAD', 0)"
        val insertValue5_4_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (46, 5,'FADD', 0)"
        val insertValue5_4_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (46, 5,'FSQRT', 1)"
        val insertValue5_4_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (46, 5,'FMUL', 0)"
        db!!.execSQL(insertValue5_4_1)
        db!!.execSQL(insertValue5_4_2)
        db!!.execSQL(insertValue5_4_3)
        db!!.execSQL(insertValue5_4_4)

        val insertValue5_5_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (47, 5,'PC', 0)"
        val insertValue5_5_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (47, 5,'IC', 0)"
        val insertValue5_5_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (47, 5,'RC', 1)"
        val insertValue5_5_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (47, 5,'IE', 0)"
        db!!.execSQL(insertValue5_5_1)
        db!!.execSQL(insertValue5_5_2)
        db!!.execSQL(insertValue5_5_3)
        db!!.execSQL(insertValue5_5_4)

        val insertValue5_6_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (48, 5,'Слово состояния', 1)"
        val insertValue5_6_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (48, 5,'Слово данных', 0)"
        val insertValue5_6_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (48, 5,'Слово признаков', 0)"
        val insertValue5_6_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (48, 5,'Слово управления', 0)"
        db!!.execSQL(insertValue5_6_1)
        db!!.execSQL(insertValue5_6_2)
        db!!.execSQL(insertValue5_6_3)
        db!!.execSQL(insertValue5_6_4)

        val insertValue5_7_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (49, 5,'Загрузка данных в память', 0)"
        val insertValue5_7_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (49, 5,'Пометка содержимого каждого регистра', 1)"
        val insertValue5_7_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (49, 5,'Управление прерываниями', 0)"
        val insertValue5_7_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (49, 5,'Осуществление арифметических операций', 0)"
        db!!.execSQL(insertValue5_7_1)
        db!!.execSQL(insertValue5_7_2)
        db!!.execSQL(insertValue5_7_3)
        db!!.execSQL(insertValue5_7_4)

        val insertValue5_8_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (50, 5,'Конечное ненулевое число', 0)"
        val insertValue5_8_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (50, 5,'Истинный нуль', 0)"
        val insertValue5_8_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (50, 5,'Специальное число (НЕчисло, бесконечность или денормализованное)', 1)"
        val insertValue5_8_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (50, 5,'Пусто', 0)"
        db!!.execSQL(insertValue5_8_1)
        db!!.execSQL(insertValue5_8_2)
        db!!.execSQL(insertValue5_8_3)
        db!!.execSQL(insertValue5_8_4)

        val insertValue5_9_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (51, 5,'0', 0)"
        val insertValue5_9_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (51, 5,'1', 1)"
        val insertValue5_9_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (51, 5,'2', 0)"
        val insertValue5_9_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (51, 5,'3', 0)"
        db!!.execSQL(insertValue5_9_1)
        db!!.execSQL(insertValue5_9_2)
        db!!.execSQL(insertValue5_9_3)
        db!!.execSQL(insertValue5_9_4)

        val insertValue5_10_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (52, 5,'Двоичные целые', 0)"
        val insertValue5_10_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (52, 5,'Десятичные целые', 0)"
        val insertValue5_10_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (52, 5,'Вещественные числа', 0)"
        val insertValue5_10_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (52, 5,'Символы ', 1)"
        db!!.execSQL(insertValue5_10_1)
        db!!.execSQL(insertValue5_10_2)
        db!!.execSQL(insertValue5_10_3)
        db!!.execSQL(insertValue5_10_4)

        val insertValue5_11_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (53, 5,'', 1)"
        val insertValue5_11_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (53, 5,'', 1)"
        val insertValue5_11_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (53, 5,'', 1)"
        val insertValue5_11_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (53, 5,'', 1)"
        db!!.execSQL(insertValue5_11_1)
        db!!.execSQL(insertValue5_11_2)
        db!!.execSQL(insertValue5_11_3)
        db!!.execSQL(insertValue5_11_4)

        //ВОПРОСЫ 6 ТЕМА (КОМАНДЫ)
        val insertTask6_1 = "INSERT INTO task (id, task, theme) VALUES (56, 'Что делает псевдокоманда `SEGMENT`?', 6)"
        val insertTask6_2 = "INSERT INTO task (id, task, theme) VALUES (57, 'Какую информацию предоставляет команда `ASSUME`?', 6)"
        val insertTask6_3 = "INSERT INTO task (id, task, theme) VALUES (58, 'Что обозначает псевдокоманда `DB`?', 6)"
        val insertTask6_4 = "INSERT INTO task (id, task, theme) VALUES (59, 'Какой из перечисленных операторов используется для определения процедуры в ассемблере?', 6)"
        val insertTask6_5 = "INSERT INTO task (id, task, theme) VALUES (60, 'Каковы выходные данные флага при выполнении команды BTR, если сброшенный бит был 1?', 6)"
        val insertTask6_6 = "INSERT INTO task (id, task, theme) VALUES (61, 'Какой оператор используется для сложения в ассемблере?', 6)"
        val insertTask6_7 = "INSERT INTO task (id, task, theme) VALUES (62, 'Что обозначает команда `MOV`?', 6)"
        val insertTask6_8 = "INSERT INTO task (id, task, theme) VALUES (63, 'Какой из следующих операторов используется для изменения знака числа?', 6)"
        val insertTask6_9 = "INSERT INTO task (id, task, theme) VALUES (64, 'Что делает команда `PUSH`?', 6)"
        val insertTask6_10 = "INSERT INTO task (id, task, theme) VALUES (65, 'Команда `JMP` используется для:', 6)"
        val insertTask6_11 = "INSERT INTO task (id, task, theme) VALUES (66, 'Какой оператор используется для циклического сдвига влево?', 6)"
        val insertTask6_12 = "INSERT INTO task (id, task, theme) VALUES (67, 'Что делает команда `DIV`?', 6)"
        val insertTask6_13 = "INSERT INTO task (id, task, theme) VALUES (68, 'Какой оператор используется для сравнения двух строк?', 6)"
        val insertTask6_14 = "INSERT INTO task (id, task, theme) VALUES (69, 'Что делает команда `FADD` в сопроцессоре?', 6)"
        val insertTask6_15 = "INSERT INTO task (id, task, theme) VALUES (70, 'Какой оператор используется для очистки флагов ошибок в сопроцессоре?', 6)"
        val insertTask6_16 = "INSERT INTO task (id, task, theme) VALUES (71, 'Что означает команда `POP`?', 6)"
        val insertTask6_17 = "INSERT INTO task (id, task, theme) VALUES (72, 'Команда `JNE` используется для:', 6)"
        val insertTask6_18 = "INSERT INTO task (id, task, theme) VALUES (73, 'Что делает команда `IDIV`?', 6)"
        val insertTask6_19 = "INSERT INTO task (id, task, theme) VALUES (74, 'Какой оператор используется для логического И в ассемблере?', 6)"
        val insertTask6_20 = "INSERT INTO task (id, task, theme) VALUES (75, 'Какой из следующих операторов устанавливает флаги CF и ZF?', 6)"
        val insertTask6_21 = "INSERT INTO task (id, task, theme) VALUES (76, 'Что обозначает псевдокоманда `EQU`?', 6)"
        val insertTask6_22 = "INSERT INTO task (id, task, theme) VALUES (77, 'Какой оператор используется для расчета длины массива?', 6)"
        val insertTask6_23 = "INSERT INTO task (id, task, theme) VALUES (78, 'Что делает команда `FLD` в арифметическом сопроцессоре?', 6)"
        val insertTask6_24 = "INSERT INTO task (id, task, theme) VALUES (79, 'Какой оператор используется для арифметического сдвига вправо?', 6)"
        val insertTask6_25 = "INSERT INTO task (id, task, theme) VALUES (80, 'Что делает команда `STOS`?', 6)"
        val insertTask6_26 = "INSERT INTO task (id, task, theme) VALUES (81, 'Какой из следующих операторов не является арифметическим?', 6)"
        val insertTask6_27 = "INSERT INTO task (id, task, theme) VALUES (82, 'Что делает команда `TEST`?', 6)"
        val insertTask6_28 = "INSERT INTO task (id, task, theme) VALUES (83, 'Какой оператор используется для резервирования памяти без начальной инициализации?', 6)"
        val insertTask6_29 = "INSERT INTO task (id, task, theme) VALUES (84, 'Что означает команда `FLDZ` в сопроцессоре?', 6)"
        val insertTask6_30 = "INSERT INTO task (id, task, theme) VALUES (85, 'Какое из следующих утверждений верно для команды BTS?', 6)"
        val insertTask6_31 = "INSERT INTO task (id, task, theme) VALUES (86, '', 6)"

        db!!.execSQL(insertTask6_1)
        db!!.execSQL(insertTask6_2)
        db!!.execSQL(insertTask6_3)
        db!!.execSQL(insertTask6_4)
        db!!.execSQL(insertTask6_5)
        db!!.execSQL(insertTask6_6)
        db!!.execSQL(insertTask6_7)
        db!!.execSQL(insertTask6_8)
        db!!.execSQL(insertTask6_9)
        db!!.execSQL(insertTask6_10)
        db!!.execSQL(insertTask6_11)
        db!!.execSQL(insertTask6_12)
        db!!.execSQL(insertTask6_13)
        db!!.execSQL(insertTask6_14)
        db!!.execSQL(insertTask6_15)
        db!!.execSQL(insertTask6_16)
        db!!.execSQL(insertTask6_17)
        db!!.execSQL(insertTask6_18)
        db!!.execSQL(insertTask6_19)
        db!!.execSQL(insertTask6_20)
        db!!.execSQL(insertTask6_21)
        db!!.execSQL(insertTask6_22)
        db!!.execSQL(insertTask6_23)
        db!!.execSQL(insertTask6_24)
        db!!.execSQL(insertTask6_25)
        db!!.execSQL(insertTask6_26)
        db!!.execSQL(insertTask6_27)
        db!!.execSQL(insertTask6_28)
        db!!.execSQL(insertTask6_29)
        db!!.execSQL(insertTask6_30)
        db!!.execSQL(insertTask6_31)

        //ОТВЕТЫ НА 6 ТЕМУ (КОМАНДЫ)
        val insertValue6_1_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (56, 6,'Объявляет переменную', 0)"
        val insertValue6_1_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (56, 6,'Определяет границы сегмента программы', 1)"
        val insertValue6_1_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (56, 6,'Задает тип данных', 0)"
        val insertValue6_1_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (56, 6,'Устанавливает точку возврата', 0)"
        db!!.execSQL(insertValue6_1_1)
        db!!.execSQL(insertValue6_1_2)
        db!!.execSQL(insertValue6_1_3)
        db!!.execSQL(insertValue6_1_4)

        val insertValue6_2_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (57, 6,'Создает метку', 0)"
        val insertValue6_2_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (57, 6,'Определяет область сегмента', 0)"
        val insertValue6_2_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (57, 6,'Связывает регистры сегментов с сегментами программы', 1)"
        val insertValue6_2_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (57, 6,'Инициализирует стек', 0)"
        val insertValue6_2_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (57, 6,'Сравнивает данные', 0)"
        db!!.execSQL(insertValue6_2_1)
        db!!.execSQL(insertValue6_2_2)
        db!!.execSQL(insertValue6_2_3)
        db!!.execSQL(insertValue6_2_4)
        db!!.execSQL(insertValue6_2_5)

        val insertValue6_3_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (58, 6,'Определяет 2 байта памяти', 0)"
        val insertValue6_3_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (58, 6,'Определяет 4 байта памяти', 0)"
        val insertValue6_3_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (58, 6,'Определяет 8 байт памяти', 0)"
        val insertValue6_3_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (58, 6,'Определяет 1 байт памяти', 1)"
        val insertValue6_3_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (58, 6,'Определяет символическую переменную', 0)"
        db!!.execSQL(insertValue6_3_1)
        db!!.execSQL(insertValue6_3_2)
        db!!.execSQL(insertValue6_3_3)
        db!!.execSQL(insertValue6_3_4)
        db!!.execSQL(insertValue6_3_5)

        val insertValue6_4_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (59, 6,'PROC', 1)"
        val insertValue6_4_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (59, 6,'FUNC', 0)"
        val insertValue6_4_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (59, 6,'MACRO', 0)"
        val insertValue6_4_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (59, 6,'PROD', 0)"
        val insertValue6_4_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (59, 6,'MODULE', 0)"
        db!!.execSQL(insertValue6_4_1)
        db!!.execSQL(insertValue6_4_2)
        db!!.execSQL(insertValue6_4_3)
        db!!.execSQL(insertValue6_4_4)
        db!!.execSQL(insertValue6_4_5)

        val insertValue6_5_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (60, 6,'ZF = 1', 0)"
        val insertValue6_5_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (60, 6,'ZF = 0', 1)"
        val insertValue6_5_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (60, 6,'CF = 1', 0)"
        val insertValue6_5_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (60, 6,'CF = 0', 0)"
        db!!.execSQL(insertValue6_5_1)
        db!!.execSQL(insertValue6_5_2)
        db!!.execSQL(insertValue6_5_3)
        db!!.execSQL(insertValue6_5_4)

        val insertValue6_6_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (61, 6,'SUB', 0)"
        val insertValue6_6_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (61, 6,'XOR', 0)"
        val insertValue6_6_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (61, 6,'ADD', 1)"
        val insertValue6_6_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (61, 6,'INC', 0)"
        val insertValue6_6_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (61, 6,'SUM', 0)"
        db!!.execSQL(insertValue6_6_1)
        db!!.execSQL(insertValue6_6_2)
        db!!.execSQL(insertValue6_6_3)
        db!!.execSQL(insertValue6_6_4)
        db!!.execSQL(insertValue6_6_5)

        val insertValue6_7_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (62, 6,'Сравнение двух регистров', 0)"
        val insertValue6_7_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (62, 6,'Сложение значений', 0)"
        val insertValue6_7_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (62, 6,'Инициализация переменной', 0)"
        val insertValue6_7_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (62, 6,'Удаление данных', 0)"
        val insertValue6_7_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (62, 6,'Пересылка данных', 1)"
        db!!.execSQL(insertValue6_7_1)
        db!!.execSQL(insertValue6_7_2)
        db!!.execSQL(insertValue6_7_3)
        db!!.execSQL(insertValue6_7_4)
        db!!.execSQL(insertValue6_7_5)

        val insertValue6_8_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (63, 6,'NEG', 1)"
        val insertValue6_8_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (63, 6,'NOT', 0)"
        val insertValue6_8_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (63, 6,'INC', 0)"
        val insertValue6_8_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (63, 6,'DEL', 0)"
        val insertValue6_8_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (63, 6,'REV', 0)"
        db!!.execSQL(insertValue6_8_1)
        db!!.execSQL(insertValue6_8_2)
        db!!.execSQL(insertValue6_8_3)
        db!!.execSQL(insertValue6_8_4)
        db!!.execSQL(insertValue6_8_5)

        val insertValue6_9_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (64, 6,'Извлекает данные из стека', 0)"
        val insertValue6_9_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (64, 6,'Помещает операнд в стек', 1)"
        val insertValue6_9_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (64, 6,'Очищает стек', 0)"
        val insertValue6_9_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (64, 6,'Выполняет арифметическую операцию', 0)"
        val insertValue6_9_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (64, 6,'Сохраняет локальную переменную', 0)"
        db!!.execSQL(insertValue6_9_1)
        db!!.execSQL(insertValue6_9_2)
        db!!.execSQL(insertValue6_9_3)
        db!!.execSQL(insertValue6_9_4)
        db!!.execSQL(insertValue6_9_5)

        val insertValue6_10_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (65, 6,'Перехода к следующей инструкции', 0)"
        val insertValue6_10_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (65, 6,'Сравнения двух переменных', 0)"
        val insertValue6_10_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (65, 6,'Выхода из программы', 0)"
        val insertValue6_10_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (65, 6,'Завершения цикла', 0)"
        val insertValue6_10_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (65, 6,'Безусловного перехода', 1)"
        db!!.execSQL(insertValue6_10_1)
        db!!.execSQL(insertValue6_10_2)
        db!!.execSQL(insertValue6_10_3)
        db!!.execSQL(insertValue6_10_4)
        db!!.execSQL(insertValue6_10_5)

        val insertValue6_11_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (66, 6,'ROR', 0)"
        val insertValue6_11_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (66, 6,'SAL', 0)"
        val insertValue6_11_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (66, 6,'RCL', 1)"
        val insertValue6_11_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (66, 6,'SHL', 0)"
        val insertValue6_11_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (66, 6,'SAR', 0)"
        db!!.execSQL(insertValue6_11_1)
        db!!.execSQL(insertValue6_11_2)
        db!!.execSQL(insertValue6_11_3)
        db!!.execSQL(insertValue6_11_4)
        db!!.execSQL(insertValue6_11_5)

        val insertValue6_12_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (67, 6,'Делит целое число', 1)"
        val insertValue6_12_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (67, 6,'Умножает два числа', 0)"
        val insertValue6_12_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (67, 6,'Сравнивает два значения', 0)"
        val insertValue6_12_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (67, 6,'Добавляет два значения', 0)"
        db!!.execSQL(insertValue6_12_1)
        db!!.execSQL(insertValue6_12_2)
        db!!.execSQL(insertValue6_12_3)
        db!!.execSQL(insertValue6_12_4)

        val insertValue6_13_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (68, 6,'CMPS', 1)"
        val insertValue6_13_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (68, 6,'MOVS', 0)"
        val insertValue6_13_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (68, 6,'SCAS', 0)"
        val insertValue6_13_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (68, 6,'STOS', 0)"
        val insertValue6_13_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (68, 6,'LODS', 0)"
        db!!.execSQL(insertValue6_13_1)
        db!!.execSQL(insertValue6_13_2)
        db!!.execSQL(insertValue6_13_3)
        db!!.execSQL(insertValue6_13_4)
        db!!.execSQL(insertValue6_13_5)

        val insertValue6_14_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (69, 6,'Изменяет знак числа', 0)"
        val insertValue6_14_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (69, 6,'Складывает два вещественных числа', 1)"
        val insertValue6_14_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (69, 6,'Складывает числа и изменяет знак числа', 0)"
        val insertValue6_14_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (69, 6,'Такой команды нет', 0)"
        db!!.execSQL(insertValue6_14_1)
        db!!.execSQL(insertValue6_14_2)
        db!!.execSQL(insertValue6_14_3)
        db!!.execSQL(insertValue6_14_4)

        val insertValue6_15_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (70, 6,'FWAIT', 0)"
        val insertValue6_15_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (70, 6,'FDISI', 0)"
        val insertValue6_15_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (70, 6,'FCLEX', 1)"
        val insertValue6_15_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (70, 6,'FLDCW', 0)"
        val insertValue6_15_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (70, 6,'FINIT', 0)"
        db!!.execSQL(insertValue6_15_1)
        db!!.execSQL(insertValue6_15_2)
        db!!.execSQL(insertValue6_15_3)
        db!!.execSQL(insertValue6_15_4)
        db!!.execSQL(insertValue6_15_5)

        val insertValue6_16_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (71, 6,'Сохранение данных в регистр', 0)"
        val insertValue6_16_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (71, 6,'Извлечение операнда из стека', 1)"
        val insertValue6_16_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (71, 6,'Пересылка данных', 0)"
        val insertValue6_16_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (71, 6,'Инициализация переменной', 0)"
        db!!.execSQL(insertValue6_16_1)
        db!!.execSQL(insertValue6_16_2)
        db!!.execSQL(insertValue6_16_3)
        db!!.execSQL(insertValue6_16_4)

        val insertValue6_17_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (72, 6,'Перехода, если переменные равны', 0)"
        val insertValue6_17_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (72, 6,'Завершения выполнения программы', 0)"
        val insertValue6_17_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (72, 6,'Перехода, если флаг не установлен', 0)"
        val insertValue6_17_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (72, 6,'Перехода, если флаг ZF равен 0', 1)"
        val insertValue6_17_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (72, 6,'Перехода, если флаг ZF равен 1', 0)"
        db!!.execSQL(insertValue6_17_1)
        db!!.execSQL(insertValue6_17_2)
        db!!.execSQL(insertValue6_17_3)
        db!!.execSQL(insertValue6_17_4)
        db!!.execSQL(insertValue6_17_5)

        val insertValue6_18_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (73, 6,'Делит число без остатка', 0)"
        val insertValue6_18_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (73, 6,'Делит со знаком', 1)"
        val insertValue6_18_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (73, 6,'Делит беззнаковое число', 0)"
        val insertValue6_18_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (73, 6,'Делит вещественную часть числа', 0)"
        val insertValue6_18_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (73, 6,'Делит и меняет знак числа', 0)"
        db!!.execSQL(insertValue6_18_1)
        db!!.execSQL(insertValue6_18_2)
        db!!.execSQL(insertValue6_18_3)
        db!!.execSQL(insertValue6_18_4)
        db!!.execSQL(insertValue6_18_5)

        val insertValue6_19_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (74, 6,'OR', 0)"
        val insertValue6_19_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (74, 6,'NOTOR', 0)"
        val insertValue6_19_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (74, 6,'ANDR', 0)"
        val insertValue6_19_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (74, 6,'XOR', 0)"
        val insertValue6_19_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (74, 6,'AND', 1)"
        db!!.execSQL(insertValue6_19_1)
        db!!.execSQL(insertValue6_19_2)
        db!!.execSQL(insertValue6_19_3)
        db!!.execSQL(insertValue6_19_4)
        db!!.execSQL(insertValue6_19_5)

        val insertValue6_20_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (75, 6,'FCOM', 0)"
        val insertValue6_20_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (75, 6,'FADD', 0)"
        val insertValue6_20_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (75, 6,'FCOMP', 1)"
        val insertValue6_20_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (75, 6,'FLD', 0)"
        val insertValue6_20_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (75, 6,'FST', 0)"
        db!!.execSQL(insertValue6_20_1)
        db!!.execSQL(insertValue6_20_2)
        db!!.execSQL(insertValue6_20_3)
        db!!.execSQL(insertValue6_20_4)
        db!!.execSQL(insertValue6_20_5)

        val insertValue6_21_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (76, 6,'Создает переменную', 0)"
        val insertValue6_21_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (76, 6,'Присваивает постоянное значение имени', 1)"
        val insertValue6_21_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (76, 6,'Определяет количество байт', 0)"
        val insertValue6_21_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (76, 6,'Псевдокоманда неверная', 0)"
        db!!.execSQL(insertValue6_21_1)
        db!!.execSQL(insertValue6_21_2)
        db!!.execSQL(insertValue6_21_3)
        db!!.execSQL(insertValue6_21_4)

        val insertValue6_22_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (77, 6,'SIZE', 1)"
        val insertValue6_22_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (77, 6,'LENGTH', 0)"
        val insertValue6_22_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (77, 6,'DUP', 0)"
        val insertValue6_22_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (77, 6,'TYPE', 0)"
        val insertValue6_22_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (77, 6,'OFFSET', 0)"
        db!!.execSQL(insertValue6_22_1)
        db!!.execSQL(insertValue6_22_2)
        db!!.execSQL(insertValue6_22_3)
        db!!.execSQL(insertValue6_22_4)
        db!!.execSQL(insertValue6_22_5)

        val insertValue6_23_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (78, 6,'Пересылает данные', 0)"
        val insertValue6_23_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (78, 6,'Освобождает регистр', 0)"
        val insertValue6_23_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (78, 6,'Загружает новую вершину стека', 1)"
        val insertValue6_23_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (78, 6,'Создает переменную', 0)"
        val insertValue6_23_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (78, 6,'Объявляет вещественное число', 0)"
        db!!.execSQL(insertValue6_23_1)
        db!!.execSQL(insertValue6_23_2)
        db!!.execSQL(insertValue6_23_3)
        db!!.execSQL(insertValue6_23_4)
        db!!.execSQL(insertValue6_23_5)

        val insertValue6_24_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (79, 6,'SHL', 0)"
        val insertValue6_24_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (79, 6,'SAR', 0)"
        val insertValue6_24_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (79, 6,'ROR', 1)"
        val insertValue6_24_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (79, 6,'RCL', 0)"
        val insertValue6_24_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (79, 6,'ROL', 0)"
        db!!.execSQL(insertValue6_24_1)
        db!!.execSQL(insertValue6_24_2)
        db!!.execSQL(insertValue6_24_3)
        db!!.execSQL(insertValue6_24_4)
        db!!.execSQL(insertValue6_24_5)

        val insertValue6_25_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (80, 6,'Сравнивает строковый операнд', 0)"
        val insertValue6_25_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (80, 6,'Загружает строку', 0)"
        val insertValue6_25_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (80, 6,'Переносит строку', 0)"
        val insertValue6_25_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (80, 6,'Извлекает строку', 0)"
        val insertValue6_25_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (80, 6,'Сохраняет строковый операнд', 1)"
        db!!.execSQL(insertValue6_25_1)
        db!!.execSQL(insertValue6_25_2)
        db!!.execSQL(insertValue6_25_3)
        db!!.execSQL(insertValue6_25_4)
        db!!.execSQL(insertValue6_25_5)

        val insertValue6_26_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (81, 6,'ADD', 0)"
        val insertValue6_26_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (81, 6,'SUB', 0)"
        val insertValue6_26_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (81, 6,'AND', 1)"
        val insertValue6_26_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (81, 6,'DIV', 0)"
        val insertValue6_26_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (81, 6,'MUL', 0)"
        db!!.execSQL(insertValue6_26_1)
        db!!.execSQL(insertValue6_26_2)
        db!!.execSQL(insertValue6_26_3)
        db!!.execSQL(insertValue6_26_4)
        db!!.execSQL(insertValue6_26_5)

        val insertValue6_27_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (82, 6,'Изменяет знак', 0)"
        val insertValue6_27_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (82, 6,'Сравнивает два значения', 1)"
        val insertValue6_27_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (82, 6,'Проверяет массив', 0)"
        val insertValue6_27_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (82, 6,'Такой команды нет', 0)"
        db!!.execSQL(insertValue6_27_1)
        db!!.execSQL(insertValue6_27_2)
        db!!.execSQL(insertValue6_27_3)
        db!!.execSQL(insertValue6_27_4)

        val insertValue6_28_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (83, 6,'DUP', 0)"
        val insertValue6_28_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (83, 6,'?', 1)"
        val insertValue6_28_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (83, 6,'DB', 0)"
        val insertValue6_28_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (83, 6,'DW', 0)"
        val insertValue6_28_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (83, 6,'EQU', 0)"
        db!!.execSQL(insertValue6_28_1)
        db!!.execSQL(insertValue6_28_2)
        db!!.execSQL(insertValue6_28_3)
        db!!.execSQL(insertValue6_28_4)
        db!!.execSQL(insertValue6_28_5)

        val insertValue6_29_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (84, 6,'Загружает число 1', 0)"
        val insertValue6_29_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (84, 6,'Загружает предел стека', 0)"
        val insertValue6_29_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (84, 6,'Загружает π', 0)"
        val insertValue6_29_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (84, 6,'Загружает 0', 1)"
        val insertValue6_29_5 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (84, 6,'Загружает √2', 0)"
        db!!.execSQL(insertValue6_29_1)
        db!!.execSQL(insertValue6_29_2)
        db!!.execSQL(insertValue6_29_3)
        db!!.execSQL(insertValue6_29_4)
        db!!.execSQL(insertValue6_29_5)

        val insertValue6_30_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (85, 6,'Устанавливает указанный бит в 0', 0)"
        val insertValue6_30_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (85, 6,'Сбрасывает указанный бит в 1', 0)"
        val insertValue6_30_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (85, 6,'Проверяет указанный бит и устанавливает его в 1', 1)"
        val insertValue6_30_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (85, 6,'Изменяет знак числа', 0)"
        db!!.execSQL(insertValue6_30_1)
        db!!.execSQL(insertValue6_30_2)
        db!!.execSQL(insertValue6_30_3)
        db!!.execSQL(insertValue6_30_4)

        val insertValue6_31_1 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (86, 6,'', 1)"
        val insertValue6_31_2 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (86, 6,'', 1)"
        val insertValue6_31_3 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (86, 6,'', 1)"
        val insertValue6_31_4 = "INSERT INTO task_values (task_id, theme, value, f) VALUES (86, 6,'', 1)"
        db!!.execSQL(insertValue6_31_1)
        db!!.execSQL(insertValue6_31_2)
        db!!.execSQL(insertValue6_31_3)
        db!!.execSQL(insertValue6_31_4)

    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS task")
        db!!.execSQL("DROP TABLE IF EXISTS task_values")
        db!!.execSQL("DROP TABLE IF EXISTS done")
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

    fun getDone(id: Int): Int {
        var dones : Int = 0
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT value FROM done WHERE id = ?", arrayOf(id.toString()))

        if (cursor.moveToFirst()) {
            do {
                //val id = cursor.getInt(0)
                val value = cursor.getInt(0)
                dones = value
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return dones
    }

    fun setDone() {
        val values = ContentValues()
        values.put("id", idtheme)
        values.put("value", 1)

        val db1 = this.writableDatabase
        db1.insert("done", null, values)
        db1.close()


        //val db = this.readableDatabase
       // val cursor = db.rawQuery("INSERT INTO done(id, value) VALUES ('$idtheme', 1)", null)
       // cursor.close()
       // db.close()
    }


}