package magnit.xml;

import magnit.Config;
import magnit.store.StoreSQL;
import org.junit.Test;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Class StoreXMLTest
 *
 * @author Petr B.
 * @since 15.11.2019, 12:24
 */
public class StoreXMLTest {
    @Test
    public void whenGetDataFromDbAndGenerateXml() throws JAXBException, IOException {
        StoreSQL generate = new StoreSQL(new Config());
        generate.init();
        generate.generate(2);
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        StoreXML store = new StoreXML(new File(absolutePath + "/test.xml"));
        store.save(generate.load());
        BufferedReader reader = new BufferedReader(new FileReader(absolutePath + "/test.xml"));
        String data = null;
        String result = "";
        while ((data = reader.readLine()) != null) {
            result += data;
        }
        String expected = "<?xmlversion=\"1.0\"encoding=\"UTF-8\"standalone=\"yes\"?>"
                + "<entries><entry><field>1</field></entry><entry><field>2</field></entry></entries>";
        assertThat(
                result.replaceAll("\\s+", ""),
                is(expected)
        );
    }
}