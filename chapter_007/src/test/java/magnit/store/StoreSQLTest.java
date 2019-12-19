package magnit.store;

import magnit.Config;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class StoreSQLTest
 *
 * @author Petr B.
 * @since 15.11.2019, 12:34
 */
public class StoreSQLTest {
    @Test
    public void whenCreateDbAndTableAndInsertDataAndLoadRowsToList() {
        StoreSQL store = new StoreSQL(new Config());
        store.init();
        store.generate(5);
        assertThat(store.load().size(), is(5));
    }
}