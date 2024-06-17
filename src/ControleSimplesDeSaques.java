import java.util.Scanner;

public class ControleSimplesDeSaques {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir limite diário
        System.out.print("Informe seu limite diário de saque: R$ ");
        double limiteDiario = scanner.nextDouble();

        // Variável para controle de transações
        boolean continuarTransacoes = true;

        // Loop principal para realizar saques
        while (continuarTransacoes) {
            // Apresentar saldo disponível
            System.out.printf("Limite disponível: R$ %.2f\n", limiteDiario);

            // Solicitar valor do saque
            System.out.print("Informe o valor do saque (ou 0 para finalizar): R$ ");
            double valorSaque = scanner.nextDouble();

            // Verificar se o usuário deseja encerrar as transações
            if (valorSaque == 0) {
                System.out.println("Obrigado por utilizar o nosso serviço!");
                continuarTransacoes = false;
            }

            // Verificar se o valor do saque ultrapassa o limite diário
            else if (valorSaque > limiteDiario) {
                System.out.println("Limite diário de saque excedido. Transação cancelada.");
            }

            // Realizar o saque dentro do limite
            else {
                limiteDiario -= valorSaque;
                System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valorSaque);
                System.out.printf("Limite restante: R$ %.2f\n", limiteDiario);
            }
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

