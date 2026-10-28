package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_recipe)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val doneBtn = findViewById<com.google.android.material.button.MaterialButton>(R.id.doneButton)

        val backBtn = findViewById<com.google.android.material.button.MaterialButton>(R.id.backButton)

        val titleView = findViewById<EditText>(R.id.titleField)

        backBtn.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)

            startActivity(intent)
        }

        doneBtn.setOnClickListener {

            if (titleView.text.isNullOrBlank()){
                Toast.makeText(this, "Please enter a title for your task.", Toast.LENGTH_SHORT).show()
            }
            else{

                Toast.makeText(this, "Task Saved!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, HomeScreen::class.java)

                startActivity(intent)


            }

        }

    }
}