package com.example.caculatorudemy

import java.math.BigInteger

fun evaluateExpression(expression: ArrayDeque<Any>): BigInteger {
    val stack = ArrayDeque<BigInteger>()
    while (expression.isNotEmpty()) {
        val current = expression.removeFirst()

        if (current is BigInteger) {
            stack.addLast(current)
        } else {
            val top = stack.removeLast()
            val nextTop = stack.removeLast()
            when (current) {
                '+' -> stack.addLast(nextTop + top)
                '-' -> stack.addLast(nextTop - top)
                '*' -> stack.addLast(nextTop * top)
                '/' -> stack.addLast(nextTop / top)
                '^' -> stack.addLast(nextTop.pow(top.toInt()))
            }
        }
    }
    return stack.removeLast()
}