package magnit.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * Class StoreXML
 *
 * @author Petr B.
 * @since 14.11.2019, 13:28
 */
public class StoreXML {
    private File pathTarget;

    public StoreXML() {

    }

    public StoreXML(File target) {
        pathTarget = target;
    }

    public void save(List<Field> list) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(
                new Entries(list),
                new File(pathTarget.getPath())
        );
    }

    @XmlRootElement
    public static class Entries {
        private List<Field> list;

        public Entries() {
        }

        public Entries(List<Field> list) {
            this.list = list;
        }

        public List<Field> getEntry() {
            return list;
        }

        public void setEntry(List<Field> entry) {
            this.list = entry;
        }
    }

    @XmlRootElement
    public static class Field {
        private int field;

        public Field() {
        }

        public Field(int value) {
            field = value;
        }

        public int getField() {
            return field;
        }

        public void setField(int fieldId) {
            this.field = fieldId;
        }
    }
}
