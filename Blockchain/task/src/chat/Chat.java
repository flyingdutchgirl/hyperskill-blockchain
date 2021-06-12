package chat;

import blockchain.Block;
import blockchain.ContentSupplier;
import miners.MiningManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Chat implements ContentSupplier<MessageList> {
    private MiningManager<MessageList> manager;
    private String[] names = {"Alex", "Jessica", "Jack", "Max", "Amelie", "Janette", "Karl"};
    private String[] verbs = {"want", "need", "miss", "love"};
    private String[] nouns = {"oranges", "relax", "him", "cats", "home", "sleep"};
    private Random rand;
    private MessageList msgList;
    private List<Block<MessageList>> myBlocks;
    private Supplier<String> messageGenerator =
            () -> "I " + verbs[rand.nextInt(3)] + " " + nouns[rand.nextInt(4)];
    private Supplier<String> nameGenerator =
            () -> names[rand.nextInt(6)];

    public Chat() {
        this.rand = new Random();
        this.msgList = new MessageList();
        this.myBlocks = new ArrayList<>();
    }

    public synchronized MessageList blockGenerated(Block<MessageList> block) {
        if (block != null) {
            myBlocks.add(block);
        }

        MessageList oldList = msgList;
        msgList = new MessageList();
        for (int i = 0; i < rand.nextInt(4); i++) {
            msgList.addMessage(new Message(nameGenerator.get(), messageGenerator.get()));
        }

        return oldList;
    }

    public synchronized void newMessage(Message msg) {
        msgList.addMessage(msg);
    }

    public List<Block<MessageList>> getMyBlocks() {
        return myBlocks;
    }
}
