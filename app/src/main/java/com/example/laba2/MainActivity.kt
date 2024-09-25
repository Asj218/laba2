package com.example.laba2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainNumberEditText = findViewById<EditText>(R.id.main_namber)
        val calculateButton = findViewById<Button>(R.id.button)
        val sumTextView = findViewById<TextView>(R.id.label1)
        val lastTermTextView = findViewById<TextView>(R.id.label2)
        val iterationsTextView = findViewById<TextView>(R.id.label3)

        calculateButton.setOnClickListener {
            val epsilon = mainNumberEditText.text.toString().toDoubleOrNull()
            if (epsilon != null) {
                var sum = 1.0
                var lastTerm = 1.0
                var iterations = 1
                var n = 2

                while (abs(lastTerm) >= epsilon) {
                    lastTerm = 1.0 / (n * n)
                    sum += lastTerm
                    iterations++
                    n++
                }

                sumTextView.text = "Сумма: $sum"
                lastTermTextView.text = "Последнее слагаемое: $lastTerm"
                iterationsTextView.text = "Количество повторений: $iterations"
            } else {
                sumTextView.text = "Ошибка: Введите число"
                lastTermTextView.text = ""
                iterationsTextView.text = ""
            }
        }
    }
}