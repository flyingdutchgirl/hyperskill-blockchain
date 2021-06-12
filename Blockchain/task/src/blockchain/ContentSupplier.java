package blockchain;

public interface ContentSupplier<T> {

    /*
    Informs the supplier that the block was just generated
    and returns a new update of content for the next block.
     */
    T blockGenerated(Block<T> block);
}
