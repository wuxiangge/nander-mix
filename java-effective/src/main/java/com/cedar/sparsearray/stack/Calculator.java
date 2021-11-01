package com.cedar.sparsearray.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 计算器
 * 中缀表达式
 *
 * @author zhangnan
 * @date 2021-04-18 19:49
 */
public class Calculator {


    public int calculateString(String expression) {

        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Integer> operStack = new ArrayDeque<>();

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int result = 0;
        int c = 0;
        int n = expression.length();
        String keepNum = "";

        while (true) {
            if (index >= n) {
                break;
            }

            c = expression.charAt(index);
            if (isOper(c)) { //字符
                if (!operStack.isEmpty()) {
                    int operTopInStack = operStack.peekFirst();
                    if (priority(operTopInStack) > priority(c)) {
                        num2 = numStack.removeFirst();
                        num1 = numStack.removeFirst();
                        oper = operStack.removeFirst();
                        result = cal(num1, num2, oper);
                        numStack.addFirst(result);
                    }
                }
                operStack.addFirst(c);
            } else { // 数字
                c = c - '0';

                //numStack.push(ch - 48); //? "1+3" '1' => 1
                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接

                //处理多位数
                keepNum += c;

                //如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    numStack.addFirst(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (isOper(expression.charAt(index + 1))) {
                        //如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        numStack.addFirst(Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum清空
                        keepNum = "";
                    }
                }
            }
            index++;
        }

        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while (true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num2 = numStack.removeFirst();
            num1 = numStack.removeFirst();
            oper = operStack.removeFirst();
            result = cal(num1, num2, oper);
            numStack.push(result);//入栈
        }
        //将数栈的最后数，pop出，就是结果
        result = numStack.removeFirst();
        return result;
    }

    // 定义优先级
    private int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }
        if (oper == '+' || oper == '-') {
            return 0;
        }
        return -1;
    }

    // 是否是计算字符
    private boolean isOper(int oper) {
        if (oper == '*' || oper == '/' || oper == '+' || oper == '-') {
            return true;
        }
        return false;
    }


    private int cal(int num1, int num2, int oper) {
        int result = 0;

        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.calculateString("2+4*5+4-1");
        System.out.println(result);
    }
}
