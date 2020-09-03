package top.qcxiao.leetcode.palindrome;


/**
 * @title 回文数判断
 * @description
 * @author qcxiao
 * @updateTime 2020/6/20 16:04
 */
public class Palindrome {

    /**
     * 通过字符串反转后与其最初字符串进行比较
     **/
    public static boolean isPalindrome1(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        System.out.println(new StringBuilder("123456").reverse());
        return (x + "").equals(reversedStr);
    }

    /**
     * 通过取整和取余操作获取整数中对应的数字进行比较
     **/
    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;

        // 找出当前数值是多少位数
        int div = 1;
        while (x / div >= 10) div *= 10;

        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    /**
     * 取出后半段数字进行翻转
     * 每次进行取余操作 （ %10），取出最低的数字：y = x % 10
     * 将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
     * 每取一个最低位数字，x 都要自除以 10
     * 判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
     * 最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
     *
     **/
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome1(121));
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(9));
    }
}
