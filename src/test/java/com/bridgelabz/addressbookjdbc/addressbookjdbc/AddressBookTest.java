package com.bridgelabz.addressbookjdbc.addressbookjdbc;
import java.util.List;
import org.junit.*;
import junit.framework.Assert;
public class AddressBookTest {
	static AddressBookServices addressBookService;

    @BeforeClass
    public static void createAddressBookObj() {
        addressBookService = new AddressBookServices();
    }

    @Test
    public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount() throws AddressBookException {
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(AddressBookServices.IOService.DB_IO);
        org.junit.Assert.assertEquals(5, addressBookData.size());
    }

    @Test
    public void givenAddressBook_WhenUpdate_ShouldSyncWithDB() throws AddressBookException {
        addressBookService.updateRecord("pratiik", "NKB");
        boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("pratiik");
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void givenAddressBook_WhenRetrieved_ShouldMatchCountInGivenRange() throws AddressBookException {
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(AddressBookServices.IOService.DB_IO, "2018-02-14",
                "2020-06-02");
        org.junit.Assert.assertEquals(3, addressBookData.size());
    }

    @Test
    public void givenAddresBook_WhenRetrieved_ShouldReturnCountOfCity() throws AddressBookException {
        org.junit.Assert.assertEquals(1, addressBookService.readAddressBookData("Maharashtra", "Mumbai"));
    }
}
