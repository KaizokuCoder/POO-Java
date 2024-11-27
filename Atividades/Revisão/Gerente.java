import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Funcionario {
    private String senha;
    private ArrayList<Funcionario> equipe;

    public Gerente() {
        super();
        Scanner s = new Scanner(System.in);
        this.senha = s.nextLine();
        this.equipe = new ArrayList<>();
    }

    public Gerente(String senha) {
        super();
        this.senha = senha;
        this.equipe = new ArrayList<>();
    }

    public boolean validarAcesso() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a senha: ");
        String tentativa = s.nextLine();
        return tentativa.equals(this.senha);
    }

    public void setSenha() {
        Scanner s = new Scanner(System.in);
        System.out.println("Verifique a senha anterior.");
        if (validarAcesso()) {
            System.out.println("Digite uma nova senha: ");
            String senha2 = s.nextLine();
            this.senha = senha2;
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    public double custoTotal() {
        double total = 0.0;
        for (Funcionario f : this.equipe) {
            total += f.getSalario();
        }
        total += this.getSalario();
        return total;
    }

    public void listarNomes() {
        System.out.println("Gerente: " + this.getNome());
        for (Funcionario f : this.equipe) {
            System.out.println("Funcionário: " + f.getNome());
        }
    }

    public void inserirFuncionario(Funcionario f1) {
        boolean existe = false;
        for (Funcionario f2 : this.equipe) {
            if (f1.getCpf().equals(f2.getCpf())) {
                System.out.println("Funcionário já adicionado.");
                existe = true;
            }
        }
        if (!existe) this.equipe.add(f1);
    }

    public void listarDados() {
        System.out.println("===== Dados do Gerente =====");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Salario: " + this.getSalario());
        System.out.println("Data de nascimento: " + this.getDtNasc());
        System.out.println("Data de contratação: " + this.getDtContr());
    }
}
