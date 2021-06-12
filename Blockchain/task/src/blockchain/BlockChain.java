package blockchain;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class BlockChain<T> implements Serializable {
    private static final long serialVersionUID = -932208795683975455L;
    private ArrayList<Block<T>> blocks;
    private int previousId;
    private String previousHash;
    private int n;  // number of zeros needed for a hash to be valid - can change with time
    private int registeredMiners;
    private T content;
    private ContentSupplier<T> contentSupplier;


    public BlockChain(ContentSupplier<T> contentSupplier) {
        this.blocks = new ArrayList<>();
        this.previousId = 0;
        this.previousHash = "0";
        this.n = 0;
        this.registeredMiners = 0;
        this.contentSupplier = contentSupplier;
        this.content = contentSupplier.blockGenerated(null);
    }

    public static <T> void saveToFile(BlockChain<T> blockChain) {
        String randString = blockChain.getBlock(0).getMyHash().substring(10, 15);
        File file = new File("my_blockchain-" + randString + ".txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(blockChain);
            oos.close();
//            System.out.println("Succesfully saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static <T> BlockChain<T> readFromFile() {
        File file = new File("my_blockchain.txt");
        BlockChain<T> blockChain = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            blockChain = (BlockChain<T>) obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Read from the file! and is null? : " + Objects.isNull(blockChain));

        return blockChain;
    }

    public synchronized boolean validate(Block<T> block) {

        if (block.getPreviousHash().equals(this.previousHash)
                && block.getId() == previousId + 1
                && StringUtil.startsWithZeros(block.getMyHash(), this.n)) {
            T newContent = contentSupplier.blockGenerated(block);
            this.content = newContent;

            this.blocks.add(block);
            this.previousHash = block.getMyHash();
            this.previousId += 1;


            String changeN;
            long generationTime = block.getGenerationTime(); // unit - ms
            if (generationTime < 50) {
                changeN = "N was increased to " + (++n);
            } else if (generationTime > 150) {
                changeN = "N was decreased by 1";
                this.n--;
            } else {
                changeN = "N stays the same";
            }
            changeN += "\n";
            block.setChangeOfN(changeN);

            return true;
        }

        return false;
    }

    public synchronized T getContent() {
        return content;
    }

    public synchronized int getPreviousId() {
        return previousId;
    }

    public synchronized String getPreviousHash() {
        return previousHash;
    }

    public synchronized int getN() {
        return n;
    }

    public synchronized Block<T> getBlock(int id) {
        return id >= 0 && id < blocks.size() ? blocks.get(id) : null;
    }

    public synchronized int newMinerId() {
        return this.registeredMiners++;
    }

    /*
       public Block[] generate(int howMany, int zeros) {
        Block[] arr = new Block[howMany];
        for (int i = 0; i < howMany; i++) {
            Block bl = new Block("", ++previousId, previousHash, zeros);
            previousHash = bl.getMyHash();
            arr[i] = bl;
            blocks.add(bl);
        }

        return arr;
    }

    */


}
