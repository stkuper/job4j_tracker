package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] lefts = left.split(". ");
        String[] rights = right.split(". ");
        for (int i = 0; i < lefts.length; i++) {
            if (isNumber(lefts[i]) && isNumber(rights[i])) {
                int leftNum = Integer.parseInt(lefts[i]);
                int rightNum = Integer.parseInt(rights[i]);
                return Integer.compare(leftNum, rightNum);
            }
        }
        return left.compareTo(right);
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }

}
