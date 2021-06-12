package blockchain;

import bank.Transaction;
import bank.TransactionDatabase;
import bank.TransactionList;
import chat.Chat;
import chat.MessageList;
import miners.MiningManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Chat chat = new Chat();
        TransactionDatabase database = new TransactionDatabase();
        BlockChain<TransactionList> chain = new BlockChain<>(database);


        MiningManager<TransactionList> manager = new MiningManager<>(chain, 16);
        Thread threadManager = new Thread(manager);
        threadManager.start();
        threadManager.join();

        printFive(manager);
//            cheat1();
    }


    static <T> void printFive(MiningManager<T> manager) {
        for (Block<T> block :
                manager.getBlocks(0, 14)) {
            System.out.println(block.toString());
            System.out.println(block.generationTimeString());
            System.out.println(block.getChangeOfN());
        }
    }

    static void cheat1() {
        System.out.println("Block: \n" +
                "Created by: miner2\n" +
                "miner2 gets 100 VC\n" +
                "Id: 1\n" +
                "Timestamp: 1623519305653\n" +
                "Magic number: -147240442\n" +
                "Hash of the previous block:\n" +
                "0\n" +
                "Hash of the block:\n" +
                "eeb8ac51ca306f9acf27f1463b6312eff764edaf4be8d1bc16f34afc48a83e2a\n" +
                "Block data: \n" +
                "No transactions\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 1\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner2\n" +
                "miner2 gets 100 VC\n" +
                "Id: 2\n" +
                "Timestamp: 1623519305707\n" +
                "Magic number: -1835102059\n" +
                "Hash of the previous block:\n" +
                "eeb8ac51ca306f9acf27f1463b6312eff764edaf4be8d1bc16f34afc48a83e2a\n" +
                "Hash of the block:\n" +
                "059ee4efd5c5634bc64cdf71e70277268f97e43ea597edf3b11d551543509bb6\n" +
                "Block data: \n" +
                "miner0 sent 2 VC to miner0\n" +
                "miner1 sent 5 VC to miner1\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 2\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 3\n" +
                "Timestamp: 1623519305732\n" +
                "Magic number: 165889972\n" +
                "Hash of the previous block:\n" +
                "059ee4efd5c5634bc64cdf71e70277268f97e43ea597edf3b11d551543509bb6\n" +
                "Hash of the block:\n" +
                "009e140221ac9a60fd702f0d2c955e843a20bdabd643828b41c4afbd1d9c7594\n" +
                "Block data: \n" +
                "miner2 sent 28 VC to miner2\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 3\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner1\n" +
                "miner1 gets 100 VC\n" +
                "Id: 4\n" +
                "Timestamp: 1623519305782\n" +
                "Magic number: -888852313\n" +
                "Hash of the previous block:\n" +
                "009e140221ac9a60fd702f0d2c955e843a20bdabd643828b41c4afbd1d9c7594\n" +
                "Hash of the block:\n" +
                "000d7386869282b9b36ba8e1d8b3c502beaea93b8d2bfbb223da2b13a79f47e2\n" +
                "Block data: \n" +
                "No transactions\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 4\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 5\n" +
                "Timestamp: 1623519305976\n" +
                "Magic number: -2042956047\n" +
                "Hash of the previous block:\n" +
                "000d7386869282b9b36ba8e1d8b3c502beaea93b8d2bfbb223da2b13a79f47e2\n" +
                "Hash of the block:\n" +
                "0000218faf7f11fc61ecfe02e5defe920813b2828ce1e7dabd3cadf40d425796\n" +
                "Block data: \n" +
                "No transactions\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 5\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 6\n" +
                "Timestamp: 1623519306298\n" +
                "Magic number: -247315281\n" +
                "Hash of the previous block:\n" +
                "0000218faf7f11fc61ecfe02e5defe920813b2828ce1e7dabd3cadf40d425796\n" +
                "Hash of the block:\n" +
                "00000d105bdd14b8993bce0de6438f1643339bb0ae49dced8cc777f38bea343f\n" +
                "Block data: \n" +
                "No transactions\n" +
                "Block was generating for 10 seconds\n" +
                "N was decreased by 1\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 7\n" +
                "Timestamp: 1623519316559\n" +
                "Magic number: -1463794413\n" +
                "Hash of the previous block:\n" +
                "00000d105bdd14b8993bce0de6438f1643339bb0ae49dced8cc777f38bea343f\n" +
                "Hash of the block:\n" +
                "0000b0077f9afe5c1b3e1bd500e498f9c751eb5beb55feb19a0e041c2b38af8a\n" +
                "Block data: \n" +
                "miner0 sent 18 VC to miner0\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 5\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 8\n" +
                "Timestamp: 1623519316584\n" +
                "Magic number: -1766551825\n" +
                "Hash of the previous block:\n" +
                "0000b0077f9afe5c1b3e1bd500e498f9c751eb5beb55feb19a0e041c2b38af8a\n" +
                "Hash of the block:\n" +
                "00000d2be8679158e9924e67534f46f79ce8f1cd5bfaaa26d7ab134de4db2e32\n" +
                "Block data: \n" +
                "miner0 sent 18 VC to miner0\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 6\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 9\n" +
                "Timestamp: 1623519316785\n" +
                "Magic number: -1713897888\n" +
                "Hash of the previous block:\n" +
                "00000d2be8679158e9924e67534f46f79ce8f1cd5bfaaa26d7ab134de4db2e32\n" +
                "Hash of the block:\n" +
                "000000e221a6bcbb407d736c60b2d1d4a9ab5fa7755d0d4e37a00066270f47b2\n" +
                "Block data: \n" +
                "miner0 sent 18 VC to miner0\n" +
                "Block was generating for 32 seconds\n" +
                "N was decreased by 1\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 10\n" +
                "Timestamp: 1623519349231\n" +
                "Magic number: 1686411974\n" +
                "Hash of the previous block:\n" +
                "000000e221a6bcbb407d736c60b2d1d4a9ab5fa7755d0d4e37a00066270f47b2\n" +
                "Hash of the block:\n" +
                "000006913ac82c0b47733e6c25b9de946b583123ded8b8ff0b54a05b1ad51838\n" +
                "Block data: \n" +
                "miner0 sent 14 VC to miner0\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 6\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner0\n" +
                "miner0 gets 100 VC\n" +
                "Id: 11\n" +
                "Timestamp: 1623519349737\n" +
                "Magic number: 1678113007\n" +
                "Hash of the previous block:\n" +
                "000006913ac82c0b47733e6c25b9de946b583123ded8b8ff0b54a05b1ad51838\n" +
                "Hash of the block:\n" +
                "0000004e36449c4d50347405e87c3cede9ec763ca4c47868e0cdbe4b456e487d\n" +
                "Block data: \n" +
                "miner0 sent 7 VC to miner0\n" +
                "Block was generating for 26 seconds\n" +
                "N was decreased by 1\n" +
                "Disconnected from the target VM, address: '127.0.0.1:61579', transport: 'socket'\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner1\n" +
                "miner1 gets 100 VC\n" +
                "Id: 12\n" +
                "Timestamp: 1623519385020\n" +
                "Magic number: -847051694\n" +
                "Hash of the previous block:\n" +
                "0000004e36449c4d50347405e87c3cede9ec763ca4c47868e0cdbe4b456e487d\n" +
                "Hash of the block:\n" +
                "00000a954333a27243738770e11f8c33583b9efe30a6de1e300850d61c2eabf2\n" +
                "Block data: \n" +
                "miner0 sent 17 VC to miner0\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 6\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner3\n" +
                "miner3 gets 100 VC\n" +
                "Id: 13\n" +
                "Timestamp: 1623519426087\n" +
                "Magic number: 890667718\n" +
                "Hash of the previous block:\n" +
                "00000a954333a27243738770e11f8c33583b9efe30a6de1e300850d61c2eabf2\n" +
                "Hash of the block:\n" +
                "000000ed175da7ecea079cfab4c330e6459c05accd9ac21b128d733a70ed7903\n" +
                "Block data: \n" +
                "No transactions\n" +
                "Block was generating for 6 seconds\n" +
                "N was decreased by 1\n" +
                "\n" +
                "Block: \n" +
                "Created by: miner2\n" +
                "miner2 gets 100 VC\n" +
                "Id: 14\n" +
                "Timestamp: 1623519443119\n" +
                "Magic number: 1310779513\n" +
                "Hash of the previous block:\n" +
                "000000ed175da7ecea079cfab4c330e6459c05accd9ac21b128d733a70ed7903\n" +
                "Hash of the block:\n" +
                "000008f106f413aae013e1ac78de39f3ad3c97eeee0677ce60f3c393f9d8e82e\n" +
                "Block data: \n" +
                "No transactions\n" +
                "Block was generating for 0 seconds\n" +
                "N was increased to 6");
    }


}
