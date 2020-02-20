package magnit.parse;

import magnit.Config;
import magnit.store.StoreSQL;
import magnit.xml.StoreXML;
import magnit.xstl.ConvertXSQT;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class XMLParseTest
 *
 * @author Petr B.
 * @since 16.11.2019, 10:23
 */
public class XMLParseTest {
    private String absolutePath;

    @Before
    public void setUp() throws Exception {
        StoreSQL generate = new StoreSQL(new Config());
        generate.init();
        generate.generate(5);
        Path resourceDirectory = Paths.get("src", "main", "resources");
        absolutePath = resourceDirectory.toFile().getAbsolutePath();
        StoreXML store = new StoreXML(new File(this.getClass().getClassLoader().getResource("test.xml").getPath()));
        store.save(generate.load());
        File scheme = new File(this.getClass().getClassLoader().getResource("scheme.xml").getFile());
        File source = new File(this.getClass().getClassLoader().getResource("test.xml").getFile());
        File dest = new File(absolutePath + "/test_parse.xml");
        ConvertXSQT call = new ConvertXSQT();
        call.convert(source, dest, scheme);
    }

    @Test
    public void whenParseXmlAndCount() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLParse parse = new XMLParse();
        parser.parse(new File(absolutePath + "/test_parse.xml"), parse);
        int result = parse.getAllValues().stream().mapToInt(Integer::intValue).sum();
        assertThat(result, is(15));
    }
}