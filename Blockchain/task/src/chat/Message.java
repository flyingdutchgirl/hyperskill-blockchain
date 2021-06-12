package chat;

public class Message {

    private String from;
    private String content;
    private long timeStamp;
    private int id;

    public Message(String from, String content) {
        this.from = from;
        this.content = content;
        this.timeStamp = System.nanoTime();
    }


    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public String getHashableContent() {
        return this.toString();
    }
}
