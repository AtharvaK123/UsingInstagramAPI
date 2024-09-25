package com.example;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MutualFinder {
    public static List<String> findMutuals(List<String> list1, List<String> list2) {
        Set<String> set1 = Set.copyOf(list1);
        return list2.stream().filter(set1::contains).collect(Collectors.toList());
    }
}
