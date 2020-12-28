package q203;

public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算 arr[l...n) 这个区间内的所有数字之和
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }


}
