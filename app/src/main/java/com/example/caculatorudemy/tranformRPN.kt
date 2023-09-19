package com.example.caculatorudemy

fun transformRPN(infix: MutableList<Any>): ArrayDeque<Any> {
    val operatorsTemp = ArrayDeque<Pair<Char, Int>>()
    val postfix = ArrayDeque<Any>()
    while (infix.isNotEmpty()) {
        val current = infix.removeFirst()
        when {
            current is Number -> postfix.add(current)
            current == ')' -> {
                while (operatorsTemp.lastOrNull()?.first != '(') {
                    postfix.add(operatorsTemp.removeLast().first)
                }
                operatorsTemp.removeLast()
            }
            current == '(' -> operatorsTemp.add('(' to 0)
            operatorsList.containsKey(current) -> {
                val opt = current as Char
                while ((operatorsTemp.lastOrNull()?.second ?: -1) >= operatorsList[opt]!!) {
                    postfix.add(operatorsTemp.removeLast().first)
                }
                operatorsTemp.addLast(Pair(opt, operatorsList.getValue(opt)))
            }
        }
    }
    while (operatorsTemp.isNotEmpty()) {
        postfix.add(operatorsTemp.removeLast().first)
    }
    postfix.addAll(operatorsTemp)
    return postfix
}