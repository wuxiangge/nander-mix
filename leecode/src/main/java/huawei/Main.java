package huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            sb.append(sc.hasNextLine());
        }
        String string = sb.toString();
        String[] strings = string.split(";");
        int inputLength = strings.length;
        String canOpsString = strings[inputLength - 1];
        String[] canOpsStringSplit = canOpsString.split(",");

        int canOpsLength = canOpsStringSplit.length;

        int diageN = strings[0].split(",").length;

        double[][] diage = new double[canOpsLength][diageN];
        for (int i = 0; i < canOpsLength; i++) {
            String[] temp = strings[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                diage[i][j] = Double.parseDouble(temp[j]);
            }
        }

        String[] changeNumsString = strings[canOpsLength].split(",");
        String[] targetString = strings[canOpsLength + 1].split(",");


        int[] changeNums = new int[changeNumsString.length];
        for (int i = 0; i < changeNumsString.length; i++) {
            changeNums[i] = Integer.parseInt(changeNumsString[i]);
        }

        int[] target = new int[targetString.length];
        for (int i = 0; i < targetString.length; i++) {
            target[i] = Integer.parseInt(targetString[i]);
        }

        Main main = new Main();
        main.calculate(diage, changeNums, target, canOpsStringSplit);
    }

    private void calculate(double[][] diage, int[] changeNums, int[] target, String[] canOps) {
        int m = diage.length;
        int n = diage[0].length;

        double maxValue = Integer.MIN_VALUE;
        double minValue = Integer.MAX_VALUE;
        boolean booResult = true;

        int temp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp += diage[i][j] * changeNums[j];
            }

            // 找到最大值和最小值
            maxValue = Math.max(maxValue, temp);
            minValue = Math.min(minValue, temp);

            if (temp == target[i]) {
                boolean flag = (canOps[i] == ">=" || canOps[i] == "=" || canOps[i] == "<=");
                booResult = booResult && flag;
            } else if (temp > target[i]) {
                boolean flag = canOps[i] == ">";
                booResult = booResult && flag;
            } else {
                boolean flag = canOps[i] == "<";
                booResult = booResult && flag;
            }
            temp = 0;
        }

        System.out.println(booResult);
        System.out.println(Math.abs(maxValue - minValue));
    }
}
