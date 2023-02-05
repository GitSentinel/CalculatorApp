package com.jacinthmahanta.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Calculator : AppCompatActivity() {

    lateinit var number1: String
    lateinit var number2: String
    lateinit var operation: String
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        number1=""
        number2=""
        operation=""
        result = findViewById<TextView>(R.id.result)

        val n1 = findViewById<Button>(R.id.n1)
        val n2 = findViewById<Button>(R.id.n2)
        val n3 = findViewById<Button>(R.id.n3)
        val n4 = findViewById<Button>(R.id.n4)
        val n5 = findViewById<Button>(R.id.n5)
        val n6 = findViewById<Button>(R.id.n6)
        val n7 = findViewById<Button>(R.id.n7)
        val n8 = findViewById<Button>(R.id.n8)
        val n9 = findViewById<Button>(R.id.n9)
        val n0 = findViewById<Button>(R.id.n0)
        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val divide = findViewById<Button>(R.id.divide)
        val multiply = findViewById<Button>(R.id.multiply)
        val equals = findViewById<Button>(R.id.equal)
        n1.setOnClickListener {
            SetNumber("1")
        }
        n2.setOnClickListener {
            SetNumber("2")
        }
        n3.setOnClickListener {
            SetNumber("3")
        }
        n4.setOnClickListener {
            SetNumber("4")
        }
        n5.setOnClickListener {
            SetNumber("5")
        }
        n6.setOnClickListener {
            SetNumber("6")
        }
        n7.setOnClickListener {
            SetNumber("7")
        }
        n8.setOnClickListener {
            SetNumber("8")
        }
        n9.setOnClickListener {
            SetNumber("9")
        }
        n0.setOnClickListener {
            SetNumber("0")
        }
        plus.setOnClickListener {
            SetOpration("+")
        }
        minus.setOnClickListener {
            SetOpration("-")
        }
        divide.setOnClickListener {
            SetOpration("/")
        }
        multiply.setOnClickListener {
            SetOpration("*")
        }
        equals.setOnClickListener {
            calculate()
        }

    }

    fun SetNumber(number: String){
        if(operation=="")
        {
            number1=number1+number
            updateUI(number1)
        }
        else{
            number2 = number2 + number
            updateUI(number2)
        }
    }

    fun updateUI(res: String){
        result.text = res
    }

    fun SetOpration(operationtext: String){
        if(operation=="")
        {
            operation = operationtext
            updateUI("")
        }
        else{
            val toast = Toast.makeText(applicationContext,"Operation Not Completed", Toast.LENGTH_LONG)
            toast.show()
        }
    }

    fun calculate(){
        if(number1=="" ||number2=="" || operation==""){
            val toast = Toast.makeText(applicationContext,"Invalid Operation", Toast.LENGTH_LONG)
            toast.show()
        }

        if(operation == "+")
        {
            result.text = (number1.toInt() + number2.toInt()).toString()
        }
        else if(operation == "-")
        {
            result.text = (number1.toInt() - number2.toInt()).toString()
        }
        else if(operation == "/")
        {
            result.text = (number1.toInt() / number2.toInt()).toString()
        }
        else if(operation == "*")
        {
            result.text = (number1.toInt() * number2.toInt()).toString()
        }

        number1 = result.text.toString()
        operation=""
        number2=""
    }


}