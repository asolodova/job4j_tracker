package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char leftCh = left.charAt(i);
            char rightCh = right.charAt(i);
            if (leftCh != rightCh) {
                return leftCh -  rightCh;
            }
         }
        return left.length() - right.length();
    }
}
