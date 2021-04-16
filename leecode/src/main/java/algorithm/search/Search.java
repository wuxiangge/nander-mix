package algorithm.search;

/**
 * @author zhangnan
 * @date 2021/4/15 9:37
 */
public class Search {
    private Search() {
    }


    public static <E extends Comparable<? super E>> int lineSort(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }


    public static <E extends Comparable<? super E>> int binarySearch(E[] data, E target) {
        int l = 0;
        int r = data.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


    public static <E extends Comparable<? super E>> int recursionBinarySearch(E[] data, E target) {
        return recursionBinarySearch(data, target, 0, data.length - 1);
    }


    public static <E extends Comparable<? super E>> int recursionBinarySearch(E[] data, E target, int l, int r) {

        if (l > r) {
            return -1;
        }


        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) < 0) {
            return recursionBinarySearch(data, target, mid + 1, r);
        } else {
            return recursionBinarySearch(data, target, l, mid - 1);
        }
    }


    public static <E extends Comparable<? super E>> int ceil(E[] data, E target) {
        int l = 0;
        int r = data.length - 1;

        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    public static <E extends Comparable<? super E>> int upper(E[] data, E target) {
        int l = 0;
        int r = data.length - 1;

        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (data[mid].compareTo(target) >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }


}
