import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Product {

    Load loadData = new Load();

    private int id;
    private String name;
    private Queue<Stock> stockList = new LinkedList<>();

    public Queue<Stock> getStockList() {
        return stockList;
    }
    public void setStockList(Queue<Stock> stockList) {
        this.stockList = stockList;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Product (int id, String name) {
        setId(id);
        setName(name);
        setStockList(Stock.setStock());
    }

    public static Product productSearch(int id) {
        for (Product product : Load.products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public static List productSearch(String name) {
        List<Product> products = new ArrayList<>();
        //products = null;
        for (Product product : Load.products) {
            if(product.getName().matches("(.*)" + name + "(.*)")) {
                products.add(product);
            }
        }
        return products;
    }

}
