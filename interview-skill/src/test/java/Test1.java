import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ​ 按要求分解字符串，输入两个数M，N；M代表输入的M串字符串，N代表输出的每串字符串的位数，不够补0。
 * 例如：输入2,8， “abc” ，“123456789”，则输出为“abc00000”,“12345678“,”90000000”
 *
 * @author TomLuo
 * @date 2020/3/3
 */
public class Test1 {
    public static void main(String[] args) {
        //获取输入的数字
        String input[] = getInputNum();
        int a = Integer.valueOf(input[0]);
        int b = Integer.valueOf(input[1]);
        List<String> collect1 = Arrays.stream(input).skip(2).collect(Collectors.toList());
        collect1.forEach(line -> {
            final int length = line.length();
            if(length==b){
                System.out.print(line + " ");
            }else if(length<b){
                System.out.print(line + " ");
                IntStream.rangeClosed(1, b - length).forEach(idx -> {
                    System.out.print("0");
                });
            }else{
               int num= length/b;
                IntStream.rangeClosed(0, num-1).forEach(idx -> {
                    System.out.println(line.substring(idx*b,(idx+1)*b));
                });
                if(length%b!=0){
                    System.out.println(line.substring(num*b,length%b));
                    IntStream.rangeClosed(1,b-length%b).forEach(idx -> {
                        System.out.print("0");
                    });
                }

            }




        });


    }

    private static String[] getInputNum() {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            final String next = scanner.next();
            if (next == null || next.length() <= 2) {
                System.out.println("输入不符合要求长度要求，请重新输入！");
                continue;
            }
            final String[] split = next.split(",");
            System.out.println(split[0] + " " + split[1]);
            if (!split[0].matches("^[0-9]*$") || !split[1].matches("^[0-9]*$")) {
                System.out.println("输入前两位必须为数字！");
                continue;
            }
            final int lenStrNum = Integer.valueOf(split[0]).intValue();
            final int listSize = Arrays.stream(split).skip(2).collect(Collectors.toList()).size();
            if (lenStrNum != listSize) {
                System.out.println("输入字符串不符合要求长度要求，请重新输入！");
                continue;
            }
            return split;
        }
    }
}
