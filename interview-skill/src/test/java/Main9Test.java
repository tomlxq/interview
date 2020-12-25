import com.google.common.math.BigIntegerMath;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 11/8/2020
 */
@Slf4j
public class Main9Test {
    public BigInteger factorialUsingGuava(int n) {
        return BigIntegerMath.factorial(n);
    }public long factorialUsingApacheCommons(int n) {
        return CombinatoricsUtils.factorial(n);
    }public long factorialUsingStreams(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }
    @Test
    public void main() {
        IntStream.range(1,10).forEach(idx-> System.out.println(idx+"^2="+Math.pow(idx,2)));


        IntStream.range(1,10).forEach(idx-> System.out.println(idx+"!="+factorial(idx)));

        IntStream.range(1,10).forEach(idx-> System.out.println(idx+"!="+factorialUsingGuava(idx)));
        IntStream.range(1,10).forEach(idx-> System.out.println(idx+"!="+factorialUsingApacheCommons(idx)));
        IntStream.range(1,10).forEach(idx-> System.out.println(idx+"!="+factorialUsingStreams(idx)));
        log.info("2^6={}",Math.pow(2,6));
    }

    private int factorial(int idx) {
        if(idx<2){
            return 1;
        }
        return idx*factorial(idx-1);
    }
}