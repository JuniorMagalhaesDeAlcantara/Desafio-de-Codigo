import java.util.InputMismatchException;
import java.util.Scanner;

public class VerificadorNumeroConta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar número da conta ao usuário
            System.out.print("Informe o número da conta (apenas dígitos): ");
            String numeroConta = scanner.nextLine();

            // Validar o número da conta
            validarNumeroConta(numeroConta);

            // Exibir mensagem de sucesso
            System.out.println("Número de conta válido!");
        } catch (IllegalArgumentException e) {
            // Exibir mensagem de erro com detalhes
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            // Exibir mensagem de erro para entrada inválida
            System.out.println("Erro: Entrada inválida. Digite apenas números.");
        } finally {
            // Fechar o scanner para evitar vazamentos de recursos
            scanner.close();
        }
    }

    private static void validarNumeroConta(String numeroConta) {
        // Verificar se o tamanho é 8 dígitos
        if (numeroConta.length() != 8) {
            throw new IllegalArgumentException("Número de conta inválido. Deve ter exatamente 8 dígitos.");
        }

        // Verificar se todos os caracteres são dígitos
        for (char c : numeroConta.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Número de conta inválido. Deve conter apenas dígitos.");
            }
        }
    }
}

