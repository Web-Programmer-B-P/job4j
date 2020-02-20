package magnit;

import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.Properties;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class ConfigTest
 *
 * @author Petr B.
 * @since 15.11.2019, 12:26
 */
public class ConfigTest {
    private Properties values;

    @Before
    public void setUp() throws Exception {
        values = new Properties();
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        }
    }

    @Test
    public void whenReadConfigFromResources() {
        Config read = new Config();
        read.init();
        String expected = values.getProperty("dbName");
        assertThat(read.get("dbName"), is(expected));
    }
}