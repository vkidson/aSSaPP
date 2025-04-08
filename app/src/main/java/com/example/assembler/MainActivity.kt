package com.example.assembler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.zxc)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val start : Button = findViewById(R.id.button)
        val start2 : Button = findViewById(R.id.button2)
        val debug : ImageButton = findViewById(R.id.debug)

        start.setOnClickListener {
            val intent = Intent(this, TaskList::class.java)
            startActivity(intent)
        }

        start2.setOnClickListener {
            val intent = Intent(this, TheoryActivity::class.java)
            startActivity(intent)
        }

        debug.setOnClickListener {
            val intent = Intent(this, Code::class.java)
            startActivity(intent)
        }

    }
    companion object {
        @JvmStatic
        fun newInstance() = MainActivity()
        var idtheme : Int = 0
        var idtask : Int = 1
    }
}