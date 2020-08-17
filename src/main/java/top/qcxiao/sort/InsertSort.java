package top.qcxiao.sort;

import top.qcxiao.Utils;

public class InsertSort {
    public static void main(String[] args) {
        int [] arr = Utils.generatorArr(1000, 0, 10000);
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("use time:" + (endTime - startTime));
    }

    private static void sort(int[] arr) {
        Utils.print(arr);
        for (int i = 1; i < arr.length; i++){
            for (int j = i; j > 0 && Utils.less(arr[j], arr[j-1]); j--) {
                Utils.swap(arr, j, j-1);
            }
        }

        Utils.print(arr);
    }
}
