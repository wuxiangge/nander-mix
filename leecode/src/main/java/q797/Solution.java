package q797;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author zhangnan
 * @date 2021/9/6
 */
public class Solution {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return result;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);
    }


    public static <E extends Comparable<? super E>> void quickSort(E[] arr) {
        Random random = new Random();
        quickSort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<? super E>> void quickSort(E[] arr, int left, int right, Random random) {
        if (left > right) {
            return;
        }

        int p = partition(arr, left, right, random);
        quickSort(arr, left, p - 1, random);
        quickSort(arr, p + 1, right, random);
    }


    private static <E extends Comparable<? super E>> int partition(E[] arr, int left, int right, Random random) {
        // 随机选择一个数作为双路快排的中间值
        int p = left + random.nextInt(right - left + 1);
        swap(arr, left, p);

        int i = left + 1;
        int j = right;

        // arr[l+1,,,i-1]<=v  arr[j+1...right]>=v
        while (true) {
            while (arr[i].compareTo(arr[left]) < 0) {
                i++;
            }

            while (arr[j].compareTo(arr[left]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, left, j);
        return j;
    }


    private static <E extends Comparable<? super E>> void swap(E[] arr, int left, int right) {
        E temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        temp = null; // help gc
    }


    public static <E extends Comparable<? super E>> void mergeSort(E[] arr) {
        E[] aux = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, 0, arr.length - 1, aux);
    }

    private static <E extends Comparable<? super E>> void mergeSort(E[] arr, int l, int r, E[] aux) {
        if (l > r) {
            // 这里可以使用插入排序优化速度
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid, aux);
        mergeSort(arr, mid + 1, r, aux);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, aux);
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param aux
     * @param <E>
     */
    private static <E extends Comparable<? super E>> void merge(E[] arr, int l, int mid, int r, E[] aux) {
        System.arraycopy(arr, l, aux, l, r - l + 1);

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (k > mid) {
                arr[k] = aux[j++];
            } else if (j > r) {
                arr[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}