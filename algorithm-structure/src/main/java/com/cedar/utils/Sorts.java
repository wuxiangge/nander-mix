package com.cedar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author zhangnan
 * @date 2021/8/3
 */
public class Sorts {

    private Sorts() {
    }

    // 基础模板
    public static <E extends Comparable<E>> void sort(E[] array) {
    }


    // 冒泡排序
    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        // 排序基本思想
        // [1,2,3,4,.....,n]
        // 对于冒泡排序来说
        // [1,2,3,...,array.length-1-i] 还没有排好序
        // 但是对于 (array.length-1-i,...,array.length-1] 已经排好序
        for (int i = 0; i < array.length - 1; i++) {
            // 在【array.length-1-i】的位置上放上合适的参数
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    public static <E extends Comparable<E>> void bubbleSort2(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    isSwapped = true;
                    swap(array, j, j + 1);
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }


    public static <E extends Comparable<E>> void bubbleSort3(E[] array) {
        for (int i = 0; i < array.length - 1; ) {
            int isSwappedIndex = 0;

            // [1,2,3,4,5,6,7,0]
            // [1,2,3,4,5,6,0,7]
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    isSwappedIndex = j + 1;
                    swap(array, j, j + 1);
                }
            }
            i = array.length - isSwappedIndex;
        }
    }


    // 插入排序算法
    public static <E extends Comparable<E>> void insertSort(E[] array) {
        //插入排序算法基本思想
        // [1,2,3,...,i) 已经排好序了
        // 现在需要将array[i]插入到合适的位置

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j - 1 > 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    // 优化版本插入算法
    public static <E extends Comparable<E>> void insertSort2(E[] array) {
        for (int i = 0; i < array.length; i++) {
            E temp = array[i];  // 带插入的元素

            int j; // 应该插入的位置

            for (j = i; j - 1 > 0 && temp.compareTo(array[j]) < 0; j--) {
                array[j] = array[j - 1];
            }

            array[j] = temp;
            temp = null;
        }
    }


    // 希尔排序
    public static <E extends Comparable<E>> void shellSort(E[] array) {
        // 等距数组排序
        int h = 1;
        while (h < array.length) {
            h = 3 * h + 1;
        }

        // 希尔排序基本思想  等距数组排序
        // 对data[start,start+h,start+2h... ] 进行插入排序
        while (h >= 1) {
            // 对data[start,start+h,start+2h... ] 进行插入排序

            for (int i = h; i < array.length; i++) {
                E ret = array[i];
                int j;
                for (j = i; j - h > 0 && ret.compareTo(array[j - h]) < 0; j -= h) {
                    array[j] = array[j - h];
                }
                array[j] = ret;
            }
            h = h / 3;
        }
    }


    // 快速排序
    public static <E extends Comparable<E>> void quickSort1(E[] array) {
        // 快速排序基本思想 是一种划分交换排序 采用分治策略
        Random random = new Random();
        quickSort1(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort1(E[] array, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = partition(array, l, r, random);
        quickSort1(array, 0, p - 1, random);
        quickSort1(array, p + 1, r, random);
    }

    /**
     * [1,2,3,4,5,6,]   random = 4
     * [4,1,2,3,,5,6]
     * <p>
     * for (int i = l+1;i<=r;i++) {
     * if (array[i].compareTo(array[l])<0) {
     * j++;
     * swap(array,i,j);
     * }
     * }
     * <p>
     * 基本快速排序基本思想
     * 确定一个数v
     * data[l+1,,,j]<v
     * data[j+1...i]>v
     * 遍历数组i完成更新
     *
     * @param array
     * @param l
     * @param r
     * @param random
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> int partition(E[] array, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);   // [l,,,r] 中间生成一个随机值
        swap(array, l, p);
        // data[l+1...j] < v  data[j+1...i] >v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i].compareTo(array[l]) < 0) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, l, j);
        return j;
    }


    /**
     * 双路快速排序
     *
     * @param array
     * @param l
     * @param r
     * @param random
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> int partition2Way(E[] array, int l, int r, Random random) {
        // 首先随机选择一个数作为划分的标准
        int p = random.nextInt(r - l + 1) + l;
        swap(array, l, p);

        // arr[l+1...i-1]<=v;arr[j+1...r]>=v
        int i = l + 1;
        int j = r;
        while (true) {
            while (i < j && array[i].compareTo(array[l]) < 0) {
                i++;
            }
            while (j > i && array[j].compareTo(array[l]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
            i++;
            j--;
        }
        swap(array, l, j);
        return j;
    }


    public static <E extends Comparable<E>> void quickSort3Way(E[] array) {
        Random random = new Random();
        quickSort3Way(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void quickSort3Way(E[] array, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = l + random.nextInt(r - l + 1);
        swap(array, l, p);

        // arr[l+1...lt]<v arr[lt+1...i-1]==v arr[gt...r]>v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;

        while (i < gt) {
            if (array[i].compareTo(array[l]) < 0) {
                lt++;
                swap(array, i, lt);
                i++;
            } else if (array[i].compareTo(array[l]) > 0) {
                gt--;
                swap(array, i, gt);
                i++;
            } else {
                //array[i].compareTo(array[l])==0
                i++;
            }
        }

        swap(array, l, lt);
        // arr[l...lt-1]<v arr[lt...gt-1]===v arr[gt...r]>v

        quickSort3Way(array, l, lt - 1, random);
        quickSort3Way(array, lt + 1, r, random);
    }


    // 归并排序算法
    public static <E extends Comparable<E>> void mergeSort(E[] array) {
        // 归并排序算法基本思想
        E[] aux = Arrays.copyOf(array, array.length);
        mergeSort(array, 0, array.length - 1, aux);
    }

    public static <E extends Comparable<E>> void mergeSort(E[] array, int l, int r, E[] aux) {
        // 归并排序算法基本思想
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(array, l, mid, aux);
        mergeSort(array, mid + 1, r, aux);

        if (array[mid].compareTo(array[mid + 1]) < 0) {
            merge(array, l, mid, r, aux);
        }
    }

    // 归并排序的核心就是二叉树的后序遍历
    private static <E extends Comparable<E>> void merge(E[] array, int l, int mid, int r, E[] aux) {
        // 将两个有序数组合并成一个数组
        System.arraycopy(array, l, aux, l, r - l + 1);
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (k > mid) {
                array[k] = aux[j];
                j++;
            } else if (j > r) {
                array[k] = aux[i];
                i++;
            } else if (aux[i].compareTo(aux[j]) > 0) {
                array[k] = aux[j];
                j++;
            } else {
                array[k] = array[i];
                i++;
            }
        }
    }


    // 堆排序算法
    public static <E extends Comparable<E>> void heapSort(E[] array) {
        // 将一个数组组装成一个最大堆
        MaxHeap maxHeap = new MaxHeap(array);

        for (int i = array.length; i > 0; i--) {
            array[i] = (E) maxHeap.extractMax();
        }
        // 每次取出堆中最大元素
    }


    private static class MaxHeap<E extends Comparable<? super E>> {

        private ArrayList<E> arrayList;

        public MaxHeap() {
            arrayList = new ArrayList<E>();
        }

        public MaxHeap(E[] array) {
            arrayList = new ArrayList<>(array.length);
            arrayList.addAll(Arrays.asList(array));
            for (int i = getParent(arrayList.size()); i > 0; i--) {
                siftDown(i);
            }
        }

        /**
         * 查询最大数据
         *
         * @return
         */
        private E extractMax() {
            E ret = arrayList.get(0);
            swap(arrayList, 0, arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            siftDown(0);
            return ret;
        }

        private int getParent(int index) {
            if (index == 0) {
                throw new IllegalArgumentException("index-0 does not have parent");
            }
            return (index - 1) / 2;
        }

        private int getLeftChild(int index) {
            return 2 * index + 1;
        }


        private void siftDown(int k) {
            while (getLeftChild(k) < arrayList.size()) {
                int j = getLeftChild(k);
                if (j + 1 < arrayList.size() && arrayList.get(j + 1).compareTo(arrayList.get(j)) > 0) {
                    j = j + 1;
                }
                // 此时j是k的左右孩子中的较大者
                if (arrayList.get(k).compareTo(arrayList.get(j)) > 0) {
                    break;
                }
                swap(arrayList, k, j);
                k = j;
            }
        }
    }


    /**
     * 选择排序算法
     *
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void selectSort(E[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i; j < array.length; j++) {
                if (array[min].compareTo(array[j]) > 0) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }


    private static <E> void swap(List<E> array, int l, int r) {
        E temp = array.get(l);
        array.set(l, array.get(r));
        array.set(r, temp);
        temp = null;
    }


    private static <E> void swap(E[] array, int l, int r) {
        E temp = array[l];
        array[l] = array[r];
        array[r] = temp;
        temp = null;
    }

}
