import java.util.Scanner;

public class VerificacaoChequeEspecial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar saldo ao usuário
        System.out.print("Informe seu saldo atual: ");
        double saldo = scanner.nextDouble();

        // Solicitar valor do saque ao usuário
        System.out.print("Informe o valor do saque desejado: ");
        double saque = scanner.nextDouble();

        // Definir limite do cheque especial
        double limiteChequeEspecial = 500;

        // Verificar se o saque ultrapassa o saldo disponível
        if (saque <= saldo) {
            // Transação realizada com sucesso usando apenas o saldo
            System.out.println("Parabéns! Seu saque de R$ " + saque + " foi realizado com sucesso.");
        } else {
            // Verificar se o saque ultrapassa o limite do cheque especial
            if (saldo + limiteChequeEspecial >= saque) {
                // Transação realizada usando cheque especial
                double valorChequeEspecial = saque - saldo;
                System.out.println("Seu saque de R$ " + saque + " foi realizado com sucesso utilizando o cheque especial.");
                System.out.println("Você utilizou R$ " + valorChequeEspecial + " do seu limite de cheque especial.");
            } else {
                // Transação não realizada devido ao limite do cheque especial
                System.out.println("Infelizmente, seu saque de R$ " + saque + " não pôde ser realizado.");
                System.out.println("O valor do saque excede o limite disponível em seu saldo e cheque especial.");
            }
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
