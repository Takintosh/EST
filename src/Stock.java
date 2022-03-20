import java.time.LocalDate;
import java.util.*;

public class Stock {

  int qty;
  LocalDate date;

  public int getQty() { return qty; }
  public void setQty(int qty) { this.qty = qty; }

  public LocalDate getDate() { return date; }
  public void setDate(LocalDate date) { this.date = date; }

  public Stock(int qty) {
    setQty(qty);
    setDate(LocalDate.now());
  }

  public static Queue<Stock> setStock() {
    Queue<Stock> stockList = new LinkedList<>();
    Random generator = new Random();
    int record = generator.nextInt((20 - 1) + 1) + 1;
    for (int i = 0; i < record; i++) {
      int qty = generator.nextInt((100 - 1) + 1) + 1;
      stockList.add(new Stock(qty));
    }
    return stockList;
  }

  public static int checkStock(int id, int qty) {
    id = id;
    qty = qty;
    int totalStock = 0;
    Product found = Product.productSearch(id);
    if (found != null) {
      if (found.getStockList() != null) {
        Queue<Stock> stockList = found.getStockList();
        Iterator<Stock> iterator = stockList.iterator();
        while (iterator.hasNext()) {
          totalStock = (totalStock + iterator.next().getQty());
        }
        if (totalStock >= qty) {
          return qty;
        } else {
          return totalStock;
        }
      }
    }
    return 0;
  }

  public static List<Stock> removeStock(int id, int qty) {
    id = id;
    qty = qty;
    Product found = Product.productSearch(id);
    Queue<Stock> stockList = found.getStockList();
    List<Stock> stockRemoved = new ArrayList<>();
    int aux = qty;

    while (aux != 0) {
      if (stockList.element().getQty() > aux) {
        stockList.element().setQty(stockList.element().getQty() - aux);
        Stock stockAux = stockList.element();
        stockAux.setQty(aux);
        stockRemoved.add(stockAux);
        break;
      } else {
        aux = aux - stockList.element().getQty();
        stockRemoved.add(stockList.element());
        stockList.remove();
      }
    }

    return stockRemoved;
  }
}
