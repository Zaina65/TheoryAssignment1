import java.util.ArrayList;
import java.util.List;

class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private List<Message> messages;

    public Contact(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.messages = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void sendMessage(String content) {
        Message message = new Message(content, this.name);
        messages.add(message);
    }

    public void receiveMessage(Message message) {
        messages.add(message);
        message.setDelivered(true); 
    }

    public void readMessages() {
        for (Message message : messages) {
            if (!message.isSeen()) {
                message.setSeen(true);
            }
            message.displayMessage();
        }
    }

    public void displayAllMessages() {
        messages.sort((m1, m2) -> m2.getTimestamp().compareTo(m1.getTimestamp())); 
        for (Message message : messages) {
            message.displayMessage();
        }
    }

    public void deleteMessage(int messageId) {
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            if (message.getId() == messageId) {
                messages.remove(i);
                System.out.println("Message with ID " + messageId + " has been deleted.");
                return;
            }
        }
        System.out.println("Message with ID " + messageId + " not found.");
    }
}