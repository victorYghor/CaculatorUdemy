package com.example.caculatorudemy

import java.math.BigInteger
import kotlin.math.exp

val operatorsList = mapOf(
    '(' to 0,
    '+' to 1, '-' to 1,
    '*' to 2, '/' to 2,
    '^' to 3,
)

fun calculator(equation: String): String {
    val expression = mutableListOf<Any>()
    var number: String = ""
    for (i in equation.indices) {
        if (equation[i].isDigit()) {
            number += equation[i]
            if (equation.lastIndex == i) {
                expression.add(number.toBigInteger())
            }
        } else {
            expression.add(number.toBigInteger())
            number = ""
            expression.add(equation[i])
        }
    }
    return evaluateExpression(transformRPN(expression)).toString()

}