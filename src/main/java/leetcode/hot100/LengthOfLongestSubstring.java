package leetcode.hot100;


/**
 * leetcode -03 无重复字符的最长子串
 *
 * @author wangpengzhe
 * @date 2020/1/22 14:28
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbtablud"));
    }

    /**
     * 滑动窗口
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        //窗口左边界
        int left = 0;
        //无重复字符串最大长度
        int mLength = 1;
        for (int i = 1; i < s.length(); i++) {
            //判断窗口内是否存在重复字符
            String tmp = s.substring(left, i);
            int index = tmp.indexOf(s.charAt(i));
            //存在重复字符，移动窗口左边界
            if (index != -1) {
                left = index + left + 1;
            } else {
                mLength = Math.max(mLength, i - left + 1);
            }
        }
        return mLength;
    }
}
