package com.cedar.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangnan
 * @date 2021/2/21 16:18
 */
public class Sorts {

    private Sorts() {
    }

    // 排序模板
    public static <E extends Comparable<? super E>> void sort(E[] arr) {

    }

    // 堆排序算法
    public static <E extends Comparable<? super E>> void heapSort(E[] arr) {

        if (arr.length <= 1) {
            return;
        }

        for (int i = getParent(arr.length - 1); i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i - 1);
        }

    }


    /**
     * 下沉操作
     *
     * @param arr
     * @param index
     * @param n
     * @param <E>
     */
    private static <E extends Comparable<? super E>> void siftDown(E[] arr, int index, int n) {

        while (leftChild(index) < n) {

            int j = leftChild(index);

            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j = rightChild(index);
            }

            // data[j] 是 leftChild rightChild 中的最大值
            if (arr[index].compareTo(arr[j]) > 0) {
                break;
            }

            swap(arr, index, j);
            index = j;
        }

    }


    private static int leftChild(int index) {
        return 2 * index + 1;
    }

    private static int rightChild(int index) {
        return 2 * index + 2;
    }


    private static int getParent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("没有父元素");
        }
        return (index - 1) / 2;
    }


    // 插入排序算法
    public static <E extends Comparable<? super E>> void insertSort(E[] arr) {
        // 循环不变量 [0...i) 已经排好序 现在准备将 i 放到[0...i)中的合适位置

        int length = arr.length;

        for (int i = 1; i < length; i++) {

            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }


    // 插入排序算法
    public static <E extends Comparable<? super E>> void insertSort(E[] arr, int l, int r) {
        // 循环不变量 [0...i) 已经排好序 现在准备将 i 放到[0...i)中的合适位置

        for (int i = l; i < r; i++) {

            for (int j = i; j - 1 >= l; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }


    // 插入排序算法优化
    public static <E extends Comparable<? super E>> void insertSortUpdate(E[] arr) {

        int length = arr.length;
        // 循环不变量 [0...i) 已经排好序 现在准备将 i 放到[0...i)中的合适位置
        for (int i = 0; i < length; i++) {

            E ret = arr[i];

            int j; // i应该插入的正确位置

            for (j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = ret;

            ret = null; //help gc
        }
    }


    // 选择排序算法
    public static <E extends Comparable<? super E>> void selectSort(E[] arr) {
        // 循环不变量 [0...i) 已经排好序 现在从[i....arr.length) 中选择最小值 放入 arr[i]

        int length = arr.length;

        for (int i = 0; i < length; i++) {

            int min = i;  // 记录[i....arr.length) 最小值的索引

            for (int j = i; j < length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }

            swap(arr, i, min);
        }
    }


    // 希尔排序算法
    public static <E extends Comparable<? super E>> void shellSort(E[] arr) {

        // 算法基本思想 对等距数组排序
        int length = arr.length;

        int h = 1; // 等距数组的距离
        while (h < length) {
            h = 3 * h + 1;
        }


        while (h >= 1) {

            // 对data[start,start+h,start+2h... ] 进行插入排序

            for (int i = h; i < length; i += h) {

                E ret = arr[i];

                int j; // i应该插入的正确位置

                for (j = i; j - h >= 0 && arr[j].compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }

                arr[j] = ret;

                ret = null; //help gc

            }
            h = h / 3;
        }
    }


    // 冒泡排序算法 todo... 还需要再深入了解
    public static <E extends Comparable<? super E>> void bubbleSort(E[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; ) {

            // arr[n-i...n) 已经排好序了
            // 通过冒泡在arr[n-i-1] 放上合适的数据

            int lastSwapIndex = 0;

            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    lastSwapIndex = j + 1;
                }
            }

            i = length - lastSwapIndex;
        }
    }


    /**
     * 自顶向下归并排序算法
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void mergeSortUpToDown(E[] arr) {
        int length = arr.length;
        E[] aux = Arrays.copyOf(arr, length);
        mergeSortUpToDown(arr, 0, length - 1, aux);
    }

    private static <E extends Comparable<? super E>> void mergeSortUpToDown(E[] arr, int l, int r, E[] aux) {
        if (l >= r) {
            return;
        }

//        if (r - l <= 15) {
//            insertSort(arr, l, r);
//            return;
//        }

        int mid = l + (r - l) / 2;
        mergeSortUpToDown(arr, l, mid, aux);
        mergeSortUpToDown(arr, mid + 1, r, aux);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, aux);
        }
    }

    private static <E extends Comparable<? super E>> void merge(E[] arr, int l, int mid, int r, E[] aux) {
        System.arraycopy(arr, l, aux, l, r - l + 1);  // 数组拷贝

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > r) {
                arr[k] = aux[i];
                i++;
            } else if (aux[i].compareTo(aux[j]) > 0) {
                arr[k] = aux[j];
                j++;
            } else {
                arr[k] = aux[i];
                i++;
            }
        }
    }


    /**
     * 自底向上归并排序算法
     * todo... 需要深入理解
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void mergeSortDownToUp(E[] arr) {
        int length = arr.length;
        E[] aux = Arrays.copyOf(arr, length);

        for (int size = 1; size < length; size += size) {
            // 遍历合并的两个区间的起始位置 i
            // 合并[i,i+size-1] 和 [i+size,i+size+size-1]

            for (int i = 0; i + size < length; i += 2 * size) {
                if (arr[i + size].compareTo(arr[i + size - 1]) < 0) {
                    merge(arr, i, i + size - 1, Math.min(i + size + size - 1, length - 1), aux);
                }
            }
        }
    }


    // 基本快速排序算法
    public static <E extends Comparable<? super E>> void quickSort(E[] arr) {
        Random random = new Random();
        int length = arr.length;
        quickSort(arr, 0, length - 1, random);
    }

    private static <E extends Comparable<? super E>> void quickSort(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r, random);
        quickSort(arr, l, p, random);
        quickSort(arr, p + 1, r, random);
    }

    // 快速排序算法核心
    private static <E extends Comparable<? super E>> int partition(E[] arr, int l, int r, Random random) {

        // [0...x) 左闭右开区间
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l] = v;
        int j = l;

        // arr[l+1...j] < v  arr[j+1...i) >v 现在正在处理i 最终结果 arr[j+1...i]>v

        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    // 双路快速排序
    public static <E extends Comparable<? super E>> void quickSort2Way(E[] arr) {
        int length = arr.length;
        Random random = new Random();
        quickSort2Way(arr, 0, length - 1, random);
    }

    private static <E extends Comparable<? super E>> void quickSort2Way(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = partition2Way(arr, l, r, random);

        quickSort2Way(arr, l, p, random);
        quickSort2Way(arr, p + 1, r, random);
    }

    private static <E extends Comparable<? super E>> int partition2Way(E[] arr, int l, int r, Random random) {

        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1;
        int j = r;

        // arr[l+1...i-1]<=v;arr[j+1...r]>=v

        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                ++i;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                --j;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;

        }

        swap(arr, l, j);
        return j;
    }

    // 三路快速排序
    public static <E extends Comparable<? super E>> void quickSort3Way(E[] arr) {
        Random rnd = new Random();
        quickSort3Way(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<? super E>> void quickSort3Way(E[] arr, int l, int r, Random rnd) {
        if (l >= r) {
            return;
        }
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);


        // arr[l+1...lt]<v arr[lt+1...i-1]==v arr[gt...r]>v

        int i = l + 1;
        int lt = l;
        int gt = r + 1;

        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, lt, i);
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }

        }

        swap(arr, l, lt);
        // arr[l...lt-1]<v arr[lt...gt-1]===v arr[gt...r]>v
        quickSort3Way(arr, l, lt - 1, rnd);
        quickSort3Way(arr, gt, r, rnd);
    }


    private static <E> void swap(E[] arr, int l, int h) {
        E temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
        temp = null;   //help gc
    }
}
