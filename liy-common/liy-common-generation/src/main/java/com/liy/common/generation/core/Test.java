package com.liy.common.generation.core;


import java.util.*;

/**
 * @Author LiY
 */
public class Test {

    public static void main(String[] args) {

        int[] nums1,nums2;
        nums1 = new int[]{1,1,2,2,0,1,1};
        int m = 2;
         nums2 = new int[]{2,5,6};
        int n = 3;

        char x = 'a';
        System.out.println(1e9 + 7);

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

//        System.out.println(groupAnagrams(nums1));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        int[] shu = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        Map<Integer, List<String>> map = new HashMap<>();

        for(String str: strs){
            int sum = 1;
            for (char x: str.toCharArray()){
                sum *= shu[x - 97] % 1e9;
            }
            List<String> temp = map.getOrDefault(sum, new ArrayList<>());
            temp.add(str);
            map.put(sum, temp);
        }

        return new ArrayList<>(map.values());

    }


}
