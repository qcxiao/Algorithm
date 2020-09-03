package top.qcxiao.leetcode.palindrome;

/**
 * @title 方法1：暴力求解
 * @description: 
 * @author: qcxiao
 * @param: 
 * @return 
 * @create: 2020/7/15 10:45
 * @throws 
 **/
public class LongestPalindrome1 {

    public static void main(String[] args) {
        LongestPalindrome1 solution = new LongestPalindrome1();
        System.out.println(solution.longestPalindrome("babad"));
    }

    // 暴力解法
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        // 枚举所有长度严格大于 1 的子串 charArray[i...j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && isPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串是否为回文串
     */
    public boolean isPalindromic(char [] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
