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
         AddressBookDB addressbookdb = new AddressBookDB();
        List<AddressBook> addresstest = AddressBookDB.retrieveAlltheEntriesInAddressBook();
                Assertions.assertEquals(3,addressbooktest.size());
    }
    @Test
    public void updateContactInfoTest() {
        
         AddressBookDB addressbookdb = new AddressBookDB();
        int contact = AddressBookDB.updateContactInfo("makreting","Anusha","Nallapu");
                Assertions.assertEquals(1,contact());
    }

}
