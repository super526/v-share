package com.supan.vshare.Java8;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author supan
 * @Date 2017/12/1 11:01
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Slf4j
public class Demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("supan-520-manman-526".split("-")));
        log.info("list is {}",list);
        list.removeIf(s-> Pattern.compile("\\d").matcher(s).find());
        log.info("list is {}",list);
    }
}
