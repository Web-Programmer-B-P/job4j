package magnit.xstl;

import magnit.Config;
import magnit.store.StoreSQL;
import magnit.xml.StoreXML;
import org.junit.Before;
import org.junit.Test;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.URISyntaxException;
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
            generate.generate(5);
            Path resourceDirectory = Paths.get("src", "main", "resources");
            absolutePath = resourceDirectory.toFile().getAbsolutePath();
            StoreXML store = new StoreXML(new File(this.getClass().getClassLoader().getResource("test.xml").getFile()));
            store.save(generate.load());
            scheme = new File(this.getClass().getClassLoader().getResource("scheme.xml").getFile());
            source = new File(this.getClass().getClassLoader().getResource("test.xml").getFile());
            dest = new File(absolutePath + "/test_convert_xsqt.xml");
            ConvertXSQT call = new ConvertXSQT();
            call.convert(source, dest, scheme);
    }

    @Test
    public void whenConvertXmlFileByXstlSchemeToNewXmlFile() throws IOException, TransformerException, InterruptedException, URISyntaxException {
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><entries><entry href=\"1\"/>"
                + "<entry href=\"2\"/><entry href=\"3\"/><entry href=\"4\"/><entry href=\"5\"/></entries>";
        BufferedReader reader = new BufferedReader(new FileReader(absolutePath + "/test_convert_xsqt.xml"));
        String data;
        String result = "";
        while ((data = reader.readLine()) != null) {
            result +=  data;
        }
        assertThat(result, is(expected));
    }
}