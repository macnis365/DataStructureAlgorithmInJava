package com.mathematica.ds.crossover;

import java.io.*;
import java.util.*;

public class Tester {

    public static final char CLOSE_EXPRESSION = '>';
    public static final char OPEN_EXPRESSION = '<';

    /**Assumption made are if the expression is empty or null i'm considering it as balanced expression.
     * Complete the function below.
     * DO NOT MODIFY anything outside this method.
     */
    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int expressionsSize = expressions.length;
        int result[] = new int[expressionsSize];
        Deque<Character> stack = new LinkedList<>();
        for (int expressionsIndex = 0; expressionsIndex < expressionsSize; expressionsIndex++) {
            String currentExpression = expressions[expressionsIndex];
            if (currentExpression.length() == 0) {
                result[expressionsIndex] = 1;
                continue;
            }

            processExpressions(stack, currentExpression);

            int actualReplacement = stack.size();
            if (stack.isEmpty()) {
                result[expressionsIndex] = 1;
            } else if (stack.getFirst().equals(OPEN_EXPRESSION)) {
                result[expressionsIndex] = 0;
            } else if (expressionsIndex <= maxReplacements.length && actualReplacement <= maxReplacements[expressionsIndex]) {
                result[expressionsIndex] = 1;
            } else if (expressionsIndex > maxReplacements.length && actualReplacement == 0) {
                result[expressionsIndex] = 1;
            } else {
                result[expressionsIndex] = 0;
            }
            stack.clear();
        }
        return result;
    }

    private static void processExpressions(Deque<Character> stack, String currentExpression) {
        for (int currentExpressionIndex = 0; currentExpressionIndex < currentExpression.length(); currentExpressionIndex++) {
            Character currentCharacter = currentExpression.charAt(currentExpressionIndex);
            if (stack.isEmpty()) {
                addToStack(stack, currentCharacter);
            } else {
                Character previousCharacter = stack.getFirst();
                if (currentCharacter.equals(CLOSE_EXPRESSION)) {
                    if (previousCharacter.equals(OPEN_EXPRESSION)) {
                        stack.pollFirst();
                    } else {
                        addToStack(stack, currentCharacter);
                    }
                } else {
                    addToStack(stack, currentCharacter);
                }
            }
        }
    }

    private static void addToStack(Deque<Character> stack, Character currentCharacter) {
        stack.addLast(currentCharacter);
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for (int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }

        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for (int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }

        res = balancedOrNot(_expressions, _maxReplacements);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}