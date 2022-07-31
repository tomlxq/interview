import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SplitList {
    @org.junit.Test
    public void name() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21);
        List<List<Integer>> partition = Lists.partition(integers, 5);
        partition.stream().forEach(v -> log.info(StringUtils.join(v, ",")));
    }
}
