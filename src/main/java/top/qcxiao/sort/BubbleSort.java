package top.qcxiao.sort;

import top.qcxiao.Utils;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = Utils.generatorArr(1000, 0, 10000);
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("use time:" + (endTime - startTime));
    }

    private static void sort(int[] arr) {
        Utils.print(arr);
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++) {
                if (Utils.less(arr[j], arr[i])) {
                    Utils.swap(arr, i, j);
                }
            }
        }

        Utils.print(arr);
    }
}
