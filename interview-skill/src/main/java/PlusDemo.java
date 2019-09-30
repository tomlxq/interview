/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/11
 */
public class PlusDemo {
    /**
     * ++在前表示先使用再计算，++在后表示先计算再使用。
     * 输出：
     * 1235
     * 3514
     * @param args
     */
    public static void main(String[] args) {
        int m=12,n=34;
        System.out.println(String.format("%d%d",m++,++n));
        System.out.println(String.format("%d%d\n",n++,++m));
    }

}
