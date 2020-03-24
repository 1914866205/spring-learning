package com.soft1851.spring.orm.entity;

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

    /**
     * 基数排序
     * 考虑负数的情况还可以参考： https://code.i-harness.com/zh-CN/q/e98fa9
     */
        public int[] raisxSortMain(int[] sourceArray) throws Exception {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

            int maxDigit = getMaxDigit(arr);
            return radixSort(arr, maxDigit);
        }

        /**
         * 获取最高位数
         */
        private int getMaxDigit(int[] arr) {
            int maxValue = getMaxValue(arr);
            return getNumLenght(maxValue);
        }

        private int getMaxValue(int[] arr) {
            int maxValue = arr[0];
            for (int value : arr) {
                if (maxValue < value) {
                    maxValue = value;
                }
            }
            return maxValue;
        }

        protected int getNumLenght(long num) {
            if (num == 0) {
                return 1;
            }
            int lenght = 0;
            for (long temp = num; temp != 0; temp /= 10) {
                lenght++;
            }
            return lenght;
        }

        private int[] radixSort(int[] arr, int maxDigit) {
            int mod = 10;
            int dev = 1;

            for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
                // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
                int[][] counter = new int[mod * 2][0];

                for (int j = 0; j < arr.length; j++) {
                    int bucket = ((arr[j] % mod) / dev) + mod;
                    counter[bucket] = arrayAppend(counter[bucket], arr[j]);
                }

                int pos = 0;
                for (int[] bucket : counter) {
                    for (int value : bucket) {
                        arr[pos++] = value;
                    }
                }
            }

            return arr;
        }

        /**
         * 自动扩容，并保存数据
         *
         * @param arr
         * @param value
         */
        private int[] arrayAppend(int[] arr, int value) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = value;
            return arr;
        }
    }
