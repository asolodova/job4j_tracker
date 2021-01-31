package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        Comparator<Job> comb = new JobDescByName();
        Collections.sort(jobs, comb);
        System.out.println(jobs);
    }
}
