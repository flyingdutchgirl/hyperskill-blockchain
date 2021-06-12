package blockchain;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;


public class Block<T> implements Serializable {

    private static final long serialVersionUID = -1601262513489518187L;
    private T content;
    private int id;
    private int minerId;
    private int magic;
    private String previousHash;
    private String myHash;
    private long timeStamp;
    private long generationTime;
    private String changeOfN;


    public Block(T content, int id, String previousHash, int requiredZeros, int minerId) {
        this.content = content;
        this.id = id;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.minerId = minerId;
        generateHash(requiredZeros);
    }


    private void generateHash(int zeros) {
        Random rand = new Random();
        long startTime = System.currentTimeMillis();
//        long attempts = 0;

        do {
//            attempts++;
            magic = rand.nextInt();
            String info = getHashableContent();
            myHash = StringUtil.applySha256(info);
        } while (!StringUtil.startsWithZeros(this.myHash, zeros));

//        System.out.println("zeros = " + zeros + "  attempts = " + attempts);

        this.generationTime = System.currentTimeMillis() - startTime;
    }


    public String getHashableContent() {
        return magic + content.toString() + id + previousHash + timeStamp + minerId;
    }

    @Override
    public String toString() {
        return "Block: " + "\n"
                + "Created by: miner" + minerId
                + "\nminer" + minerId + " gets 100 VC"
                + "\nId: " + id
                + "\nTimestamp: " + timeStamp +
                "\nMagic number: " + magic +
                "\nHash of the previous block:\n"
                + previousHash + "\nHash of the block:\n" + myHash
                + "\nBlock data: " + content.toString();
    }

    public String generationTimeString() {
        return "Block was generating for " + getGenerationTimeSeconds() + " seconds";
    }

    public int getGenerationTimeSeconds() {
        return (int) generationTime / 1000;
    }

    public int getMinerId() {
        return minerId;
    }

    public T getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getMyHash() {
        return myHash;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getChangeOfN() {
        return changeOfN;
    }

    public void setChangeOfN(String changeOfN) {
        this.changeOfN = changeOfN;
    }

    public long getGenerationTime() {
        return generationTime;
    }
}
