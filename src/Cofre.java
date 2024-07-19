import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {
    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {
    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }
}

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tipoCofre = scanner.nextLine();

        if (tipoCofre.equalsIgnoreCase("digital")) {
            // Leitura dos dados de senha sem mensagens de solicitação
            int senha = scanner.nextInt();
            int confirmacaoSenha = scanner.nextInt();

            CofreDigital cofreDigital = new CofreDigital(senha);

            System.out.println("Tipo: Cofre Digital");
            System.out.println("Metodo de abertura: Senha");

            if (cofreDigital.validarSenha(confirmacaoSenha)) {
                System.out.println("Cofre aberto!");
            } else {
                System.out.println("Senha incorreta!");
            }

        } else if (tipoCofre.equalsIgnoreCase("fisico")) {
            CofreFisico cofreFisico = new CofreFisico();
            System.out.println("Tipo: Cofre Fisico");
            System.out.println("Metodo de abertura: Chave");
        } else {
            System.out.println("Tipo de cofre desconhecido.");
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
