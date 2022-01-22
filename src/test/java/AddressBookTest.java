
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
        AddressBookDB addressbookdb = new AddressBookDB();
        List<AddressBook> addresstest = AddressBookDB.retrieveAlltheEntriesInAddressBook();
                Assertions.assertEquals(3,addressbooktest.size());
    }
    @Test
    public void updateContactInfoTest() {
        
        AddressBookDB addressbookdb = new AddressBookDB();
        List<AddressBook> addresstest = AddressBookDB.updatecontactinfotetsInAddressBook();
        int contact = AddressBookDB.updateContactInfo("makreting","Anusha","Nallapu");
       Assertions.assertEquals(1, contact());
    }
    @Test
    public void retrieveContactFromDatabaseTest() {
        
        AddressBookDB addressbookdb = new AddressBookDB();
        LocalDate start_date = LocalDate.of(2021,10,02);
        LocalDate end_date = LocalDate.of(2022,11,05);
        List<AddressBook> dateresult = AddressBookDB.retrieveContactFromDatabase(start_date,end_date);
        Assertions.assertEquals(2, Dateresult.size());
    }
    @Test
    public void retrieveNumberOfContactsInDbByCityorStateTest() throws SQLException {
        AddressBookDB addressbookdb = new AddressBookDB();
        List<AddressBook> cityorstatetest = AddressBookDB.retrieveContactsByCityorState("karnataka");
          Assertions.assertEquals(1, cityorstatetest.size());
    }

    @Test
    public void addDataIntoAddressBookTransactionTest() throws SQLException {
         AddressBookDB addressbookdb = new AddressBookDB();
        LocalDate start_date = LocalDate.of(2019,03, 01);
        int result = AddressBookDB.addDatabaseIntoTransaction("bhavitha","potha","sathupally","sales",start_date, "kallur","Telangana",507303,987586412,"bhavi@gmail.com");
        Assertions.assertEquals(1, result);
    }
}
