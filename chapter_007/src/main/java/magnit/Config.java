package magnit;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class Config
 *
 * @author Petr B.
 * @since 12.11.2019, 11:15
 */
public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
