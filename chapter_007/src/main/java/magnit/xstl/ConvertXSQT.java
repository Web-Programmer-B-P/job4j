package magnit.xstl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Class ConvertXSQT
 *
 * @author Petr B.
 * @since 14.11.2019, 21:34
 */
public class ConvertXSQT {
    public void convert(File source, File dest, File scheme) throws IOException, TransformerException {
       TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        new ByteArrayInputStream(
                                new FileInputStream(scheme.getPath()).readAllBytes()))
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(
                                new FileInputStream(source.getPath()).readAllBytes())),
                new StreamResult(
                        new FileOutputStream(new File(dest.getPath())))
        );
    }
}
