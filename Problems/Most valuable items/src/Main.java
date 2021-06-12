import java.util.Comparator;
import java.util.List;

class StockItem {
    private String name;
    private double pricePerUnit;
    private int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Utils {
    public static List<StockItem> sort(List<StockItem> stockItems) {

        Comparator<StockItem> itemComparator = new Comparator<StockItem>() {
            @Override
            public int compare(StockItem o1, StockItem o2) {

                /*
                If you don't know what happened here, look at the docs of methods
                Comparator.compare and Math.signum ;)
                */
                return (int) Math.signum(totalValue(o2) - totalValue(o1));

//                 you can look for compare(T t1, T t2) methods in different library classes
//                return Double.compare(totalValue(o2), totalValue(o1));
            }

            /*
            Sometimes you need more processing of your data before comparing them.
            In such cases it's best to create an instance of Comparator - an anonymous class
            is usually enough - and write additional methods which you need.
            */
            private double totalValue(StockItem item) {
                return item.getPricePerUnit() * item.getQuantity();
            }

        }; // end of anonymous class

        // sort method from interface List is a void so we can't use it in the return clause
        stockItems.sort(itemComparator);


        /*
        Note that I didn't cloned the list but I sorted the passed list
        and then returned the same list (but now it's sorted)
         */
        return stockItems;
    }
}