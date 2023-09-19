package com.example.caculatorudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.example.caculatorudemy.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)

        val viewModel = SharedViewModel()
        val expression = viewModel.expression
        val calculatorScreen = b.tvResult

        b.btn0.setOnClickListener {
            calculatorScreen.append("0")
        }
        b.btn1.setOnClickListener {
            calculatorScreen.append("1")
        }
        b.btn2.setOnClickListener {
            calculatorScreen.append("2")
        }
        b.btn3.setOnClickListener {
            calculatorScreen.append("3")
        }
        b.btn4.setOnClickListener {
            calculatorScreen.append("4")
        }
        b.btn5.setOnClickListener {
            calculatorScreen.append("5")
        }
        b.btn6.setOnClickListener {
            calculatorScreen.append("6")
        }
        b.btn7.setOnClickListener {
            calculatorScreen.append("7")
        }
        b.btn8.setOnClickListener {
            calculatorScreen.append("8")
        }
        b.btn9.setOnClickListener {
            calculatorScreen.append("9")
        }

        b.btnCLR.setOnClickListener {
            calculatorScreen.text = ""
            expression.clear()
        }

        val isLastOperator = operatorsList.containsKey(calculatorScreen.text.last())
        val toastAlreadyOperator = Toast.makeText(this,
            getString(R.string.you_cannot_put_another_operator), LENGTH_LONG)
        b.btnPlus.setOnClickListener {
            if (isLastOperator) {
                toastAlreadyOperator.show()
            } else {
                calculatorScreen.append("+")
                while()
            }
        }

        b.btnDivide.setOnClickListener {
            if (isLastOperator) {
                  toastAlreadyOperator.show()
            } else {
                calculatorScreen.append("/")
            }
        }

        b.btnminus.setOnClickListener {
            // implement a different logic
            if ('-' == ) {
                toastAlreadyOperator.show()
            } else {
                calculatorScreen.append("-")
            }
        }

        b.btnTimes.setOnClickListener {
            if (isLastOperator) {
                calculatorScreen.append("*")
            } else {
                toastAlreadyOperator.show()
            }
        }



        b.btnEqual.setOnClickListener {
            calculatorScreen.text = calculator(calculatorScreen.text.toString())
        }
    }
}