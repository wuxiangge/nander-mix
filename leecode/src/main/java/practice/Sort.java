package practice;

public class Sort {

    private Sort() {
    }


    // 冒泡排序
    public static <E extends Comparable<? super E>> void bubbleSort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 在[0,array.length-i-1] 上排序 (array.length - i -1, array.length-1] 已经排好序
            // 在 [array.length - 1 - i] 上防止合适参数
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    // 冒泡排序 在冒泡的过程中 可能数字已经排好序了
    public static <E extends Comparable<? super E>> void bubbleSort2(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 在[0,array.length-i-1] 上排序 (array.length - i -1, array.length-1] 已经排好序
            // 在 [array.length - 1 - i] 上防止合适参数

            boolean isSwap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    isSwap = true;
                    swap(array, j, j + 1);
                }
            }

            if (!isSwap) {
                break;
            }
        }
    }


    // 冒泡排序 在冒泡的过程中 可能数字已经排好序了 n^2
    public static <E extends Comparable<? super E>> void bubbleSort3(E[] array) {
        for (int i = 0; i < array.length - 1; ) {

            // arr[n-i...n) 已经排好序了

            // 通过冒泡在arr[n-i-1] 放上合适的数据

            int lastSwappedIndex = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            // 0 1 2 3 4
            // 8 1 10 15
            // 1 8 10 15

            i = array.length - lastSwappedIndex;
        }
    }


    public static <E extends Comparable<? super E>> void insertionSort(E[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            // [0,i) 已经排序 将i插入到[0,i)中合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    swap(array, j-1, j);
                } else {
                    break;
                }
            }
        }
    }


    public static <E extends Comparable<? super E>> void insertionSort2(E[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            // [0,i) 已经排序 将i插入到[0,i)中合适的位置
            for (int j = i; j - 1 >= 0 && array[j - 1].compareTo(array[j]) > 0; j--) {
                swap(array, j-1, j);
            }
        }
    }

    public static <E extends Comparable<? super E>> void insertionSort3(E[] array) {
        for (int i = 1;i< array.length-1;i++) {
            // 待插入的数据
            E t = array[i];
            // 应该插入的位置
            int j;
            for (j = i; j >= 1 && t.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = t;
            // help gc
            t = null;
        }
    }




    private static <E> void swap(E[] array, int l, int r) {
        E temp = array[l];
        array[l] = array[r];
        array[r] = temp;
        temp = null;
    }
}
