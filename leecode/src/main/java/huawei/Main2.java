package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputSplit = input.split(",");
        int target = sc.nextInt();
        Main2 main = new Main2();
        main.getVlan(inputSplit, target);
    }


    private void getVlan(String[] nums, int target) {
        List<Integer> vlanpool = new ArrayList<>();

        for (String cur : nums) {
            if (cur.contains("-")) {
                String[] temps = cur.split("-");
                int start = Integer.parseInt(temps[0]);
                int end = Integer.parseInt(temps[1]);
                for (int i = start; i <= end; i++) {
                    vlanpool.add(i);
                }
            } else {
                vlanpool.add(Integer.parseInt(cur));
            }
        }

        for (int i = 0; i < vlanpool.size(); i++) {
            if (vlanpool.get(i) == target) {
                vlanpool.remove(i);
            }
        }
        Collections.sort(vlanpool);


        int startIndex = 0;
        int endIndex = 0;

        while (endIndex < vlanpool.size()) {
            while (endIndex < vlanpool.size() - 1 && vlanpool.get(endIndex + 1) - vlanpool.get(endIndex) == 1) {
                endIndex++;
            }

            if (startIndex == endIndex) {
                System.out.print(vlanpool.get(startIndex));
                startIndex++;
                endIndex++;
            } else {
                System.out.print(vlanpool.get(startIndex) + "-" + vlanpool.get(endIndex));
                endIndex++;
                startIndex = endIndex;
            }

            if (endIndex != vlanpool.size()) {
                System.out.print(",");
            }
        }
    }
}
