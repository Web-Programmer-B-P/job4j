package magnit.parse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Class XMLParse
 *
 * @author Petr B.
 * @since 16.11.2019, 9:19
 */
public class XMLParse extends DefaultHandler {
    private static final Logger LOG = LogManager.getLogger(XMLParse.class.getName());
    private static final String TAG_ENTRY = "entry";
    private List<Integer> allValues = new ArrayList<>();

    public List<Integer> getAllValues() {
        return allValues;
    }

    @Override
    public void startDocument() throws SAXException {
        LOG.info("We are going parsing..");
    }

    @Override
    public void endDocument() throws SAXException {
        LOG.info("finished parse..");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(TAG_ENTRY)) {
            String id = attributes.getValue("href");
            allValues.add(Integer.parseInt(id));
        }
    }
}
