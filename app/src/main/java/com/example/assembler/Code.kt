package com.example.assembler

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assembler.MainActivity.Companion.idtask
import kotlin.reflect.typeOf

class Code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_code)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val builder = AlertDialog.Builder(this)
            .setTitle("Справка")
            .setMessage("Список доступных команд: mov, add, div, mul, sub."+ '\n' + "Регистр символов не важен." + '\n' + "Для начала анализа необходимо нажать на кнопку 'Пуск'." + '\n' + '\n' + "<команда>_операнд1,операнд2." + '\n' + "Для корректного анализа рекомендуется следовать такой структуре.")
            .setPositiveButton("Продолжить") { dialog, which ->
            }

        val dialog = builder.create()
        dialog.show()


        val button_main : Button = findViewById(R.id.button_to_main)
        val start : Button = findViewById(R.id.start)

        val textBox : TextView = findViewById(R.id.mainField)

        val ax : TextView = findViewById(R.id.axValue)
        val bx : TextView = findViewById(R.id.bxValue)
        val cx : TextView = findViewById(R.id.cxValue)
        val dx : TextView = findViewById(R.id.dxValue)

        val cf : TextView = findViewById(R.id.cfValue)
        val zf : TextView = findViewById(R.id.zfValue)
        val sf : TextView = findViewById(R.id.sfValue)
        val oof : TextView = findViewById(R.id.ofValue)
        val pf : TextView = findViewById(R.id.pfValue)
        val af : TextView = findViewById(R.id.afValue)
        val iif : TextView = findViewById(R.id.ifValue)
        val df : TextView = findViewById(R.id.dfValue)

        var axValue : String = "0000"
        var bxValue : String = "0000"
        var cxValue : String = "0000"
        var dxValue : String = "0000"


        var cfValue: String = "0"
        var zfValue: String = "0"
        var sfValue: String = "0"
        var ofValue: String = "0"
        var pfValue: String = "0"
        var afValue: String = "0"
        var ifValue: String = "0"
        var dfValue: String = "0"

        val registers = mutableMapOf(
            "AX" to axValue,
            "BX" to bxValue,
            "CX" to cxValue,
            "DX" to dxValue
        )
        val flags = mutableMapOf(
            "CF" to cfValue,
            "ZF" to zfValue,
            "SF" to sfValue,
            "OF" to ofValue,
            "PF" to pfValue,
            "AF" to afValue,
            "IF" to ifValue,
            "DF" to dfValue
        )

        start.setOnClickListener {
            val commands = textBox.text.split("\n")


            for (command in commands) {
                var parts = command.split(' ', ',')
                for (part in parts) {
                    if (part == " ") {
                        Toast.makeText(this,"Ошибка!", Toast.LENGTH_SHORT).show()
                        break;
                    }
                }
                if (parts[0].toLowerCase() == "mov") {
                    if (parts[2] != "ax" && parts[2] != "bx" && parts[2] != "cx" && parts[2] != "dx") {
                        registers[parts[1].toUpperCase()] = parts[2]
                    }
                    else {
                        registers[parts[1].toUpperCase()] = registers[parts[2].toUpperCase()].toString()
                    }
                }

                if (parts[0].toLowerCase() == "add") {
                    val operand1 = registers[parts[1].toUpperCase()]?.toInt(16)!!
                    val operand2 = registers[parts[2].toUpperCase()]?.toInt(16)!!
                    val result = operand1 + operand2
                    registers[parts[1].toUpperCase()] = (operand1 + operand2).toString(16)

                    flags["CF"] = if (result > 0xFFFF) "1" else "0"
                    flags["ZF"] = if (result and 0xFFFF == 0) "1" else "0"
                    flags["SF"] = if (result and 0x8000 != 0) "1" else "0"
                    flags["OF"] = if (((operand1 xor result) and (operand2 xor result)) and 0x8000 != 0) "1" else "0"
                    flags["PF"] = if (Integer.bitCount(result and 0xFFFF) % 2 == 0) "1" else "0"

                }

                if (parts[0].toLowerCase() == "sub") {
                    val operand1 = registers[parts[1].toUpperCase()]?.toInt(16)!!
                    val operand2 = registers[parts[2].toUpperCase()]?.toInt(16)!!
                    val result = operand1 - operand2
                    registers[parts[1].toUpperCase()] = (operand1 - operand2).toString(16)

                    flags["CF"] = if (result < 0) "1" else "0"
                    flags["ZF"] = if (result and 0xFFFF == 0) "1" else "0"
                    flags["SF"] = if (result and 0x8000 != 0) "1" else "0"
                    flags["OF"] = if (((operand1 xor result) and (operand2 xor result)) and 0x8000 != 0) "1" else "0"
                    flags["PF"] = if (Integer.bitCount(result and 0xFFFF) % 2 == 0) "1" else "0"
                }

                if (parts[0].toLowerCase() == "div") {

                    val operand1 = registers["AX"]?.toInt(16)!!
                    val operand2 = registers[parts[1].toUpperCase()]?.toInt(16)!!
                    val result = operand1 / operand2
                    registers["AX"] = (operand1 / operand2).toString(16)
                    registers["DX"] = (operand1 % operand2).toString(16)


                    flags["CF"] = if (result < 0) "1" else "0"
                    flags["ZF"] = if (result and 0xFFFF == 0) "1" else "0"
                    flags["SF"] = if (result and 0x8000 != 0) "1" else "0"
                    flags["OF"] = if (result > 0xFFFF) "1" else "0"
                    flags["PF"] = if (Integer.bitCount(result and 0xFFFF) % 2 == 0) "1" else "0"


                }

                if (parts[0].toLowerCase() == "mul") {
                    val operand1 = registers[parts[1].toUpperCase()]?.toInt(16)!!
                    val operand2 = registers[parts[2].toUpperCase()]?.toInt(16)!!
                    val result = operand1 * operand2
                    registers[parts[1].toUpperCase()] = (operand1 * operand2).toString(16)

                    flags["CF"] = if (result > 0xFFFF) "1" else "0"
                    flags["ZF"] = if (result and 0xFFFF == 0) "1" else "0"
                    flags["SF"] = if (result and 0x8000 != 0) "1" else "0"
                    flags["OF"] = if (result > 0xFFFF) "1" else "0"
                    flags["PF"] = if (Integer.bitCount(result and 0xFFFF) % 2 == 0) "1" else "0"

                }
                ax.text = "0000"
                bx.text = "0000"
                cx.text = "0000"
                dx.text = "0000"

                cf.text = "0"
                zf.text = "0"
                sf.text = "0"
                oof.text = "0"
                pf.text = "0"
                af.text = "0"
                iif.text = "0"
                df.text = "0"

                ax.text = (ax.text.substring(0, 4-registers["AX"].toString()?.length!!) + registers["AX"]).toUpperCase()
                bx.text = (bx.text.substring(0, 4-registers["BX"].toString()?.length!!) + registers["BX"]).toUpperCase()
                cx.text = (cx.text.substring(0, 4-registers["CX"].toString()?.length!!) + registers["CX"]).toUpperCase()
                dx.text = (dx.text.substring(0, 4-registers["DX"].toString()?.length!!) + registers["DX"]).toUpperCase()

                cf.text = flags["CF"]
                zf.text = flags["ZF"]
                sf.text = flags["SF"]
                oof.text = flags["OF"]
                pf.text = flags["PF"]
                af.text = flags["AF"]
                iif.text = flags["IF"]
                df.text = flags["DF"]

            }


        }

        button_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}