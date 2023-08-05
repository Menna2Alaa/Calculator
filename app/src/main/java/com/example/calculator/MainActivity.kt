package com.example.calculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var btn1: Button
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
    private var toggle = true

    private var num1 = 0L
    private var num2 = 0L
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn10 = findViewById(R.id.btn10)
        btn11 = findViewById(R.id.btn11)
        btn12 = findViewById(R.id.btn12)
        btn13 = findViewById(R.id.btn13)
        btn14 = findViewById(R.id.btn14)
        btn15 = findViewById(R.id.btn15)
        btn16 = findViewById(R.id.btn16)
        btn17 = findViewById(R.id.btn17)

        btn1.setOnClickListener { addToInput("7") }
        btn2.setOnClickListener { addToInput("8") }
        btn3.setOnClickListener { addToInput("9") }
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
        btn16.setOnClickListener { isCalculatorOn(toggle) }
        btn17.setOnClickListener {
            clear()
        }
    }

    private fun isCalculatorOn(toggle: Boolean) {
        btn1.isClickable = toggle
        btn2.isClickable = toggle
        btn3.isClickable = toggle
        btn4.isClickable = toggle
        btn5.isClickable = toggle
        btn6.isClickable = toggle
        btn7.isClickable = toggle
        btn8.isClickable = toggle
        btn9.isClickable = toggle
        btn10.isClickable = toggle
        btn11.isClickable = toggle
        btn12.isClickable = toggle
        btn13.isClickable = toggle
        btn14.isClickable = toggle
        btn15.isClickable = toggle
        btn17.isClickable = toggle
        if (toggle)
            Toast.makeText(this, "Calculator On", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Calculator Off", Toast.LENGTH_SHORT).show()

        this.toggle = !toggle
    }

    private fun addToInput(str: String) {
        textView.text = "${textView.text}$str"
    }

    private fun operator(op: String) {
        if (textView.text.isNotEmpty()) {
            num1 = textView.text.toString().toLong()
            operator = op
            textView.text = ""
        }
    }

    private fun equalsClicked() {
        if (textView.text.isNotEmpty()) {
            num2 = textView.text.toString().toLong()
            var result = 0L
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

    fun openCalculatorApp(context: Context) {
        val packageName = "com.example.calculator"
        val launchIntent = context.packageManager.getLaunchIntentForPackage(packageName)

        if (launchIntent != null) {
            context.startActivity(launchIntent)
        } else {
            Toast.makeText(context, "Calculator app not found.", Toast.LENGTH_SHORT).show()
        }
    }
}