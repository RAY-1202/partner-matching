package com.ray.partner_matching_system.service;


import org.junit.jupiter.api.Test;

import com.ray.partner_matching_system.utils.AlgorithmUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 算法工具类测试
 */
public class AlgorithmUtilsTest {


    @Test
    void test() {
        String str1 = "ray is a student";
        String str2 = "ray is a boy";
        String str3 = "ray is a girl";
        
        int score1 = AlgorithmUtils.minDistance(str1, str2);
        
        int score2 = AlgorithmUtils.minDistance(str1, str3);
        System.out.println(score1);
        System.out.println(score2);
    }

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("Java", "大一", "男");
        List<String> tagList2 = Arrays.asList("Java", "大一", "女");
        List<String> tagList3 = Arrays.asList("Python", "大二", "女");
        
        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        System.out.println(score1);
        System.out.println(score2);
    }

}
