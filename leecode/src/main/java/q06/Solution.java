package q06;

public class Solution {

    public String convert(String s, int numRows) {

        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        int length = s.length();
        StringBuilder stringBuilderArray[] = new StringBuilder[length];

        for (int i = 0; i < length; i++) {
            stringBuilderArray[i] = new StringBuilder();
        }


        int dir = 1;
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            StringBuilder stringBuilder = stringBuilderArray[index];
            stringBuilder.append(c);
            index = index + dir;
            if (index == 0 || index == numRows-1) {
                dir = -dir;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilderArray) {
            result.append(stringBuilder);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String paypalishiring = solution.convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }
}
