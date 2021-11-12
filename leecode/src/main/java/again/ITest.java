package again;

/**
 * @author zhangnan
 * @date 2021/9/22
 */
public class ITest {


    public static void main(String[] args) {
        Long l = 10L;
        while (true) {
            if (l > 100) {
                break;
            }
            System.out.println(l);
            l++;
        }
    }
}
