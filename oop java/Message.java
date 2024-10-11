import java.time.LocalDateTime;


class Message {
    private static int nextId = 1;  
    private int id;
    private String content;
    private LocalDateTime timestamp;
    private boolean delivered;
    private boolean seen;
    private String sender;

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
        this.delivered = false;
        this.seen = false;
        this.id = nextId++;  
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getSender() {
        return sender;
    }

    public void displayMessage() {
        System.out.println("Message ID: " + id);
        System.out.println("Message from: " + sender);
        System.out.println("Content: " + content);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Delivered: " + delivered + ", Seen: " + seen);
        System.out.println();
    }
}
