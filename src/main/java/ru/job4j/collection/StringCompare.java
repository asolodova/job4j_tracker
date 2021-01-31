package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char leftCh = left.charAt(i);
            System.out.println(leftCh);
            char rightCh = right.charAt(i);
            System.out.println(rightCh);
            if (leftCh != rightCh) {
                return leftCh -  rightCh;
            }
         }
        return left.length() - right.length();
    }
}
