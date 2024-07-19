import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();

        List<Transacao> transacoes = new ArrayList<>();

        for (int i = 1; i <= quantidadeTransacoes; i++) {
            char tipoTransacao = scanner.next().charAt(0);
            double valorTransacao = scanner.nextDouble();

            // Cria uma nova transação e adiciona à lista de transações
            Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);

            // Verifica e atualiza o saldo da conta com base no tipo de transação
            if (Character.toUpperCase(transacao.getTipo()) == 'D') {
                saldo += valorTransacao;
            } else if (Character.toUpperCase(transacao.getTipo()) == 'S') {
                saldo -= valorTransacao;
            }
        }

        // Exibe o saldo final
        System.out.println("\nSaldo : " + saldo);
        // Exibe as transações formatadas conforme os exemplos
        System.out.println("\nTransacoes:");
        transacoes.stream()
                .map(transacao -> formatarTransacao(transacao))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }

    // Método para formatar a transação conforme o exemplo dado
    private static String formatarTransacao(Transacao transacao) {
        char tipoMaiusculo = Character.toUpperCase(transacao.getTipo());
        String tipo = tipoMaiusculo == 'D' ? "d de " : "s de ";
        return tipo + transacao.getValor();
    }
}

class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
