package miners;

import bank.Account;
import bank.Transaction;
import bank.TransactionDatabase;
import blockchain.Block;
import blockchain.BlockChain;

import java.util.Random;

public class Miner<T> implements Runnable {

    private BlockChain<T> blockChain;
    private MiningManager<T> manager;
    private int minerId;
    private Account account;

    public Miner(BlockChain<T> blockChain, MiningManager<T> manager) {
        this.blockChain = blockChain;
        this.manager = manager;
        this.minerId = this.blockChain.newMinerId();
        this.account = TransactionDatabase.newAccount("miner" + minerId, "miner" + minerId + "BottomSecret");
    }

    @Override
    public void run() {
        while (!manager.isTargetReached()) {
             if (Math.random() < 0.6) {
                doSomeTransaction();
            }

            Block<T> block = generateNewBlock();
            manager.blockGenerated(block);
        }
    }


    private Block<T> generateNewBlock() {
        Block<T> block;
        do {
            block = new Block<T>(blockChain.getContent(), blockChain.getPreviousId() + 1,
                    blockChain.getPreviousHash(), blockChain.getN(), minerId);
        } while (!blockChain.validate(block));


        return block;
    }

    private void doSomeTransaction() {
        int amount = new Random().nextInt(30);
        TransactionDatabase.makeTransaction(account, TransactionDatabase.randomAccount(account),
                amount, "miner" + minerId + "BottomSecret");
    }

}
