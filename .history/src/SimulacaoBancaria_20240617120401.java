import java.util.Scanner;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        boolean continuar = true;

        while (continuar) {
            System.out.print("\nSelecione a operação desejada:\n" +
            "1 - Deposito\n" +
            "2 - Saque\n" +
            "3 - Saldo\n" +
            "0 - Sair\n") ;

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    // TODO: Ler o valor a ser depositado e atualizar/imprimir o saldo
                    System.out.println("\n Digite o valor a ser depositado: ");
                    Scanner Deposito = new Scanner(System.in);
                    double valorDespositado = scanner.nextDouble();
                    saldo += valorDespositado;
                    System.out.printf("Saldo atual: %.1f\n", +saldo);
                    
                    break;
                case 2:
                    // TODO: Ler o valor a ser sacado e verificar/imprimir se há saldo suficiente.
                    System.out.print("\n Digite o valor a ser sacado: ");
                    Scanner Saque = new Scanner(System.in);
                    double valorSaque = scanner.nextDouble();
                        if (saldo >= valorSaque) {
                           saldo = saldo - valorSaque; 
                        }else{
                            System.out.println("Saldo insuficiente.");
                        }
                    System.out.printf("Saldo atual: %.1f\n", +saldo);
                    break;
                case 3:
                    System.out.printf("Saldo atual: %.1f\n", +saldo);
    
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    continuar = false;  // Atualiza a variável de controle para encerrar o loop
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
