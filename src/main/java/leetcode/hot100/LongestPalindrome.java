package leetcode.hot100;

/**
 * leetcode-05 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author wangpengzhe
 * @date 2020/1/22 16:17
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 动态规划
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        //dp[i][j] i-j的字符串是否为回文串
        boolean[][] dp = new boolean[length][length];

        String res = "";
        //一个字符都是回文
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            res = s.substring(i, i + 1);
        }

        //长度为2的串，如果两个字符相等则是回文串
        for (int j = 1; j < length; j++) {
            if (s.charAt(j) == s.charAt(j - 1)) {
                dp[j - 1][j] = true;
                res = s.substring(j - 1, j + 1);
            }
        }

        //length>3 => s[i]==s[j]&&dp[i-1][j-1] 则 dp[i][j] = true;
        for (int k = 3; k <= length; k++) {
            for (int i = 0; i + k - 1 < length; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
