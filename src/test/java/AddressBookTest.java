
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.addressbookjdbc.AddressBook;
import com.addressbookjdbc.AddressBookDB;
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
    @Test
    public void retrieveContactFromDatabaseTest() {
        LocalDate start_date = LocalDate.of(2021,10,02);
        LocalDate end_date = LocalDate.of(2022,11,05);
        List<AddressBook> dateresult = AddressBookDB.retrieveContactFromDatabase(start_date,end_date);
        Assertions Assert = null;
        Assert.assertEquals(3, dateresult.size());
    }
    @Test
    public void retrieveNumberOfContactsInDbByCityorStateTest() throws SQLException {
        List<AddressBook> cityorstatetest = AddressBookDB.retrieveContactsByCityorState("kolar");
        Assertions Assert = null;
        Assert.assertEquals(1, cityorstatetest.size());
    }
    @Test
    public void addDataIntoAddressBookTransactionTest() throws SQLException {
        LocalDate start_date = LocalDate.of(2019,03, 01);
        int result = AddressBookDB.addDatabaseIntoTransaction("bhavitha","potha","sathupally","sales",start_date, "kallur","Telangana",507303,987586412,"bhavi@gmail.com");
        Assertions Assert = null;
        Assert.assertEquals(1, result);
    }
}
