package magnit.xstl;

import magnit.Config;
import magnit.store.StoreSQL;
import magnit.xml.StoreXML;
import org.junit.Before;
import org.junit.Test;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertXSQTTest
 *
 * @author Petr B.
 * @since 15.11.2019, 11:24
 */
public class ConvertXSQTTest {
    private File scheme;
    private File source;
    private File dest;
    private String absolutePath;

    @Before
    public void setUp() throws Exception {
        StoreSQL generate = new StoreSQL(new Config());
        generate.init();
        generate.generate(2);
        Path resourceDirectory = Paths.get("src", "test", "resources");
        absolutePath = resourceDirectory.toFile().getAbsolutePath();
        StoreXML store = new StoreXML(new File(absolutePath + "/test.xml"));
        store.save(generate.load());
        scheme = new File(this.getClass().getClassLoader().getResource("scheme.xml").getFile());
        source = new File(this.getClass().getClassLoader().getResource("test.xml").getFile());
        dest = new File(absolutePath + "/test_convert_xsqt.xml");
    }

    @Test
    public void whenConvertXmlFileByXstlSchemeToNewXmlFile() throws IOException, TransformerException, InterruptedException {
        ConvertXSQT call = new ConvertXSQT();
        call.convert(source, dest, scheme);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><entries><entry href=\"1\"/><entry href=\"2\"/></entries>";
        BufferedReader reader = new BufferedReader(new FileReader(absolutePath + "/test_convert_xsqt.xml"));
        String data = null;
        String result = "";
        while ((data = reader.readLine()) != null) {
            result += data;
        }
        assertThat(result.replaceAll("\\s+", " "),
                is(expected)
        );
    }
}