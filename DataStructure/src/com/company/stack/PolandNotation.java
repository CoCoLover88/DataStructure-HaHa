package com.company.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*计算逆波兰表达式*/
public class PolandNotation {
    public static void main(String[] args) {

        String expression = "1-((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        List<String> strings = parseSuffixExpressionList(list);
        System.out.println(strings);

        System.out.println(calculate(strings));
    }

    /**
     * 字符串转换成 List
     *
     * @param expression 后缀表达式
     * @return
     */
    public static List<String> stringToList(String expression) {
        String[] strings = expression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String elem : strings) {
            list.add(elem);
        }
        return list;
    }

    /**
     * 中缀表达式转后缀表达式
     *
     * @param list
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> list) {
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : list) {
            //遇到操作数时，将其压入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else if (isOperate(item)) {
                while (s1.size() != 0 && getPriority(item) <= getPriority(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            } else {
                throw new RuntimeException("输入的操作数或运算符有错");
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 判断是否为运算符
     *
     * @param op
     * @return
     */
    public static boolean isOperate(String op) {
        return "+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op);
    }

    /**
     * 获取运算符优先级
     *
     * @param op
     * @return
     */
    public static int getPriority(String op) {
        final int ADD = 1;
        final int SUB = 1;
        final int MUL = 2;
        final int DIV = 2;
        int result = 0;
        switch (op) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }

    /**
     * 将中缀表达式转成对应的List
     *
     * @param str
     * @return
     */
    public static List<String> toInfixExpressionList(String str) {
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        String append;
        char c;
        do {
            if ((c = str.charAt(index)) < 48 || (c = str.charAt(index)) > 57) {
                list.add("" + c);
                index++;
            } else {
                append = "";
                while (index < str.length() && (c = str.charAt(index)) >= 48 && (c = str.charAt(index)) <= 57) {
                    append += c;
                    index++;
                }
                list.add(append);
            }
        } while (index < str.length());
        return list;
    }

    /**
     * 计算逆波兰表达式
     *
     * @param list
     * @return
     */
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        for (String elem : list) {
            if (elem.matches("\\d+")) {
                stack.push(elem);
            } else {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                if (elem.equals("+")) {
                    res = num1 + num2;
                } else if (elem.equals("-")) {
                    res = num1 - num2;
                } else if (elem.equals("*")) {
                    res = num1 * num2;
                } else if (elem.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符错误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
