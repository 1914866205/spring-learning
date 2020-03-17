package com.soft1851.spring.ioc.entity;

import java.util.Arrays;

public class Sort {
    //冒泡排序
    public int[] bubbleSort(int[] sourceArray) {
//        拷贝数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    //选择排序
    public int[] selectSort(int[] sourceArray) {
//        拷贝数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果你比最小值还小，那么，你就是最小值
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i!=min){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min] = temp;
            }

        }
        return arr;
    }

    //插入排序
    public int[] insertSort(int[]sourceArray){
        //拷贝数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i <arr.length ; i++) {
            //记录插入的数据
            int temp=arr[i];
            int j=i;
            while (j>0&&temp<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            if (j!=i){
                arr[j]=temp;
            }
        }
        return arr;
    }

        public int[] shellSort(int[] sourceArray) {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

            int gap = 1;
            while (gap < arr.length) {
                gap = gap * 3 + 1;
            }
            while (gap > 0) {
                for (int i = gap; i < arr.length; i++) {
                    int tmp = arr[i];
                    int j = i - gap;
                    while (j >= 0 && arr[j] > tmp) {
                        arr[j + gap] = arr[j];
                        j -= gap;
                    }
                    arr[j + gap] = tmp;
                }
                gap = (int) Math.floor(gap / 3);
            }

            return arr;
        }
}
