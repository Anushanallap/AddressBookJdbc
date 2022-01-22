import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.addressbookjdbc.AddressBook;
import com.addressbookjdbc.AddressBookDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AddressBookTest {
    @Test
    public void retrieveAlltheEntriesInAddressBookTest()
    {
        List<AddressBook> addressbooktest = AddressBookDB.retrieveAlltheEntriesInAddressBook();
        Assertions Assert = null;
        Assert.assertEquals(8, addresstest.size());
    }

}
