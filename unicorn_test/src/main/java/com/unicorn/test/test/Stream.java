package com.unicorn.test.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:wangsusheng
 * @Date: 2019/12/2 17:29
 */
public class Stream {

    public static void main(String[] args) {
        List<String> lsit = Arrays.asList("a1", "a1", "b1", "c2", "c1");


        System.out.println(lsit.stream()
                .filter(s->s.startsWith(""))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList()));
    }


}
