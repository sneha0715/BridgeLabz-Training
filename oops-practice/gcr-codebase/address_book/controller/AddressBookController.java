package address_book.controller;
import java.util.Scanner;
import address_book.services.AddressBookService;
public class AddressBookController {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter details to add new contact");
    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine();
    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine();
    System.out.print("Enter address: ");
    String address = scanner.nextLine();
    System.out.print("Enter city: ");
    String city = scanner.nextLine();
    System.out.print("Enter state: ");
    String state = scanner.nextLine();
    System.out.print("Enter zip: ");
    String zip = scanner.nextLine();
    System.out.print("Enter phone number: ");
    String phoneNumber = scanner.nextLine();
    System.out.print("Enter email: ");
    String email = scanner.nextLine();

    AddressBookService addressBookService = new AddressBookService();
    addressBookService.createContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    System.out.println("\nContact Details:");
    addressBookService.displayContact();
    scanner.close();
  }
}

