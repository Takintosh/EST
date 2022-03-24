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
        for (Product product : Load.products) {
            if(product.getName().matches("(.*)" + name + "(.*)")) {
                products.add(product);
            }
        }
        return products;
    }

    public static Product productBinarySearch(int productCode) {
        List<Product> products = Load.products;
        int startIndex = 0, endIndex = products.size() - 1;
        int middleIndex;
        while (startIndex <= endIndex) {
            middleIndex = (startIndex + endIndex) / 2;
            if (productCode == products.get(middleIndex).getId()) {
                return products.get(middleIndex);
            }
            if (productCode < products.get(middleIndex).getId()) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return null;
    }

    /*
    public static Product productBinarySearch(int productCode) {
        List<Product> products = Load.products;
        Comparator<Product> c = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getId() == o2.getId()) ? 0 : -1;
            }
        };
        int index = Collections.binarySearch(products, new Product(productCode, ""), c);

        // debug
        //System.out.println(index + " - " + products.get(productCode-1).getId());
        //System.out.println(products.get(1).getId() == products.get(1).getId() ? 0 : -1);


        return products.get(index);
    }
    */

}