import java.util.ArrayList;
import java.util.List;

public class Product {

    Load loadData = new Load();

    private int id;
    private String name;

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
