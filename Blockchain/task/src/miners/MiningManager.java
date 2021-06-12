package miners;

import blockchain.Block;
import blockchain.BlockChain;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MiningManager<T> implements Runnable {

    private static final int DEFAULT_NUMBER_OF_MINERS = 4;
    private volatile int blocksGenerated;
    private int target;
    private volatile ArrayList<Block<T>> ourBlocks;
    private ArrayList<Miner<T>> ourMiners;
    private BlockChain<T> blockChain;
//    private ExecutorService executor;
    private int numberOfMiners;


    public MiningManager(BlockChain<T> blockChain, int target) {
        this.blocksGenerated = 0;
        this.target = target;
        this.ourBlocks = new ArrayList<>();
        this.ourMiners = new ArrayList<>();
        this.blockChain = blockChain;
        this.numberOfMiners = DEFAULT_NUMBER_OF_MINERS;
//        this.executor = Executors.newFixedThreadPool(this.numberOfMiners);
    }


    @Override
    public void run() {
        work();
    }

    public void work() {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfMiners; i++) {
            ourMiners.add(new Miner<T>(blockChain, this));
        }

        for (Miner<T> miner : ourMiners) {
//            executor.submit(miner);
            Thread thr = new Thread(miner);
            threads.add(thr);
            thr.start();
        }

        threads.forEach(thr -> {
            try {
                thr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        try {
//            Thread.sleep(99);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        executor.shutdown();
//        try {
//            executor.awaitTermination(12, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    synchronized void blockGenerated(Block<T> block) {
        ourBlocks.add(block);
//        if (isTargetReached()) {
//            executor.shutdownNow();
//        } else {
//            blocksGenerated++;
//        }
    }

    synchronized boolean isTargetReached() {
        return ourBlocks.size() > target;
    }


    public synchronized ArrayList<Block<T>> getBlocks(int from, int to) {
        int len = from - to + 1;
        ArrayList<Block<T>> blocks = new ArrayList<>();

        for (int i = from; i <= to && i < ourBlocks.size(); i++) {
            blocks.add(ourBlocks.get(i));
        }

        return blocks;
    }

}
