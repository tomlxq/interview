import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * @author TomLuo
 * @date 11/5/2020
 */
public class Main9 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        if(sc.hasNext()){
            StringBuffer sb=new StringBuffer(sc.nextLine());
            final char[] chars = sb.reverse().toString().toCharArray();
            Set<Character> set=new HashSet<>();
            for(char c:chars){
                // Set后续增加add都会失败，返回false
                if(set.add(c)){
                    System.out.print(c);
                }
            }
            //method2(sc);
            //method1(sc);
        }
    }

    private static void method2(Scanner sc) {
        StringBuffer sb=new StringBuffer(sc.nextLine());
        final char[] chars = sb.reverse().toString().toCharArray();
        Set<Character> set=new LinkedHashSet<>();
        for(char c:chars){
            set.add(c);
        }
        for(char c:set){
            System.out.print(c);
        }
    }

    private static void method1(Scanner sc) {
        String line=sc.nextLine();
        char[] ary=line.toCharArray();
        List<String> list=new ArrayList<>();
        for(int i=ary.length-1;i>=0;i--){
            String tmpStr=String.valueOf(ary[i]);
            if(list.contains(tmpStr)){
                continue;
            }else{
                list.add(tmpStr);
            }
        }
        for(String c:list){
            System.out.print(c);
        }
    }
}
