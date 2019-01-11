package com.kkhuluwa.leetcode.numberorder;

import java.util.HashMap;

public class LT1TwoNumbers {
    class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // 1 input check
//         // 2 for for
//         // 3 out put
//         if(nums == null){
//             return null;
//         }

//         for(int i = 0;i <nums.length; i ++){
//             for(int j = i + 1;j < nums.length;j++){
//                 if(nums[j] == target-nums[i]){
//                     return new int[]{i,j};
//                 }
//             }
//         }

//         return null;
//     }


//         public int[] twoSum(int[] nums, int target) {
//         // 1 input check
//         // 2 for hashmap
//         // 3 out put
//         if(nums == null){
//             return null;
//         }
//         HashMap<Integer,Integer> map = new HashMap();

//         for(int i = 0;i < nums.length; i ++){
//            map.put(nums[i],i);

//         }
//         for(int i = 0; i< nums.length;i++){
//             int con = target-nums[i];
//             if(map.containsKey(con) && map.get(con) != i){
//                 return new int[]{i,map.get(con)};
//             }
//         }

//         return null;
//     }

        public int[] twoSum(int[] nums, int target) {
            // 1 input check
            // 2 for hashmap
            // 3 out put
            if(nums == null){
                return null;
            }
            HashMap<Integer,Integer> map = new HashMap();

            for(int i = 0;i < nums.length; i ++){
                int con = target -nums[i];
                if(map.containsKey(con)){
                    return new int[]{map.get(con), i};
                }
                // 先放入前面的，如果后面有 一定可以匹配到前面的数据
                map.put(nums[i],i);

            }


            return null;
        }
    }
}
