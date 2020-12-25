import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 11/8/2020
 */
@Slf4j
public class ToolTest {
    @Test
    public void name() {
        final Collection<File> files = FileUtils.listFiles(new File("E:\\data\\wwwtest\\interview\\doc"), new String[]{"md"}, true);
        files.stream().forEach(file -> {
            try {
                log.info("process file {}", file.getCanonicalPath());
                final String content = StringUtils.replaceEachRepeatedly(FileUtils.readFileToString(file, "utf-8"), new String[]{"E:\\data\\wwwtest\\interview\\doc\\img", "E:\\data\\wwwtest\\interview\\doc\\Operating Examination\\img"}, new String[]{"img", "img"});
                FileUtils.writeStringToFile(file, content, "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
