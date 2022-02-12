import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContactData contactData = new ContactData();
        initialize(contactData);
    }

    public static String initialize(ContactData contactData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("list of contacts, enter a command");
        System.out.println("list - list all the contacts");
        System.out.println("create - create a contact");
        System.out.println("update - update a contact");
        System.out.println("delete - delete a contact");

        System.out.println("Enter command: ");
        String input = scanner.nextLine();

        execute(input, contactData);

        return input;
    }

    public static void addContact(ContactData contactData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Contact name: ");
        String name = scanner.nextLine();

        System.out.println("Contact email: ");
        String email = scanner.nextLine();

        System.out.println("Contact telephone: ");
        String telephone = scanner.nextLine();

        Contact newContact = new Contact(name, email, telephone);
        contactData.createContact(newContact);
    }

    public static void updateContact(ContactData contactData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wich contact you want to update: ");
        String contactIndex = scanner.nextLine();

        System.out.println("New Contact name: ");
        String name = scanner.nextLine();

        System.out.println("New Contact email: ");
        String email = scanner.nextLine();

        System.out.println("New Contact telephone: ");
        String telephone = scanner.nextLine();

        Contact updatedContact = new Contact(name, email, telephone);
        contactData.updateContact(Integer.parseInt(contactIndex), updatedContact);
    }

    public static void deleteContact(ContactData contactData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wich contact you want to delete: ");
        String contactIndex = scanner.nextLine();

        contactData.deleteContact(Integer.parseInt(contactIndex));
    }

    public static void displayContact(ContactData contactData) {
        System.out.println("Your contacts");
        contactData.listContacts();
    }

    public static void execute(String input, ContactData contactData) {
        if (input.equals("list")) contactData.listContacts();

        if (input.equals("create")) {
            addContact(contactData);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Wants to add another contact ? y/n");
            String wantToAdd = scanner.nextLine();

            if (wantToAdd.equals("y")) addContact(contactData);

            initialize(contactData);

            displayContact(contactData);
        }

        if (input.equals("update")) {
            updateContact(contactData);

            displayContact(contactData);
        }

        if (input.equals("delete")) {
            deleteContact(contactData);

            displayContact(contactData);
        }
    }
}