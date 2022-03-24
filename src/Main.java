import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static boolean done = false;

    public static void main(String[] args) {

        Load loadData = new Load();
        loadData.load();

        /*
        Product found = Product.productSearch(1);
        System.out.println(found.getStockList());
        List<Stock> founded = Stock.removeStock(1, 1);
        for(Stock f : founded) {
            System.out.println(f.getDate() + " - " + f.getQty());
        }
        */

        menu();

    }

    public static void menu() {


        while (!done) {
            System.out.println(
                    "\nMenu" +
                            "\n1 - Buscar produto por codigo." +
                            "\n2 - Buscar produto por nome." +
                            "\n3 - Retirar produto por codigo." +
                            "\n4 - Buscar produto utilizando busca binaria" +
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

                case 3:
                    System.out.print("\nCodigo do produto: ");
                    input = new Scanner(System.in);
                    productCode = input.nextInt();
                    found = Product.productSearch(productCode);
                    if(found != null) {
                        System.out.print("\n Quantidade a retirar: ");
                        input = new Scanner(System.in);
                        int qty = input.nextInt();
                        int available = Stock.checkStock(found.getId(), qty);
                        if(available == qty) {
                            List<Stock> removedStock = Stock.removeStock(found.getId(), available);
                            for(Stock s : removedStock) {
                                System.out.println("Removido: " + s.getDate() + " - " + s.getQty());
                            }
                        } else if (available == 0) {
                            System.out.print("Nao tem estoque.");
                        } else {
                            boolean error = true;
                            while (error) {
                                System.out.print ("\nEstoque insuficiente. Deseja retirar o estoque disponivel (" + available + " em estoque)? (S/N) ");
                                input = new Scanner(System.in);
                                String select = input.nextLine();
                                if(select.equals("S")) {
                                    //System.out.println(Stock.removeStock(found.getId(), available));
                                    List<Stock> removedStock = Stock.removeStock(found.getId(), available);
                                    for(Stock s : removedStock) {
                                        System.out.println("Removido: " + s.getDate() + " - " + s.getQty());
                                    }
                                    error = false;
                                } else if (select.equals("N")) {
                                    error = false;
                                } else {
                                    System.out.print("\nOpcao errada, tente novamente");
                                }
                            }
                        }
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Codigo do produto: ");
                    input = new Scanner(System.in);
                    int binaryCode = input.nextInt();
                    Product binaryFound = Product.productBinarySearch(binaryCode);

                    // debug
                    //Product.productBinarySearch(binaryCode);

                    if(binaryFound != null) {
                        int totalStock = 0;
                        for (Stock s : binaryFound.getStockList()) {
                            totalStock = totalStock + s.getQty();
                        }
                        System.out.println("Id: " + binaryFound.getId() + " - " + binaryFound.getName() +
                                "\nQuantidade em estoque: " + totalStock);
                    } else {
                        System.out.println("Produto nao encontrado.");
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
