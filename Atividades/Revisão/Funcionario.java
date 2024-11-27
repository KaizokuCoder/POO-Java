import java.util.Scanner;

public class Funcionario {
    protected String nome, cpf;
    protected double salario;
    protected Data dtNasc, dtContr;

    public Funcionario() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        this.nome = s.nextLine();
        System.out.println("Digite o cpf: ");
        this.cpf = s.nextLine();
        System.out.println("Digite o salario: ");
        this.salario = s.nextDouble();
        System.out.println("Insira data de nascimento. ");
        this.dtNasc = new Data();
        System.out.println("Insira data de contratação. ");
        this.dtContr = new Data();
    }

    public Funcionario(String nome, String cpf, double salario, Data dtNasc, Data dtContr) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dtNasc = dtNasc;
        this.dtContr = dtContr;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public Data getDtNasc() {
        return dtNasc;
    }

    public Data getDtContr() {
        return dtContr;
    }

    public void listarDados() {
        System.out.println("===== Dados do Funcionário =====");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Salario: " + this.getSalario());
        System.out.println("Data de nascimento: " + this.getDtNasc());
        System.out.println("Data de contratação: " + this.getDtContr());
    }
}
