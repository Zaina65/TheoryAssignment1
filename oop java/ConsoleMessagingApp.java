import java.util.Scanner;

public class ConsoleMessagingApp {
   private static MessagingApp messagingApp = new MessagingApp();
   private static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
       boolean running = true;

       messagingApp.addContact("Alice", "12345678901");
       messagingApp.addContact("Bob", "09876543211");

       while (running) {
           System.out.println("Messaging App - Console Based");
           System.out.println("1. Add Contact");
           System.out.println("2. Send Message");
           System.out.println("3. Read Messages");
           System.out.println("4. Display All Messages");
           System.out.println("5. Delete Message");
           System.out.println("6. Display All Contacts");
           System.out.println("7. Check Message Delivery Status");
           System.out.println("8. Exit");
           System.out.print("Choose an option: ");
           int choice = scanner.nextInt();
           scanner.nextLine(); 

           switch (choice) {
               case 1:
                   addContact();
                   break;
               case 2:
                   sendMessageByName();
                   break;
               case 3:
                   readMessages();
                   break;
               case 4:
                   displayAllMessages();
                   break;
               case 5:
                   deleteMessage();
                   break;
               case 6:
                   displayAllContacts();
                   break;
               case 7:
                   checkMessageDeliveryStatus();
                   break;
               case 8:
                   running = false;
                   System.out.println("Exiting the Messaging App...");
                   break;
               default:
                   System.out.println("Invalid choice. Try again.");
           }
       }
   }

   private static void addContact() {
       System.out.print("Enter contact name: ");
       String name = scanner.nextLine();
       System.out.print("Enter 11-digit phone number: ");
       String phoneNumber = scanner.nextLine();
       messagingApp.addContact(name, phoneNumber);
   }

   private static void sendMessageByName() {
       System.out.print("Enter sender's name: ");
       String senderName = scanner.nextLine();
       System.out.print("Enter receiver's name: ");
       String receiverName = scanner.nextLine();
       System.out.print("Enter the message: ");
       String content = scanner.nextLine();

       Contact sender = messagingApp.getContactByName(senderName);
       Contact receiver = messagingApp.getContactByName(receiverName);

       if (sender != null && receiver != null) {
           sender.sendMessage(content); 
           Message message = new Message(content, sender.getName());
           receiver.receiveMessage(message); 
           System.out.println("Message sent from " + sender.getName() + " to " + receiver.getName() + " successfully.");
       } else {
           System.out.println("One or both contacts do not exist.");
       }
   }

   private static void readMessages() {
       System.out.print("Enter contact name to read messages: ");
       String contactName = scanner.nextLine();
       Contact contact = messagingApp.getContactByName(contactName);

       if (contact != null) {
           System.out.println("Reading messages for " + contact.getName() + ":");
           contact.readMessages();
       } else {
           System.out.println("Contact does not exist.");
       }
   }

   private static void displayAllMessages() {
       System.out.print("Enter contact name to display all messages: ");
       String contactName = scanner.nextLine();
       Contact contact = messagingApp.getContactByName(contactName);

       if (contact != null) {
           System.out.println("All messages for " + contact.getName() + ":");
           contact.displayAllMessages();
       } else {
           System.out.println("Contact does not exist.");
       }
   }

   private static void deleteMessage() {
       System.out.print("Enter contact name to delete a message: ");
       String contactName = scanner.nextLine();
       Contact contact = messagingApp.getContactByName(contactName);

       if (contact != null) {
           System.out.print("Enter the message ID to delete: ");
           int messageId = scanner.nextInt();
           contact.deleteMessage(messageId);
           scanner.nextLine();
       } else {
           System.out.println("Contact does not exist.");
       }
   }

   private static void displayAllContacts() {
       System.out.println("All Contacts:");
       messagingApp.displayAllContacts();
   }

   private static void checkMessageDeliveryStatus() {
       System.out.print("Enter sender's name: ");
       String senderName = scanner.nextLine();
       System.out.print("Enter receiver's name: ");
       String receiverName = scanner.nextLine();

       Contact sender = messagingApp.getContactByName(senderName);
       Contact receiver = messagingApp.getContactByName(receiverName);

       if (sender != null && receiver != null) {
           System.out.println("Delivery Status for Messages from " + sender.getName() + " to " + receiver.getName() + ":");
           messagingApp.checkMessageDeliveryStatus(sender, receiver);
       } else {
           System.out.println("One or both contacts do not exist.");
       }
   }
}