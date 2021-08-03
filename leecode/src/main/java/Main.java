import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException {
//
//        Scanner input = new Scanner(System.in);
//        input.nextLine();
//        input.close();
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        bufferedReader.close();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = String.valueOf(bf.readLine());
        String m = String.valueOf(bf.readLine());
        Integer times = Integer.parseInt(bf.readLine());


        HashMap<String ,Integer> map = new HashMap<>();

        for (Integer k = 0; k < times; k++) {

            String input = bf.readLine();
            String[] str = input.split(" ");
            Integer i = Integer.parseInt(str[0]);
            Integer j = Integer.parseInt(str[1]);


            String cacheKey = String.valueOf(i)+String.valueOf(j);

            Integer ans = map.get(cacheKey);


            if (ans!=null) {
                System.out.println(ans);
            }

            if (ans == null) {
                int result = getDiffCharNum(s, m, i, j);
                map.put(cacheKey,result);
                System.out.println(result);
            }
        }

    }


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
}
