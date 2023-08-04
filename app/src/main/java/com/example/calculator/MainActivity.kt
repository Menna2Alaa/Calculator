package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
class MainActivity : AppCompatActivity() {

    private lateinit var textView : TextView
    private lateinit var btn1 : Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn10: Button
    private lateinit var btn11: Button
    private lateinit var btn12: Button
    private lateinit var btn13: Button
    private lateinit var btn14: Button
    private lateinit var btn15: Button
    private lateinit var btn16: Button
    private lateinit var btn17: Button


    private var num1 = 0
    private var num2 = 0
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.tv)
        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)
        btn3 = findViewById<Button>(R.id.btn3)
        btn4 = findViewById<Button>(R.id.btn4)
        btn5 = findViewById<Button>(R.id.btn5)
        btn6 = findViewById<Button>(R.id.btn6)
        btn7 = findViewById<Button>(R.id.btn7)
        btn8 = findViewById<Button>(R.id.btn8)
        btn9 = findViewById<Button>(R.id.btn9)
        btn10 = findViewById<Button>(R.id.btn10)
        btn11 = findViewById<Button>(R.id.btn11)
        btn12 = findViewById<Button>(R.id.btn12)
        btn13 = findViewById<Button>(R.id.btn13)
        btn14 = findViewById<Button>(R.id.btn14)
        btn15 = findViewById<Button>(R.id.btn15)
        btn16 = findViewById<Button>(R.id.btn16)
        btn17 = findViewById<Button>(R.id.btn17)

        btn1.setOnClickListener { addToInput("1") }
        btn2.setOnClickListener { addToInput("2") }
        btn3.setOnClickListener { addToInput("3") }
        btn4.setOnClickListener { addToInput("4") }
        btn5.setOnClickListener { addToInput("5") }
        btn6.setOnClickListener { addToInput("6") }
        btn7.setOnClickListener { addToInput("1") }
        btn8.setOnClickListener { addToInput("2") }
        btn9.setOnClickListener { addToInput("3") }
        btn10.setOnClickListener { addToInput("0") }
        btn11.setOnClickListener { equalsClicked() }
        btn12.setOnClickListener { operator("+") }
        btn13.setOnClickListener { operator("/") }
        btn14.setOnClickListener { operator("*") }
        btn15.setOnClickListener { operator("-") }
        btn16.setOnClickListener { clear() }
        btn17.setOnClickListener { open() }


    }

    private fun addToInput(str: String) {
        textView.text = "${textView.text}$str"
    }

    private fun operator(op: String) {
        if (textView.text.isNotEmpty()) {
            num1 = textView.text.toString().toInt()
            operator = op
            textView.text = ""
        }
    }

    private fun equalsClicked() {
        if (textView.text.isNotEmpty()) {
            num2 = textView.text.toString().toInt()
            var result = 0
            when (operator) {
                "+" -> result = num1 + num2
                "/" -> result = num1 / num2
                "*" -> result = num1 * num2
                "-" -> result = num1 - num2
            }
            textView.text = result.toString()
        }
    }
    private fun clear() {
        textView.text = ""
    }
    private fun open() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_CALCULATOR)
        startActivity(intent)
    }
}