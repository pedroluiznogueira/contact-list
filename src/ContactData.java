import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactData {

    private List<Contact> contacts;

    public ContactData() {
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void createContact(Contact contact) {
        contacts.add(contact);
    }

    public void listContacts() {
        contacts.forEach(System.out::println);
    }

    public void updateContact(Integer contactIndex, Contact contact) {
        contacts.set(contactIndex - 1, contact);
    }

    public void deleteContact(Integer contactIndex) {
        contacts.remove(contacts.indexOf(contactIndex));
    }
}
