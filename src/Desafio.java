import java.text.DecimalFormat;
import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lendo os dados de entrada
        String titular = scanner.next();
        int numeroConta = scanner.nextInt();
        double saldo = scanner.nextDouble();
        double taxaJuros = scanner.nextDouble();

        // Criando uma instância de ContaPoupanca
        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, titular, saldo, taxaJuros);

        // Exibindo as informações da conta poupança
        System.out.println("Conta Poupanca:");
        contaPoupanca.exibirInformacoes();

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class ContaBancaria {
    protected int numero;
    protected String titular;
    protected double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void exibirInformacoes() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println(titular);
        System.out.println(numero);
        System.out.println("Saldo: R$ " + decimalFormat.format(saldo));
    }
}

class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca(int numero, String titular, double saldo, double taxaJuros) {
        super(numero, titular, saldo); // Chama o construtor da classe pai
        this.taxaJuros = taxaJuros;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); // Exibe as informações da classe pai
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println("Taxa de juros: " + decimalFormat.format(taxaJuros) + "%");
    }
}
