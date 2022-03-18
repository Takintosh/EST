import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static boolean done = false;

    public static void main(String[] args) {

        Load loadData = new Load();
        loadData.load();
        menu();

    }

    public static void menu() {


        while (!done) {
            System.out.println(
                    "\nMenu" +
                            "\n1 - Buscar produto por código." +
                            "\n2 - Buscar produto por nome." +
                            "\n0 - Fechar processo."
            );
            int option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nCódigo do produto: ");
                    input = new Scanner(System.in);
                    int productCode = input.nextInt();
                    Product found = Product.productSearch(productCode);
                    if (found != null) {
                        System.out.println("Id: " + found.getId() + " - Nome: " + found.getName());
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;

                case 2:
                    List<Product> founds;
                    System.out.print("\nNome do produto: ");
                    input = new Scanner(System.in);
                    String productName = input.nextLine();
                    founds = Product.productSearch(productName);
                    if (founds.size()>0) {
                        for(Product p : founds) {
                            System.out.println("Id: " + p.getId() + " Nome: " + p.getName());
                        }
                    } else {
                        System.out.println("Produto nao encontrado");
                    }
                    break;

                case 0:
                    System.out.println("Fechando processo");
                    done = true;
                    break;

                default:
                    System.out.println("Opçao errada, tente novamente.");
                    break;
            }
        }


    }

}
