import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Stock {

    int qty;
    LocalDate date;

    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Stock(int qty) {
        setQty(qty);
        setDate(LocalDate.now());
    }

    public static Queue<Stock> setStock() {
        Queue<Stock> stockList = new LinkedList<>();
        for (Product product : Load.products) {
            Random generator = new Random();
            int record = generator.nextInt((20-1)+1)+1;
            for(int i=0; i<record; i++) {
                int qty = generator.nextInt((100-1)+1)+1;
                stockList.add(new Stock(qty));
            }
        }
        return stockList;
    }

    public static boolean removeStock(int id, int qty) {
        for (Product product : Load.products) {
            if(product.getId() == id) {
                if (product.getStockList() != null) {

                    Queue<Stock> stockList = product.getStockList();
                    Iterator<Stock> iterator = stockList.iterator();
                    int totalStock = 0;
                    while (iterator.hasNext()) {
                        totalStock = (totalStock + iterator.next().getQty());
                    }

                    if(totalStock>=qty) {
                        int aux = qty;
                        while (aux!=0) {
                            if(stockList.element().getQty()>qty) {
                                stockList.element().setQty(stockList.element().getQty()-qty);
                                break;
                            } else {
                                aux = aux - stockList.element().getQty();
                                stockList.remove();
                            }
                        }

                    }

                }
            }
        }
        return false;
    }

}
