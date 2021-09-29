package practice;

/**
 * @author zhangnan
 * @date 2021/9/14
 */
public class Main {

//    public static void main(String[] args) throws IOException{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String s1 = bf.readLine();
//        String s2 = bf.readLine();
//        Main solution  = new Main();
//        int result = solution.calculateTimesWordInString(s1,s2);
//        System.out.println(result);
//    }


    public int calculateTimesWordInString(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }

        char s2Char = s2.charAt(0);
        int times = 0;
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char iChar = s1.charAt(i);
            if (s2Char == iChar || Math.abs(s2Char - iChar) == 26) {
                times++;
            }
        }
        return times;
    }


//    public static void main(String[] args) {
//        String customerId = "20210705000061950024010000005";
//                             9223372036854775807
//
////        Long aLong = Long.parseLong(customerId);
//        System.out.println(Long.MAX_VALUE);
//    }
}
