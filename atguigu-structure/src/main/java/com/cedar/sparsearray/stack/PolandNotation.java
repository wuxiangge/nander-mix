package com.cedar.sparsearray.stack;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author zhangnan
 * @date 2021-04-18 22:00
 */
public class PolandNotation {

    private static final String REGEXP_OPERATION = "\\+|-|\\*|\\/|\\(|\\)";

    private static final String REGEXP_ADD_MINUS = "\\+|-";

    private static final String REGEXP_TIMES_DIVISION = "\\/|\\*";

    /**
     * 加減 + -
     */
    private static final int LEVEL_01 = 1;
    /**
     * 乘除 * /
     */
    private static final int LEVEL_02 = 2;

    /**
     * 括号
     */
    private static final int LEVEL_HIGH = Integer.MAX_VALUE;


    private static final String LEFT = "(";
    private static final String RIGHT = ")";
    private static final String ADD = "+";
    private static final String MINUS = "-";
    private static final String TIMES = "*";
    private static final String DIVISION = "/";


    // 中缀转后缀
    private List<String> parseInfixToSuffix(List<String> infixExpressionList) {

    }


    // 中缀表达式转List
    private List<String> parseInfixToList(String infixExpress) {

    }


    // 外部调用
    public int calculate(String expression) {


    }


    // 内部调用
    private int calculate(List<String> suffixExpressionList) {

    }


    // 去除字符串中的所有空格
    public static String replaceAllWhite(String expression) {
        return expression.replaceAll("\\s+", "");
    }

    // 判断数字正则表达式
    public static boolean isNumber(String expression) {
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d+)?$");
        return pattern.matcher(expression).matches();
    }

    public static boolean isOperation(String expression) {
        return expression.matches(REGEXP_OPERATION);
    }


    /**
     * 匹配运算等级
     *
     * @param operation 操作符
     * @return
     */
    public static int calcLevel(String operation) {
        if (operation.matches(REGEXP_ADD_MINUS)) {
            return LEVEL_01;
        } else if (operation.matches(REGEXP_TIMES_DIVISION)) {
            return LEVEL_02;
        }
        return LEVEL_HIGH;
    }


}
