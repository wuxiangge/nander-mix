import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {


//    public static void main(String[] args) throws IOException {
////
////        Scanner input = new Scanner(System.in);
////        input.nextLine();
////        input.close();
////
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        bufferedReader.close();
//
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String s = String.valueOf(bf.readLine());
//        String m = String.valueOf(bf.readLine());
//        Integer times = Integer.parseInt(bf.readLine());
//
//
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (Integer k = 0; k < times; k++) {
//
//            String input = bf.readLine();
//            String[] str = input.split(" ");
//            Integer i = Integer.parseInt(str[0]);
//            Integer j = Integer.parseInt(str[1]);
//
//
//            String cacheKey = String.valueOf(i) + String.valueOf(j);
//
//            Integer ans = map.get(cacheKey);
//
//
//            if (ans != null) {
//                System.out.println(ans);
//            }
//
//            if (ans == null) {
//                int result = getDiffCharNum(s, m, i, j);
//                map.put(cacheKey, result);
//                System.out.println(result);
//            }
//        }
//
//    }


    /**
     * 获取两个子串去重后的数量
     */
    private static int getDiffCharNum(String s, String m, Integer i, Integer j) {

        Set<Character> set = new HashSet<>();

        for (Integer integer = 0; integer < i; integer++) {
            char sPart = s.charAt(integer);
            set.add(sPart);
        }

        for (Integer integer = 0; integer < j; integer++) {
            char mPart = m.charAt(integer);
            set.add(mPart);
        }

        return set.size();
    }


    public String LCS(String s1, String s2) {
        // write code here
        int s1Length = s1.length();
        int s2Length = s2.length();

        int[][] dp = new int[s1Length + 1][s2Length + 1];

        for (int i = 0; i <= s1Length; i++) {
            for (int j = 0; j <= s2Length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int longest = dp[s1Length][s2Length];
        System.out.println(Arrays.deepToString(dp));
        if (longest == 0) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        while (s1Length > 0 && s2Length > 0) {
            if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
                sb.append(s1.charAt(s1Length - 1));
                s1Length--;
                s2Length--;
            } else {
                if (dp[s1Length - 1][s2Length] > dp[s1Length][s2Length - 1]) {
                    s1Length--;
                } else {
                    s2Length--;
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        String result = main.LCS("1A2C3D4B56", "B1D23A456A");
        System.out.println(result);
    }

}
