package com.bridgelabz.addressbookjdbc.addressbookjdbc;

import junit.framework.Assert;

import java.util.List;

import org.junit.*;
public class LibraryTest {
	static AddressBookServices addressBookService;

    @BeforeClass
    public static void createAddressBookObj() {
        addressBookService = new AddressBookServices();
    }

    @Test
    public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount() throws AddressBookException {
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(AddressBookServices.IOService.DB_IO);
        Assert.assertEquals(5, addressBookData.size());
    }

    @Test
    public void givenAddressBook_WhenUpdate_ShouldSyncWithDB() throws AddressBookException {
        addressBookService.updateRecord("pratiik", "NKB");
        boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("pratiik");
        Assert.assertTrue(result);
    }
}
