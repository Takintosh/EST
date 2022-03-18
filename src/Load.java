import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load {

    public static List<Product> products = new ArrayList<>();
    public static final String splitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    public static String line = "";
    protected static String dataFile = System.getProperty("user.dir") + "\\src\\Data\\Products.csv";
    public static BufferedReader reader = null;
    public static Product p;

    public void load() {

        try {
            System.out.println("Carregando...");
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            /*
            while ((line = reader.readLine()) != null) {
                String[] product = line.split(splitBy);
                products.add(new Product(Integer.parseInt(product[0].trim()), product[21]));
            }
            */
            reader.readLine();
            for (int i=0; i<10; i++) {
                line = reader.readLine();
                String[] product = line.split(splitBy);
                //System.out.println(product[0] + " - " + product[21]);
                //products.add(new Product(Integer.parseInt(product[0].trim()), product[21]));
                p = new Product(Integer.parseInt(product[0].trim()), product[21]);
                products.add(p);
                //System.out.println(p.getId() + " - " + p.getName());
            }
            System.out.println("Dados carregados!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
