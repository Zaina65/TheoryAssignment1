import java.util.ArrayList;
import java.util.List;

class MessagingApp {
    private List<Contact> contacts;

    public MessagingApp() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        int id = contacts.size() + 1; 
        contacts.add(new Contact(id, name, phoneNumber));
    }

    public Contact getContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
        }
    }

    public void checkMessageDeliveryStatus(Contact sender, Contact receiver) {
        for (Message message : receiver.getMessages()) {
            if (message.getSender().equals(sender.getName())) {
                System.out.println("Message ID: " + message.getId() + ", Delivered: " + message.isDelivered() + ", Seen: " + message.isSeen());
            }
        }
    }
}