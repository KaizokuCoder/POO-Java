import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Gerente> gerentes;

    public Empresa() {
        this.funcionarios = new ArrayList<>();
        this.gerentes = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public void folhaPagamento() {
        double custoMensal = 0.0;
        System.out.println("=== Gerentes:");
        for (Gerente g : this.gerentes) {
            custoMensal += g.getSalario();
            System.out.println(g.getNome() + ": " + g.getSalario() + "\t\tCusto da equipe: " + g.custoTotal());
        }
        System.out.println("\n=== Funcionários:");
        for (Funcionario f: this.funcionarios) {
            custoMensal += f.getSalario();
            System.out.println(f.getNome() + ": " + f.getSalario());
        }
        System.out.println("\n=== Custo mensal da empresa: " + custoMensal);
    }

    public void contratarFuncionario() {
        System.out.println("=== Contratar Funcionário ===");
        this.funcionarios.add(new Funcionario());
    }

    public void contratarGerente() {
        System.out.println("=== Contratar Gerente ===");
        System.out.println("Deseja iniciar com uma nova senha? (s/n)");
        Scanner s = new Scanner(System.in);
        String resposta = s.nextLine();
        if (resposta.equals("s")) {
            this.gerentes.add(new Gerente());
        } else {
            System.out.println("Digite a senha: ");
            String senha = s.nextLine();
            this.gerentes.add(new Gerente(senha));
        }
    }

    public Funcionario funcionarioMaisAntigo() {
        Funcionario maisAntigo = funcionarios.get(0);
        for (Funcionario f : this.funcionarios) {
            if (maisAntigo.getDtContr().compara(f.getDtContr()) == -1) {
                maisAntigo = f;
            }
        }
        maisAntigo.listarDados();
        return maisAntigo;
    }

    public Funcionario funcionarioMaisVelho() {
        Funcionario maisVelho = funcionarios.get(0);
        for (Funcionario f : this.funcionarios) {
            if (maisVelho.getDtNasc().compara(f.getDtNasc()) == -1) {
                maisVelho = f;
            }
        }
        maisVelho.listarDados();
        return maisVelho;
    }

    private Funcionario localizarFuncionario(String cpf) {
        for (Funcionario f : this.funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    private Gerente localizarGerente(String cpf) {
        for (Gerente g : this.gerentes) {
            if (g.getCpf().equals(cpf)) {
                return g;
            }
        }
        return null;
    }

    public void atribuirFuncGer() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o CPF do funcionário: ");
        String cpfFunc = s.nextLine();
        System.out.println("Digite o CPF do gerente: ");
        String cpfGer = s.nextLine();
        Gerente g = localizarGerente(cpfGer);
        Funcionario f = localizarFuncionario(cpfFunc);
        if (g != null && f != null) {
            g.inserirFuncionario(f);
        } else {
            System.out.println("Gerente ou Funcionario não existe");
        }
    }
}
