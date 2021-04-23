package offer.q5;

/**
 * @author zhangnan
 * @date 2021/4/23 10:08
 */
public class Solution {

    private static final String WHITE = "%20";

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
            } else {
                stringBuilder.append(WHITE);
            }
        }

        return stringBuilder.toString();
    }

}
