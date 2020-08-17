package top.qcxiao.sort;

import top.qcxiao.Utils;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = Utils.generatorArr(1000, 0, 100000);

        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        assert Utils.isSort(arr);
        System.out.println(("优化前使用时间:" + (endTime - startTime)));

        startTime = System.currentTimeMillis();
        sortPlus(arr2);
        endTime = System.currentTimeMillis();
        assert Utils.isSort(arr2);
        System.out.println(("优化后使用时间:" + (endTime - startTime)));
    }

    /**
     * @title 优化前
     * @param: arr
     * @create: 2020/5/28 19:39
     **/
    private static void sort(int[] arr) {
        Utils.print(arr);
        for (int i = 0; i < arr.length - 1; i++){
            int minPoint = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPoint = arr[j] < arr[minPoint] ? j : minPoint;
            }
            Utils.swap(arr, i, minPoint);
        }
        Utils.print(arr);
    }

    /**
     * @title 优化后
     * @param: arr
     * @create: 2020/5/28 19:39
     **/
    private static void sortPlus(int[] arr) {
        Utils.print(arr);
        for (int left = 0, right = arr.length - 1; left < right; left++, right--){
            int minPoint = left;
            int maxPoint = right;
            for (int index = left; index <= right; index++) {
                minPoint = Utils.less(arr[index], arr[minPoint]) ? index : minPoint;
                maxPoint = Utils.less(arr[maxPoint], arr[index]) ? index : maxPoint;
            }

            Utils.swap(arr, minPoint, left);
            //System.out.println("left:" + left + ",right:" + right + ", minPoint:" + minPoint + ", maxPoint:" + maxPoint);
            maxPoint = left == maxPoint ? minPoint : maxPoint;
            Utils.swap(arr, maxPoint, right);
        }
        Utils.print(arr);
    }

}