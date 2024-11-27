import java.util.Scanner;

public class Data {
    private final int dia, mes, ano;

    public Data() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o dia: ");
        this.dia = s.nextInt();

        System.out.println("Digite o mês: ");
        this.mes = s.nextInt();

        System.out.println("Digite o ano: ");
        this.ano = s.nextInt();
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int compara(Data d) {
        if (this.getAno() < d.getAno()) return -1;
        if (this.getAno() > d.getAno()) return 1;
        if (this.getMes() < d.getMes()) return -1;
        if (this.getMes() > d.getMes()) return 1;
        if (this.getDia() < d.getDia()) return -1;
        if (this.getDia() > d.getDia()) return 1;
        return 0;
    }
}
