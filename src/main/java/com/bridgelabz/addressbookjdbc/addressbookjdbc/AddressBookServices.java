package com.bridgelabz.addressbookjdbc.addressbookjdbc;
import java.util.List;
public class AddressBookServices {
	 public enum IOService {
	        DB_IO
	    }

	    private List<AddressBookData> addressBookList;
	    private static AddressBookDBService addressBookDBService;

	    public AddressBookServices() {
	        addressBookDBService = AddressBookDBService.getInstance();
	    }

	    public AddressBookServices(List<AddressBookData> addresBookList) {
	        this();
	        this.addressBookList = addressBookList;
	    }

	    public List<AddressBookData> readAddressBookData(IOService ioservice) throws AddressBookException {
	        if (ioservice.equals(IOService.DB_IO))
	            this.addressBookList = addressBookDBService.readData();
	        return this.addressBookList;
	    }
}
