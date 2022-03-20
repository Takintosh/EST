import java.util.*;

public class Product {

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

    public static List<Product> productSearch(String name) {
        List<Product> products = new ArrayList<>();
        //products = null;
        for (Product product : Load.products) {
            if(product.getName().matches("(.*)" + name + "(.*)")) {
                products.add(product);
            }
        }
        return products;
    }

    static class productComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return (o1.id == o2.id)?0:-1;
        }
    }
    public static Product binarySearch(int productCode) {
        List<Product> products = Load.products;
        int index = Collections.binarySearch(products, new Product(productCode, null), new productComparator());
        if(index>=0) {
            return products.get(index);
        } else {
            return null;
        }
    }

}
