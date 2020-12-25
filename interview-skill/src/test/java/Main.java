import java.util.Scanner;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 11/8/2020
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextBigInteger()) {
            System.out.println(sc.nextBigInteger().add(sc.nextBigInteger()));
        }
        sc.close();
    }
}
