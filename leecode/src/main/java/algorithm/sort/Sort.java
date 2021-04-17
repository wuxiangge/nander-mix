package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhangnan
 * @date 2021/4/15 9:07
 */
public class Sort {

    private Sort() {
    }

    // 冒泡排序
    public static <E extends Comparable<? super E>> void bubbleSort(E[] data) {

        for (int i = 0; i < data.length; i++) {
            // （data.length-1-i  data.length] 已经排序
            // 在 [0,data.length-1-i] 中选择合适的值 放入 data[data.length-1-i]

            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) < 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }


    public static <E extends Comparable<? super E>> void bubbleSort1(E[] data) {
        for (int i = 0; i < data.length; i++) {

            boolean swapFlag = false;

            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) < 0) {
                    swap(data, j, j + 1);
                    swapFlag = true;
                }
            }

            if (!swapFlag) {
                break;
            }
        }
    }


    public static <E extends Comparable<? super E>> void bubbleSort2(E[] data) {
        for (int i = 0; i < data.length; ) {
            int lastSwapIndex = 0;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) < 0) {
                    swap(data, j, j + 1);
                    lastSwapIndex = j + 1;
                }
            }
            i = data.length - lastSwapIndex;
        }
    }

    // 插入排序
    public static <E extends Comparable<? super E>> void insertionSort(E[] data) {
        for (int i = 1; i < data.length; i++) {
            // [0,i) 已经排序
            for (int j = i; j - 1 >= 0; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    swap(data, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static <E extends Comparable<? super E>> void insertionSort1(E[] data) {
        for (int i = 1; i < data.length; i++) {
            // [0,i) 已经排序
            for (int j = i; j - 1 >= 0 && data[j].compareTo(data[j - 1]) < 0; j--) {
                swap(data, j - 1, j);
            }
        }
    }


    public static <E extends Comparable<? super E>> void insertionSort1(E[] data, int l, int r) {
        for (int i = l; i <= r; i++) {
            // [0,i) 已经排序
            for (int j = i; j - 1 >= l && data[j].compareTo(data[j - 1]) < 0; j--) {
                swap(data, j - 1, j);
            }
        }
    }


    // 插入排序
    public static <E extends Comparable<? super E>> void insertionSort2(E[] data) {
        for (int i = 1; i < data.length; i++) {
            E t = data[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = t;
        }
    }


    // 希尔排序是直接插入排序算法的一种优化
    public static <E extends Comparable<? super E>> void shellSort(E[] data) {
        int h = 1;
        while (h < data.length) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 对data[start,start+h,start+2h... ] 进行插入排序
            for (int i = h; i < data.length; i++) {
                E ret = data[i];
                int j;
                for (j = i; j - h >= 0 && ret.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = ret;
            }
            h /= 3;
        }
    }


    // 快速排序思想
    public static <E extends Comparable<? super E>> void quickSort(E[] data) {
        Random random = new Random();
        quickSort(data, 0, data.length - 1, random);
    }

    private static <E extends Comparable<? super E>> void quickSort(E[] data, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        // 选择一个分割点
        int p = partition(data, l, r, random);
        quickSort(data, l, p - 1, random);
        quickSort(data, p + 1, r, random);
    }

    private static <E extends Comparable<? super E>> int partition(E[] data, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(data, l, p);

        // data[l+1...j] < v  data[j+1...i] >v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (data[i].compareTo(data[l]) < 0) {
                j++;
                swap(data, i, j);
            }
        }
        swap(data, l, j);
        return j;
    }


    private static <E extends Comparable<? super E>> int partitionSingle(E[] data, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(data, l, p);
        // data[l+1,j] < v data[j+1,i]>v
        E v = data[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (data[i].compareTo(v) < 0) {
                j++;
                swap(data, i, j);
            }
        }
        swap(data, l, j);
        return j;
    }

    // 快速排序思想
    public static <E extends Comparable<? super E>> void quickSort2Way(E[] data) {
        Random random = new Random();
        quickSort2Way(data, 0, data.length - 1, random);

    }

    private static <E extends Comparable<? super E>> void quickSort2Way(E[] data, int l, int r, Random random) {

        if (l >= r) {
            return;
        }

        int p = partition2Way(data, l, r, random);
        quickSort2Way(data, l, p - 1, random);
        quickSort2Way(data, p + 1, r, random);

    }

    // 双路快排
    private static <E extends Comparable<? super E>> int partition2Way(E[] data, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(data, l, p);

        // arr[l+1...i-1]<=v;arr[j+1...r]>=v
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && data[i].compareTo(data[l]) < 0) {
                i++;
            }
            while (j >= i && data[j].compareTo(data[l]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(data, i, j);
            i++;
            j--;
        }
        swap(data, l, j);
        return j;
    }


    private static <E extends Comparable<? super E>> int partitionDoubleWay(E[] data, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(data, l, p);

        // data[l+1...i-1] <=v data[j+1...r] >=v
        int i = l + 1;
        int j = r;
        E v = data[l];

        while (true) {
            while (i <= j && data[i].compareTo(v) < 0) {
                i++;
            }
            while (i <= j && data[j].compareTo(v) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(data, i, j);
            i++;
            j--;
        }

        swap(data, l, j);
        return j;
    }


    // 快速排序思想
    public static <E extends Comparable<? super E>> void quickSort3Way(E[] data) {
        Random random = new Random();
        quickSort3Way(data, 0, data.length - 1, random);
    }

    private static <E extends Comparable<? super E>> void quickSort3Way(E[] data, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = l + random.nextInt(r - l + 1);
        swap(data, l, p);

        // arr[l+1...lt]<v arr[lt+1...i-1]===v arr[gt...r]>v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (data[i].compareTo(data[l]) < 0) {
                lt++;
                swap(data, i, lt);
                i++;
            } else if (data[i].compareTo(data[l]) > 0) {
                gt--;
                swap(data, i, gt);
            } else {
                // arr[i] == arr[l]
                i++;
            }
        }

        swap(data, l, lt);
        // arr[l+1...lt-1]<v arr[lt...gt-1]===v arr[gt...r]>v

        quickSort3Way(data, l, lt - 1, random);
        quickSort3Way(data, gt, r, random);

    }


    private static <E extends Comparable<? super E>> void quickSortThirdWay(E[] data, int l, int r, Random random) {
        if (l >= r) {
            return;
        }

        int p = l + random.nextInt(r - l + 1);
        swap(data, l, p);

        // arr[l+1...lt]<v arr[lt+1...i-1]===v arr[gt...r]>v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        E v = data[l];


        while (i < gt) {
            if (data[i].compareTo(v) < 0) {
                lt++;
                swap(data, lt, i);
                i++;
            } else if (data[i].compareTo(v) > 0) {
                gt--;
                swap(data, i, gt);
            } else { // data[i] == v
                i++;
            }
        }

        swap(data, l, lt);
        quickSortThirdWay(data, l, lt - 1, random);
        quickSortThirdWay(data, gt, r, random);
    }


    public static <E extends Comparable<? super E>> void insertionSort2(E[] data, int l, int r) {
        for (int i = l; i <= r; i++) {
            E t = data[i];
            int j;
            for (j = i; j - 1 >= l && t.compareTo(data[j - 1]) < 0; j--) {
                data[j] = data[j - 1];
            }
            data[j] = t;
        }
    }


    public static <E extends Comparable<? super E>> void selectionSort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            //[0,i) 已经排序 从[i,data.length-1] 中选择最小值放入 data[i]

            int minIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[minIndex].compareTo(data[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }


    public static <E extends Comparable<? super E>> void mergeSortUpToDown(E[] data) {
        E[] aux = Arrays.copyOf(data, data.length);
        mergeSortUpToDown(data, 0, data.length - 1, aux);
    }


    private static <E extends Comparable<? super E>> void mergeSortUpToDown(E[] data, int l, int r, E[] aux) {
        if (l >= r) {
            return;
        }

        //插入排序算法优化
        if (r - l <= 15) {
            insertionSort1(data, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSortUpToDown(data, l, mid, aux);
        mergeSortUpToDown(data, mid + 1, r, aux);

        if (data[mid].compareTo(data[mid + 1]) > 0) {
            merge(data, l, mid, r, aux);
        }
    }


    public static <E extends Comparable<? super E>> void mergeSortDownToUp(E[] data) {
        int n = data.length;
        E[] aux = Arrays.copyOf(data, n);

        for (int size = 1; size < n; size += size) {
            // 遍历合并的两个区间的起始位置 i
            // 合并[i,i+size-1] 和 [i+size,i+size+size-1]
            for (int i = 0; i + size < n; i += size + size) {
                if (data[i + size - 1].compareTo(data[i + size]) > 0) {
                    merge(data, i, i + size - 1, Math.min(i + size + size - 1, n - 1), aux);
                }
            }
        }

    }


    private static <E extends Comparable<? super E>> void merge(E[] data, int l, int mid, int r, E[] aux) {
        System.arraycopy(data, l, aux, l, r - l + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                data[k] = aux[j];
                j++;
            } else if (j > r) {
                data[k] = aux[i];
                i++;
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                data[k] = aux[i];
                i++;
            } else {
                data[k] = aux[j];
                j++;
            }
        }
    }


    private static <E> void swap(E[] data, int l, int r) {
        E temp = data[l];
        data[l] = data[r];
        data[r] = temp;
        temp = null;
    }

}
