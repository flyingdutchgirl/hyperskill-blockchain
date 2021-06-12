package chat;

import java.util.ArrayList;
import java.util.List;

public class MessageList {
    List<Message> messages;

    public MessageList() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    @Override
    public String toString() {
        if (messages.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder("\n");

        this.messages.stream()
                .map(msg -> msg.getFrom() + ": " + msg.getContent() + "\n")
                .forEach(sb::append);

        return sb.toString().substring(0, sb.length() - 2);
    }
}
