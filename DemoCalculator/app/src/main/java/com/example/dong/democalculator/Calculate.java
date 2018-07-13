package com.example.dong.democalculator;

import java.util.Arrays;
import java.util.Stack;

public class Calculate {
    public int priority(char syntax) {
        if (syntax == Constants.CHAR_ADD || syntax == Constants.CHAR_SUB) return 1;
        else if (syntax == Constants.CHAR_MUL || syntax == Constants.CHAR_DIV) return 2;
        return 0;
    }

    public boolean isOperator(char c) {
        char operator[] = {Constants.CHAR_ADD, Constants.CHAR_SUB, Constants.CHAR_MUL,
                Constants.CHAR_DIV, Constants.OPEN, Constants.CLOSE};
        Arrays.sort(operator);
        return (Arrays.binarySearch(operator, c) > -1);
    }

    public String[] processString(String stringMath) {
        String stringTemp = Constants.NONE, elementMath[] = null;
        stringMath = stringMath.trim();
        stringMath = stringMath.replaceAll(Constants.TAX_DELETE, Constants.EMPTY);
        for (int i = 0; i < stringMath.length(); i++) {
            char syntax = stringMath.charAt(i);
            if (!isOperator(syntax))
                stringTemp += syntax;
            else stringTemp = stringTemp + Constants.EMPTY + syntax + Constants.EMPTY;
        }
        stringTemp = stringTemp.trim();
        stringTemp = stringTemp.replaceAll(Constants.TAX_DELETE, Constants.EMPTY);
        elementMath = stringTemp.split(Constants.EMPTY);
        return elementMath;
    }

    public String[] converseToPostFix(String[] elementMath) {
        String stringTemp = Constants.NONE;
        Stack<String> stackString = new Stack<String>();
        for (int i = 0; i < elementMath.length; i++) {
            char syntax = elementMath[i].charAt(Constants.DEFAULT);
            if (!isOperator(syntax))
                stringTemp = stringTemp + Constants.EMPTY + elementMath[i];
            else if (syntax == Constants.OPEN)
                stackString.push(elementMath[i]);
            else {
                if (syntax == Constants.CLOSE) {
                    char charTemp;
                    do {
                        charTemp = stackString.peek().charAt(Constants.DEFAULT);
                        if (charTemp != Constants.OPEN)
                            stringTemp = stringTemp + Constants.EMPTY + stackString.peek();
                        stackString.pop();
                    } while (charTemp != Constants.CLOSE);
                } else {
                    while (!stackString.isEmpty() && priority(stackString.peek().charAt(Constants.DEFAULT)) > priority(syntax)) {
                        stringTemp = stringTemp + Constants.EMPTY + stackString.peek();
                        stackString.pop();
                    }
                    stackString.push(elementMath[i]);
                }
            }
        }
        while (!stackString.isEmpty()) {
            stringTemp = stringTemp + Constants.EMPTY + stackString.peek();
            stackString.pop();
        }
        return stringTemp.split(Constants.EMPTY);
    }

    public String valueMath(String[] elementMath) {
        Stack<String> S = new Stack<String>();
        for (int i = 1; i < elementMath.length; i++) {
            char syntax = elementMath[i].charAt(Constants.DEFAULT);
            if (!isOperator(syntax)) S.push(elementMath[i]);
            else {
                double number = 0f;
                double number1 = Float.parseFloat(S.pop());
                double number2 = Float.parseFloat(S.pop());
                switch (syntax) {
                    case Constants.CHAR_ADD:
                        number = number2 + number1;
                        break;
                    case Constants.CHAR_SUB:
                        number = number2 - number1;
                        break;
                    case Constants.CHAR_MUL:
                        number = number2 * number1;
                        break;
                    case Constants.CHAR_DIV:
                        number = number2 / number1;
                        break;
                    default:
                        break;
                }
                S.push(Double.toString(number));
            }
        }
        return S.pop();
    }
}
