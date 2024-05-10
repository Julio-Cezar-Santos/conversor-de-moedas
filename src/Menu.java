import java.util.Scanner;

public class Menu {

    private void realizarConversao(Scanner scanner, String moedaOrigem, String moedaDestino) {
        System.out.println("Digite o valor em " + moedaOrigem + ":");
        double valor = scanner.nextDouble();
        Conversor conversor = new Conversor();
        String resultado = conversor.converteMoeda(moedaOrigem, moedaDestino, valor);
        System.out.println(resultado);
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;


        while (opcao != 7) {
            System.out.println("""
                    ***************************************
                    
                    Bem vindo ao conversor de moedas!
                    
                    1 - Dólar para Real
                    2 - Real para Dólar
                    3 - Euro para Real
                    4 - Real para Euro
                    5 - Libra para Real
                    6 - Real para Libra
                    7 - Sair
                    
                    ***************************************
                    
                    Escolha uma opção:
                    
                    """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    realizarConversao(scanner, "USD", "BRL");
                    break;
                case 2:
                    realizarConversao(scanner, "BRL", "USD");
                    break;
                case 3:
                    realizarConversao(scanner, "EUR", "BRL");
                    break;
                case 4:
                    realizarConversao(scanner, "BRL", "EUR");
                    break;
                case 5:
                    realizarConversao(scanner, "GBP", "BRL");
                    break;
                case 6:
                    realizarConversao(scanner, "BRL", "GBP");
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
            }
        }
    }
}
