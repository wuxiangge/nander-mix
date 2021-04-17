package practice;

public class Search {

    private Search() {
    }

    // 线性查找法
    public static <E extends Comparable<? super E>> int lineSearch(E[] array, E target) {
        int arrLength = array.length;
        for (int i = 0; i < arrLength; i++) {
            if (array[i].compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }


    // 二分查找法
    public static <E extends Comparable<? super E>> int binarySearch(E[] array, E target) {
        int low = 0;
        int hight = array.length - 1;

        while (hight >= low) {
            int mid = low + (hight - low) / 2;


            if (array[mid].compareTo(target) == 0) {
                return mid;
            }
            if (array[mid].compareTo(target) > 0) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable<? super E>> int recursionBinarySearch(E[] array, E target) {
        return recursionBinarySearch(array, target, 0, array.length - 1);
    }

    private static <E extends Comparable<? super E>> int recursionBinarySearch(E[] array, E target, int low, int hight) {
        if (low > hight) {
            return -1;
        }

        int mid = low + (hight - low) / 2;
        if (array[mid].compareTo(target) == 0) {
            return mid;
        }
        if (array[mid].compareTo(target) < 0) {
            return recursionBinarySearch(array, target, mid + 1, hight);
        } else {
            return recursionBinarySearch(array, target, low, mid - 1);
        }
    }

    // 返回大于指定表达式的最小整数
    public static <E extends Comparable<? super E>> int ceil(E[] array, E target) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }


    // 返回小于等于指定表达式的最大值
    public static <E extends Comparable<? super E>> int upper(E[] array, E target) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array[mid].compareTo(target) >= 0) {
                r = mid -1;
            } else {
                l = mid;
            }
        }

        return r;
    }

}
