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
        List<AddressBook> addresstest = AddressBookDB.retrieveAlltheEntriesInAddressBook();
        Assertions Assert = null;
        Assert.assertEquals(8, addresstest.size());
    }
    @Test
    public void updateContactInfoTest() {
        int contact = AddressBookDB.updateContactInfo("makreting","Anusha","Nallapu");
        Assertions Assert = null;
        Assert.assertEquals(1, contact);
    }

}
