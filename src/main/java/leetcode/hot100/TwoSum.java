package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode-01 两数之和
 *
 * @author wangpengzhe
 * @date 2020/1/22 11:51
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] ints = twoSum2(nums, 6);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 暴力解法，两层遍历
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * 遍历过程中使用map保存遍历的值k，再生育元素中找到target-k 则为结果
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
