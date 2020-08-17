package top.qcxiao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @title 两数之和
 * @description: https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 * @author: qcxiao
 * @create: 2020/7/16 19:41
 **/
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum3(new int[]{2, 2, 5, 5, 6, 7, 9}, 7)));
    }

    /**
     * @description 暴力解法
     * @author qcxiao
     * @updateTime 2020/7/16 19:39
     */
    public static int[] twoSum1(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * @description 两遍哈希表
     * @author qcxiao
     * @updateTime 2020/7/16 19:40
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (map.containsKey(expect) && map.get(expect) != i) {
                return new int[]{i, map.get(expect)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * @description 一遍哈希表
     * @author qcxiao
     * @updateTime 2020/7/16 19:40
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (map.containsKey(expect)) {
                return new int[]{i, map.get(expect)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
