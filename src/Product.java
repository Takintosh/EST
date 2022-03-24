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

    // Bubble Sort
    public static List<Product> productBubbleSort(List<Product> productsUnsorted) {
        List<Product> products = productsUnsorted;
        for (int i = 1; i < products.size(); i++) {
            for (int j = products.size() - 1; j >= i; j--) {
                if (products.get(j-1).getId() > products.get(j).getId()) {
                    Product auxProduct = products.get(j-1);
                    products.set(j-1, products.get(j));
                    products.set(j, auxProduct);
                }
            }
        }
        return products;
    }

    // Selection Sort
    public static List<Product> productSelectionSort(List<Product> productsUnsorted) {
        List<Product> products = productsUnsorted;
        int smallerIndex;
        for (int i = 0; i < products.size() - 1; i++) {
            smallerIndex = i;
            Product auxProduct = products.get(i);
            for (int j = i; j < products.size(); j++) {
                if (products.get(j).getId() < auxProduct.getId()) {
                    smallerIndex = j;
                    auxProduct = products.get(j);
                }
            }
            products.set(smallerIndex, products.get(i));
            products.set(i, auxProduct);
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

}