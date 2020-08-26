package com.test.Other.z_other;

import java.util.Stack;

public class StringMatch {
    public static void main(String[] args) {

        String s = "()()[(])]";
        System.out.println(testFH(s));

    }

    /**
     * 判断字符串是否是有效的字符，符合合理的开闭原则
     */
    public static Boolean testFH(String s) {
        Stack stack = new Stack();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            char c = chars[i];

            if(stack.empty()) {
                stack.push(c);
            } else {
                char o = (char)stack.peek();    //不刪
                if (o == '(' && c == ')' || o == '{' && c == '}' || o == '[' && c == ']') {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        System.out.println(stack);
        return stack.empty();
    }
}
