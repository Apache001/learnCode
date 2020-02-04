package leetcode.hot100;

/**
 * leetcode -10 正则表达式匹配
 *
 * @author wpz
 * @date 2020/1/22 16:58
 */
public class MatchRegex {

    public static void main(String[] args) {

    }


    /**
     * 递归
     */
    public boolean isMatch(String s, String p) {
        if (p.length() <= 0) {
            if (s.length() <= 0) {
                return true;
            }
        }
        boolean flag = false;
        //字符串和模式串开始字符相等或模式串字符为'.' 则匹配，比较剩余字符
        if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            flag = true;
        }

        //模式串下一个字符为'*'
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2, p.length())) ||
                (flag && isMatch(s.substring(1), p));
        } else {
            return isMatch(s.substring(1), p.substring(1)) && flag;
        }
    }

    public boolean isMatch2(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        boolean[][] cek = new boolean[slen + 1][plen + 1];

        //s为空串时的初始化
        cek[0][0] = true;
        for (int pi = 0; pi < plen; ++pi) {
            if (p.charAt(pi) == '*') {
                cek[0][pi + 1] = cek[0][pi - 1];
            }
        }

        for (int si = 0; si < slen; ++si) {
            for (int pi = 0; pi < plen; ++pi) {

                if (p.charAt(pi) == '*') {
                    cek[si + 1][pi + 1] = (cek[si + 1][pi - 1]) ||
                        (cek[si][pi + 1] && (s.charAt(si) == p.charAt(pi - 1) || p.charAt(pi - 1) == '.'));
                } else if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
                    cek[si + 1][pi + 1] = cek[si][pi];
                }

            }
        }

        return cek[slen][plen];
    }
}
