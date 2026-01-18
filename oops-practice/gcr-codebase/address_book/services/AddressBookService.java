package address_book.services;
import address_book.entity.Contact;
import address_book.repository.AddressBookRepository;
public class AddressBookService {
  AddressBookRepository addressBookRepository=new AddressBookRepository();
  public void createContact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
    Contact contact=new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    addressBookRepository.save(contact);
    System.out.println("Contact saved successfully!");
  }
  public void displayContact(){
    Contact contact=addressBookRepository.getContact();
    System.out.println(contact);
  }
}
