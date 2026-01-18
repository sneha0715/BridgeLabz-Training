package address_book.controller;
import address_book.entity.Contact;
public class AddressBookController {
  public static void main(String[] args) {
    Contact contact=new Contact("Rohan","Sharma","123 Street","Cityville","Stateville","123456","123-456-7890","rohan.sharma@example.com");
    System.out.println("First Name: "+contact.getFirstName() +"\nLast Name: "+contact.getLastName()+"\nAddress: "+contact.getAddress()+"\nCity: "+contact.getCity()+"\nState: "+contact.getState()+"\nZip: "+contact.getZip());
  }
}

