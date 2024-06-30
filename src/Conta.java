import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0.00;
    protected Cliente cliente;
    protected List<Seguro> seguros = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void adicionarSeguro(String nome, String descricao, double preco, LocalDate validade){
        if (preco <= this.saldo){
            this.seguros.add(new Seguro(nome, descricao, preco, validade));
            this.saldo -= preco;
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo){
            this.saldo -= valor;
        }
        else {
            System.out.println("Nao foi possivel realizar o saque, " +
                    "pois o valor requerido foi maior que o saldo disponivel");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= this.saldo){
            this.sacar(valor);
            contaDestino.depositar(valor);        }
        else {
            System.out.println("Nao foi possivel realizar a tranferencia, " +
                    "pois o valor requerido foi maior que o saldo disponivel");
        }
    }

    @Override
    public String toString() {
        return "\n\nConta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", seguros=" + seguros +
                '}';
    }

    protected void imprimirDadosExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia - %d", this.agencia));
        System.out.println(String.format("Numero - %d", this.numero));
        System.out.println(String.format("Saldo - %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}
