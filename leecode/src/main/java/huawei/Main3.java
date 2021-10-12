package huawei;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputSplit = input.split(" ");
        int[] nums = new int[inputSplit.length];

        for (int i = 0; i < inputSplit.length; i++) {
            nums[i] = Integer.parseInt(inputSplit[i]);
        }

        Main3 main = new Main3();
        String result = main.calculate(nums);
        System.out.println(result);
    }

    private String calculate(int[] nums) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int curNum = nums[i];
                int loopNum = nums[j];


                if (!curNumBiggerLoopNum(curNum, loopNum)) {
                    int temp = curNum;
                    nums[j] = temp;
                    nums[i] = loopNum;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }

        String string = sb.toString();
        while (string.startsWith("0") && string.length() > 1) {
            string = string.replaceFirst("0", "");
        }
        return string;
    }

    private boolean curNumBiggerLoopNum(int curNum, int loopNum) {
        boolean flag = true;
        String curNumString = String.valueOf(curNum);
        String loopNumString = String.valueOf(loopNum);

        String curNumFirst = curNumString + loopNumString;
        String loopNumFirst = loopNumString + curNumFirst;

        int result = curNumBigger(curNumFirst, loopNumFirst);
        if (result < 0) {
            flag = false;
        } else if (result == 0) {
            if (curNumString.length() > loopNumString.length()) {
                flag = false;
            }
        }
        return flag;
    }

    private int curNumBigger(String curNum, String loopNum) {
        for (int i = 0; i < curNum.length(); i++) {
            int curChar = curNum.charAt(i);
            int loopChar = loopNum.charAt(i);

            if (curChar > loopChar) {
                return 1;
            }
            if (curChar < loopChar) {
                return -1;
            }
        }
        return 0;
    }
}
