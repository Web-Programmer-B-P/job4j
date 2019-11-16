package magnit;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class ConfigTest
 *
 * @author Petr B.
 * @since 15.11.2019, 12:26
 */
public class ConfigTest {
    @Test
    public void whenReadConfigFromResources() {
        Config read = new Config();
        read.init();
        assertThat(read.get("path"), is("/home/proger/projects/job4j/chapter_007/src/test/resources/"));
    }
}