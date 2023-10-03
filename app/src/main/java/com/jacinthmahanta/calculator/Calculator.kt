package com.jacinthmahanta.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jacinthmahanta.calculator.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    private lateinit var number1: String
    private lateinit var number2: String
    private lateinit var operation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        number1 = ""
        number2 = ""
        operation = ""

        binding.apply {
            n1.setOnClickListener { setNumber("1") }
            n2.setOnClickListener { setNumber("2") }
            n3.setOnClickListener { setNumber("3") }
            n4.setOnClickListener { setNumber("4") }
            n5.setOnClickListener { setNumber("5") }
            n6.setOnClickListener { setNumber("6") }
            n7.setOnClickListener { setNumber("7") }
            n8.setOnClickListener { setNumber("8") }
            n9.setOnClickListener { setNumber("9") }
            n0.setOnClickListener { setNumber("0") }
            plus.setOnClickListener { setOperation("+") }
            minus.setOnClickListener { setOperation("-") }
            divide.setOnClickListener { setOperation("/") }
            multiply.setOnClickListener { setOperation("*") }
            equal.setOnClickListener { calculate() }
        }
    }

    private fun setNumber(number: String) {
        if (operation == "") {
            number1 += number
            updateUI(number1)
        } else {
            number2 += number
            updateUI(number2)
        }
    }

    private fun updateUI(res: String) {
        binding.result.text = res
    }

    private fun setOperation(operationText: String) {
        if (operation == "") {
            operation = operationText
            updateUI("")
        } else Toast.makeText(applicationContext, "Operation Not Completed", Toast.LENGTH_LONG)
            .show()
    }

    private fun calculate() {
        if (number1 == "" || number2 == "" || operation == "")
            Toast.makeText(applicationContext, "Invalid Operation", Toast.LENGTH_LONG).show()

        binding.result.text = when (operation) {
            "+" -> (number1.toInt() + number2.toInt()).toString()
            "-" -> (number1.toInt() - number2.toInt()).toString()
            "/" -> (number1.toInt() / number2.toInt()).toString()
            "*" -> (number1.toInt() * number2.toInt()).toString()
            else -> ""
        }

        number1 = binding.result.text.toString()
        operation = ""
        number2 = ""
    }
}