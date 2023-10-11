package com.jacinthmahanta.calculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jacinthmahanta.calculator.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {

    // binding
    private lateinit var binding: ActivityCalculatorBinding

    // result
    private lateinit var number1: String
    private lateinit var number2: String
    private lateinit var operation: String

    private lateinit var rvHistory: RecyclerView
    private var tempCalculation = ""
    private var historyShow = 0
    private var historyList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        number1 = ""
        number2 = ""
        operation = ""

        rvHistory = binding.rvHistory
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
            btnHistory.setOnClickListener { showHistory() }
            ac.setOnClickListener { clear() }
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
        tempCalculation += res
        binding.result.text = tempCalculation
    }

    private fun resetUI() {
        binding.result.text = "0"
    }

    private fun setOperation(operationText: String) {
        if (operation == "") {
            operation = operationText
            updateUI(" $operation ")
        } else Toast.makeText(applicationContext, "Operation Not Completed", Toast.LENGTH_LONG)
            .show()
    }

    private fun calculate() {

        if (number1 == "" || number2 == "" || operation == "") {
            Toast.makeText(applicationContext, "Invalid Operation", Toast.LENGTH_LONG).show()
            resetUI()
            number1 = ""
            tempCalculation = ""
        } else {
            binding.result.text = when (operation) {
                "+" -> (number1.toInt() + number2.toInt()).toString()
                "-" -> (number1.toInt() - number2.toInt()).toString()
                "/" -> (number1.toInt() / number2.toInt()).toString()
                "*" -> (number1.toInt() * number2.toInt()).toString()
                else -> ""
            }
            number1 = binding.result.text.toString()
            tempCalculation += " = $number1"
            historyList.add(tempCalculation)
            tempCalculation = number1
        }

        number2 = ""
        operation = ""
    }

    private fun showHistory() {

        binding.apply {
            if (historyShow == 1) {
                btnHistory.setImageResource(R.drawable.historybutton)

                buttonLayout.visibility = View.VISIBLE
                historyLayout.visibility = View.GONE
                historyShow = 0
            } else {
                btnHistory.setImageResource(R.drawable.closebutton)

                buttonLayout.visibility = View.GONE
                historyLayout.visibility = View.VISIBLE

                showRecyclerView()

                historyShow = 1
            }

        }
    }

    private fun showRecyclerView() {
        rvHistory.layoutManager = LinearLayoutManager(this)

        val itemAdapter = HistoryAdapter(historyList)
        rvHistory.adapter = itemAdapter
    }

    private fun clear() {
        number1 = ""
        number2 = ""
        operation = ""
        tempCalculation = ""
        binding.result.text = "0"
    }
}